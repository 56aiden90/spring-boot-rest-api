package com.dasol.study.service.implementation;

import com.dasol.study.entity.User;
import com.dasol.study.service.UserService;
import com.dasol.study.store.implementation.UserStoreImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserStoreImp userStoreImp;

    @Autowired
    public UserServiceImp(UserStoreImp userStoreImp) {
        this.userStoreImp = userStoreImp;
    }

    @Override
    public String create(User user) {
        return this.userStoreImp.create(user);
    }

    @Override
    public void update(User user) {
        this.userStoreImp.update(user);
    }

    @Override
    public void delete(String id) {
        this.userStoreImp.delete(id);
    }

    @Override
    public User find(String id) {
        return this.userStoreImp.find(id);
    }

    @Override
    public List<User> findAll() {
        return this.userStoreImp.findAll();
    }
}
