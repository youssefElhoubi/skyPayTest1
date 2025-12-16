package com;

import com.entities.Account;
import com.utils.ExceptionHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Banking Menu ===");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Print statement");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            try {

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        ExceptionHandler.handleDeposit(scanner, account);
                        break;

                    case 2:
                        ExceptionHandler.handleWithdrawal(scanner, account);
                        break;

                    case 3:
                        account.printStatement();
                        break;

                    case 4:
                        running = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose 1–4.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input! Please enter a number.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }


}