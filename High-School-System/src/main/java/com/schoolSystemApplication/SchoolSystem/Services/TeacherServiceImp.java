package com.schoolSystemApplication.SchoolSystem.Services;

import com.schoolSystemApplication.SchoolSystem.Entities.Teacher;
import com.schoolSystemApplication.SchoolSystem.Exception.ResourceNotFoundException;
import com.schoolSystemApplication.SchoolSystem.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TeacherServiceImp implements TeacherService{
    @Autowired
    private final TeacherRepository teacherRepository;

    public TeacherServiceImp(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findTeacherByEmail(teacher.getEmail());
        if(teacherOptional.isPresent()){
            throw new IllegalStateException("email already exist");
        }
        teacherRepository.save(teacher);
    }

    @Override
    public void getTeacherById(Long Id) {
        boolean exist = teacherRepository.existsById(Id);
        if(!exist){
            throw new ResourceNotFoundException("Teacher by id "+Id+" does not exist");
        }
        teacherRepository.findById(Id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void updateTeacher(Long Id, Teacher teacher) {
        Teacher teacherToUpdate = teacherRepository.findTeacherByEmail(teacher.getEmail())
                .orElseThrow(()-> new ResourceNotFoundException("Teacher by id "+Id+" does not exist"));
        teacherToUpdate.setFirstName(teacher.getFirstName());
        teacherToUpdate.setLastName(teacher.getLastName());
        teacherToUpdate.setTeacherId(teacher.getTeacherId());
        teacherToUpdate.setEmail(teacher.getEmail());
        teacherToUpdate.setDOB(teacher.getDOB());
        teacherToUpdate.setPosition(teacher.getPosition());
        teacherToUpdate.setSubjects(teacher.getSubjects());

        teacherRepository.save(teacherToUpdate);
    }

    @Override
    public void deleteTeacher(long Id) {
        boolean exist = teacherRepository.existsById(Id);
        if(!exist){
            throw new ResourceNotFoundException("Teacher by id "+Id+" does not exist");
        }
        teacherRepository.deleteById(Id);

    }
}
