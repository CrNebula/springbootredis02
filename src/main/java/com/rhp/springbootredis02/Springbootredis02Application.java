package com.rhp.springbootredis02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.rhp.springbootredis02.mapper")
@SpringBootApplication
public class Springbootredis02Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootredis02Application.class, args);
    }

}
