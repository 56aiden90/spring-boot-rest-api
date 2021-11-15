package com.dasol.study.store;

import com.dasol.study.entity.User;

import java.util.List;

public interface UserStore {

    String create(User user);

    void update(User user);

    void delete(String id);

    User find(String id);

    List<User> findAll();

}
