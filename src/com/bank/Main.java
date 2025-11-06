package com.bank;

public class Main {
    public static void main(String[] args) {
        try {
            Account acc1 = new Account("1", "Alice", 1000);
            Account acc2 = new Account("2", "Bob", 500);

            acc1.deposit(200);
            acc2.withdraw(100);

            System.out.println(acc1);
            System.out.println(acc2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
