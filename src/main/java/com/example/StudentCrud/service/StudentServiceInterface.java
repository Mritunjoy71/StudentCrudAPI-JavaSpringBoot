package com.example.StudentCrud.service;

import com.example.StudentCrud.domain.Student;

import java.util.List;

public interface StudentServiceInterface {
    public List<Student> listAll();

    public void save(Student std);

    public Student get(long id);

    public void delete(long id) ;

    public void updateStudent(long id, Student newStudent);
}
