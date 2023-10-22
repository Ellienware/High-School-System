package com.schoolSystemApplication.SchoolSystem.Services;

import com.schoolSystemApplication.SchoolSystem.Entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void saveStudent(Student student);
    void getStudentById(Long Id);
    List<Student> getAllStudents();

    void updateStudent(Long Id, Student student);

    void deleteStudent(long Id);
}
