package pl.nkoder.craftingcodeworkshop.exercise2;

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
        console.writeLine("DATE | AMOUNT | BALANCE");
        int totalAmount = 0;
        List<String> lines = newArrayList();
        for (Transaction transaction : reverse(transactions.orderedFromNewestToOldest())) {
            totalAmount += transaction.amount();
            lines.add(formatted(transaction, totalAmount));
        }
        reverse(lines).forEach(console::writeLine);
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
