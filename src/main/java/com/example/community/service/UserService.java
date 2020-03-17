package com.example.community.service;

import com.example.community.dataobject.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserService {

    User findOne(Integer id);

    User save(User user);

    User findBytoken(String token);

    User findByAccountId(String accountId);
}
