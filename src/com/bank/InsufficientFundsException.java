package com.bank;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String accountId, double balance, double requested) {
        super(String.format(
                "Not enough funds in account '%s': balance = %.2f, requested = %.2f",
                accountId, balance, requested
        ));
    }
}
