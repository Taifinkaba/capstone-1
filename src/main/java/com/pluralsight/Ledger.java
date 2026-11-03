package com.pluralsight;

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
                    System.out.println("Deposit");
                }
                case "P" -> {
                    System.out.println("Make Payment(Debit)");
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
                    System.out.println("Search by Vendor");
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

        // for each transaction we have on file print it
        for(Transaction t : transactions){
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


}
