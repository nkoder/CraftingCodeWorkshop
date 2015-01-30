package pl.nkoder.craftingcodeworkshop.exercise2;

import org.junit.Test;
import org.mockito.InOrder;
import pl.nkoder.craftingcodeworkshop.exercise2.statementprinter.StatementPrinter;
import pl.nkoder.craftingcodeworkshop.exercise2.system.Console;
import pl.nkoder.craftingcodeworkshop.exercise2.system.SystemClock;
import pl.nkoder.craftingcodeworkshop.exercise2.transactions.Transactions;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class PrintStatementFeature {

    @Test
    public void print_statement() {
        Console console = mock(Console.class);
        SystemClock systemClock = mock(SystemClock.class);
        when(systemClock.currentDate())
                .thenReturn(dateOf(2014, 4, 2))
                .thenReturn(dateOf(2014, 4, 10))
                .thenReturn(dateOf(2014, 4, 1));
        Account account = newAccountUsing(systemClock, console);
        account.withdraw(100);
        account.deposit(500);
        account.deposit(1000);

        account.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).writeLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).writeLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).writeLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).writeLine("01/04/2014 | 1000.00 | 1000.00");
        inOrder.verifyNoMoreInteractions();
    }

    private LocalDate dateOf(int year, int month, int dayOfMonth) {
        return LocalDate.of(year, month, dayOfMonth);
    }

    private Account newAccountUsing(SystemClock systemClock, Console console) {
        return new Account(new Transactions(), systemClock, new StatementPrinter(console));
    }
}