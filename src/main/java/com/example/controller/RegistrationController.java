package com.example.controller;

import com.example.model.Course;
import com.example.model.Registration;
import com.example.model.Student;
import com.example.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;


    @PostMapping("/add")
    public String addRegistration(@RequestBody Registration registration) {
        return registrationService.setRegistration(registration);
    }

    @PutMapping("/update")
    public String updateRegistration(@RequestBody Registration registration) {
        return registrationService.setRegistration(registration);
    }

    @GetMapping("/show")
    public Iterable<Registration> getAllRegistrations() {
        return registrationService.showAllRegistration();
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteRegistration(@PathVariable int id) {
//        return registrationService.deleteRegistration(id);
//    }

    @GetMapping("/show/students/{id}")
    public Iterable<Course> getRegistrationBySId(@PathVariable int id) {
        return registrationService.getRegistrationBySId(id);
    }

    @GetMapping("/show/course/{id}")
    public List<Student> getRegistrationByCId(@PathVariable int id) {
        return registrationService.getRegistrationByCId(id);
    }


}
