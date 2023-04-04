package com.ppfurtado.jgcrud.service.impl;

import com.ppfurtado.jgcrud.entity.User;
import com.ppfurtado.jgcrud.repository.UserRepository;
import com.ppfurtado.jgcrud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public User createUser(User user) {
        return null;
    }
}
