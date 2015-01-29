package pl.nkoder.craftingcodeworkshop.exercise2;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;

public class StatementPrinter {

    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void printStatementFor(Transactions transactions) {
        console.writeLine("DATE | AMOUNT | BALANCE");
        int totalAmount = 0;
        for (Transaction transaction : transactions.asListOrderedChronologically()) {
            totalAmount += transaction.amount();
            console.writeLine(formatted(transaction, totalAmount));
        }
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
