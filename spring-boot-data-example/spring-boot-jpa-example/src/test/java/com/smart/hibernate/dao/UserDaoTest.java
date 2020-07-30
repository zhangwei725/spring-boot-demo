package com.smart.hibernate.dao;

import com.smart.hibernate.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserDaoTest {
    @Resource
    UserDao userDao;

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setCreateDate(new Date());
        user.setIsDel(0);
        userDao.save(user);
    }

    @Test
    public void testSelect() {
        //查询所有
        List<User> all = userDao.findAll();
        //复杂的查询
        Specification<User> specification = new Specification<User>() {
            /**
             * 查询条件封装
             * @param root
             * @param query
             * @param criteriaBuilder
             * @return
             */

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                通过用户名查询用户信息
//                where  username= ""
                Predicate predicate = criteriaBuilder.equal(root.get("username"), "admin");
                return predicate;
            }


            @Override
            public Specification<User> and(Specification<User> other) {
                return null;
            }

            @Override
            public Specification<User> or(Specification<User> other) {
                return null;
            }

        };

        List<User> list = userDao.findAll(specification);

    }


}
