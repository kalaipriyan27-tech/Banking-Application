
package com.bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        BankingService bank = context.getBean(BankingService.class);

        System.out.println("===== BANKING APPLICATION =====");
        System.out.println("Initial Balance: ₹" + bank.getBalance());

        // Test 1: Successful deposit
        System.out.println("\n--- Test 1: Deposit ₹500 ---");
        bank.deposit(500);

        // Test 2: Successful withdrawal
        System.out.println("\n--- Test 2: Withdraw ₹200 ---");
        bank.withdraw(200);

        // Test 3: Insufficient balance
        System.out.println("\n--- Test 3: Withdraw ₹2000 ---");
        try {
            bank.withdraw(2000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 4: Invalid deposit
        System.out.println("\n--- Test 4: Deposit ₹0 ---");
        try {
            bank.deposit(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 5: Invalid withdrawal
        System.out.println("\n--- Test 5: Withdraw ₹-100 ---");
        try {
            bank.withdraw(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Final balance
        System.out.println("\n===== FINAL RESULT =====");
        System.out.println("Final Balance: ₹" + bank.getBalance());

        context.close();
    }
}

