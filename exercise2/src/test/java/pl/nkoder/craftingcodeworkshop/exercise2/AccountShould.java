package pl.nkoder.craftingcodeworkshop.exercise2;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.*;

public class AccountShould {

    private final Transactions transactions = mock(Transactions.class);
    private final SystemClock systemClock = mock(SystemClock.class);
    private final StatementPrinter statementPrinter = mock(StatementPrinter.class);
    private final LocalDate someDate = new LocalDate(2014, 1, 1);
    private Account account;

    @Test
    public void print_statement_of_transactions() {
        account = newAccountUsing(transactions, statementPrinter);
        
        account.printStatement();

        verify(statementPrinter).printStatementOf(transactions);
    }

    @Test
    public void store_deposit_in_transactions() {
        currentDateIs(someDate);
        account = newAccountUsing(transactions);

        account.deposit(100);

        verify(transactions).storeTransaction(100, someDate);
    }

    @Test
    public void store_withdraw_in_transactions() {
        currentDateIs(someDate);
        account = newAccountUsing(transactions);

        account.withdraw(100);

        verify(transactions).storeTransaction(-100, someDate);
    }

    private OngoingStubbing<LocalDate> currentDateIs(LocalDate date) {
        return when(systemClock.currentDate()).thenReturn(date);
    }

    private Account newAccountUsing(Transactions transactions) {
        return newAccountUsing(transactions, statementPrinter);
    }

    private Account newAccountUsing(Transactions transactions, StatementPrinter statementPrinter) {
        return newAccountUsing(transactions, systemClock, statementPrinter);
    }

    private Account newAccountUsing(Transactions transactions, SystemClock systemClock,
                                    StatementPrinter statementPrinter) {
        return new Account(transactions, systemClock, statementPrinter);
    }
}