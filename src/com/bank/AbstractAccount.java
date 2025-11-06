package com.bank;

public abstract class AbstractAccount {
    protected String id;
    protected String name;
    protected double balance;

    public AbstractAccount(String id, String name, double initialBalance) {
        if (id == null || id.isBlank()) 
            throw new IllegalArgumentException("Account ID cannot be null or empty.");
        if (name == null || name.isBlank()) 
            throw new IllegalArgumentException("Account name cannot be null or empty.");
        if (initialBalance < 0)
            throw new IllegalArgumentException("Initial balance cannot be negative.");

        this.id = id;
        this.name = name;
        this.balance = Math.max(0, initialBalance);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public abstract void deposit(double amount) throws IllegalArgumentException;
    public abstract void withdraw(double amount) throws Exception;

    @Override
    public String toString() {
        return String.format("Account{id='%s', name='%s', balance=%.2f}", id, name, balance);
    }
}
