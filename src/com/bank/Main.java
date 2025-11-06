package com.bank;

public class Main {
        public static void main(String[] args) {

    //ID null
       try {
    new Account(null, "Alice", 1000);
        } catch (IllegalArgumentException e) {
              System.out.println("Error: " + e.getMessage());
        }   

    // Name null
        try {
                new Account("2", "", 500);
            } catch (IllegalArgumentException e) {
                 System.out.println("Error: " + e.getMessage());
            }

    // Bilance negative
        try {
                new Account("3", "Bob", -100);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        
        Account acc4 = null;
        try {
            acc4 = new Account("4", "Charlie", 300);
            System.out.println("Passed: " + acc4);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed: " + e.getMessage());
        }

    //Added deposit            
            if (acc4 != null) {
            try {
                acc4.deposit(200);
                System.out.println("Deposit 200: " + acc4);
            } catch (IllegalArgumentException e) {
                System.out.println("Deposit failed: " + e.getMessage());
            }
            
    //Negatitve deposit
        try {
                acc4.deposit(-50);
            } catch (IllegalArgumentException e) {
                System.out.println("Deposit failed: " + e.getMessage());
            }

    //Withdraw            
         try {
                acc4.withdraw(100);
                System.out.println("Withdraw 100: " + acc4);
            } catch (InsufficientFundsException e) {
               System.out.println("Withdraw failed (not enough funds): " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Withdraw failed (negative): " + e.getMessage());
            }

    //Over bilance           
        try {
                acc4.withdraw(1000);
            } catch (InsufficientFundsException e) {
                System.out.println("Withdraw over bilance: " + e.getMessage());
            }

    //Negative withdraw
       try {
                 acc4.withdraw(-50);
            } catch (InsufficientFundsException e) {
                 System.out.println("Withdraw failed (not enough funds): " + e.getMessage());
            } catch (IllegalArgumentException e) {
                 System.out.println("Withdraw failed (negative): " + e.getMessage());
            }
 
    }
}}