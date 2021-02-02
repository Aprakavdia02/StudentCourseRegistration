package com.example.service;

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
        if (checkIsEmpty(student)) {
            studentRepository.save(student);
            return "Successfully Updated";
        } else {
            return "Error Occurred";
        }
    }

    public boolean checkIsEmpty(Student student) {
        System.out.print(student.getFirstName());
        if (student.getFirstName().equals("") || student.getLastName().equals("") || student.getFirstName().equals(" ") || student.getLastName().equals(" ") || student.getAge() == -1 || student.getContactNo() == -1) {
            return false;
        } else {
            return true;
        }
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
        } else {
            return "Error Occurred";
        }
    }


}
