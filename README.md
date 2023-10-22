# High-School-System
This a School system project that i am working on using Spring boot.
Its incomplete at the moment, I use postman to test the API's.
The aim of this project is to familiarize myself with Spring Boot.

Project Overview:

    This is a web-based school management system that enables students, teachers, and administrators to manage student data, subjects, classes, and grades.

Key Components:

    Entities:
        Student: Represents students and their information.
        Teacher: Represents teachers and their information.
        Subject: Represents subjects that students can enroll in and teachers can teach.
        Class: Represents class schedules, including class name, room number, and time.
        Grade: Represents student grades for different subjects.

    Repositories:
        A repository is created for each entity to handle database operations, including Create, Read, Update, and Delete (CRUD) operations.

    Controllers:
        Controllers define RESTful API endpoints for each entity, allowing clients to interact with the system over HTTP.
        HTTP methods (GET, POST, PUT, DELETE) are used to perform operations on the entities.

    Services:
        Service classes handle the business logic, interacting with the repositories to manage data for the various entities.
        Services are responsible for validation, processing, and applying business rules.

Functionality:

    Student Management:
        Students can register and view their information.
        Students can enroll in subjects offered by teachers.
        Students can view their grades and class schedules.

    Teacher Management:
        Teachers can register and view their information.
        Teachers can assign subjects to students.

    Subject Management:
        Subjects are created and managed.
        Subjects can be associated with both students and teachers.

    Class Scheduling:
        Class schedules are created and managed, including class name, room number, and timings.
        Subjects are linked to class schedules.

    Grade Tracking:
        Teachers can input and update student grades for subjects.
        Cumulative grades are calculated and displayed for students.

