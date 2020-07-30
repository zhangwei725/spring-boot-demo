package com.smart.hibernate.dao;

import com.smart.hibernate.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 过滤行
 *
 */
@Repository
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    // 自定义  findAll
    List<User> findAll(Specification<User> specification);

    // JPQL 语句
    @Query(value = "select  u from  User u   where  u.username=?1")
    List<User> findByUsers(String username);

    @Query(value = "SELECT * FROM  tb_user WHERE username=?", nativeQuery = true)
    List<User> findByNavUsers(String username);

}
