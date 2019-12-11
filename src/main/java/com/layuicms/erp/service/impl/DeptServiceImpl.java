package com.layuicms.erp.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.layuicms.erp.domain.Dept;
import com.layuicms.erp.mapper.DeptMapper;
import com.layuicms.erp.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 小康
 * @since 2019-12-11
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
    @Override
    public Dept getOne(Wrapper<Dept> queryWrapper) {
        return null;
    }

    @Override
    public boolean update(Wrapper<Dept> updateWrapper) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

}
