package com.pduda.penny.domain.view;

import com.pduda.penny.domain.presenter.WriteTextAction;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextToFileAction
        implements WriteTextAction {

    private final File destinationFile;

    public WriteTextToFileAction(File destinationFile) {
        this.destinationFile = destinationFile;
    }

    protected FileWriter fileWriterOnDestinationFile()
            throws IOException {
        return new FileWriter(destinationFile);
    }

    @Override
    public void writeText(String text) throws IOException {
        final FileWriter fileWriter = fileWriterOnDestinationFile();
        fileWriter.write(text);
        fileWriter.flush();
        fileWriter.close();
    }
}