package com.example.community.service;

import com.example.community.dataobject.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface QuestionService {

    Question findOne(Integer id);

    Question create(Question question);

    void delete(Question question);

    @Query(nativeQuery=true,value = "select count(1) form question}")
    Integer count();

    Page<Question> findAll(Pageable pageable);
}
