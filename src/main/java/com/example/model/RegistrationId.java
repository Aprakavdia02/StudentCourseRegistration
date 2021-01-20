package com.example.model;

import java.io.Serializable;
import java.util.Objects;

public class RegistrationId implements Serializable {

    private int studentId;
    private int courseId;

    public RegistrationId(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationId that = (RegistrationId) o;
        return studentId == that.studentId &&
                courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }

    public RegistrationId() {
    }
}
