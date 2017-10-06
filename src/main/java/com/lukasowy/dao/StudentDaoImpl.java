package com.lukasowy.dao;

import com.lukasowy.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {
    private static Map<Integer, Student> students;

    static{
        students = new HashMap<Integer, Student>(){
            {
                put(1,new Student(1, "Maniek", "Computer Science"));
                put(2,new Student(2, "Czesiek", "Computer Science"));
                put(3,new Student(3, "Walerian", "Computer Science"));
                put(4,new Student(4, "Eutanazjusz", "Computer Science"));

            }
        };
    }


    @Override
    public Collection<Student> getAllStudent(){
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    @Override
    public Student removeStudentById(int id) {
        return this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        this.students.put(student.getId(), student);
    }

    @Override
    public void insertStudent(Student student) {
     this.students.put(student.getId(), student);
    }
}
