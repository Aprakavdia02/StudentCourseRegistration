package com.example.controller;


import com.example.model.Course;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/add")
    public String addCourse(@RequestBody Course course) {
        return courseService.setCourse(course);
    }

    @GetMapping("/show")
    public List<Course> showAllCourses() {
        return courseService.getAllCourse();
    }

    @GetMapping("/show/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getByCId(id);
    }

    @PutMapping("/update")
    public String updateCourseDetails(@RequestBody Course course) {
        return courseService.setCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }

}
