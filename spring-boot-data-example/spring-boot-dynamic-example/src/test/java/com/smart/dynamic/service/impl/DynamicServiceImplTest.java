package com.smart.dynamic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.dynamic.entity.Member;
import com.smart.dynamic.service.DynamicService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class DynamicServiceImplTest {
    @Resource
    DynamicService service;

    @Test
    void find() {
        IPage<Member> memberIPage = service.find();
        log.info(memberIPage.toString());
    }

    @Test
    void save() {
        int save = service.save(null);
        log.info(save + "");
    }
}