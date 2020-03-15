package com.example.community.service.serviceImpl;

import com.example.community.dataobject.Question;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class QuestionServiceImplTest {

    @Autowired
    private QuestionServiceImpl questionService;

    @Test
    void findOne() {
        Question question = questionService.findOne(2);
        Assert.assertNotNull(question);
    }

    @Test
    void create() {
        Question question = new Question("2","2",2l,2l,2,2,2,2,"2");
        Question result = questionService.create(question);
        Assert.assertNotNull(result);
    }

    @Test
    void delete() {
        Question question = new Question("2","2",2l,2l,2,2,2,2,"2");
        questionService.delete(question);
    }
}