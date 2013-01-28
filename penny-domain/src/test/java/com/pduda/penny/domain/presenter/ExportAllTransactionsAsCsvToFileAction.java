package com.pduda.penny.domain.presenter;

import com.pduda.penny.domain.model.Transaction;
import com.pduda.penny.domain.view.CsvFormat;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExportAllTransactionsAsCsvToFileAction {

    private final CsvFormat<List<Transaction>> transactionsFileFormat;
    private final WriteTextToFileAction writeTextToFileAction;
    private final File destinationFile;

    public ExportAllTransactionsAsCsvToFileAction(
            CsvFormat<List<Transaction>> transactionsFileFormat,
            WriteTextToFileAction writeTextToFileAction,
            File destinationFile) {
        this.transactionsFileFormat = transactionsFileFormat;
        this.writeTextToFileAction = writeTextToFileAction;
        this.destinationFile = destinationFile;
    }

    public void exportAllTransactionsAsCsvToFileAction(
            List<Transaction> transactions) throws IOException {
        final String text = transactionsFileFormat.format(
                transactions);
        new WriteTextAction() {
            @Override
            public void writeText(String text)
                    throws IOException {
                writeTextToFileAction.writeTextToFile(
                        text, destinationFile);
            }
        }.writeText(text);
    }
}