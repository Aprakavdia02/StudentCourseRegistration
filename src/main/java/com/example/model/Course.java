package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

    @Id   // used to define primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // used to define auto increment , strategy can be either auto or sequence etc.
            int courseId;
    String courseName;
    int courseFee;
    String duration;
    String startDate;

    public Course() {

    }

    public Course(int courseId, String courseName, int courseFee, String duration, String startDate) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.duration = duration;
        this.startDate = startDate;

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(int courseFee) {
        this.courseFee = courseFee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

//    public Set<Registration> getRegistrations() {
//        return registrations;
//    }
//
//    public void setRegistrations(Set<Registration> registrations) {
//        this.registrations = registrations;
//    }
}
