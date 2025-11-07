package com.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private BigDecimal flatFee;
    private BigDecimal percentFee; //0.05 = 5%

    public Bank(String bankName, BigDecimal flatFee, BigDecimal percentFee) {
        this.bankName = bankName; 
        this.flatFee = flatFee.setScale(2, RoundingMode.HALF_EVEN);
        this.percentFee = percentFee;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountById(String id) throws Exception {
        return accounts.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Account not found: " + id));
    }

    public void transfer(String fromId, String toId, BigDecimal amount, boolean usePercentFee, String reason) throws Exception {
        Account fromAcc = getAccountById(fromId);
        Account toAcc = getAccountById(toId);

        BigDecimal fee = usePercentFee ? amount.multiply(percentFee).setScale(2, RoundingMode.HALF_EVEN) : flatFee;
        BigDecimal totalAmount = amount.add(fee);

        if (fromAcc.getBalance().compareTo(totalAmount)<0) {
            throw new InsufficientFundsException(fromId, fromAcc.getBalance(), totalAmount);
        }

        fromAcc.withdraw(totalAmount);
        toAcc.deposit(amount);

        Transaction t = new Transaction(fromId, toId, amount, fee, reason);
        fromAcc.getTransactions().add(t);
        toAcc.getTransactions().add(t);
        transactions.add(t);

        System.out.println("Transfer: " + t);
    }

    public List<Transaction> getTransactionsForAccount(String accountId) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (accountId.equals(t.getFromAccountId()) || accountId.equals(t.getToAccountId())) {
                result.add(t);
            }
        }
        return result;
    }
     public List<Account> getAccounts() {
        return accounts;
    }
    public String getBankName() {
        return bankName;
    }
    public BigDecimal getTotalTransactionFees() {
        return transactions.stream()
                .map(Transaction::getFee)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getTotalTransferAmount() {
        return transactions.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}
