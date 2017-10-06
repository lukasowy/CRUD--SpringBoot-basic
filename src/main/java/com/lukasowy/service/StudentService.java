package com.lukasowy.service;

import com.lukasowy.dao.StudentDaoImpl;
import com.lukasowy.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    @Qualifier("studentDaoImpl")
    private StudentDaoImpl studentDaoImpl;

    public Collection<Student> getAllStudent(){
        return studentDaoImpl.getAllStudent();
    }

    public Student getStudentById(int id){
        return studentDaoImpl.getStudentById(id);
    }

    public Student removeStudentById(int id) {
        return studentDaoImpl.removeStudentById(id);
    }

    public void updateStudent(Student student){
       this.studentDaoImpl.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDaoImpl.insertStudent(student);
    }
}
