package com.ppfurtado.jgcrud.service;

import com.ppfurtado.jgcrud.dto.UserDto;
import com.ppfurtado.jgcrud.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto findById(Long id);

    List<User> findAll();

    UserDto updateUser(UserDto userDto, Long id);

    void deleteUser(Long id);
}
