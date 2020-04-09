package com.codes.blues.plugin;

import cn.hutool.core.util.StrUtil;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
 
/**
 * 定时扫描并动态加载mybatis的SQL配置文件,刷新sql mapper cache,可以在修改xml后不用重启tomcat也能生效
 * 
 * 扫描参数:<br/>
 * 1.RELOAD_INTERVAL:扫描时间间隔=3s<br/>
 * 2.XML_RESOURCE_PATTERN:当前CLASSPATH下xml通配符<br/>
 * 3.SESSION_FACTORY_BEAN_NAME:数据源session factory名称<br/>
 * 备注:本类在开发环境下使用,正式发布后注释掉applicationContext.xml中id=MyBatisDynamicLoader的bean
 * 
 * @author MF
 * @version 1.0
 */
public class XMLMapperLoader implements InitializingBean, ApplicationContextAware {
    // 扫描时间间隔
    private long RELOAD_INTERVAL = 3000;

    private String xmlResourcePattern = null;

    private final HashMap<String, String> mappers = new HashMap<String, String>();
    private volatile ConfigurableApplicationContext context = null;
    private volatile Scanner scanner = null;

    public XMLMapperLoader(String xmlResourcePattern, long reloadInterval) {
        this.xmlResourcePattern = xmlResourcePattern;
        this.RELOAD_INTERVAL = reloadInterval;
    }

    public XMLMapperLoader() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = (ConfigurableApplicationContext) applicationContext;
    }
 
    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            scanner = new Scanner();
            System.out.println("RELOAD_INTERVAL--------------------------------");
            System.out.println(RELOAD_INTERVAL);
            System.out.println("RELOAD_INTERVAL--------------------------------");
            new Timer(true).schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        if (scanner.isChanged()) {
                            scanner.reloadXML();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 5 * 1000, RELOAD_INTERVAL);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
 
    class Scanner {
        private String XML_RESOURCE_PATTERN =
                ResourcePatternResolver.CLASSPATH_URL_PREFIX + "mappers/*.xml";
        private static final String SESSION_FACTORY_BEAN_NAME = "sqlSessionFactory";
 
        private final ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        public Scanner() throws IOException {
            if (StrUtil.isNotBlank(xmlResourcePattern)) {
                this.XML_RESOURCE_PATTERN = xmlResourcePattern;
            }
            System.out.println("XML_RESOURCE_PATTERN----------------------");
            System.out.println("XML_RESOURCE_PATTERN----------------------");
            System.out.println(XML_RESOURCE_PATTERN);
            Resource[] resources = findResource();
            if (resources != null) {
                for (Resource resource : resources) {
                    String key = resource.getURI().toString();
                    String value = getMd(resource);
                    mappers.put(key, value);
                }
            }
        }
 
        public void reloadXML() throws Exception {
            // 如果是单数据源用这个
            // SqlSessionFactory factory = context.getBean(SqlSessionFactory.class);
            /* 这里指定数据源,多数据源环境使用 */
            System.out.println("========== Reload SQL Cache on [" + SESSION_FACTORY_BEAN_NAME + "] ==========");
            SqlSessionFactory factory = (SqlSessionFactory) context.getBean(SESSION_FACTORY_BEAN_NAME);
            Configuration configuration = factory.getConfiguration();
            removeConfig(configuration);
            for (Resource resource : findResource()) {
                System.out.println(resource.getFilename());
                try {
                    XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(resource.getInputStream(), configuration,
                            resource.toString(), configuration.getSqlFragments());
                    xmlMapperBuilder.parse();
                } finally {
                    ErrorContext.instance().reset();
                }
            }
            System.out.println("========== Reload end ==========");
        }
 
        private void removeConfig(Configuration configuration) throws Exception {
            Class<?> classConfig = configuration.getClass();
            clearMap(classConfig, configuration, "mappedStatements");
            clearMap(classConfig, configuration, "caches");
            clearMap(classConfig, configuration, "resultMaps");
            clearMap(classConfig, configuration, "parameterMaps");
            clearMap(classConfig, configuration, "keyGenerators");
            clearMap(classConfig, configuration, "sqlFragments");
            clearSet(classConfig, configuration, "loadedResources");
        }
 
        @SuppressWarnings("rawtypes")
        private void clearMap(Class<?> classConfig, Configuration configuration, String fieldName) throws Exception {
            Field field = classConfig.getDeclaredField(fieldName);
            field.setAccessible(true);
            ((Map) field.get(configuration)).clear();
        }
 
        @SuppressWarnings("rawtypes")
        private void clearSet(Class<?> classConfig, Configuration configuration, String fieldName) throws Exception {
            Field field = classConfig.getDeclaredField(fieldName);
            field.setAccessible(true);
            ((Set) field.get(configuration)).clear();
        }
 
        public boolean isChanged() throws IOException {
            boolean isChanged = false;
            for (Resource resource : findResource()) {
                String key = resource.getURI().toString();
                String value = getMd(resource);
                if (!value.equals(mappers.get(key))) {
                    isChanged = true;
                    mappers.put(key, value);
                }
            }
            return isChanged;
        }
 
        private Resource[] findResource() throws IOException {
            return resourcePatternResolver.getResources(XML_RESOURCE_PATTERN);
        }
 
        private String getMd(Resource resource) throws IOException {
            return new StringBuilder()
                    .append(resource.contentLength())
                    .append("-")
                    .append(resource.lastModified())
                    .toString();
        }
    }
}