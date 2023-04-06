package com.ppfurtado.jgcrud.service.impl;

import com.ppfurtado.jgcrud.entity.User;
import com.ppfurtado.jgcrud.repository.UserRepository;
import com.ppfurtado.jgcrud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User findById(Long id) {
        Optional<User> user =  repository.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = findById(user.getId());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return createUser(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = findById(id);
        repository.delete(existingUser);
    }
}
