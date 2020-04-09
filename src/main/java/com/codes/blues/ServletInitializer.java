package com.codes.blues;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/23 10:38
 * @description：
 */
public class ServletInitializer extends SpringBootServletInitializer {
    public ServletInitializer() {
        System.out.println("初始化成功！！");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
