package com.schoolSystemApplication.SchoolSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.schoolSystemApplication.SchoolSystem.Entities.ClassRoom;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<ClassRoom, Long> {
}
