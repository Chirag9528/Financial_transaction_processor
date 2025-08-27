package com.transactionReport;

import java.util.List;

/**
 * This class generates the report from a list of transactions.
 */
public class ReportGenerator {
    /**
     * It generates a report from a list of transactions.
     *
     * @param transactions a list of transactions.
     * @return returns a string of report
     */
    public String generateReport(final List<Transaction> transactions) {
        final StringBuilder report = new StringBuilder();
        report.append("------------------------------------------\n");
        report.append(String.format("%-12s %-12s %-12s %s\n", "Date", "Type", "Amount", "Balance"));
        report.append("------------------------------------------\n");

        for (Transaction t : transactions) {
            report.append(String.format("%-12s %-12s %-12.2f %.2f\n",
                t.getDate(), t.getType(), t.getAmount(), t.getBalance()));
        }

        report.append("------------------------------------------\n");
        return report.toString();
    }
}
