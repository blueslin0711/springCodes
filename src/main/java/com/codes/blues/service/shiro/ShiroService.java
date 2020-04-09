package com.codes.blues.service.shiro;

import com.codes.blues.dao.shiro.model.ShiroUser;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/19 13:58
 * @description：权限管理服务
 */
public interface ShiroService {
    ShiroUser getShiroUserById(String id);
}
