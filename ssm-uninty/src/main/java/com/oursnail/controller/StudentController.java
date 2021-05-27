package com.oursnail.controller;

import com.oursnail.entity.Student;
import com.oursnail.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/students")
    public String showAllStudents(Model model){
        List<Student> students = studentService.students();
        model.addAttribute("students",students);
        return "/students";
    }

    @RequestMapping("/addStudent")
    public void addStudent(){
        studentService.addStudent();
    }

    @RequestMapping("/showStudentById/{Sid}")
    @ResponseBody
    public Student showStudentById(@PathVariable long Sid){
        Student student = studentService.showOneStudent(Sid);
        return student;
    }
}
