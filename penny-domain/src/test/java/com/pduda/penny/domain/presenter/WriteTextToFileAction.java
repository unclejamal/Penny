package com.pduda.penny.domain.presenter;

import java.io.File;

public interface WriteTextToFileAction {
  void writeTextToFile(String csvText, File path);
}