package com.rhp.springbootredis02.controller;

import com.rhp.springbootredis02.entity.User;
import com.rhp.springbootredis02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String list(Model model) {
        System.out.println("查看用户："+userService.selectAllUser());
        model.addAttribute("userList",userService.selectAllUser());
        return "list";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/doAdd")
    public String doAdd(User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/update")
    public String update(User user,Model model) {
        model.addAttribute("user",user);
        return "update";
    }

    @RequestMapping("/doUpdate")
    public String doUpdate(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping("/del")
    public String del(Integer userId) {
        userService.delUser(userId);
        return "redirect:/";
    }
}
