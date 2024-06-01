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

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();
        getStudents(students);
        writeStudents(students);
    }

    private static void printGreeting() {
        System.out.println(
            "Hello! Please enter the name, address, and GPA of each student you wish to\n" +
            "document."
        );
    }

    private static String getResponse(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException | IllegalStateException e) {
            /* NoSuchElementException - if no more tokens are available
             * IllegalStateException - if this scanner is closed
             */
            System.err.println(e.getMessage());
            System.err.println("ERROR: Failed to scan next token. Exiting.");
            System.exit(-1);
        }
        return "";
    }

    private static double getResponseAsDouble(Scanner scanner, String prompt) {
        String response = getResponse(scanner, prompt);
        double result = 0.0;
        try {
            result = Double.parseDouble(response);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            System.err.println(
                "ERROR: Please enter a properly formated double, got: '" + response + "'"
            );
            result = getResponseAsDouble(scanner, prompt);
        }
        if (!Student.isValidGPA(result)) {
            Student.printGPAError();
            return getResponseAsDouble(scanner, prompt);
        }
        return result;
    }

    private static void getStudent(LinkedList<Student> students, Scanner scanner) {
        String firstName = getResponse(scanner, "Please enter the student's first name: ");
        String lastName = getResponse(scanner, "Please enter the student's last name: ");
        String address = getResponse(scanner, "Please enter the student's address: ");
        double gpa = getResponseAsDouble(scanner, "Please enter the student's GPA (0.0-5.0): ");
        Student student = new Student(lastName + ", " + firstName, address, gpa);
        students.push(student);
    }

    private static void getStudents(LinkedList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        printGreeting();

        boolean running = true;
        while (running) {
            getStudent(students, scanner);
            running = !getResponse(scanner, "Enter \"done\" to stop: ").toLowerCase().equals("done");
        }

        scanner.close();
    }

    private static void writeStudents(LinkedList<Student> students) {
        System.out.println("Saving students to \"Students.txt\".");
        StudentComparator comparator = new StudentComparator();
        students.sort(comparator);
        try (PrintWriter printWriter = new PrintWriter("Students.txt");) {
            for (Student student : students) {
                printWriter.print(student.toString());
            }
        } catch (FileNotFoundException e) {
            System.err.println(
                "ERROR: An error occurred while saving students to Students.txt: " + e.getMessage()
            );
            System.exit(-1);
        }
    }
}
