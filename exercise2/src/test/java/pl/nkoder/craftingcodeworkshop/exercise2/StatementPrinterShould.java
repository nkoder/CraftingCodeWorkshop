package pl.nkoder.craftingcodeworkshop.exercise2;

import org.junit.Test;
import org.mockito.InOrder;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;
import static org.mockito.Mockito.*;

public class StatementPrinterShould {

    private Console console = mock(Console.class);
    private StatementPrinter statementPrinter;

    @Test
    public void
    print_only_statement_header_for_no_transactions_at_all() {
        statementPrinter = new StatementPrinter(console);

        statementPrinter.printStatementFor(noTransactions());

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).writeLine("DATE | AMOUNT | BALANCE");
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void
    print_statement_for_one_transaction() {
        statementPrinter = new StatementPrinter(console);

        statementPrinter.printStatementFor(transactions(
                transaction(100, dateOf(2014, 1, 29))));

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).writeLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).writeLine("29/01/2014 | 100.00 | 100.00");
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void
    print_statement_for_multiple_transactions() {
        statementPrinter = new StatementPrinter(console);

        statementPrinter.printStatementFor(transactions(
                transaction(100, dateOf(2014, 1, 28)),
                transaction(-50, dateOf(2014, 1, 29)),
                transaction(150, dateOf(2014, 1, 30))));

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).writeLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).writeLine("28/01/2014 | 100.00 | 100.00");
        inOrder.verify(console).writeLine("29/01/2014 | -50.00 | 50.00");
        inOrder.verify(console).writeLine("30/01/2014 | 150.00 | 200.00");
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void
    print_statement_for_transactions_from_different_months_and_years() {
        statementPrinter = new StatementPrinter(console);

        statementPrinter.printStatementFor(transactions(
                transaction(0, dateOf(2014, 12, 31)),
                transaction(0, dateOf(2015, 1, 1))));

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).writeLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).writeLine("31/12/2014 | 0.00 | 0.00");
        inOrder.verify(console).writeLine("01/01/2015 | 0.00 | 0.00");
        inOrder.verifyNoMoreInteractions();
    }

    private Transaction transaction(int amount, LocalDate date) {
        return new Transaction(amount, date);
    }

    private LocalDate dateOf(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    private Transactions noTransactions() {
        return transactions();
    }

    private Transactions transactions(Transaction... transactionsAsList) {
        ArrayList<Transaction> asList = newArrayList(transactionsAsList);
        Transactions transactions = mock(Transactions.class);
        when(transactions.orderedFromNewestToOldest()).thenReturn(asList);
        return transactions;
    }

}