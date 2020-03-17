package com.example.community.service;

import com.example.community.dataobject.User;
import com.example.community.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServlet {
    @Autowired
    private UserServiceImpl userService;

    public void createOrUpdate(User user){
        User dbUser = userService.findByAccountId(user.getAccountId());
        if(dbUser == null){
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userService.save(user);
        }
        else{
            dbUser.setGmtModified(System.currentTimeMillis());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            userService.save(dbUser);
        }
    }
}
