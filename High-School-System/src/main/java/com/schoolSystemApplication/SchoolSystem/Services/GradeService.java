package com.schoolSystemApplication.SchoolSystem.Services;

import com.schoolSystemApplication.SchoolSystem.Entities.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeService {
    void saveGrade(Grade grade);
    void getGradeById(Long Id);
    List<Grade> getAllGrades();

    void updateGrade(Long Id, Grade grade);

    void deleteGrade(long Id);
}
