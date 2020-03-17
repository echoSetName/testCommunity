package com.example.community.controller;

import com.example.community.dataobject.Question;
import com.example.community.dto.QuestionDTO;
import com.example.community.service.serviceImpl.QuestionDTOServiceImpl;
import com.example.community.service.serviceImpl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

    @Autowired
    private QuestionDTOServiceImpl questionDTOService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id")Integer id,
                           Model model){
        QuestionDTO questionDTO = questionDTOService.getById(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
