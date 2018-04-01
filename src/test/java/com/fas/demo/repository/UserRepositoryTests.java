package com.fas.demo.repository;

import com.fas.demo.entity.User;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Test
    public void testAAAdd() throws Exception {
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//        String formattedDate = dateFormat.format(date);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUserName("user" + i);
            user.setNickName("昵称" + i);
            user.setEmail("email" + i + "@domain.com");
            user.setPassword("pwd" + i);
            user.setAge(i);
            user.setRegTime(new Date());
            users.add(user);
        }
        List<User> results = repository.saveAll(users);
        Assert.assertEquals(true, results.size() > 0);
    }

    @Test
    public void testZZZDelete() {
        repository.deleteAll();
    }

    @Test
    public void testFind() {
        Assert.assertNotNull(repository.findByUserNameOrEmail("user50", "email50@domain.com"));
        Assert.assertNotNull(repository.findByAgeBetween(15,25));
//        Assert.assertTrue("记录数大于 0?",repository.getCount() > 0);
    }

    @Test
    public void testFinda() {

    }

}