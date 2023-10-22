package com.schoolSystemApplication.SchoolSystem.Services;

import com.schoolSystemApplication.SchoolSystem.Entities.ClassRoom;
import com.schoolSystemApplication.SchoolSystem.Exception.ResourceNotFoundException;
import com.schoolSystemApplication.SchoolSystem.Repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClassServiceImp implements ClassService{

    private final ClassRepository classRepository;
    @Autowired
    public ClassServiceImp(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public void saveClass(ClassRoom theClass) {
        classRepository.save(theClass);
    }

    @Override
    public void getClassById(Long Id) {
        boolean exist = classRepository.existsById(Id);
        if(!exist){
            throw new ResourceNotFoundException("Class with id "+Id+" does not exist.");
        }
        classRepository.findById(Id);
    }

    @Override
    public List<ClassRoom> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public void updateClass(Long Id, ClassRoom theClass) {
        ClassRoom classToUpdate = classRepository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Class with id"+Id+" does not exist."));
        classToUpdate.setClassName(theClass.getClassName());
        classToUpdate.setSubjects(theClass.getSubjects());
        classToUpdate.setRoomNumber(theClass.getRoomNumber());
        classToUpdate.setStartTime(theClass.getStartTime());
        classToUpdate.setEndTime(theClass.getEndTime());
        classToUpdate.setDayOfWeek(theClass.getDayOfWeek());

        classRepository.save(classToUpdate);
    }

    @Override
    public void deleteClass(long Id) {
        boolean exist = classRepository.existsById(Id);
        if(!exist){
            throw new ResourceNotFoundException("Class with id "+Id+" does not exist.");
        }
        classRepository.deleteById(Id);
    }
}
