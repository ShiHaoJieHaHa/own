package com.demo.login.service;

import com.demo.login.entity.User;

import java.util.Set;

public interface UserService {
    public User getUserByName(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
