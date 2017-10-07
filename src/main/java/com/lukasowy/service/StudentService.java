package com.lukasowy.service;

import com.lukasowy.dao.StudentDao;
import com.lukasowy.dao.StudentDaoImpl;
import com.lukasowy.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    @Qualifier("mysql")
    private StudentDao studentDao;

    public Collection<Student> getAllStudent(){
        return studentDao.getAllStudent();
    }

    public Student getStudentById(int id){
        return studentDao.getStudentById(id);
    }

    public void removeStudentById(int id) {
         studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student){
       this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDao.insertStudent(student);
    }
}
