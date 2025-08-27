package com.transactionReport;

import java.util.List;

/**
 * The main application class for the Financial Transaction Processor.
 */
public class App {
    /**
     * This is the starting point of the application.
     *
     * @param args command-line arguments passed to the application.
     */
    public static void main(final String[] args) {
        // Step 1: Read the raw data
        final TransactionDataReader reader = new TransactionDataReader();
        final List<Transaction> rawTransactions = reader.readTransactions("transaction.csv");
                
        // Step 2: Perform business logic (calculate balances)
        final BalanceCalculator calculator = new BalanceCalculator();
        calculator.calculateBalances(rawTransactions);
                
        // Step 3: Generate the final report
        final ReportGenerator reportGenerator = new ReportGenerator();
        final String report = reportGenerator.generateReport(rawTransactions);
                
        // Step 4: Output the report
        System.out.println(report);
    }
}
