package com.example.school.model;
import jakarta.persistence.*;

import jakarta.persistence.*;
 // Correct import statement
 // This is correct

@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name="studentid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column(name="studentname")
    private String studentName;
    @Column(name="gender")
    private String gender;
    @Column(name="standard")
    private int standard;
    public Student(){}

    public Student(int studentId, String studentName, String gender, int standard) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.standard = standard;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStandard() {
        return this.standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

}



