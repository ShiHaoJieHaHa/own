package com.example.register.dao;


import com.example.register.entity.Register;

public interface RegisterMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);

    Register getRegisterByCode(String code);

    Register getRegisterByUserId(Long userId);
}