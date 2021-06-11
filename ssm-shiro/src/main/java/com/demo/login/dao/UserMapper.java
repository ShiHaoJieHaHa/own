package com.demo.login.dao;

import com.demo.login.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);

    User selectByName(@Param("username") String username);
}