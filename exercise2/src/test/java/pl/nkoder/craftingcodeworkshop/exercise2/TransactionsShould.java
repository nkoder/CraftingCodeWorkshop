package pl.nkoder.craftingcodeworkshop.exercise2;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionsShould {

    private int AMOUNT = 100;
    private static final LocalDate DATE = LocalDate.of(2014, 1, 29);

    @Test
    public void
    store_provide_empty_list_if_nothing_stored() {
        Transactions transactions = new Transactions();

        assertThat(transactions.orderedFromNewestToOldest()).isEmpty();
    }

    @Test
    public void
    store_provide_one_stored_transaction() {
        Transactions transactions = new Transactions();
        transactions.storeTransaction(AMOUNT, DATE);

        assertThat(transactions.orderedFromNewestToOldest())
                .usingFieldByFieldElementComparator()
                .containsExactly(transaction(AMOUNT, DATE));
    }

    @Test
    public void
    store_provide_stored_transaction_ordered_chronologically() {
        Transactions transactions = new Transactions();
        transactions.storeTransaction(AMOUNT, DATE);
        transactions.storeTransaction(AMOUNT, DATE.minusDays(1));
        transactions.storeTransaction(AMOUNT, DATE.plusDays(1));

        assertThat(transactions.orderedFromNewestToOldest())
                .containsExactly(
                        transaction(AMOUNT, DATE.plusDays(1)),
                        transaction(AMOUNT, DATE),
                        transaction(AMOUNT, DATE.minusDays(1)));
    }

    private Transaction transaction(int amount, LocalDate date) {
        return new Transaction(amount, date);
    }
}