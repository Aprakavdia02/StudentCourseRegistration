package com.example.controller;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/show")
    public List<Student> showAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/show/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getBySId(id);
    }

    @PutMapping("/update")
    public String updateStudentDetails(@RequestBody Student student) {
        return studentService.setStudent(student);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        return studentService.setStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}


























