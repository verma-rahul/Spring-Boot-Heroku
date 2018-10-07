package com.project.coursemanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import javax.persistence.*;
import java.util.List;

/*
 * @Entity : Used to Mark as Table for JPA
 * */
@Entity
public class Student extends User {

    private float gpa;
    private int graduationYear;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID"))
    @JsonIgnore
    private List<Course> attendedCourses;

    public List<Course> getAttendedCourses() {
        return attendedCourses;
    }

    public void setAttendedCourses(List<Course> authoredCourses) {
        this.attendedCourses = attendedCourses;
    }

    public Student() {
        super();
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Student(String username, String password, String firstName, String lastName, float gpa, int gradYear) {
        super(username, password, firstName, lastName);
        this.gpa = gpa;
        this.graduationYear = gradYear;
    }

    public Student(Float gpa, int graduationYear) {
        super();
        this.gpa = gpa;
        this.graduationYear = graduationYear;
    }

    public void set(Student newUser) {
        super.set(newUser);
        this.gpa = newUser.gpa != 0 ? newUser.gpa : this.gpa;
        this.graduationYear = newUser.graduationYear != 0 ? newUser.graduationYear : this.graduationYear;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }
}
