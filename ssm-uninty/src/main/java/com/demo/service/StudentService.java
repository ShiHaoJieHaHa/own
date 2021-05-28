package com.demo.service;

import com.demo.entity.Student;

import java.util.List;


public interface StudentService {
    List<Student> students();

    void addStudent();

    Student showOneStudent(long Sid);
}
