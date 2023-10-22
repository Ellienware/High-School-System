package com.schoolSystemApplication.SchoolSystem.Services;

import com.schoolSystemApplication.SchoolSystem.Entities.Subjects;
import com.schoolSystemApplication.SchoolSystem.Exception.ResourceNotFoundException;
import com.schoolSystemApplication.SchoolSystem.Repositories.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SubjectsServiceImp implements SubjectService{
    @Autowired
    private final SubjectsRepository subjectsRepository;

    public SubjectsServiceImp(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }

    @Override
    public void saveSubject(Subjects subject) {
        subjectsRepository.save(subject);
    }

    @Override
    public void getSubjectById(Long Id) {
        boolean exist = subjectsRepository.existsById(Id);
        if(!exist){
            throw new ResourceNotFoundException("Subject with id "+Id+" does not exist");
        }
        subjectsRepository.findById(Id);
    }

    @Override
    public List<Subjects> getAllSubjects() {
        return subjectsRepository.findAll();
    }

    @Override
    public void updateSubject(Long Id, Subjects subject) {
        Subjects subjectToUpdate = subjectsRepository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Subject with id "+Id+" does not exist"));
        subjectToUpdate.setName(subject.getName());
        subjectToUpdate.setCode(subject.getCode());
        subjectToUpdate.setTeachers(subject.getTeachers());
        subjectToUpdate.setStudents(subject.getStudents());

        subjectsRepository.save(subjectToUpdate);
    }

    @Override
    public void deleteSubject(long Id) {
        boolean exist = subjectsRepository.existsById(Id);
        if(!exist){
            throw new ResourceNotFoundException("Subject with id "+Id+" does not exist");
        }
        subjectsRepository.deleteById(Id);
    }
}
