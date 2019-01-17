package com.song.order.controller;

import com.song.order.model.User;
import com.song.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String userList(Model model) {
        User user = userService.getUser(1);
        List<User> users = new ArrayList<>();
        users.add(user);
        model.addAttribute("users", users);
        return "/user/list";
    }
}
