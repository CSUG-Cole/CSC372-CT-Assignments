package com.csc372.module_6;

import java.util.ArrayList;
import java.util.Random;

/*
 * Create a Java program that will store 10 student objects in an ArrayList,
 * ArrayList<Student>. A student object consists of the following fields:
 *
 *    int rollno
 *    String name
 *    String address
 *
 * Implement a comparator class to sort student objects by rollno (roll number).
 * Implement your own merge sort method and place your code in a separate Java
 * source file. Do not use a sort method from the Java collections library.
 */

public class Main
{
    private static final Random RANDOM = new Random();
    private static final int[] ROLL_NUMBERS = {
        4829, 1234, 5678, 2468, 7890,
        3456, 6482, 6789, 2345, 8901
    };
    private static final String[] FIRST_NAMES = {
        "John", "Emma", "Michael", "Sophia", "William",
        "Isabella", "David", "Mia", "Joseph", "Charlotte"
    };
    private static final String[] LAST_NAMES = {
        "Smith", "Johnson", "Williams", "Jones", "Brown",
        "Davis", "Miller", "Wilson", "Moore", "Taylor"
    };
    /* Its an online school, so the students don't all live in the same city/state :) */
    private static final String[] ADDRESSES = {
        "123 Main St, New York City, NY",
        "456 Oak Ave, Los Angeles, CA",
        "789 Maple Ln, Chicago, IL",
        "321 Pine Rd, Houston, TX",
        "654 Elm St, Phoenix, AZ",
        "987 Cedar Blvd, Philadelphia, PA",
        "246 Birch Dr, San Antonio, TX",
        "135 Willow Way, San Diego, CA",
        "864 Cherry Ct, Dallas, TX",
        "579 Poplar Pl, San Jose, CA"
    };
    private static final int RANDOM_CHOICES = 10;

    public static void main(String[] args) {
        /* Generate the students */
        ArrayList<Student> students = new ArrayList<>();
        generateStudents(students);

        /* Display the students before sorting. */
        System.out.println("Students before sorting:");
        displayStudents(students);
    }

    private static void displayStudents(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static Student makeRandomStudent(int choice) {
        return new Student(
            ROLL_NUMBERS[choice],
            LAST_NAMES[choice] + ", " + FIRST_NAMES[choice],
            ADDRESSES[choice]
        );
    }

    private static void generateStudents(ArrayList<Student> students) {
        int choice = RANDOM.nextInt(RANDOM_CHOICES);

        for (int i = 0; i < RANDOM_CHOICES; i++) {
            choice = (choice + 1) % RANDOM_CHOICES;
            students.add(makeRandomStudent(choice));
        }
    }
}
