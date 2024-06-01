/*
 * Write a Java program that incorporates a loop that prompts the user for
 * student data. Student data are private fields in a student class including:
 *
 * String name
 * String address
 * double GPA
 *
 * Each student object is stored in a linked list. After the user completes the
 * data entry, output the contents of the linked list in ascending sorted order
 * by name to a regular text file that can be opened and viewed using a simple
 * plain-text editor such as notepad.
 *
 * Validate numeric data for Grade Point Average (GPA).
 */

package com.csc372.module_8;

public class Student
{
    private String name = "";
    private String address = "";
    private double gpa = 0.0;

    /* Constructors */
    Student() {  }
    Student(String name, String address, double gpa) {
        this.name = name;
        this.address = address;
        if (isValidGPA(gpa)) {
            this.gpa = gpa;
        } else {
            printGPAError();
            this.gpa = 0.0;
        }
    }

    /* Helpers */
    public static boolean isValidGPA(double gpa) { return 0.0 <= gpa && gpa <= 5.0; }
    public static void printGPAError() {
        System.err.println("GPA must be within bounds 0.0 and 5.0. Please try again.");
    }
    @Override
    public String toString() {
        return (
            "Name: " + this.name + "\n" +
            "Address: " + this.address + "\n" +
            "GPA: " + this.gpa + "\n"
        );
    }

    /* Getters */
    public String getName() { return this.name; }
    public String getAddress() { return this.address; }
    public double getGPA() { return this.gpa; }

    /* Setters */
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setGPA(double gpa) {
        if (!isValidGPA(gpa)) {
            printGPAError();
        } else {
            this.gpa = gpa;
        }
    }
}
