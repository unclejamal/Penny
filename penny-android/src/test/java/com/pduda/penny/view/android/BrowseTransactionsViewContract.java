package com.pduda.penny.view.android;

import com.pduda.penny.domain.model.view.BrowseTransactionsView;
import com.pduda.penny.toolkit.ProgrammerMistake;
import org.junit.Test;
import static org.junit.Assert.*;

public abstract class BrowseTransactionsViewContract {

    @Test
    public void rejectNegativeNumber() throws Exception {
        final BrowseTransactionsView browseTransactionsView = initializeView();
        try {
            browseTransactionsView
                    .displayNumberOfTransactions(-1);
            fail(
                    "Why did you display a negative number of "
                    + "transactions?! That's crazy talk!");
        } catch (ProgrammerMistake success) {
            assertTrue(
                    success.getCause() instanceof IllegalArgumentException);
        }
    }

    protected abstract BrowseTransactionsView initializeView();
}
