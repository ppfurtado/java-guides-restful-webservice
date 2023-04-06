package com.ppfurtado.jgcrud.controller;


import com.ppfurtado.jgcrud.entity.User;
import com.ppfurtado.jgcrud.service.UserService;
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
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) throws Exception {
        User findUser = userService.findById(id);
        return ResponseEntity.ok(findUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> findById() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id ,@RequestBody User user){
        user.setId(id);
        User userUpdated = userService.updateUser(user);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleterUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User Sucessfully deleted", HttpStatus.OK);
    }
}
