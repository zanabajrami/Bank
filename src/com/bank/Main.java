package com.bank;

import java.math.BigDecimal;

public class Main {
        public static void main(String[] args) {

    //ID null
       try {
    new Account(null, "Alice", BigDecimal.valueOf(1000));
        } catch (IllegalArgumentException e) {
              System.out.println("Error: " + e.getMessage());
        }   

    // Name null
        try {
                new Account("2", "", BigDecimal.valueOf(500));
            } catch (IllegalArgumentException e) {
                 System.out.println("Error: " + e.getMessage());
            }

    // Bilance negative
        try {
                new Account("3", "Bob", BigDecimal.valueOf(-100));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        
        Account acc4 = new Account("4", "Charlie", BigDecimal.valueOf(300));
            System.out.println("Passed: " + acc4);
        

    //Added deposit            
           try {
            acc4.deposit(BigDecimal.valueOf(200));
            System.out.println("Deposit 200: " + acc4);
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }

    //Negative
        try {
                acc4.deposit(BigDecimal.valueOf(-50));
            } catch (IllegalArgumentException e) {
                System.out.println("Deposit failed: " + e.getMessage());
            }

    //Withdraw            
         try {
                acc4.withdraw(BigDecimal.valueOf(100));
                System.out.println("Withdraw 100: " + acc4);
            } catch (InsufficientFundsException e) {
               System.out.println("Withdraw failed (not enough funds): " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Withdraw failed (negative): " + e.getMessage());
            }

    //Over bilance           
        try {
                acc4.withdraw(BigDecimal.valueOf(1000));
            } catch (InsufficientFundsException e) {
                System.out.println("Withdraw over bilance: " + e.getMessage());
            }

    //Negative withdraw
       try {
                 acc4.withdraw(BigDecimal.valueOf(-50));
            } catch (InsufficientFundsException e) {
                 System.out.println("Withdraw failed (not enough funds): " + e.getMessage());
            } catch (IllegalArgumentException e) {
                 System.out.println("Withdraw failed (negative): " + e.getMessage());
            }
            
        Bank bank = new Bank("National Bank", BigDecimal.valueOf(10), BigDecimal.valueOf(0.05));

        Account acc1 = new Account("1", "Alice", BigDecimal.valueOf(1000));
        Account acc2 = new Account("2", "Bob", BigDecimal.valueOf(500));

        bank.addAccount(acc1);
        bank.addAccount(acc2);

        System.out.println("\n--- Bank: " + bank.getBankName() + " ---");
        System.out.println("Accounts added:");
        System.out.println(acc1);
        System.out.println(acc2);
   
        try {
            // Flat fee transfer
            bank.transfer("1", "2", BigDecimal.valueOf(200), false, "Flat fee transfer");
            // Percent fee transfer
            bank.transfer("2", "1", BigDecimal.valueOf(100), true, "Percent fee transfer");
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

    //Transactions
          System.out.println("\nTransactions for Alice:");
        for (Transaction t : bank.getTransactionsForAccount("1")) {
            System.out.println(t);
        }

        System.out.println("\nTransactions for Bob:");
        for (Transaction t : bank.getTransactionsForAccount("2")) {
            System.out.println(t);
        }

    //All accounts
        System.out.println("\nBalances:");
        System.out.println(acc1);
        System.out.println(acc2);

       System.out.println("\nAll accounts in bank:");
        for (Account a : bank.getAccounts()) {
        System.out.println(a);
        }

        System.out.println("\n--- Bank Totals ---");
        System.out.println("Total fees collected: $" + bank.getTotalTransactionFees());
        System.out.println("Total transfer amount: $" + bank.getTotalTransferAmount());

    }
}