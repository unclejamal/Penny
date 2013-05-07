package com.pduda.penny.domain.view;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.Assert.*;
import static com.pduda.hamcrest.RegexMatcher.*;
import com.pduda.penny.Conveniences;
import com.pduda.penny.ObjectMother;
import com.pduda.penny.domain.model.Amount;
import com.pduda.penny.domain.model.Category;
import com.pduda.penny.domain.model.Transaction;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.joda.time.LocalDate;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class FormatTransactionsAsCsvFileTest {

    private Mockery mockery = new Mockery();
    private final CsvFormat<Transaction> transactionCsvFormat = mockery.mock(CsvFormat.class, "transaction format");
    private final CsvHeaderFormat csvHeaderFormat = mockery
            .mock(
            CsvHeaderFormat.class, "header format");
    private final TransactionsCsvFileFormat transactionsCsvFileFormat = new TransactionsCsvFileFormat(
            csvHeaderFormat, transactionCsvFormat);

    @Test
    public void noTransactions() throws Exception {
        mockery.checking(
                new Expectations() {
            {
                allowing(csvHeaderFormat).formatHeader();
                will(returnValue("::header::"));
            }
        });

        final String text = transactionsCsvFileFormat.format(
                Collections.<Transaction>emptyList());
        final List<String> lines = Arrays.asList(
                text.split(
                Conveniences.NEWLINE));
        assertEquals(1, lines.size());
        assertThat(lines.get(0), matches("::header::"));
        assertThat(text, endsWith(Conveniences.NEWLINE));
    }

    @Test
    public void aFewTransactions() throws Exception {
        mockery.checking(
                new Expectations() {
            {
                allowing(csvHeaderFormat).formatHeader();
                will(returnValue("::header::"));
                allowing(transactionCsvFormat).format(
                        with(
                        any(
                        Transaction.class)));
                will(
                        onConsecutiveCalls(
                        returnValue("::row 1::"), returnValue(
                        "::row 2::"), returnValue("::row 3::")));
            }
        });

        final String text = transactionsCsvFileFormat.format(
                Lists.newArrayList(
                ObjectMother.createAnyNonNullTransaction(),
                ObjectMother.createAnyNonNullTransaction(),
                ObjectMother.createAnyNonNullTransaction()));

        final List<String> lines = Arrays.asList(
                text.split(
                Conveniences.NEWLINE));
        assertEquals(4, lines.size());
        assertThat(lines.get(0), matches("::header::"));
        assertThat(lines.get(1), matches("::row 1::"));
        assertThat(lines.get(2), matches("::row 2::"));
        assertThat(lines.get(3), matches("::row 3::"));
        assertThat(text, endsWith(Conveniences.NEWLINE));
    }
}