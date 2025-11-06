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

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive.");
        if (balance < amount) throw new Exception("Not enough funds.");
        balance -= amount;
    }
}
