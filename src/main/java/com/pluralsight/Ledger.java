package com.pluralsight;

import java.util.Scanner;

public class Ledger {
    static void main() {
        // initalize scanner
        Scanner myScanner = new Scanner(System.in);

        // user input
        System.out.println("Enter deposit information(date|time|description|vendor|amount): ");
        String input = myScanner.nextLine().trim();

        homeScreen();
        ledger();
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

    // display ledger menu options
    static void ledger() {
        System.out.println("""
                Select Entry Type:
                A) All
                D) Deposits
                P) Payments
                R) Reports
                """);

    }
}
