/*
Author: Sean Briggs
Date: 8/13

This program has a class to handle bank accounts
*/

import java.util.Date;
public class TestAccount {
    public static void main(String[] args) {
        Account.setAnnualInterestRate(4.5);
        Account account1 = new Account(1122, 20000);

        account1.withdraw(2500);
        account1.deposit(3000);
        System.out.println("Balance: " + account1.getBalance());
        System.out.println("Monthly Interest: " + account1.getMonthlyInterest());
        System.out.println("Creation date: " + account1.getDateCreated());
    }
}

class Account {
    private int id;
    private double balance;
    private static double annualInterestRate = 0;
    private Date dateCreated = new Date();

    Account() {
        this.id = 0;
        this.balance = 0;
    }

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    int getId() {
        return id;
    }

    double getBalance() {
        return balance;
    }

    static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    Date getDateCreated() {
        return dateCreated;
    }

    void setId(int newId) {
        id = newId;
    }

    void setBalance(double newBalance) {
        balance = newBalance;
    }

    static void setAnnualInterestRate(double newInterestRate) {
        annualInterestRate = newInterestRate;
    }

    static double getMonthlyInterestRate() {
        return getAnnualInterestRate() / 12;
    }

    double getMonthlyInterest() {
        return getMonthlyInterestRate() / 100 * balance;
    }

    void withdraw(double withdrawalAmount) {
        setBalance(getBalance() - withdrawalAmount);
    }

    void deposit(double depositAmount) {
        setBalance(getBalance() + depositAmount);
    }
}