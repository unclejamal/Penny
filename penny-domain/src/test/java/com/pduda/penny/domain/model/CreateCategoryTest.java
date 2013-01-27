package com.pduda.penny.domain.model;

import com.pduda.penny.toolkit.ProgrammerMistake;
import java.util.regex.Pattern;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.pduda.hamcrest.RegexMatcher.matches;

public class CreateCategoryTest {

    @Test
    public void requireKeyInformation() throws Exception {
        try {
            new Category(null);
            fail("Why did you create a Category with no name?!");
        } catch (ProgrammerMistake success) {
        }
    }

    @Test
    public void nameCannotBeBlank() throws Exception {
        try {
            new Category("");
            fail(
                    "Why did you create a Category with an empty "
                    + "name?!");
        } catch (ProgrammerMistake success) {
            assertThat(
                    success.getMessage(), matches(
                    Pattern.compile(
                    ".*Category name can't be blank.*")));
        }
    }

    @Test
    public void nameCannotBeOnlyWhitespace()
            throws Exception {
        try {
            new Category("  \t \n   \r ");
            fail(
                    "Why did you create a Category with a name made"
                    + " up of only whitespace?!");
        } catch (ProgrammerMistake success) {
            assertThat(
                    success.getMessage(), matches(
                    Pattern.compile(
                    ".*Category name can't be only whitespace.*")));
        }
    }
}
