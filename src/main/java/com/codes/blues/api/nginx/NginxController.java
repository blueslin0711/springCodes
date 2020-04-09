package com.codes.blues.api.nginx;

import com.codes.blues.api.BaseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/23 16:53
 * @description：
 */
@RestController
@RequestMapping(value = "nginx", produces = "application/json; charset=utf-8")
public class NginxController extends BaseController{

    @Value("${user.param.nginx.value}")
    private String value;

    @GetMapping("/hello")
    public String hello() {
        return value + "aa你好a";
    }
}
