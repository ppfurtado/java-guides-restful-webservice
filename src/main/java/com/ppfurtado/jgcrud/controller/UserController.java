package com.ppfurtado.jgcrud.controller;


import com.ppfurtado.jgcrud.dto.UserDto;
import com.ppfurtado.jgcrud.entity.User;
import com.ppfurtado.jgcrud.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        UserDto findUser = userService.findById(id);
        return ResponseEntity.ok(findUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> findById() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable("id") Long id ,@RequestBody UserDto userDto){
        UserDto userUpdated = userService.updateUser(userDto, id);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleterUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User Sucessfully deleted", HttpStatus.OK);
    }
}
