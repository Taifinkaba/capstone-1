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
        homeScreenLoop();
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

    static void homeScreenLoop() {
        boolean run = true;

        while(run){

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
