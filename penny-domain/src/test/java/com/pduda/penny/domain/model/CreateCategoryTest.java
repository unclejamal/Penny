package com.pduda.penny.domain.model;

import com.pduda.penny.toolkit.ProgrammerMistake;
import org.junit.Test;
import static org.junit.Assert.fail;

public class CreateCategoryTest {

    @Test
    public void requireKeyInformation() throws Exception {
        try {
            new Category(null);
            fail("Why did you create a Category with no name?!");
        } catch (ProgrammerMistake success) {
        }
    }
}
