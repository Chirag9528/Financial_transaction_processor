package com.transactionReport;

import java.time.LocalDate;

/**
 * Data model representing a single transcation.
 */
public class Transaction {
    /**
     * The date of the transaction.
     */
    private LocalDate date;
    /**
     *  The type of the transaction ("deposit" or "withdrawal").
     */
    private String type;
    /**
     *  The amount of the transaction.
     */
    private double amount;
    /**
     * The account balance after this transaction.
     */
    private double balance;
                      
    public Transaction(final LocalDate trDate, final String trType, final double trAmount) {
        this.date = trDate;
        this.type = trType;
        this.amount = trAmount;
    }
        
    public LocalDate getDate() {
        return date; 
    }

    public String getType() {
        return type; 
    }

    public double getAmount() { 
        return amount; 
    }

    public double getBalance() {
        return balance; 
    }

    public void setBalance(final double trBalance) {
        this.balance = trBalance; 
    }
}

