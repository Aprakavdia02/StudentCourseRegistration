package com.example.service;

import com.example.model.Course;
import com.example.repository.CourseRepository;
import com.example.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private RegistrationRepository registrationRepository;

    public String setCourse(Course course) {
        try {
            if (checkIsEmpty(course))
                courseRepository.save(course);
        } catch (Exception e) {
            String s = "Exception" + e + "occurred";
            return s;
        }
        return "Successfully Updated";
    }

    public boolean checkIsEmpty(Course course) {
        if (course.getCourseFee() == -1 || course.getCourseName().equals("") || course.getDuration().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public List<Course> getAllCourse() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course getByCId(int id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.get();
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public String deleteCourse(int id) {
        String s = registrationService.deleteRegistrationByCid(id);
        if (s == "Deleted Successfully") {
            courseRepository.deleteById(id);
            return "Deleted Successfully";
        } else {
            return "Error Occurred";
        }
    }

}
