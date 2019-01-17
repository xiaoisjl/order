package com.song.order.controller;

import com.song.order.model.User;
import com.song.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public String userList() {
        User user = userService.getUser(1);
        return "用户";
    }
}
