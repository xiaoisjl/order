package com.song.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account")
public class LoginViewController {


    // 预先设置好的正确的用户名和密码，用于登录验证
    private String rightUserName = "admin";
    private String rightPassword = "admin";

}
