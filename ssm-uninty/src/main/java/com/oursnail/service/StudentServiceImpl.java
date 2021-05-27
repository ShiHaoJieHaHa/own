package com.oursnail.service;

import com.oursnail.dao.StudentMapper;
import com.oursnail.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> students() {

        return studentMapper.selectAllStudents();
    }

    @Override
    @Transactional
    public void addStudent() {
        Student student = new Student();
        student.setSid(8L);
        student.setSname("swg");
        student.setSsex("男");
        studentMapper.insertSelective(student);
        System.out.println("插入成功了");
        Student student2 = new Student();
        student2.setSid(9L);
        student2.setSname("swg");
        student2.setSsex("男");
        studentMapper.insertSelective(student2);
    }

    @Override
    public Student showOneStudent(long Sid) {

        return studentMapper.selectByPrimaryKey(Sid);
    }
}
