# Skypay Technical Test 1: Banking Service

## Overview
[cite_start]This project is an implementation of a core banking system logic as part of the Skypay Technical Test[cite: 1, 2]. [cite_start]The application handles basic financial operations including depositing money, withdrawing money, and printing a transaction statement[cite: 5].

[cite_start]Per the project requirements, this system focuses on the logic layer without external database dependencies, utilizing in-memory data structures for storage[cite: 35].

## Features
* [cite_start]**Deposit**: Add funds to a user account[cite: 12].
* [cite_start]**Withdraw**: Deduct funds from a user account[cite: 13].
* [cite_start]**Print Statement**: Display a history of transactions including date, amount, and running balance in reverse chronological order[cite: 14, 23].
* [cite_start]**Error Handling**: Robust handling of invalid inputs and exceptions.

## Technical Decisions & Constraints
Following the technical requirements provided in the instructions:
* **Data Storage**: No repositories or databases are used. [cite_start]Transaction history is stored in memory using `ArrayList`[cite: 35].
* [cite_start]**Data Types**: Currency is represented using `int` to keep auxiliaries simple, though a real-world system would use arbitrary precision data types (like `BigDecimal`)[cite: 36, 37].
* [cite_start]**Interface Compliance**: The `Account` class strictly implements the required `AccountService` public interface without modification[cite: 8, 16].

## interface Architecture
The solution implements the mandatory interface:

```java
public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}