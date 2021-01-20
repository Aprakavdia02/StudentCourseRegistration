package com.example.model;

import javax.persistence.*;
import java.util.Date;

/***
 *  Many to One = A many-to-one mapping means that many instances of this entity are
 *              mapped to one instance of another entity.
 * Owning side = The side which owns the foreign key is owning side, and this is
 *              defined as the many side of the relationship.
 *  composite key class(registrationId) = contains all the primary key of registration class
 *  composite key = multiple primary key.
 *  name and data type of the variable in the registrationId and registration class should be same in order to get linked.
 *  @OneToMany = a student can have many relations with the registration class
 *  FetchType :
 *         LAZY = registration class will fetch student LAZY i.e. when we call for the list of all the registrations of the particular
 *                 student will only be called when we specifically make a call to it.
 *         EAGER = when fetch type if eager that way all the student's registrations will be loaded when the other variables of student is loaded.
 *     mappedBy = mapped by means that this entity "class Student" is linked in the registration entity using the variable "student".
 *
 */


@Entity
@IdClass(RegistrationId.class)
public class Registration {

    @Id
    int studentId;
    @Id
    int courseId;
    Date registrationDate;

    @ManyToOne
    @JoinColumn(name = "studentId",insertable = false,updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId",insertable = false,updatable = false)
    private Course course;

    public Registration() {
    }

    public Registration(int studentId, int courseId, Date registrationDate, Student student, Course course) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.registrationDate = registrationDate;
        this.student = student;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}
