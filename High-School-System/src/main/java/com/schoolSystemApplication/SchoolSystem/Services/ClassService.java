package com.schoolSystemApplication.SchoolSystem.Services;

import com.schoolSystemApplication.SchoolSystem.Entities.ClassRoom;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    void saveClass(ClassRoom theClass);
    void getClassById(Long Id);
    List<ClassRoom> getAllClasses();

    void updateClass(Long Id, ClassRoom theClass);

    void deleteClass(long Id);
}
