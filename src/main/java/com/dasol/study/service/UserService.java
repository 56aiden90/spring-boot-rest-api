package com.dasol.study.service;

import com.dasol.study.entity.User;

import java.util.List;

public interface UserService {
    String create(User user);

    void update(User user);

    void delete(String id);

    User find(String id);

    List<User> findAll();
}
