package com.smart.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
// @ConfigurationProperties("druid")
public class DruidProperties {
    private String url;
    private String username;
    private String password;
    private int maxActive;
}
