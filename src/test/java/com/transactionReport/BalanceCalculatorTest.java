package com.transactionReport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BalanceCalculatorTest {
    @Test
    void testCalculateBalances() {
        BalanceCalculator calculator = new BalanceCalculator();
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(LocalDate.of(2025, 1, 1), "deposit", 1000.00));
        transactions.add(new Transaction(LocalDate.of(2025, 1, 2), "withdrawal", 250.00));
        transactions.add(new Transaction(LocalDate.of(2025, 1, 3), "deposit", 500.00));
        
        calculator.calculateBalances(transactions);

        // Assert
        assertEquals(1000.00, transactions.get(0).getBalance(), 0.01, "First transaction balance should be 1000.00");
        assertEquals(750.00, transactions.get(1).getBalance(), 0.01, "Second transaction balance should be 750.00");
        assertEquals(1250.00, transactions.get(2).getBalance(), 0.01, "Third transaction balance should be 1250.00");
    }

    @Test
    void testCalculateBalance_WithEmptyList() {
        BalanceCalculator calculator = new BalanceCalculator();
        List<Transaction> transactions = new ArrayList<>();

        calculator.calculateBalances(transactions);

        // Assert
        assertTrue(transactions.isEmpty(), "An empty list should remain empty.");
    }
}
