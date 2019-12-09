package com.layuicms.erp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.layuicms.erp.common.*;
import com.layuicms.erp.domain.Permission;
import com.layuicms.erp.domain.User;
import com.layuicms.erp.service.IPermissionService;
import com.layuicms.erp.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 *  菜单前端控制器
 * </p>
 *
 * @author 小康
 * @since 2019-12-09
 */
@RestController
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/loadIndexLeftMenuJson")
    public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo){
        //查询所有菜单
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        //设置只能查询菜单
        queryWrapper.eq("type", Constast.TYPE_MENU);
        queryWrapper.eq("available",Constast.TYPE_AVAILABLE_TRUE);

        User user = (User) WebUtils.getSession().getAttribute("user");
        List<Permission> list = null;
        if(user.getType()==Constast.UERR_TYPE_SUPER){
            list = permissionService.list(queryWrapper);

        }else{//根据用户ID+角色+权限去查询
            list = permissionService.list(queryWrapper);
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        for (Permission p : list){
            Integer id = p.getId();
            Integer pid = p.getPid();
            String title = p.getTitle();
            String icon = p.getIcon();
            String href = p.getHref();
            Boolean spread= p.getOpen()==Constast.OPEN_TURE?true:false;
            treeNodes.add(new TreeNode(id,  pid,  title,  icon,  href,  spread));
        }
        //构造层级关系
        List<TreeNode> build = TreeNodeBuilder.build(treeNodes, 1);
        return new DataGridView(build);
    }

}

