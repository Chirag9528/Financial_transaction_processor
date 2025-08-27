package com.transactionReport;

import java.util.List;

/**
 * This class calculates the running balance for a list of transactions.
 */
public class BalanceCalculator {
    /**
     * It calculates the running balance after processing each transaction.
     *
     * @param transactions A list of transactions.
     */
    public void calculateBalances(final List<Transaction> transactions) {
        double currentBalance = 0.0;
        for (Transaction t : transactions) {
            if ("deposit".equalsIgnoreCase(t.getType())) {
                currentBalance += t.getAmount();
            } else if ("withdrawal".equalsIgnoreCase(t.getType())) {
                currentBalance -= t.getAmount();
            }
            t.setBalance(currentBalance);
        }
    }
}
