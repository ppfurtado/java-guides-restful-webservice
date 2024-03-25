package com.ppfurtado.jgcrud.service.impl;

import com.ppfurtado.jgcrud.dto.UserDto;
import com.ppfurtado.jgcrud.entity.User;
import com.ppfurtado.jgcrud.excepetion.EmailAlreadyExistsException;
import com.ppfurtado.jgcrud.excepetion.ResourceNotFoundException;
import com.ppfurtado.jgcrud.mapper.AutoUserMapper;
import com.ppfurtado.jgcrud.repository.UserRepository;
import com.ppfurtado.jgcrud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public UserDto createUser(UserDto userDto) {
        boolean hasEmail = repository.existsByEmail(userDto.email());

        if (hasEmail) throw new EmailAlreadyExistsException("Email Already Exists for User");

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        return AutoUserMapper.MAPPER.mapToUSerDto(repository.save(user));
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> user =  repository.findById(id);
        return AutoUserMapper.MAPPER.mapToUSerDto(user.orElseThrow( () -> new ResourceNotFoundException("User", "id", id)));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        UserDto existingUser = findById(id);

        BeanUtils.copyProperties(existingUser, userDto, "id");

        return createUser(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        UserDto existingUser = findById(id);

        repository.delete(AutoUserMapper.MAPPER.mapToUser(existingUser));
    }
}
