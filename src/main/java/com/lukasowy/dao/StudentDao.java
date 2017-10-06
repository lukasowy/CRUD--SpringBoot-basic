package com.lukasowy.dao;

import com.lukasowy.entity.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudent();

    Student getStudentById(int id);

    Student removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
