package com.schoolSystemApplication.SchoolSystem.Controllers;

import com.schoolSystemApplication.SchoolSystem.Entities.Student;
import com.schoolSystemApplication.SchoolSystem.Services.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private final StudentServiceImp Service;

    public StudentController(StudentServiceImp Service) {
        this.Service = Service;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        Service.saveStudent(student);
    }
    @GetMapping("{Id}")
    public void getStudent(@PathVariable Long Id){
        Service.getStudentById(Id);
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return Service.getAllStudents();
    }
    @PutMapping("{Id}")
    public void updateStudentInfo(@PathVariable Long Id, @RequestBody Student studentDetails){
        Service.updateStudent(Id,studentDetails);
    }
    @DeleteMapping("{Id}")
    public void deleteStudent(@PathVariable Long Id){
        Service.deleteStudent(Id);
    }
}
