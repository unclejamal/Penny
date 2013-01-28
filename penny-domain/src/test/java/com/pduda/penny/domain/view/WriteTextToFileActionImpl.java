package com.pduda.penny.domain.view;

import com.pduda.penny.domain.presenter.WriteTextToFileAction;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextToFileActionImpl
        implements WriteTextToFileAction {

    @Override
    public void writeTextToFile(String text, File path)
            throws IOException {
        final FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(text);
        fileWriter.flush();
        fileWriter.close();
    }
}
