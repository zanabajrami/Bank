package com.bank;

public abstract class AbstractAccount {
    protected String id;
    protected String name;
    protected double balance;

    public AbstractAccount(String id, String name, double initialBalance) {
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
        return "Account{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", balance=" + String.format("%.2f", balance) + '}';
    }
}
