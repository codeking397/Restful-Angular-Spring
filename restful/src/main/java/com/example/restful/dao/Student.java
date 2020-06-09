package com.example.restful.dao;

public class Student {
    private String firstName;
    private String lastName;
    private int rollNumber;
    private String emailId;
    private int mobile;

    // public Student(String firstName, String lastName, int rollNumber, String
    // emailId, int mobile) {
    // this.firstName = firstName;
    // this.lastName = lastName;
    // this.rollNumber = rollNumber;
    // this.emailId = emailId;
    // this.mobile = mobile;
    // }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

}