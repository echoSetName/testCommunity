package com.example.community.controller;

import com.example.community.dataobject.Question;
import com.example.community.dataobject.User;
import com.example.community.dto.PaginationDTO;
import com.example.community.dto.QuestionDTO;
import com.example.community.service.serviceImpl.QuestionDTOServiceImpl;
import com.example.community.service.serviceImpl.QuestionServiceImpl;
import com.example.community.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private QuestionDTOServiceImpl questionDTOService;

    // 小用户量的情况下，通过判断数据库里是否已存在token，而实现持久化登录
    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name="page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userService.findBytoken(token);
                    if(user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        PaginationDTO pagination = questionDTOService.list(page, size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
