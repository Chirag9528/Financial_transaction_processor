package com.transactionReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used for reading transactions.
 */
public class TransactionDataReader {
    /**
     * It represents the number of coloumns in a transaction.
     */
    private static final int EXPECTED_PARTS = 3;

    /**
     *  Reads transaction data from a CSV file.
     *
     *  @param filename The name of the CSV file to read.
     *  @return a list of transactions 
     */
    public List<Transaction> readTransactions(final String filename) {
        final List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                final String[] parts = line.split(",");
                if (parts.length == EXPECTED_PARTS) {
                    final LocalDate date = LocalDate.parse(parts[0]);
                    final String type = parts[1];
                    final double amount = Double.parseDouble(parts[2]);
                    if (amount >= 0) {
                        transactions.add(new Transaction(date, type, amount));
                    } else {
                        System.out.println("Invalid transaction skipped: " + date + type + amount);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return transactions;
    }
}
