package com.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Account extends AbstractAccount {
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String id, String name, BigDecimal initialBalance) {
        super(id, name, initialBalance);
    }

    @Override
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO)<= 0) 
        throw new IllegalArgumentException("Deposit must be positive.");
        balance = balance.add(amount).setScale(2, RoundingMode.HALF_EVEN);
    }

    public void deposit(BigDecimal amount, String reason) {
        deposit(amount);
        Transaction t = new Transaction(null, id, amount, BigDecimal.ZERO, reason);
        transactions.add(t);
        System.out.println("Deposit reason: " + reason);
    }

    @Override
    public void withdraw(BigDecimal amount) throws InsufficientFundsException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) 
        throw new IllegalArgumentException("Withdrawal must be positive.");
        if (balance.compareTo(amount)<0)
        throw new InsufficientFundsException(id,balance,amount);
        balance = balance.subtract(amount).setScale(2, RoundingMode.HALF_EVEN);
    }

    public void withdraw(BigDecimal amount, String reason) throws InsufficientFundsException {
        withdraw(amount);
        Transaction t = new Transaction(id, null, amount, BigDecimal.ZERO, reason);
        transactions.add(t);
        System.out.println("Withdrawal reason: " + reason);
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
