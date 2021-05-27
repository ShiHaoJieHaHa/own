package com.oursnail.service;

import com.oursnail.entity.Student;

import java.util.List;


public interface StudentService {
    List<Student> students();

    void addStudent();

    Student showOneStudent(long Sid);
}
