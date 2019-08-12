package com.springboot.three.jpa;


import com.springboot.three.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;


/**
 * 数据库操作
 * SpringBoot+SpringDataJPA
 * SpringDataJPA内部使用了类代理的方式
 * 让继承了它接口的子接口都以spring管理的Bean的形式存在，
 * 也就是说我们可以直接使用@Autowired注解在spring管理bean使用
 */
public interface UserJPA extends
        JpaRepository<UserEntity,Long>,//SpringDataJPA提供的简单数据操作接口
        JpaSpecificationExecutor<UserEntity>, //SpringDataJPA提供的复杂查询接口
        Serializable {

    UserEntity findByNameAndPassword(String name, Long password);

    List<UserEntity> findByNameLike(String name);
}
