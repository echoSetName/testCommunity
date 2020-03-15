package com.example.community.service.serviceImpl;

import com.example.community.dataobject.Question;
import com.example.community.dataobject.User;
import com.example.community.dto.PaginationDTO;
import com.example.community.dto.QuestionDTO;
import com.example.community.service.QuestionDTOService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionDTOServiceImpl implements QuestionDTOService {

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public PaginationDTO list(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionService.count();
        paginationDTO.setPagination(totalCount, page, size);
        // 判断输入的页面是否超过范围
        if(page < 1){
            page = 1;
        }
        if(page > paginationDTO.getTotalPage()){
            page =  paginationDTO.getTotalPage();
        }

        // size*(page-1)
        Integer offse = size * (page - 1);
        PageRequest request = PageRequest.of(page-1,size);
        List<Question> questionList =  questionService.findAll(request).getContent();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for(Question question:questionList){
            User user = userService.findOne(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }
}
