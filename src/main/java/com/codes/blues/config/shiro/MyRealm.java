package com.codes.blues.config.shiro;

import com.codes.blues.dao.shiro.ShiroUserMapper;
import com.codes.blues.dao.shiro.model.ShiroUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ShiroUserMapper shiroUserMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 获取访问用户id
        String id = (String)principals.getPrimaryPrincipal();
        // 查询用户信息
        ShiroUser user = shiroUserMapper.getShiroUserByUserId(id);
        // 添加用户授权
        user.getRoles().forEach(role -> {
            authorizationInfo.addRole(role.getId());
            role.getPermissions()
                    .forEach(permission -> authorizationInfo.addStringPermission(permission.getId()));
        });
        /*authorizationInfo.addRole("A1");
        authorizationInfo.addStringPermission("P1");*/
        return authorizationInfo;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String id = (String) token.getPrincipal();
        ShiroUser user = shiroUserMapper.getShiroUserByUserId(id);
        if (user == null) {
            throw new UnknownAccountException("账户不存在!");
        }
        return new SimpleAuthenticationInfo(id, user.getPassword(), getName());
    }


}