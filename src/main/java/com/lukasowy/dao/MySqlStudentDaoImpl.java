package com.lukasowy.dao;

import com.lukasowy.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mysql")
public class MySqlStudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //It make it easy to create a student instance in database
    public static class StudentRowMapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setCourse(resultSet.getString("course"));
            return student;
        }
    }

    //GET request
    @Override
    public Collection<Student> getAllStudent() {
        final String sql = "SELECT id, name, course FROM students";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
        return students;
    }

    //GET request by Id
    @Override
    public Student getStudentById(int id) {
        final String sql = "SELECT id, name, course FROM students where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }
    //DELETE request
    @Override
    public void removeStudentById(int id) {
        final String sql = "DELETE FROM students WHERE id= ?";
        jdbcTemplate.update(sql, id);
    }

    //POST request
    @Override
    public void updateStudent(Student student) {
        final String sql = "UPDATE students SET name = ?, course = ? WHERE id = ?";
        final int id = student.getId();
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[] {name, course, id});
    }

    //PUT request
    @Override
    public void insertStudent(Student student) {
        final String sql = " INSERT INTO students (name, course) VALUES (?, ?)";
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[] {name, course});

    }
}
