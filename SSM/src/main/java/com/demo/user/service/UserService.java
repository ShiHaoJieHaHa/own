package com.demo.user.service;

import com.demo.user.entity.User;

import java.util.List;

public interface UserService {
    List<User> showUsers();
    void addUser();
    User getUserById(int id);
}
