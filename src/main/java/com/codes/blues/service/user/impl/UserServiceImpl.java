package com.codes.blues.service.user.impl;

import com.codes.blues.dao.user.UserMapper;
import com.codes.blues.dao.user.model.User;
import com.codes.blues.dao.user.model.UserExample;
import com.codes.blues.dao.user.req.UserReq;
import com.codes.blues.service.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户表业务实现
 * @author linzg
 * @date 2020/03/02 15:25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "users", key = "#id", cacheManager = "myCacheManager")
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findByIds(List<Integer> ids) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(ids);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public Integer create(UserReq req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        userMapper.insertSelective(user);
        return user.getId();
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(ids);
        userMapper.deleteByExample(userExample);
    }

    @Override
    public void updateById(UserReq req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        int result = userMapper.updateByPrimaryKeySelective(user);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}