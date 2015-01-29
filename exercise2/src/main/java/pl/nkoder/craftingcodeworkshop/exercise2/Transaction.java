package pl.nkoder.craftingcodeworkshop.exercise2;

import java.time.LocalDate;

public class Transaction {

    private final int amount;
    private final LocalDate date;

    public Transaction(int amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public LocalDate date() {
        return date;
    }

    public int amount() {
        return amount;
    }
}
