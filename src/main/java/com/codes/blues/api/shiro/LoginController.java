package com.codes.blues.api.shiro;

import com.codes.blues.api.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/4/13 9:33
 * @description：
 */
@Controller
public class LoginController extends BaseController {

    @PostMapping("/doLogin")
    public String doLogin(String id, String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(id, password));
            System.out.println("登录成功!");
            return "redirect:/index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登录失败!");
            return "html/err";
        }
    }
    @GetMapping("/hello")
    public @ResponseBody String hello() {
        return "hello";
    }

    @GetMapping("/login")
    public String  login() {
        return "html/login";
    }

    @GetMapping("/index")
    public String index(Model model) {
        Subject subject = SecurityUtils.getSubject();
        model.addAttribute("name", subject.getPrincipal());
        System.out.println(subject.hasRole("A1"));
        System.out.println(subject.hasRole("A2"));
        System.out.println(subject.hasRole("A3"));
        System.out.println(subject.isPermitted("P1"));
        System.out.println(subject.isPermitted("P2"));
        System.out.println(subject.isPermitted("P10"));
        return "html/index";
    }

}
