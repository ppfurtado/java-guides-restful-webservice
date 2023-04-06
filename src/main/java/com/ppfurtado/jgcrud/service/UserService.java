package com.ppfurtado.jgcrud.service;

import com.ppfurtado.jgcrud.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User findById(Long id) throws Exception;

    List<User> findAll();

    User updateUser(User user);

    void deleteUser(Long id);
}
