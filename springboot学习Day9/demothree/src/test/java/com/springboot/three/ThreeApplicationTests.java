package com.springboot.three;

import com.springboot.three.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreeApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void testLombok()
    {
        //测试Getter/Setter
        UserEntity user = new UserEntity();
        user.setName("测试lombok");
        user.setAge(10);
        user.setAddress("测试地址");
        user.setId(1L);
        //user.setPassword(123456L);

        System.out.println(user.getName()+"  " + user.getAge() +"  "+user.getAddress());
        System.out.println("Lombok为我们提供了自动生成toString方法的注解:toString()\n"+user.toString());
    }
    @Test
    public void testLombok2()
    {
        //测试AllArgsConstructor
        UserEntity user = new UserEntity(1l,"Lombok",20,"构造lombok",123456l);
        //id:1l,password:123456l是因为Long类型写法
        System.out.println(user.toString());
        log.info(user.toString());
    }

}
