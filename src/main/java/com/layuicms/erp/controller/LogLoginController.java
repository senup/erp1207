package com.layuicms.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.layuicms.erp.common.DataGridView;
import com.layuicms.erp.common.ResultObj;
import com.layuicms.erp.domain.LogLogin;
import com.layuicms.erp.service.ILogLoginService;
import com.layuicms.erp.vo.LogLoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 小康
 * @since 2019-12-10
 */
@RestController
@RequestMapping("/log")
public class LogLoginController {

    @Autowired
    private ILogLoginService logLoginService;

    @RequestMapping("/loadAllLoginfo")
    public DataGridView loadAllLoginfo(LogLoginVo logLoginVo){

        //全查询
        Page<LogLogin> page = new Page<>(logLoginVo.getPage(),logLoginVo.getLimit());
        QueryWrapper<LogLogin> queryWrapper = new QueryWrapper<>();
        //封装条件
        //第一个参数为 条件 boolean
        queryWrapper.like(StringUtils.isNotBlank(logLoginVo.getLoginname()),"loginname",logLoginVo.getLoginname());
        queryWrapper.like(StringUtils.isNotBlank(logLoginVo.getLoginip()),"loginip",logLoginVo.getLoginip());
        queryWrapper.ge(logLoginVo.getStartTime()!=null,"logintime",logLoginVo.getStartTime());
        queryWrapper.le(logLoginVo.getEndTime()!=null,"logintime",logLoginVo.getEndTime());
        queryWrapper.orderByDesc("logintime");
        //添加条件
        this.logLoginService.page(page, queryWrapper);
        //参数一 总数 参数二 数据
        return new DataGridView(0,"",page.getTotal(),page.getRecords());
    }



    //删除
    @RequestMapping("/deleteLoginfo")
    public ResultObj deleteLoginfo(Integer id){
        try {
            //“IDEA try catch的快捷键是选中后 ctrl+alt+t ”
            this.logLoginService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }

    }



    //批量删除
    @RequestMapping("/batchDeleteLoginfo")
    public ResultObj batchDeleteLoginfo(LogLoginVo logLoginVo){
        try {
            //“IDEA try catch的快捷键是选中后 ctrl+alt+t ”
            Collection<Serializable> idList = new ArrayList<Serializable>();
            for ( Integer id : logLoginVo.getIds() ) {
                idList.add(id);
            }
            this.logLoginService.removeByIds(idList);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }

    }
}

