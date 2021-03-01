package com.aerospike.userdemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aerospike.userdemo.objects.User;
import com.aerospike.userdemo.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
    UserService userService;
    
    
    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }
    
    @GetMapping("/users/{id}")
    public Optional<User> readUserById(@PathVariable("id") Integer id) {
        return userService.readUserById(id);
    }
    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        userService.removeUserById(id);
    }
}