package com.smart.rest.controller;

import com.smart.rest.annotation.ResultNoHandler;
import com.smart.rest.entity.Product;
import com.smart.rest.vo.RespEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截器  AOP
 * <p>
 * 设计风格
 * 返回接口 json数据   统一的结果集
 * 同一的结果集处理  AOP
 */
//get   /product
//post  /product
//put  /product
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @GetMapping("/")
    public Product product() {
        return new Product();
    }
    // 网关来处理
    @GetMapping("/list")
    public List<Product> products() {
        log.info("2:{}-{}", "测试");
        return new ArrayList<>();
    }

    @GetMapping("/test")
    @ResultNoHandler
    public String test() {
        log.info("2:{}-{}", "测试");
        return "hello";
    }

}
