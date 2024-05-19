/*
 * Using recursion, create a program that will allow a user to enter five
 * numbers. The program will provide the product of all five numbers using
 * recursive methods.
 */

package com.csc372.module_5;

import java.lang.IllegalStateException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* Get five numbers */
        double result = getNumber(scanner, 5);
        System.out.println("The product of these numbers is: " + result);
        scanner.close();
    }

    private static double getNumber(Scanner scanner, int count) {
        /* Base case, return if there are no more numbers to get. */
        if (count <= 0) return 1;

        /* Get the product of each additional number through recursion. */
        double product = getNumber(scanner, count - 1);

        /* Get the current number. */
        System.out.print("Please enter a number: ");
        try {
            return scanner.nextDouble() * product;
        } catch (InputMismatchException error) {
            System.out.println("Warning, please enter a number like 1, 2, 3.5, -8.09, etc.");
            scanner.next();
            /* Only recurse by one to get the current number. */
            return getNumber(scanner, 1) * product;
        } catch (NoSuchElementException error) {
            System.out.println("Error, input is exhausted. Exiting.");
        } catch (IllegalStateException error) {
            System.out.println("Error, scanner is closed. Exiting.");
        }
        return 1;
    }
}
