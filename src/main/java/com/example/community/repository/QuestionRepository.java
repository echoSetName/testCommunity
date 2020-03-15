package com.example.community.repository;

import com.example.community.dataobject.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

}
