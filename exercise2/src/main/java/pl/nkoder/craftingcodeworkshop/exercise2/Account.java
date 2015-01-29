package pl.nkoder.craftingcodeworkshop.exercise2;

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
        transactions.storeTransaction(amount, systemClock.currentDate());

    }

    public void withdraw(int amount) {
        transactions.storeTransaction(-amount, systemClock.currentDate());

    }

    public void printStatement() {
        statementPrinter.printStatementFor(transactions);
    }
}
