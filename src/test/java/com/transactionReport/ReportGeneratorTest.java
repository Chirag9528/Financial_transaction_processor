package com.transactionReport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReportGeneratorTest {
    @Test
    void testGenerateReport() {
        ReportGenerator reportGenerator = new ReportGenerator();
        List<Transaction> transactions = new ArrayList<>();
        Transaction t1 = new Transaction(LocalDate.of(2025, 1, 1), "deposit", 1000.00);
        t1.setBalance(1000.00);
        Transaction t2 = new Transaction(LocalDate.of(2025, 1, 2), "withdrawal", 250.00);
        t2.setBalance(750.00);
        Transaction t3 = new Transaction(LocalDate.of(2025, 1, 3), "deposit", 500.00);
        t3.setBalance(1250.00);

        transactions.add(t1);
        transactions.add(t2);
        transactions.add(t3);

        String actualReport = reportGenerator.generateReport(transactions);

        String expectedReport = "------------------------------------------\n" +
                                String.format("%-12s %-12s %-12s %s\n", "Date", "Type", "Amount", "Balance") +
                                "------------------------------------------\n" +
                                String.format("%-12s %-12s %-12.2f %.2f\n", "2025-01-01", "deposit", 1000.00, 1000.00) +
                                String.format("%-12s %-12s %-12.2f %.2f\n", "2025-01-02", "withdrawal", 250.00, 750.00) +
                                String.format("%-12s %-12s %-12.2f %.2f\n", "2025-01-03", "deposit", 500.00, 1250.00) +
                                "------------------------------------------\n";

        assertEquals(expectedReport, actualReport, "The report format should match the expected string.");
    }
}
