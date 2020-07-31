package com.smart.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * log
 * 记录服务器错误
 * 日志
 * -日志持久化
 * -日志信息保存在文件中或者数据库中
 * ELK 日志收集系统(收集控制台的日志信息)
 * 发展史
 *   日志同一框架    接口    slf4j
 *  - log4j 1.3 apache(过时) 同步日志
 *  - logback () 异步日志
 *  - log4j2     异步日志
 */
@SpringBootApplication
public class LogApp {
    public static void main(String[] args) {
        SpringApplication.run(LogApp.class, args);
    }
}
