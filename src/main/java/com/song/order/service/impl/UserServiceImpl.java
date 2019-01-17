package com.song.order.service.impl;

import com.song.order.dao.UserMapper;
import com.song.order.model.User;
import com.song.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(1);
    }
}
