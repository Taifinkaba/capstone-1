package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Transaction {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    // class constructor
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount){
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // setter and getters for date, time, description, vendor, amount
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // read transaction from CSV
    static ArrayList<Transaction> readTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();

        // folder path
        String folder = "src/main/resources";

        try{
            // reader for file and buffered
            FileReader fileReader = new FileReader(folder + "transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;

            while((input = bufferedReader.readLine()) != null){
                // skip empty line
                if(input.trim().equals("")) continue;

                String[] tokens = input.split("\\|");

                // seperate each part
                LocalDate date = LocalDate.parse(tokens[0].trim());
                LocalTime time = LocalTime.parse(tokens[1].trim());
                String description = tokens[2].trim();
                String vendor = tokens[3].trim();
                double amount = Double.parseDouble(tokens[4].trim());

                // create transaction
                Transaction t = new Transaction(date, time, description, vendor, amount);

                // add to list
                transactions.add(t);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading transaction, try again!");
            e.printStackTrace();
        }

        return transactions;
    }

    // TO-DO: write transaction to CSV


}
