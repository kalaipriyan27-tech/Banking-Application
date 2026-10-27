
package com.bank;

public class BankAccount {

    private double balance = 1000.0;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be greater than zero.");
        }

        balance += amount;

        System.out.println("Deposit successful: ₹" + amount);
        System.out.println("Current balance: ₹" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                    "Insufficient balance! Withdrawal failed.");
        }

        balance -= amount;

        System.out.println("Withdrawal successful: ₹" + amount);
        System.out.println("Current balance: ₹" + balance);
    }
}

