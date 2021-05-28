package com.demo.dao;

import com.demo.entity.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectAllStudents();
}