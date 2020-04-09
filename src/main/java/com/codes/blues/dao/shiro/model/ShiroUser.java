package com.codes.blues.dao.shiro.model;

import lombok.Data;

import java.util.Set;

@Data
public class ShiroUser {
    private String id;

    private String userName;

    private String password;
    /**
     * 用户对应的角色集合
     */
    private Set<ShiroRole> roles;
}