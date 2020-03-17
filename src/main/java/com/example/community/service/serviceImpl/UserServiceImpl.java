package com.example.community.service.serviceImpl;

import com.example.community.dataobject.User;
import com.example.community.repository.UserRepository;
import com.example.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findOne(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User findBytoken(String token) {
        return repository.findByToken(token);
    }

    @Override
    public User findByAccountId(String accountId) {
        return repository.findByAccountId(accountId);
    }
}
