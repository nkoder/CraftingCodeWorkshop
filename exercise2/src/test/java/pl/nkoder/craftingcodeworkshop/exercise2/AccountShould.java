package pl.nkoder.craftingcodeworkshop.exercise2;

import org.joda.time.LocalDate;
import org.junit.Test;

import static java.util.Collections.emptyList;
import static org.mockito.Mockito.*;

public class AccountShould {

    private final Transactions transactions = mock(Transactions.class);
    private final StatementPrinter statementPrinter = mock(StatementPrinter.class);
    private final SystemClock systemClock = mock(SystemClock.class);

    @Test
    public void print_empty_statement() {
        Account account = new Account(transactions, systemClock, statementPrinter);

        account.printStatement();

        verify(statementPrinter).print(emptyList());
    }

    @Test
    public void store_deposit_transaction() {
        when(systemClock.currentDate()).thenReturn(new LocalDate(2014, 01, 01));
        Account account = new Account(transactions, systemClock, statementPrinter);

        account.deposit(1000);

        verify(transactions).storeTransaction(1000, new LocalDate(2014, 01, 01));
    }

    @Test
    public void store_withdraw_transaction() {
        when(systemClock.currentDate()).thenReturn(new LocalDate(2014, 01, 01));
        Account account = new Account(transactions, systemClock, statementPrinter);

        account.withdraw(1000);

        verify(transactions).storeTransaction(-1000, new LocalDate(2014, 01, 01));
    }
}