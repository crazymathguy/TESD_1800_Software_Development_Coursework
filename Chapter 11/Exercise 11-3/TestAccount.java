/*
Author: Sean Briggs
Date: 8/13

This program has a class to handle bank accounts
*/

import java.util.Date;

public class TestAccount {
    public static void main(String[] args) {
        Account account1 = new Account(12, 1000);
        CheckingAccount account2 = new CheckingAccount(23, 100, 100);
        SavingsAccount account3 = new SavingsAccount();

        System.out.println(account1.toString());
        System.out.println(account2.toString());
        System.out.println(account3.toString());
    }
}

class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 4.5;
    private Date dateCreated = new Date();

    Account() { }

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

    double getAnnualInterestRate() {
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

    void setAnnualInterestRate(double newInterestRate) {
        annualInterestRate = newInterestRate;
    }

    double getMonthlyInterestRate() {
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

    public String toString() {
        return "Account number: " + getId() + "\nAccount balance: " + getBalance() + "\nInterest rate: " + getAnnualInterestRate() + "\nDate created: " + getDateCreated();
    }
}

class CheckingAccount extends Account {
    private double overdraft;

    CheckingAccount() { }

    CheckingAccount(int id, double balance, double overdraft) {
        super(id, balance);
        this.overdraft = overdraft;
    }

    double getOverdraft() {
        return overdraft;
    }

    @Override
    void setBalance(double newBalance) {
        if (newBalance >= -overdraft) {
            super.setBalance(newBalance);
        }
    }

    public String toString() {
        return super.toString() + "\nOverdraft limit: " + overdraft;
    }
}

class SavingsAccount extends Account {
    SavingsAccount() { }
}