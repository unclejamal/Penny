package com.pduda.penny.domain.view;

import org.junit.Test;

import static com.pduda.hamcrest.RegexMatcher.matches;
import static org.junit.Assert.assertThat;

public class FormatTransactionCsvHeaderTest {

    @Test
    public void noTransactions() throws Exception {
        final String text = new TransactionsCsvHeader()
                .formatHeader();
        assertThat(
                text, matches(
                "\\s*\"Date\",\\s*\"Category\",\\s*\"Amount\"\\s*"));
    }
}
