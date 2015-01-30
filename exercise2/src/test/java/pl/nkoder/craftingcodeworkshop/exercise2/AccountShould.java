package pl.nkoder.craftingcodeworkshop.exercise2;

import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;
import pl.nkoder.craftingcodeworkshop.exercise2.statementprinter.StatementPrinter;
import pl.nkoder.craftingcodeworkshop.exercise2.system.SystemClock;
import pl.nkoder.craftingcodeworkshop.exercise2.transactions.Transactions;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class AccountShould {

    private static final LocalDate SOME_DATE = LocalDate.of(2014, 1, 1);

    private Transactions transactions = mock(Transactions.class);
    private SystemClock systemClock = mock(SystemClock.class);
    private StatementPrinter statementPrinter = mock(StatementPrinter.class);
    private Account account;

    @Test
    public void
    print_statement_for_transactions() {
        account = newAccountUsing(transactions, statementPrinter);
        
        account.printStatement();

        verify(statementPrinter).printStatementFor(transactions);
    }

    @Test
    public void
    store_deposit_in_transactions() {
        currentDateIs(SOME_DATE);
        account = newAccountUsing(transactions);

        account.deposit(100);

        verify(transactions).storeTransaction(100, SOME_DATE);
    }

    @Test
    public void
    store_withdraw_in_transactions() {
        currentDateIs(SOME_DATE);
        account = newAccountUsing(transactions);

        account.withdraw(100);

        verify(transactions).storeTransaction(-100, SOME_DATE);
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