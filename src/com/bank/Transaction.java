package com.bank;

public class Transaction {
    private String fromAccountId; // null për deposit
    private String toAccountId;   // null për withdraw
    private double amount;
    private double fee;
    private String reason;

    public Transaction(String fromAccountId, String toAccountId, double amount, double fee, String reason) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.fee = fee;
        this.reason = reason;
    }

    public String getFromAccountId() { return fromAccountId; }
    public String getToAccountId() { return toAccountId; }
    public double getAmount() { return amount; }
    public double getFee() { return fee; }
    public String getReason() { return reason; }

    @Override
    public String toString() {
        return String.format("Transaction{from='%s', to='%s', amount=%.2f, fee=%.2f, reason='%s'}",
                fromAccountId, toAccountId, amount, fee, reason);
    }
}
