package com.codes.blues.dao.shiro.model;

import lombok.Data;

import java.util.Set;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/4/8 9:27
 * @description：
 */
@Data
public class ShiroRole {
    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<ShiroPermissions> permissions;
}
