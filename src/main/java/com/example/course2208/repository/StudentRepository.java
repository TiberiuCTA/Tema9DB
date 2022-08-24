package com.example.course2208.repository;

import com.example.course2208.model.Student;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllBySpecialty(Integer specialtyId);
}
