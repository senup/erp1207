package com.layuicms.erp.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.layuicms.erp.common.ActiveUser;
import com.layuicms.erp.domain.User;
import com.layuicms.erp.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /*
    认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //通过前端传来的登录名查询用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginname",authenticationToken.getPrincipal().toString());
        User user = userService.getOne(queryWrapper);

        //传递activeUser到授权
        if(user!=null){
            ActiveUser activeUser = new ActiveUser();
            activeUser.setUser(user);
            ByteSource salt = ByteSource.Util.bytes(user.getSalt());
            SimpleAuthenticationInfo info =new SimpleAuthenticationInfo(activeUser,user.getPwd(),salt,this.getName());
            return info;
        }
        return null;

    }


    /*
    授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
