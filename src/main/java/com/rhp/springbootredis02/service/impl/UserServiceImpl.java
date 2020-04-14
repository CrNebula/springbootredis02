package com.rhp.springbootredis02.service.impl;

import com.rhp.springbootredis02.entity.User;
import com.rhp.springbootredis02.mapper.UserMapper;
import com.rhp.springbootredis02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> selectAllUser() {
        List<User> userList =  redisTemplate.opsForList().range("user",0,-1);
        System.out.println("从redis中查到的userList: "+userList);
        if(userList.size()==0){
            userList = userMapper.selectList(null);
            System.out.println("从mysql中查到的userList: "+userList);
            redisTemplate.opsForList().rightPushAll("user",userList);
        }
        return userList;
    }

    @Override
    public int addUser(User user) {
        int result = userMapper.insert(user);
        if (result != 0){
            User user1 = userMapper.selectById(user.getUserId()) ;
            System.out.println("添加的数据："+user1);
            redisTemplate.opsForList().rightPushAll("user",user1);
        }
        return result;
    }

    @Override
    @CacheEvict(key = "user")
    public int updateUser(User user) {
        Integer result = userMapper.updateById(user);
        if (result != 0){
            List<User> usersList = userMapper.selectList(null);
            redisTemplate.delete("user");
            redisTemplate.opsForList().rightPushAll("user",usersList);
        }
        return result;
    }

    @Override
    @CacheEvict(key = "user")
    public int delUser(Integer userId) {
        User user = userMapper.selectById(userId);
        int result = userMapper.deleteById(userId);
        if (result != 0 ){
            redisTemplate.opsForList().remove("user",0,user);
        }
        return result;
    }
}
