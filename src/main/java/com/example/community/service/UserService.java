package com.example.community.service;

import com.example.community.mapper.UserInfoMapper;
import com.example.community.model.UserInfo;
import com.example.community.model.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public void createOrUpdate(UserInfo user){
        UserInfoExample userExample = new UserInfoExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<UserInfo> users = userInfoMapper.selectByExample(userExample);
        if(users.size() == 0){
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userInfoMapper.insert(user);
        }
        else{
            UserInfo dbUser = users.get(0);
            UserInfo updateUser = new UserInfo();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            UserInfoExample example = new UserInfoExample();
            example.createCriteria().andIdEqualTo(dbUser.getId());
            userInfoMapper.updateByExampleSelective(updateUser, example);
        }
    }
}
