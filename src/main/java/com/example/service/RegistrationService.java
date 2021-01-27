package com.example.service;

import com.example.model.Course;
import com.example.model.Registration;
import com.example.model.Student;
import com.example.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public String setRegistration(Registration registration) {
        try {
            registrationRepository.save(registration);
        } catch (Exception e) {
            String s = "Exception" + e + "occured";
            return s;
        }
        return "Successfully Updated";
    }

    public Iterable<Registration> showAllRegistration() {
        return registrationRepository.findAll();
    }

    public Iterable<Course> getRegistrationBySId(int id) {
        List<Course> courses = new ArrayList<>();
        Iterable<Registration> registrations = registrationRepository.findAll();
        for (Registration registration : registrations) {
            if (registration.getStudentId() == id) {
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


    public String deleteRegistrationBySid(int id) {
        try {
            Iterable<Registration> registrations = registrationRepository.findAll();
            for (Registration registration : registrations) {
                if (registration.getStudentId() == id) {
                    registrationRepository.delete(registration);
                }
            }
        } catch (Exception e) {
            String s = "Exception" + e + "occured";
            return s;
        }
        return "Deleted Successfully";
    }

    public String deleteRegistrationByCid(int id) {
        try {
            Iterable<Registration> registrations = registrationRepository.findAll();
            for (Registration registration : registrations) {
                if (registration.getCourseId() == id) {
                    registrationRepository.delete(registration);
                }
            }
        } catch (Exception e) {
            String s = "Exception" + e + "occured";
            return s;
        }
        return "Deleted Successfully";
    }
}
