package com.example.StudentCrud.repository;

import com.example.StudentCrud.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RawStudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM student s")
    public List<Student> findAll() ;

    @Query("SELECT s FROM student s WHERE s.id=?1")
    public Student getById(long id) ;

    @Modifying
    @Query("DELETE FROM student s WHERE s.id=?1")
    public void deleteById(long id) ;

    @Modifying
    @Query(value = "insert into student (studentname,course,fee) VALUES (:studentname,:course, :fee)", nativeQuery = true)
    @Transactional
    public void save(@Param("studentname") String studentname, @Param("course") String course,  @Param("fee") int fee );

    @Modifying
    @Query(value = " UPDATE student SET studentname = :studentname, course = :course, fee = :fee WHERE id = :id", nativeQuery = true)
    @Transactional
    public void update(@Param("id") Long id,@Param("studentname") String studentname, @Param("course") String course,  @Param("fee") int fee);



}