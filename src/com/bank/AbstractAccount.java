package com.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractAccount {
    protected String id;
    protected String name;
    protected BigDecimal balance;

    public AbstractAccount(String id, String name, BigDecimal initialBalance) {
        if (id == null || id.isBlank()) 
            throw new IllegalArgumentException("Account ID cannot be null or empty.");
        if (name == null || name.isBlank()) 
            throw new IllegalArgumentException("Account name cannot be null or empty.");
        if (initialBalance .compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Initial balance cannot be negative.");

        this.id = id;
        this.name = name;
        this.balance = initialBalance.setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getBalance() { return balance; }

    public abstract void deposit(BigDecimal amount);
    public abstract void withdraw(BigDecimal amount) throws InsufficientFundsException;

    @Override
    public String toString() {
        return String.format("Account{id='%s', name='%s', balance=%.2f}", id, name, balance);
    }
}
