package com.example.community.service.serviceImpl;

import com.example.community.dataobject.Question;
import com.example.community.repository.QuestionRepository;
import com.example.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository repository;

    @Override
    public Question findOne(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Question create(Question question) {
        if(question.getLikeCount() == null){
            question.setLikeCount(0);
        }
        if(question.getViewCount() == null){
            question.setViewCount(0);
        }
        if(question.getCommentCount() == null){
            question.setCommentCount(0);
        }
        return repository.save(question);
    }

    @Override
    public void delete(Question question) {
        repository.delete(question);
    }



    @Override
    public Integer count() {
        return Integer.parseInt(repository.count() + "");
    }


    @Override
    public Page<Question> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

}
