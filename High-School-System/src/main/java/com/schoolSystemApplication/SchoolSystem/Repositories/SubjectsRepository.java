package com.schoolSystemApplication.SchoolSystem.Repositories;

import com.schoolSystemApplication.SchoolSystem.Entities.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectsRepository extends JpaRepository<Subjects, Long> {
}
