package com.example.service;

import com.example.model.Registration;
import com.example.repository.CourseRepository;
import com.example.repository.RegistrationRepository;
import com.example.repository.StudentRepository;
import com.example.model.Course;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManagementService {

    @Autowired private StudentRepository studentRepository;
    @Autowired private CourseRepository courseRepository;
    @Autowired private RegistrationRepository registrationRepository;

    public void setStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> getBySId(int id) {
        return studentRepository.findById(id);
    }

    public void setCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getAllCourse() {
        return (List<Course>) courseRepository.findAll();
    }

    public Optional<Course> getByCId(int id) {
        return courseRepository.findById(id);
    }

    public void setRegistration(Registration registration) {
        registrationRepository.save(registration);
    }

    public Iterable<Registration> showAllRegistration() {
        return registrationRepository.findAll();
    }

    public Iterable<Course> getRegistrationBySId(int id) {
        List<Course> courses = new ArrayList<>();
        Iterable<Registration> registrations = registrationRepository.findAll();
        for (Registration registration : registrations) {
            if (registration.getStudentId() == id){
                courses.add(registration.getCourse());
            }
        }
        return courses;
    }

    public List<Student> getRegistrationByCId(int id) {
        List<Student> students = new ArrayList<>();
        Iterable<Registration> registrations = registrationRepository.findAll();
        for (Registration registration : registrations) {
            if (registration.getCourseId() == id) {
                students.add(registration.getStudent());
            }
        }
        return students;
    }
}
