package com.example.community.controller;

import com.example.community.dto.PaginationDTO;
import com.example.community.service.serviceImpl.QuestionDTOServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private QuestionDTOServiceImpl questionDTOService;

    // 小用户量的情况下，通过判断数据库里是否已存在token，而实现持久化登录
    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name="page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size){

        PaginationDTO pagination = questionDTOService.list(page, size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
