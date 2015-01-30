package pl.nkoder.craftingcodeworkshop.exercise2.statementprinter;

import pl.nkoder.craftingcodeworkshop.exercise2.calculators.TotalAmountCalculator;
import pl.nkoder.craftingcodeworkshop.exercise2.system.Console;
import pl.nkoder.craftingcodeworkshop.exercise2.transactions.Transaction;
import pl.nkoder.craftingcodeworkshop.exercise2.transactions.Transactions;

import java.time.LocalDate;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.reverse;
import static java.time.format.DateTimeFormatter.ofPattern;

public class StatementPrinter {

    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void printStatementFor(Transactions transactions) {
        printHeader();
        statementLinesFor(transactions).forEach(console::writeLine);
    }

    private void printHeader() {
        console.writeLine("DATE | AMOUNT | BALANCE");
    }

    private List<String> statementLinesFor(Transactions transactions) {
        TotalAmountCalculator calculator = new TotalAmountCalculator();
        List<String> lines = newArrayList();
        for (Transaction transaction : reversed(transactions)) {
            calculator.add(transaction.amount());
            lines.add(formatted(transaction, calculator.totalAmount()));
        }
        return reverse(lines);
    }

    private List<Transaction> reversed(Transactions transactions) {
        return reverse(transactions.orderedFromNewestToOldest());
    }

    private String formatted(Transaction transaction, int totalAmount) {
        return formatted(transaction.date()) + " | "
                + formatted(transaction.amount()) + " | "
                + formatted(totalAmount);
    }

    private String formatted(LocalDate date) {
        return date.format(ofPattern("dd/MM/yyyy"));
    }

    private String formatted(int amount) {
        return String.valueOf(amount) + ".00";
    }
}
