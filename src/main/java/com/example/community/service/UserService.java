package com.example.community.service;

import com.example.community.dataobject.User;

public interface UserService {

    User findOne(Integer id);

    User save(User user);

    User findBytoken(String token);
}
