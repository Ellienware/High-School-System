package com.schoolSystemApplication.SchoolSystem.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teacherId;
    private String firstName;
    private String lastName;
    private String email;
    private String DOB;
    private String position;
    @ManyToMany(mappedBy = "teachers")
    private List<Subjects> subjects;

}
