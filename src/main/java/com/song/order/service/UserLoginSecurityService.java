package com.song.order.service;

import com.song.order.dao.UserMapper;
import com.song.order.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserLoginSecurityService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User
                        .builder()
                        .username(username)
                        .password(user == null ? UUID.randomUUID().toString() : user.getPassword())
                        .disabled(user == null ? true : false)
                        .roles("USER")
                        .build();
        return userDetails;
    }

}
