package com.schoolSystemApplication.SchoolSystem.Repositories;

import com.schoolSystemApplication.SchoolSystem.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
}
