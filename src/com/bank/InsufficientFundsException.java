package com.bank;

import java.math.BigDecimal;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String accountId, BigDecimal balance, BigDecimal requested) {
        super(String.format(
                "Not enough funds in account '%s': balance = %.2f, requested = %.2f",
                accountId, balance, requested
        ));
    }
}
