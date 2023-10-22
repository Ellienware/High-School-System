package com.schoolSystemApplication.SchoolSystem.Services;

import com.schoolSystemApplication.SchoolSystem.Entities.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    void saveTeacher(Teacher teacher);
    void getTeacherById(Long Id);
    List<Teacher> getAllTeachers();

    void updateTeacher(Long Id, Teacher teacher);

    void deleteTeacher(long Id);
}
