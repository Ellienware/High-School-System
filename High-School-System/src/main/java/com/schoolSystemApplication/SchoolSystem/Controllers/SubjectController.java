package com.schoolSystemApplication.SchoolSystem.Controllers;

import com.schoolSystemApplication.SchoolSystem.Entities.Subjects;
import com.schoolSystemApplication.SchoolSystem.Services.SubjectsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {
    @Autowired
    private final SubjectsServiceImp Service;

    public SubjectController(SubjectsServiceImp Service) {
        this.Service = Service;
    }

    @PostMapping
    public void addSubject(@RequestBody Subjects subjects){
        Service.saveSubject(subjects);
    }
    @GetMapping("{Id}")
    public void getSubject(@PathVariable Long Id){
        Service.getSubjectById(Id);
    }
    @GetMapping
    public List<Subjects> getAllSubjects(){
        return Service.getAllSubjects();
    }
    @PutMapping("{Id}")
    public void updateSubjectInfo(@PathVariable Long Id, @RequestBody Subjects subjectsDetails){
        Service.updateSubject(Id,subjectsDetails);
    }
    @DeleteMapping("{Id}")
    public void deleteSubject(@PathVariable Long Id){

        Service.deleteSubject(Id);
    }
}
