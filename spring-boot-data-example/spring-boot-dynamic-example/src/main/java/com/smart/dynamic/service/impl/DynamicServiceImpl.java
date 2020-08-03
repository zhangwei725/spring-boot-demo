package com.smart.dynamic.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.dynamic.entity.Member;
import com.smart.dynamic.mapper.MemberMapper;
import com.smart.dynamic.service.DynamicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@DS("master")
public class DynamicServiceImpl implements DynamicService {
    @Resource
    MemberMapper mapper;

    @Override
    @DS("slave")
    public IPage<Member> find() {
        IPage<Member> page = mapper.selectPage(new Page<Member>(1, 10), null);
        return page;
    }

    @Override
    public int save(Member member) {
        member = new Member();
        member.setUsername("admin");
        member.setPassword("1234567");
        member.setEmail("123457@qq.com");
        member.setPhone("110");
        int insert = mapper.insert(member);
        return 0;
    }
}
