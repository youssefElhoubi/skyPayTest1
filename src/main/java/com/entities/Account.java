package com.entities;

import com.interfaces.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements AccountService {
    private int balance;
    private int amount;
    private LocalDate date;
    List<Transaction> transactions = new ArrayList<>();

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        balance += amount;
        transactions.add(new Transaction(LocalDate.now(), amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance -= amount;
        transactions.add(new Transaction(LocalDate.now(), -amount, balance));
    }

    @Override
    public void printStatement() {
        System.out.println("DATE | AMOUNT | BALANCE");
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        }
        else {
            for (Transaction transaction : transactions) {
                System.out.println(
                        transaction.getDate() + " | " +
                                transaction.getAmount() + " | " +
                                transaction.getBalance()
                );
            }
        }
    }
}
