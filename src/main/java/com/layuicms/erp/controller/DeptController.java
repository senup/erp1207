package com.layuicms.erp.controller;


import com.layuicms.erp.common.DataGridView;
import com.layuicms.erp.common.TreeNode;
import com.layuicms.erp.domain.Dept;
import com.layuicms.erp.service.IDeptService;
import com.layuicms.erp.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 小康
 * @since 2019-12-11
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private IDeptService deptService;

    /**
     * 加载部门管理左边的部门树的json
     */
    @RequestMapping("loadDeptManagerLeftTreeJson")
    public DataGridView loadDeptManagerLeftTreeJson(DeptVo deptVo) {
        List<Dept> list = this.deptService.list();
        List<TreeNode> treeNodes=new ArrayList<>();

        for (Dept dept : list) {
            Boolean spread= dept.getOpen() == 1;
            treeNodes.add(new TreeNode(dept.getId(), dept.getPid(), dept.getTitle(), spread));
        }
        return new DataGridView(treeNodes);
    }
}

