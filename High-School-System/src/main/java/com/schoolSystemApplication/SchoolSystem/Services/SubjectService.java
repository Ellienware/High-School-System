package com.schoolSystemApplication.SchoolSystem.Services;

import com.schoolSystemApplication.SchoolSystem.Entities.Subjects;

import java.util.List;

public interface SubjectService {
    void saveSubject(Subjects subject);
    void getSubjectById(Long Id);
    List<Subjects> getAllSubjects();

    void updateSubject(Long Id, Subjects subject);

    void deleteSubject(long Id);
}
