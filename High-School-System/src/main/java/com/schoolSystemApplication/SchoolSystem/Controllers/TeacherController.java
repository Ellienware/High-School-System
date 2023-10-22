package com.schoolSystemApplication.SchoolSystem.Controllers;

import com.schoolSystemApplication.SchoolSystem.Entities.Teacher;
import com.schoolSystemApplication.SchoolSystem.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private final TeacherService Service;

    public TeacherController(TeacherService Service) {
        this.Service = Service;
    }

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher){
        Service.saveTeacher(teacher);
    }
    @GetMapping("{Id}")
    public void getTeacher(@PathVariable Long Id){
        Service.getTeacherById(Id);
    }
    @GetMapping
    public List<Teacher> getAllTeachers(){
        return Service.getAllTeachers();
    }
    @PutMapping("{Id}")
    public void updateTeacherInfo(@PathVariable Long Id, @RequestBody Teacher TeacherDetails){
        Service.updateTeacher(Id,TeacherDetails);
    }
    @DeleteMapping("{Id}")
    public void deleteTeacher(@PathVariable Long Id){

        Service.deleteTeacher(Id);
    }
}
