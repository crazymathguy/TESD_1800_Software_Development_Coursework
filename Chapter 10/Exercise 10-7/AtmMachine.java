/*
Author: Sean Briggs
Date: 8/14

This program simulates an atm
*/

import java.util.*;

public class AtmMachine {
    public static void main(String[] args) {
        Account.setAnnualInterestRate(4.5);
        Account[] accounts = new Account[10];
        
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 100);
        }

        askForId(accounts);
    }
    
    static void askForId(Account[] accounts) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an id: ");
        int id = input.nextInt();
        if (id >= 0 && id < 10) {
            mainMenu(accounts[id]);
        }
        askForId(accounts);
    }
    
    static void mainMenu(Account account) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nMain Menu\n1: check balance\n2: withdraw\n3: deposit\n4: exit");
        System.out.print("Enter a choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("The balance is " + account.getBalance());
                break;
            case 2:
                System.out.print("Enter an amount to withdraw: ");
                double withdrawAmount = input.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 3:
                System.out.print("Enter an amount to deposit: ");
                double depositAmount = input.nextDouble();
                account.deposit(depositAmount);
                break;
            case 4:
                return;
            default:
                break;
        }
        mainMenu(account);
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