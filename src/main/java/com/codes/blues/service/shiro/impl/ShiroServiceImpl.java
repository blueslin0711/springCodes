package com.codes.blues.service.shiro.impl;

import com.codes.blues.dao.shiro.ShiroUserMapper;
import com.codes.blues.dao.shiro.model.ShiroUser;
import com.codes.blues.service.shiro.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/4/8 10:39
 * @description：
 */
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private ShiroUserMapper shiroUserMapper;

    @Override
    public ShiroUser getShiroUserById(String id) {
        return shiroUserMapper.getShiroUserByUserId(id);
    }
}
