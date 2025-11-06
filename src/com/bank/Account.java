package com.bank;

public class Account extends AbstractAccount {

    public Account(String id, String name, double initialBalance) {
        super(id, name, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive.");
        balance += amount;
    }

    public void deposit(double amount, String reason) {
        deposit(amount);
        System.out.println("Deposit reason: " + reason);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) 
        throw new IllegalArgumentException("Withdrawal must be positive.");
        if (balance < amount) 
        throw new InsufficientFundsException(id,balance,amount);
        balance -= amount;
    }

    public void withdraw(double amount, String reason) throws InsufficientFundsException {
        withdraw(amount);
        System.out.println("Withdrawal reason: " + reason);
    }
}
