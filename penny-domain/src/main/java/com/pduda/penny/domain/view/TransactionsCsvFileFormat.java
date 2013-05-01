package com.pduda.penny.domain.view;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.pduda.penny.Conveniences;
import com.pduda.penny.domain.model.Transaction;
import java.util.List;
import javax.annotation.Nullable;

public class TransactionsCsvFileFormat
        implements CsvFormat<List<Transaction>> {

    private CsvHeaderFormat csvHeaderFormat;
    private CsvFormat<Transaction> transactionCsvFormat;

    public TransactionsCsvFileFormat(
            CsvHeaderFormat csvHeaderFormat,
            final CsvFormat<Transaction> transactionCsvFormat) {
        this.csvHeaderFormat = csvHeaderFormat;
        this.transactionCsvFormat = transactionCsvFormat;
    }

    @Override
    public String format(List<Transaction> transactions) {
        final List<String> lines = Lists.newArrayList(
                csvHeaderFormat.formatHeader());
        lines.addAll(
                Collections2.transform(
                transactions,
                new Function<Transaction, String>() {
                    @Override
                    public String apply(
                            @Nullable Transaction transaction) {
                        return transactionCsvFormat.format(
                                transaction);
                    }
                }));

        return Joiner.on(Conveniences.NEWLINE).join(lines)
                .concat(Conveniences.NEWLINE);
    }
}