package com.dasol.study.store.implementation;

import com.dasol.study.entity.User;
import com.dasol.study.store.UserStore;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserStoreImp implements UserStore {

    private Map<String, User> data;

    public UserStoreImp() {
        this.data = new HashMap<>();
    }

    @Override
    public String create(User user) {
        this.data.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public void update(User user) {
        this.data.put(user.getId(), user);
    }

    @Override
    public void delete(String id) {
        this.data.remove(id);
    }

    @Override
    public User find(String id) {
        return this.data.get(id);
    }

    @Override
    public List<User> findAll() {
        return this.data.values().stream().collect(Collectors.toList());
    }
}
