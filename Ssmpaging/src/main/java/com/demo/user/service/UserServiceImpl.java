package com.demo.user.service;


import com.demo.user.dao.UserMapper;
import com.demo.user.pojo.User;
import com.demo.util.PageQueryBean;
import com.demo.util.QueryCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> showUsers() {
        return userMapper.selectAll();
    }

    @Override
    @Transactional
    public void addUser() {
        User user1 = new User();
        user1.setId(3);
        user1.setName("王二");
        user1.setAge(32);
        userMapper.insertSelective(user1);

        User user2 = new User();
        user2.setId(3);
        user2.setName("王二");
        user2.setAge(32);
        userMapper.insertSelective(user2);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageQueryBean selectAllByPage(QueryCondition queryCondition) {
        PageQueryBean pageResult = new PageQueryBean();
        int count = userMapper.countByCondition(queryCondition);
        if (count > 0) {
            pageResult.setTotalRows(count);
            pageResult.setCurrentPage(queryCondition.getCurrentPage());
            pageResult.setPageSize(queryCondition.getPageSize());
            List<User> users = userMapper.selectAllByPage(queryCondition);
            pageResult.setItems(users);
        }
        return pageResult;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
