package com.example.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Parent Table =  Student (Contains the Primary Key)
 * Child Table = Registration (Contains the Foreign key of the Parent class)
 * One To Many = One entry of the Parent class can be used in many/multiple
 *              entries of the Child class.
 * Mapped by = The mappedBy property is what we use to tell Hibernate which
 *              variable we are using to represent the parent class in our child class.
 */

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    int studentId;
    @Column(name = "fname")
    String firstName;
    @Column(name = "lname")
    String lastName;
    @Column(name = "age")
    int age;
    @Column(name = "contactno")
    int contactNo;

    public Student() {
    }




    public Student(int studentId, String firstName, String lastName, int age, int contactNo) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.contactNo = contactNo;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

//    public Set<Registration> getRegistrations() {
//        return registrations;
//    }
//
//    public void setRegistrations(Set<Registration> registrations) {
//        this.registrations = registrations;
//    }
}
