package com.layuicms.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class SystemController {


    /*
    跳转到登陆页面
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "system/index/login";
    }

    /*
    跳转到首页
    */
    @RequestMapping("index")
    public String index(){
        return "system/index/index";
    }

    /*
    跳转到工作台
    */
    @RequestMapping("toDeskManager")
    public String toDeskManager(){
        return "system/index/deskManager";
    }
}
