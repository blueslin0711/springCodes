package com.codes.blues.api.shiro;

import com.codes.blues.api.BaseController;
import com.codes.blues.dao.shiro.model.ShiroUser;
import com.codes.blues.service.shiro.ShiroService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/23 16:53
 * @description：
 */
@RestController
@RequestMapping("shiro")
public class ShiroController extends BaseController{

    @Autowired
    private ShiroService shiroService;

    @GetMapping("/getUserById")
    public ShiroUser getUserById(@Param("id") String id) {
        System.out.println(id);
        return shiroService.getShiroUserById(id);
    }
}
