package com.pduda.penny.domain.view;

import com.google.common.base.Joiner;
import com.google.common.collect.*;
import com.pduda.penny.domain.model.Amount;
import com.pduda.penny.domain.model.Category;
import com.pduda.penny.domain.model.Transaction;
import com.pduda.penny.toolkit.ProgrammerMistake;
import java.util.List;
import org.joda.time.LocalDate;

public class TransactionCsvFormat
        implements CsvFormat<Transaction> {

    private final CsvFormat<LocalDate> dateCsvFormat;
    private final CsvFormat<Category> categoryCsvFormat;
    private final CsvFormat<Amount> amountCsvFormat;

    public TransactionCsvFormat(
            CsvFormat<LocalDate> dateCsvFormat,
            CsvFormat<Category> categoryCsvFormat,
            CsvFormat<Amount> amountCsvFormat) {
        this.dateCsvFormat = dateCsvFormat;
        this.categoryCsvFormat = categoryCsvFormat;
        this.amountCsvFormat = amountCsvFormat;
    }

    @Override
    public String format(Transaction transaction) {
        if (transaction == null) {
            throw new ProgrammerMistake(
                    "Can't format a null transaction.");
        }

        final List<String> formattedPropertiesInCorrectSequence = Lists.newArrayList(
                dateCsvFormat.format(transaction.getDate()),
                categoryCsvFormat.format(transaction.getCategory()),
                amountCsvFormat.format(transaction.getAmount()));

        return assembleIntoCsvRow(
                formattedPropertiesInCorrectSequence);
    }

    private String assembleIntoCsvRow(
            List<String> formattedPropertiesInCorrectSequence) {
        return Joiner.on(",").join(
                Collections2.transform(
                formattedPropertiesInCorrectSequence,
                SurroundWithQuotes.INSTANCE));
    }
}