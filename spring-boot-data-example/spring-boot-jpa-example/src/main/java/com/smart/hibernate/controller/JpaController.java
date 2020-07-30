package com.smart.hibernate.controller;

import com.smart.hibernate.dao.UserDao;
import com.smart.hibernate.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class JpaController {
    /**
     * 但条件查询
     */
    @Resource
    UserDao userDao;

    @GetMapping("/list/")
    public List<User> users() {
//        userDao.findAll(new Specification<User>() {
//            @Override
//            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                return null;
//            }
//        })
        // where  username like 'admin'
        List<User> users = userDao.findAll((root, query, builder) -> {
            return builder.like(root.get("username"), "admin");
        });
        //  list 遍历 lambda  简洁
        users.forEach(user -> log.info(user.getUsername()));
        return users;
    }

    /**
     * 多条件
     *
     * @return
     */
    @GetMapping("/list/")
    public List<User> users1() {
        List<User> users = userDao.findAll((root, query, builder) -> {
            // where  username = admin and  password=123456
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("username"), "admin"));
            predicates.add(builder.equal(root.get("password"), "123456"));
            Predicate[] predicateArr = new Predicate[predicates.size()];
            return builder.and(predicates.toArray(predicateArr));
        });
        //  list 遍历 lambda  简洁
        users.forEach(user -> log.info(user.getUsername()));
        return users;
    }

    /**
     * @return
     */
    @GetMapping("/list/")
    public List<User> users2() {
        // (phone or username)  and  password
        List<User> users = userDao.findAll((root, query, builder) -> {
            return builder.and(
                    builder.or(builder.equal(root.get("phone"), "123456"),
                            builder.equal(root.get("username"), "admin")),

                    builder.equal(root.get("password"), "123456")
            );
        });
        //  list 遍历 lambda  简洁
        users.forEach(user -> log.info(user.getUsername()));
        return users;
    }

    /**
     * 排序 分页
     */
    @GetMapping("/users/{page}/{size}")
    public Page<User> pages(@PathVariable
                            @RequestParam(defaultValue = "1") int page,
                            @PathVariable @RequestParam(defaultValue = "10") int size) {

        Sort.by(Sort.Direction.DESC, "uid");
        PageRequest pageRequest = PageRequest.of(0, 10);
        //
        Page<User> pager = userDao.findAll((root, query, builder) -> {
            return builder.equal(root.get("username"), "admin");
        }, PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "uid")));
        return  pager;
    }


}
