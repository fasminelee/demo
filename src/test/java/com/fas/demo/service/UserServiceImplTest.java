package com.fas.demo.service;

import com.fas.demo.entity.User;
import com.fas.demo.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void testAdd() {
        for (Integer i = 100; i < 200; i++) {
            User user = new User();
            user.setNickName("昵称" + i);
            user.setUserName("user" + i);
            user.setAge(i);
            user.setPassword("pwd" + i);
            user.setEmail("email" + i + "@domain.com");
            user.setRegTime(new Date());
            userService.save(user);
        }
    }

    @Test
    public void testSave() {
        for (int i = 200; i < 300; i++) {
            User user = new User();
            user.setUserName("name" + 1);
            user.setPassword("aa" + i);
            user.setAge(i);
            user.setEmail(i + "mail".concat("@163.com"));
            user.setNickName("nickName" + i);
            user.setRegTime(new Date());
            userService.save(user);
        }


    }
}
