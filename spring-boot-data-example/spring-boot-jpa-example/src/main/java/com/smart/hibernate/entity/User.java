package com.smart.hibernate.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 注解
 */

/**
 * SSH
 * JPA  Hibernate
 */
@Entity(name = "tb_user")
@Table
@Data
public class User {
    // 表示主键
    @Id
    // 表示主键生成策略
    // IDENTITY 主键自增  mysql
    // SEQUENCE  通过序列方式来实现主键自增       oracle  12C

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column()
    private String username;
    @Column
    private String password;
    @Column(name = "create_date", length = 255)
//    default  now()
    @CreatedDate
    private Date createDate;
    @Column(name = "is_del")
    private Integer isDel;
    // default  new() on update
    @LastModifiedDate
    private Timestamp loginDate;

    @Column(precision=9,scale = 2)
    // decimal(9,2)
    private BigDecimal  price;

}
