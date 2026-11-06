package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    static void main() {
        // initalize scanner
        Scanner myScanner = new Scanner(System.in);

        // array list for transaction
        ArrayList<Transaction> transactions = Transaction.readTransactions();

        // Header
        System.out.println("Tai's Ledger!");

        // loops for home and ledger
        homeScreenLoop(myScanner, transactions);

        myScanner.close();
    }


    // display home screen options
    static void homeScreen() {
        System.out.println("""
                Select An Option:
                D) Add Deposit
                P) Make Payment (Debit)
                L) Ledger
                X) Exit
                """);
    }

    static void homeScreenLoop(Scanner myScanner, ArrayList<Transaction> transactions) {
        boolean run = true;

        while(run){
            // show home screen options
            homeScreen();

            // user input
            System.out.println("Enter your choice: ");
            String input = myScanner.nextLine().trim().toUpperCase();

            // switch case depending on user input
            switch (input){
                case "D" -> {
                    addDeposit(myScanner, transactions);
                }
                case "P" -> {
                    makePayment(myScanner, transactions);
                }
                case "L" -> {
                    System.out.println("Ledger");
                    ledgerLoop(myScanner, transactions);
                }
                case "X" -> {
                    System.out.println("Exit");
                    run = false;
                }
                default -> System.out.println("Invalid option, try again!");

            }

        }
    }

    // display ledger menu options
    static void ledger() {
        System.out.println("""
                Select Entry Type:
                A) All
                D) Deposits
                P) Payments
                R) Reports
                H) Home
                """);

    }

    // ledger loop
    static void ledgerLoop(Scanner myScanner, ArrayList<Transaction> transactions) {
        boolean run = true;

        while(run){
            // show home screen options
            ledger();

            // user input
            System.out.println("Enter your choice: ");
            String input = myScanner.nextLine().trim().toUpperCase();

            // switch case depending on user input
            switch (input){
                case "A" -> {
                    displayTransactions(transactions);
                }
                case "D" -> {
                    displayDeposits(transactions);
                }
                case "P" -> {
                    displayPayments(transactions);
                }
                case "R" -> {
                    System.out.println("Reports");
                    // need another method for options 0-5
                    reportsLoop(myScanner, transactions);
                }
                case "H" -> {
                    System.out.println("Home");
                    run = false;
                }
                default -> System.out.println("Invalid option, try again!");

            }

        }
    }

    // report options
    static void reportOptions() {
        System.out.println("""
                Select Report Type:
                1) Month To Date
                2) Previous Month
                3) Year To Date
                4) Previous Year
                5) Search by Vendor
                0) Back
                """);

    }

    // ledger loop
    static void reportsLoop(Scanner myScanner, ArrayList<Transaction> transactions) {
        boolean run = true;

        while(run){
            // show home screen options
            reportOptions();

            // user input
            System.out.println("Enter your choice: ");
            String input = myScanner.nextLine().trim();

            // switch case depending on user input
            switch (input){
                case "1" -> {
                    System.out.println("Month To Date");
                }
                case "2" -> {
                    System.out.println("Previous Month");
                }
                case "3" -> {
                    System.out.println("Year To Date");
                }
                case "4" -> {
                    System.out.println("Previous Year");
                }
                case "5" -> {
                    searchByVendor(myScanner, transactions);
                }
                case "0" -> {
                    System.out.println("Back");
                    run = false;
                }
                default -> System.out.println("Invalid option, try again!");

            }

        }
    }

    // show unfiltered transaction(ALL)
    static void displayTransactions(ArrayList<Transaction> transactions) {
        // base case
        if(transactions.isEmpty()){
            System.out.println("Not found, try again!");
            return;
        }

        // sorting
        ArrayList<Transaction> sortedTransactions = sortTransactions(transactions);

        // for each transaction we have on file print it
        for(Transaction t : sortedTransactions){
            System.out.printf("%s | %s | %s | %s | $%.2f%n", t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
        }

    }

    // show depositing money(DEPOSIT)
    static void displayDeposits(ArrayList<Transaction> transactions) {
        ArrayList<Transaction> deposits = new ArrayList<>();

        for(Transaction t : transactions){
            // can not deposit negative numbers
            if(t.getAmount() > 0) deposits.add(t);
        }

        displayTransactions((deposits));
    }

    // show payments made(PAYMENT)
    static void displayPayments(ArrayList<Transaction> transactions) {
        ArrayList<Transaction> payments = new ArrayList<>();

        for(Transaction t : transactions){
            // payment means money going out
            if(t.getAmount() < 0) payments.add(t);
        }

        displayTransactions((payments));
    }


    // show report on user(REPORTS)


    // take user back to homepage(HOME)

    // return list sorted from new to old
    static ArrayList<Transaction> sortTransactions(ArrayList<Transaction> transactions) {
        ArrayList<Transaction> sortedTransactions = new ArrayList<>(transactions);

        // sorting
        for (int i = 0; i < sortedTransactions.size(); i++) {
            for (int j = i + 1; j < sortedTransactions.size(); j++) {
                Transaction first = sortedTransactions.get(i);
                Transaction second = sortedTransactions.get(j);

                // second = 1, tie = 0, first = -1
                int dateComparison = second.getDate().compareTo(first.getDate());

                // if second wins or if we have a tie compare time to pick whats newer
                boolean secondIsNewer = dateComparison > 0 || (dateComparison == 0 && second.getTime().compareTo(first.getTime()) > 0);

                // swap places
                if (secondIsNewer) {
                    sortedTransactions.set(i, second);
                    sortedTransactions.set(j, first);
                }
            }
        }

        return sortedTransactions;

    }

    // add money
    static void addDeposit(Scanner myScanner, ArrayList<Transaction> transactions) {
        addTransaction(myScanner, transactions, true);
    }

    // make payment - money goes out
    static void makePayment(Scanner myScanner, ArrayList<Transaction> transactions) {
        addTransaction(myScanner, transactions, false);
    }

    // add transactions CRUD
    static void addTransaction(Scanner myScanner, ArrayList<Transaction> transactions, boolean depositOrPayment) {
        System.out.println("Enter description: ");
        String description = myScanner.nextLine().trim();

        System.out.println("Enter vendor: ");
        String vendor = myScanner.nextLine().trim();

        System.out.println("Enter amount ");
        double amount = Double.parseDouble(myScanner.nextLine().trim());

        if(!depositOrPayment) amount = -amount;

        Transaction transaction = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);

        transaction.writeTransaction();
        transactions.add(transaction);


    }

    // show month to date
    // show previous month
    // show year to date
    // show previous year
    // search by vendor
    static void searchByVendor(Scanner myScanner, ArrayList<Transaction> transactions) {
        System.out.println("Enter vendor name: ");
        String vendor = myScanner.nextLine().trim();

        ArrayList<Transaction> results = new ArrayList<>();

        for(Transaction t : transactions){
            if(t.getVendor().equals(vendor)) results.add(t);
        }

        displayTransactions(results);

    }

}
