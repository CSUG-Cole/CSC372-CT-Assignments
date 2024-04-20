package com.csc372.module_1;

import java.text.DecimalFormat;

public class BankAccount {
    /* Formater for better printing */
    final protected static DecimalFormat dollarFormat = new DecimalFormat("#0.00");

    /* BankAccount instance members */
    private String firstName;
    private String lastName;
    private int accountID;
    protected double balance;

    public BankAccount() {

    }

    /* Constructor method */
    public void constructor() { this.balance = 0.0; }

    /* Deposit method to add @amount to bank account balance */
    public void deposit(double amount) {
        /* If balance is negative, print an error and do not add to balance */
        if (amount < 0) {
            System.out.println("Cannot deposit a negative amount into bank account.");
            System.out.println("Use `withdrawal` for negative dollar amounts.");
            return;
        }

        this.balance += amount;
    }

    /* Withdrawal method to remove @amount from bank account balance */
    public void withdrawal(double amount) {
        /* If withdrawal amount is more than the blanace print an error and do not remove from balance. */
        if (amount > this.balance) {
            System.out.println("Cannot withdrawal an amount greater than the balance in your bank account.");
            return;
        }

        this.balance -= amount;
    }

    /* Print all account information to console */
    public void accountSummary() {
        System.out.println("Summary of Bank Account Information:");
        System.out.println("First Name:     " + this.firstName);
        System.out.println("Last Name:      " + this.lastName);
        System.out.println("Account ID:     " + this.accountID);
        System.out.println("Balance:        $" + dollarFormat.format(this.balance));
    }

    /* Setters for BankAccount */
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAccountID(int accountID) { this.accountID = accountID; }

    /* Getters for BankAccount */
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public int getAccountID() { return this.accountID; }
    public double getBalance() { return this.balance; }
}
