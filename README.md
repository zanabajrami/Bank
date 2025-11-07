# Bank System

## Description
This project is a simple banking system implemented in Java. It simulates user accounts, deposits, withdrawals, and transactions between accounts, including transaction fees (fixed or percentage-based).

The program uses **Object-Oriented Programming (OOP)** with abstraction, inheritance, and method overloading/overriding.
Transactions can be **deposit, withdrawal, or transfer** between accounts, and the bank applies a **fixed or percentage fee** for each transaction.

### Main Classes
- **AbstractAccount**: Abstract class for an account, includes `id`, `name`, and `balance`.
Uses `BigDecimal` for accurate balances.
- **Account**: Inherits from `AbstractAccount`, implements `deposit` and `withdraw`,and keeps a list of transactions.
- **Transaction**: Represents a transaction between accounts or a deposit/withdrawal, with `amount`, `fee` and `reason`.
- **Bank**: Manages accounts and transactions, keeps track of total fees and total transferred amounts.
- **InsufficientFundsException**: Exception thrown when the balance is insufficient for a withdrawal or transfer.

### Features
- Create accounts with an `id`, `name`, and `balance`.
- Create a bank with required values.
- Perform transactions (transfer, deposit, withdrawal).
- Apply fixed fee or percentage fee for transactions.
- View transactions for any account.
- Check account balances.
- Track total fees collected and total transfer amounts by the bank..
- Handle errors and exceptions (e.g., negative deposit, overdraw, account not found).

### Example Output
Error: Account ID cannot be null or empty.
Error: Account name cannot be null or empty.
Error: Initial balance cannot be negative.
Passed: Account{id='4', name='Charlie', balance=300.00}
Deposit 200: Account{id='4', name='Charlie', balance=500.00}
Deposit failed: Deposit must be positive.
Withdraw 100: Account{id='4', name='Charlie', balance=400.00}
Withdraw over balance: Not enough funds in account '4': balance = 400.00, requested = 1000.00
Withdraw failed (negative): Withdrawal must be positive.

--- Bank: National Bank ---
Accounts added:
Account{id='1', name='Alice', balance=1000.00}
Account{id='2', name='Bob', balance=500.00}
Transfer: Transaction{from='1', to='2', amount=200.00, fee=10.00, reason='Flat fee transfer'}
Transfer: Transaction{from='2', to='1', amount=100.00, fee=5.00, reason='Percent fee transfer'}

Total fees collected: $15.00
Total transfer amount: $300.00

### Project Structure
BankSystem/
 └─ Bank/
     ├─ src/com/bank/
     │   ├─ Account.java
     │   ├─ AbstractAccount.java
     │   ├─ Bank.java
     │   ├─ Transaction.java
     │   ├─ InsufficientFundsException.java
     │   └─ Main.java
     └─ README.md

## Dependencies
- **Java 17** or higher.
- No external libraries required.

## How to Run the Program
1. **Open a terminal** and navigate to the `src` folder inside `Bank`.
2. Compile all Java files:
  ```bash
   javac com/bank/*.java
3.Run the main program:  
   java com.bank.Main