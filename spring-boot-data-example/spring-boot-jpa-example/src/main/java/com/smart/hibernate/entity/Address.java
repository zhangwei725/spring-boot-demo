package com.smart.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "tb_address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer aid;
    @Column(unique = true)
    private String city;
    @Column(unique = true)
    private Integer uid;

}
