package com.csc372.module_6;

public class Student
{
    private int rollno;
    private String name;
    private String address;

    Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    /* Getters */
    int getRollno() { return this.rollno; }
    String getName() { return this.name; }
    String getAddress() { return this.address; }
}
