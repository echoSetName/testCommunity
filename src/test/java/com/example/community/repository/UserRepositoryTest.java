package com.example.community.repository;

import com.example.community.dataobject.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void update(){
        User user = repository.findById(10).get();
        user.setGmtModified(System.currentTimeMillis());
        User save = repository.save(user);
        Assert.assertNotNull(save);
    }

}