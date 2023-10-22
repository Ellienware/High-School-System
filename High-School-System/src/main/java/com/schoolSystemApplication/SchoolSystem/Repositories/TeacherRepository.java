package com.schoolSystemApplication.SchoolSystem.Repositories;

import com.schoolSystemApplication.SchoolSystem.Entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findTeacherByEmail(String email);
}
