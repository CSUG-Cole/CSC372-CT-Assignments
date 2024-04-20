package com.csc372.module_1;

public class CheckingAccount extends BankAccount {
    /* Interest attribute, defaults to 1% */
    private double interest = 0.01;

    public void processWithdrawal(double amount) {
        if (amount > this.balance) {
            System.out.println("Withdrawaling more than the current account balance.");
            System.out.println("$30 overdraft fee assessed.");
            amount += 30.0;
        }

        this.balance -= amount;
        System.out.println("Current account balance: $" + BankAccount.dollarFormat.format(this.balance));
    }

    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest rate:  " + (100 * this.interest) + "%");
    }
}
