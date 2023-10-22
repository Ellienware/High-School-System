package com.schoolSystemApplication.SchoolSystem.Repositories;

import com.schoolSystemApplication.SchoolSystem.Entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
