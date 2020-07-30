package com.smart.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogController {
    @GetMapping("/test")
    public String test() {
        log.debug("debug");
        log.info("hello");
        int i = 100/0;
        return "测试日志";
    }
}
