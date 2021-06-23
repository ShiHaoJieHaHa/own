package com.example.user.service;


import com.example.user.entity.User;

public interface UserService {
    User getUserByEmail(String email);
}
