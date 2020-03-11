package com.example.community.service.serviceImpl;

import com.example.community.dataobject.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void findOne() {
        User user = userService.findOne(1);
        Assert.assertEquals(new Integer(1), user.getId());
    }

    @Test
    void save() {
        User user = new User("2", "2", "2", System.currentTimeMillis(), System.currentTimeMillis());
        User result = userService.save(user);
        Assert.assertNotNull(result);
    }
}