package com.smart.dynamic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.dynamic.entity.Member;

public interface DynamicService {
    IPage<Member> find();

    int save(Member member);
}
