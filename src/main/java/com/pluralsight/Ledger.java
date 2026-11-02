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
        ledgerLoop();

        // user input
        System.out.println("Enter deposit information(date|time|description|vendor|amount): ");
        String input = myScanner.nextLine().trim();

        homeScreen();
        ledger();

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
                }
                case "X" -> {
                    System.out.println("Exit");
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
    static void ledgerLoop() {

    }
}
