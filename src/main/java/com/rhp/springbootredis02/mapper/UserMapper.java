package com.rhp.springbootredis02.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rhp.springbootredis02.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
