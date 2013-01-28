package com.pduda.penny.domain.presenter;

import java.io.File;
import java.io.IOException;

public interface WriteTextToFileAction {

    void writeTextToFile(String text, File path)
            throws IOException;
}