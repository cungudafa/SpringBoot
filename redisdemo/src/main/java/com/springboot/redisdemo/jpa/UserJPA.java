package com.springboot.redisdemo.jpa;



import com.springboot.redisdemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;


/**
 * 数据库操作dao接口
 * SpringBoot+SpringDataJPA
*/
public interface UserJPA extends
        JpaRepository<UserEntity,Long>,//SpringDataJPA提供的简单数据操作接口
        JpaSpecificationExecutor<UserEntity>, //SpringDataJPA提供的复杂查询接口
        Serializable {
}
