package com.smart.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

public class DruidConfiguration {
    @Resource
    DruidProperties druidProperties;

    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxActive(druidProperties.getMaxActive());
        return dataSource;
    }
}
