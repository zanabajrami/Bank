package com.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Transaction {
    private String fromAccountId; // null për deposit
    private String toAccountId;   // null për withdraw
    private BigDecimal amount;
    private BigDecimal fee;
    private String reason;

    public Transaction(String fromAccountId, String toAccountId, BigDecimal amount, BigDecimal fee, String reason) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount.setScale(2, RoundingMode.HALF_EVEN);
        this.fee = fee.setScale(2, RoundingMode.HALF_EVEN);
        this.reason = reason;
    }

    public String getFromAccountId() { return fromAccountId; }
    public String getToAccountId() { return toAccountId; }
    public BigDecimal getAmount() { return amount; }
    public BigDecimal getFee() { return fee; }
    public String getReason() { return reason; }

    @Override
    public String toString() {
        return String.format("Transaction{from='%s', to='%s', amount=%.2f, fee=%.2f, reason='%s'}",
                fromAccountId, toAccountId, amount, fee, reason);
    }
}
