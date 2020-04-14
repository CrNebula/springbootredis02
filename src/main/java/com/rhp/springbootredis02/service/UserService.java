package com.rhp.springbootredis02.service;

import com.rhp.springbootredis02.entity.User;

import java.util.List;

public interface UserService  {

    List<User> selectAllUser();

    int addUser(User user);

    int updateUser(User user);

    int delUser(Integer userId);
}
