package com.dasol.study.controller;

import com.dasol.study.entity.User;
import com.dasol.study.service.implementation.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserServiceImp userServiceImp;

    @Autowired
    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @PostMapping(value = "/user")
    public User createUser(@RequestBody User user) {
        String userId = this.userServiceImp.create(user);
        return this.userServiceImp.find(userId);
    }

    @GetMapping("/user/{id}")
    public User findUser(@PathVariable(value = "id") String userId) {
        return this.userServiceImp.find(userId);
    }

    @GetMapping("/user")
    public List<User> findAllUsers() {
        return this.userServiceImp.findAll();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        this.userServiceImp.update(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable(value = "id") String userId) {
        this.userServiceImp.delete(userId);
    }
}
