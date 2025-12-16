package com.utils;

import com.entities.Account;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandler {

    public static void handleDeposit(Scanner scanner, Account account) {
        try {
            System.out.print("Enter amount to deposit: ");
            int amount = scanner.nextInt();

            if (amount <= 0) {
                System.out.println("Error: Amount must be positive.");
                return;
            }

            account.deposit(amount);
            System.out.println("Deposit successful.");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid whole number for the amount.");
            scanner.nextLine(); // Clear buffer
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }

    public static void handleWithdrawal(Scanner scanner, Account account) {
        try {
            System.out.print("Enter amount to withdraw: ");
            int amount = scanner.nextInt();

            if (amount <= 0) {
                System.out.println("Error: Amount must be positive.");
                return;
            }

            account.withdraw(amount);
            System.out.println("Withdrawal successful.");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid whole number for the amount.");
            scanner.nextLine(); // Clear buffer
        } catch (Exception e) {
            // This catches logic errors from Account (e.g., Insufficient Funds)
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}
