package com.example.StudentCrud.service;

import com.example.StudentCrud.domain.Student;
import com.example.StudentCrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {
    @Autowired
    private StudentRepository repo;

    public List<Student> listAll() {
        return repo.findAll();
    }

    public void save(Student std) {
        repo.save(std);
    }

    public Student get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public void updateStudent(long id, Student newStudent) {
        Student updateStudent = repo.findById(id).get();
        updateStudent.setStudentname(newStudent.getStudentname());
        updateStudent.setCourse(newStudent.getCourse());
        updateStudent.setFee(newStudent.getFee());
        repo.save(updateStudent);
    }
}
