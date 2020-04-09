package com.codes.blues.config;

import com.codes.blues.plugin.XMLMapperLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/4 11:02
 * @description：
 */
@Component
public class BeanConfig {

    /**
     * mybatis xml热更新的bean
     *
     * @return
     */
    @Bean
    public XMLMapperLoader xmlMapperLoader() {
        System.out.println("XMLMapperLoader注册成功！");
        //return new XMLMapperLoader(ResourcePatternResolver.CLASSPATH_URL_PREFIX + "mappers/*.xml", 100000L);
        return new XMLMapperLoader();
    }
}
