package com.codes.blues;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 项目启动类
 * @author linzg
 * @date 2020/03/02 15:25
 */
@SpringBootApplication
@MapperScan("com.codes.blues.dao")
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class);
        Environment env = context.getEnvironment();
        log.info("====================================================================");
        log.info("Project Environment:     {}", env.getProperty("project.env"));
        log.info("Server Port:             {}", env.getProperty("server.port"));
        log.info("Logging Level:           {}", env.getProperty("logback.level"));
        log.info("Startup complete ...");
        log.info("====================================================================");
    }

}