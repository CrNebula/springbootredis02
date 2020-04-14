package com.rhp.springbootredis02.service.impl;

import com.rhp.springbootredis02.entity.User;
import com.rhp.springbootredis02.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectList(){
        System.out.println(userService.selectAllUser());
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setUserName("小明");
        user.setPassword("123456");
        System.out.println(userService.addUser(user));
    }

    @Test
    public  void delUser(){
        System.out.println(userService.delUser(1008));
    }

}