package com.lukasowy.controller;

import com.lukasowy.entity.Student;
import com.lukasowy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Student removeStudentById(@PathVariable("id") int id){
        return studentService.removeStudentById(id);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public void updateStudent(@RequestBody Student student){
        this.studentService.updateStudent(student);
    }
    @RequestMapping(method = RequestMethod.POST)
    public void insertStudent(@RequestBody Student student){
        this.studentService.insertStudent(student);
    }
}
