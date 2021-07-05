package com.example.StudentCrud.api;

import com.example.StudentCrud.domain.Student;
import com.example.StudentCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/student")
@RestController
public class SudentApiController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAllStudent() {
        return service.listAll();
    }

    @PostMapping
    public void addStudent(@Valid @NonNull @RequestBody Student student) {
        service.save(student);
    }

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable("id") long id) {
        return service.get(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudentById(@PathVariable("id") long id) {
        service.delete(id);
    }


    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") long id, @Valid @NonNull @RequestBody Student newStudent) {
        service.updateStudent(id, newStudent);
    }

}
