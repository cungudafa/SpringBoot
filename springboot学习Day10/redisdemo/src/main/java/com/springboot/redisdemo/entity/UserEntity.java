package com.springboot.redisdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="t_user")
@Data
public class UserEntity implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_age")
    private int age;

    @Column(name = "t_address")
    private String address;

    @Column(name = "t_password")
    private Long password;
}
