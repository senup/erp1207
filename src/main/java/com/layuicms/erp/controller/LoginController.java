package com.layuicms.erp.controller;

import com.layuicms.erp.common.ActiveUser;
import com.layuicms.erp.common.ResultObj;
import com.layuicms.erp.common.WebUtils;
import com.layuicms.erp.domain.LogLogin;
import com.layuicms.erp.service.ILogLoginService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ILogLoginService logLoginService;

   @RequestMapping("/login" )
    public ResultObj login(String loginname,String pwd) {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(loginname,pwd);
        try {
            subject.login(token);
            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            WebUtils.getSession().setAttribute("user",activeUser.getUser());
            //记录登陆日志开始
            LogLogin log = new LogLogin();
            log.setLoginname(activeUser.getUser().getName()+"-"+activeUser.getUser().getLoginname());
            log.setLoginip(WebUtils.getRequest().getRemoteAddr());
            log.setLogintime(new Date());
            logLoginService.save(log);
            //日志结束
            return ResultObj.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultObj.LOGIN_ERROR_PASS;
        }
    }
}
