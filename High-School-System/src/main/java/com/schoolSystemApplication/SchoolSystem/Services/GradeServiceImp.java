package com.schoolSystemApplication.SchoolSystem.Services;

import com.schoolSystemApplication.SchoolSystem.Entities.Grade;
import com.schoolSystemApplication.SchoolSystem.Exception.ResourceNotFoundException;
import com.schoolSystemApplication.SchoolSystem.Repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GradeServiceImp implements GradeService{
    @Autowired
    private final GradeRepository gradeRepository;

    public GradeServiceImp(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public void saveGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void getGradeById(Long Id) {
        boolean exist = gradeRepository.existsById(Id);
        if(!exist){
            throw new ResourceNotFoundException("Grade with id "+Id+" does not exists.");
        }
        gradeRepository.findById(Id);
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public void updateGrade(Long Id, Grade grade) {
        Grade gradeToUpdate = gradeRepository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Grade with id "+Id+" does not exists."));
        gradeToUpdate.setScore(grade.getScore());
        gradeToUpdate.setStudent(grade.getStudent());
        gradeToUpdate.setSubject(grade.getSubject());

        gradeRepository.save(gradeToUpdate);
    }

    @Override
    public void deleteGrade(long Id) {
        boolean exist = gradeRepository.existsById(Id);
        if(!exist){
            throw new ResourceNotFoundException("Grade with id "+Id+" does not exists.");
        }
        gradeRepository.deleteById(Id);
    }
}
