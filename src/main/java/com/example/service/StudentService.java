package com.example.service;

import com.example.model.Registration;
import com.example.model.Student;
import com.example.repository.RegistrationRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private RegistrationRepository registrationRepository;

    public String setStudent(Student student) {
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            String s = "Exception" + e + "occured";
            return s;
        }
        return "Successfully Updated";
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student getBySId(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }



    public String deleteStudent(int id) {
            String s = registrationService.deleteRegistrationBySid(id);
           if (s == "Deleted Successfully") {
               studentRepository.deleteById(id);
               return "Deleted Successfully";
           }else{
            return "Error Occurred";
           }
    }


}
