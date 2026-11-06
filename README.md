## Features

- Add deposits and payments
- View all transactions, deposits, or payments
- View transactions from this month, last month, this year, or last year
- Search transactions by vendor
- Display transactions from newest to oldest

## Requirements

- Java JDK installed
- IntelliJ IDEA or another Java IDE

## How to Run

1. Open the project in IntelliJ IDEA.
2. Open `src/main/java/com/pluralsight/Ledger.java`.
3. Run the `Ledger` program.

## Transaction File

Transactions are stored in:

```text
src/main/resources/transactions.csv

```

Each transaction uses this format:
```text
date|time|description|vendor|amount
2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50
2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00
```
Deposits are positive amounts. Payments are negative amounts.

Manually Tested

Created By Taifinkaba Chowdhury
