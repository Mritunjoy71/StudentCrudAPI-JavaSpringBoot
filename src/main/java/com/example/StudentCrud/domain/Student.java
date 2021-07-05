package com.example.StudentCrud.domain;

import javax.persistence.*;

@Table(name = "student")
@Entity(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "studentname")
    private String studentname;
    @Column(name = "course")
    private String course;
    @Column(name = "fee")
    private int fee;

    public Student() {
        super();
    }

    public Student(Long id, String studentname, String course, int fee) {
        this.id = id;
        this.studentname = studentname;
        this.course = course;
        this.fee = fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}