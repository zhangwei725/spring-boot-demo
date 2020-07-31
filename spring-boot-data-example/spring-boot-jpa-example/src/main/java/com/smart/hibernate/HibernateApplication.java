package com.smart.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 自动装配的原理
 * 放在根目录
 *
 */
@SpringBootApplication(scanBasePackages = "com.smart.hibernate")
public class HibernateApplication {
    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }
}
