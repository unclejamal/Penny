package com.pduda.penny.domain.view;

import java.io.File;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class WriteTextToFileTest {
  private static final File testOutputDirectory = new File(
      "./test/output/WriteTextToFileTest/");

  @BeforeClass
  public static void initialiseTestOutputAreaOnFileSystem()
      throws Exception {
    FileUtils.deleteDirectory(testOutputDirectory);
    assertTrue(
        String.format(
            "Couldn't create test output directory at %1$s",
            testOutputDirectory.getAbsolutePath()),
        testOutputDirectory.mkdirs());
  }

  @Test
  public void happyPath() throws Exception {
    final File file = new File(
        testOutputDirectory, "happyPath.csv");

    new WriteTextToFileActionImpl().writeTextToFile(
        "::text::", file);

    assertEquals(
        "::text::", FileUtils.readFileToString(
        file));
  }
}
