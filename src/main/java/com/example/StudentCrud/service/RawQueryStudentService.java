package com.example.StudentCrud.service;

import com.example.StudentCrud.domain.Student;
import com.example.StudentCrud.repository.RawStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawQueryStudentService implements StudentServiceInterface{

    private RawStudentRepository  repo;
    @Autowired
    public RawQueryStudentService(RawStudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Student> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Student std) {
        repo.save(std.getStudentname(),std.getCourse(),std.getFee());
    }
    @Override
    public Student get(long id) {
        return repo.getById(id);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public void updateStudent(long id, Student newStudent) {
        repo.update(id,newStudent.getStudentname(),newStudent.getCourse(),newStudent.getFee());
    }
}
