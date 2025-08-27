# Financial Transaction Processor

### 1. Specification
The project's goal is to process financial transactions from a CSV file and generate a formatted report. The core functions are defined: reading, processing (calculating balances), and reporting.

### 2. Architecture
The architecture directly reflects the **Single Responsibility Principle** (SRP). Each component has a specific, well-defined purpose:
* **`TransactionDataReader`**: Handles file input.
* **`BalanceCalculator`**: Handles the business logic of calculating the balance.
* **`ReportGenerator`**: Handles the presentation logic.
* **`App`**: Serves as the orchestrator, tying all the components together without containing any core logic itself.

This modular architecture promotes **loose coupling**, making it easy to swap out components. For example, you could replace `TransactionDataReader` with a `DatabaseReader` without affecting the `BalanceCalculator` or `ReportGenerator`.

