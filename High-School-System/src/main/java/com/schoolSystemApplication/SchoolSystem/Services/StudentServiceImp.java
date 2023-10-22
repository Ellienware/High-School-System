package com.schoolSystemApplication.SchoolSystem.Services;

import com.schoolSystemApplication.SchoolSystem.Entities.Student;
import com.schoolSystemApplication.SchoolSystem.Exception.ResourceNotFoundException;
import com.schoolSystemApplication.SchoolSystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    private final StudentRepository studentRepository;
    public StudentServiceImp(StudentRepository studentRepository, StudentRepository studentRepository1){
        this.studentRepository = studentRepository1;
    }
    @Override
    public void saveStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Student already Exist");
        }
        studentRepository.save(student);
    }

    @Override
    public void getStudentById(Long Id) {
        boolean exist = studentRepository.existsById(Id);
        if(!exist){
            throw new ResourceNotFoundException("Student with id "+Id+" does not exist.");
        }
        studentRepository.findById(Id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void updateStudent(Long Id, Student student) {
        Student studentToUpdate = studentRepository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Student with id "+Id+" does not exist."));
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        studentToUpdate.setStudentId(student.getStudentId());
        studentToUpdate.setEmail(student.getEmail());
        studentToUpdate.setDOB(student.getDOB());
        studentToUpdate.setSubjects(student.getSubjects());

        studentRepository.save(studentToUpdate);
    }

    @Override
    public void deleteStudent(long Id) {
        boolean exist = studentRepository.existsById(Id);
        if(!exist){
            throw new ResourceNotFoundException("Student with id "+Id+" does not exist.");
        }
        studentRepository.deleteById(Id);

    }
}
