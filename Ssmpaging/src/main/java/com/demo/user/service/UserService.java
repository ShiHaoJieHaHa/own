package com.demo.user.service;



import com.demo.user.pojo.User;
import com.demo.util.PageQueryBean;
import com.demo.util.QueryCondition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> showUsers();
    void addUser();
    User getUserById(int id);

    PageQueryBean selectAllByPage(QueryCondition queryCondition);

    void updateUser(User user);
}
