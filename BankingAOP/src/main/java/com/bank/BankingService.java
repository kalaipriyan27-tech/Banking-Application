
package com.bank;

import org.springframework.stereotype.Service;

@Service
public class BankingService {

    private final BankAccount account = new BankAccount();

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public double getBalance() {
        return account.getBalance();
    }
}


