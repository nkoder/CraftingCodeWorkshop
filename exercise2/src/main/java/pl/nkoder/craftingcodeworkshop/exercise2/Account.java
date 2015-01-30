package pl.nkoder.craftingcodeworkshop.exercise2;

import pl.nkoder.craftingcodeworkshop.exercise2.statementprinter.StatementPrinter;
import pl.nkoder.craftingcodeworkshop.exercise2.system.SystemClock;
import pl.nkoder.craftingcodeworkshop.exercise2.transactions.Transactions;

public class Account {

    private Transactions transactions;
    private final SystemClock systemClock;
    private final StatementPrinter statementPrinter;

    public Account(Transactions transactions, SystemClock systemClock, StatementPrinter statementPrinter) {
        this.transactions = transactions;
        this.systemClock = systemClock;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        storeTransactionOf(amount);

    }

    public void withdraw(int amount) {
        storeTransactionOf(-amount);

    }

    public void printStatement() {
        statementPrinter.printStatementFor(transactions);
    }

    private void storeTransactionOf(int amount) {
        transactions.storeTransaction(amount, systemClock.currentDate());
    }
}
