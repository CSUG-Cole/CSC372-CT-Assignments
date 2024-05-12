package com.csc372.module_1;

public class Main
{
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount();

        /* Initialize the account */
        checkingAccount.setFirstName("John");
        checkingAccount.setLastName("Doe");
        checkingAccount.setAccountID(1234);
        checkingAccount.deposit(100);
        checkingAccount.displayAccount();

        /* Withdrawal some money */
        checkingAccount.processWithdrawal(10);
        checkingAccount.processWithdrawal(100);
        checkingAccount.displayAccount();
    }
}
