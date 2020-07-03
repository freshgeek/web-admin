package com.demo.webadmin.service.impl;

import com.demo.webadmin.entity.User;
import com.demo.webadmin.mapper.UserMapper;
import com.demo.webadmin.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chen.chao
 * @since 2020-07-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
