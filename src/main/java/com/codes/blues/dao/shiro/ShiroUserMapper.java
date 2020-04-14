package com.codes.blues.dao.shiro;

import com.codes.blues.dao.shiro.model.ShiroUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ShiroUserMapper {
    ShiroUser getShiroUserByUserId(@Param("id") String id);
}