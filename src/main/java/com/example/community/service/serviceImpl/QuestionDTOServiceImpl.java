package com.example.community.service.serviceImpl;

import com.example.community.Utils.ListToPageUtil;
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

    @Autowired
    private ListToPageUtil listToPageUtil;

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
        PageRequest request;
        if(page > 0){
            request = PageRequest.of(page-1,size);
        } else{
            request = PageRequest.of(1,size);
        }
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

    public PaginationDTO list(Integer userId, Integer page, Integer size) {

        List<Question> questions = questionService.findAllByCreator(userId);
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionService.findAllByCreator(userId).size();
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
        PageRequest request;
        List<Question> questionList = null;
        if(page > 0){
            request = PageRequest.of(page-1,size);
            questionList =  listToPageUtil.listConvertToPage(questionService.findAllByCreator(userId),request).getContent();
        } else{
            request = PageRequest.of(1,size);
        }
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        if (questionList != null && questionList.size()!=0) {
            for(Question question:questionList){
                User user = userService.findOne(question.getCreator());
                QuestionDTO questionDTO = new QuestionDTO();
                BeanUtils.copyProperties(question,questionDTO);
                questionDTO.setUser(user);
                questionDTOList.add(questionDTO);
            }
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public QuestionDTO getById(Integer id){
        Question question = questionService.findOne(id);
        User user = userService.findOne(question.getCreator());
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        questionDTO.setUser(user);
        return questionDTO;
    }
}

