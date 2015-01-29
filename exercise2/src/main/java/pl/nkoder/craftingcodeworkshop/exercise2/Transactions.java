package pl.nkoder.craftingcodeworkshop.exercise2;

import com.google.common.collect.Ordering;

import java.time.LocalDate;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Transactions {

    private List<Transaction> transactions = newArrayList();

    public void storeTransaction(int amount, LocalDate date) {
        transactions.add(new Transaction(amount, date));
    }

    public List<Transaction> orderedFromNewestToOldest() {
        return new TransactionsOrdering().sortedCopy(transactions);
    }

    private static class TransactionsOrdering extends Ordering<Transaction> {

        @Override
        public int compare(Transaction first, Transaction second) {
            return -first.date().compareTo(second.date());
        }

    }
}
