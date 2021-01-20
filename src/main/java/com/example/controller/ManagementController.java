package com.example.controller;

import com.example.model.Course;
import com.example.model.Registration;
import com.example.model.Student;
import com.example.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@ResponseBody
@RequestMapping("/myApp")
public class ManagementController {

    @Autowired
    ManagementService managementService;

    @PostMapping("students")
    public void addStudent(@RequestBody Student student){
        managementService.setStudent(student);
    }

    @GetMapping("students")
    public List<Student> showAllStudents(){
        return managementService.getAllStudents();
    }

    @GetMapping("students/{id}")
    public Optional<Student> getStudentById(@PathVariable int id){
        return managementService.getBySId(id);
    }

    @PostMapping("courses")
    public void addCourse(@RequestBody Course course){
        managementService.setCourse(course);
    }

    @GetMapping("courses")
    public List<Course> showAllCourses(){
        return managementService.getAllCourse();
    }

    @GetMapping("course/{id}")
    public Optional<Course> getCourseById(@PathVariable int id){
        return managementService.getByCId(id);
    }

    @PostMapping("/registrations")
    public void addRegistration(@RequestBody Registration registration){
         managementService.setRegistration(registration);
    }

    @GetMapping("/registrations")
    public Iterable<Registration> getAllRegistrations(){
        return managementService.showAllRegistration();
    }

    @GetMapping("/students/{id}/registrations")
    public Iterable<Course> getRegistrationBySId(@PathVariable int id){
        return managementService.getRegistrationBySId(id);
    }

    @GetMapping("/course/{id}/registrations")
    public List<Student> getRegistrationByCId(@PathVariable int id){
        return managementService.getRegistrationByCId(id);
    }
}
