package com.layuicms.erp.service.impl;

import com.layuicms.erp.domain.User;
import com.layuicms.erp.mapper.UserMapper;
import com.layuicms.erp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 小康
 * @since 2019-12-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
