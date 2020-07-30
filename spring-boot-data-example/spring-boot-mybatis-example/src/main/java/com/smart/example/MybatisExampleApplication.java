package com.smart.example;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// mapper.java 注册
@MapperScan("com.smart.example.mapper")
public class MybatisExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisExampleApplication.class, args);
    }
}
