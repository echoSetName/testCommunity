package com.example.community.repository;

import com.example.community.dataobject.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

    List<Question> findAllByCreator(Integer creator);
}
