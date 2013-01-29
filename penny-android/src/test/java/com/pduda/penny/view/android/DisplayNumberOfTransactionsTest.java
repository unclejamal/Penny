package com.pduda.penny.view.android;

import android.widget.TextView;
import com.pduda.penny.domain.view.BrowseTransactionsView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class DisplayNumberOfTransactionsTest
        extends BrowseTransactionsViewContract {

    @Test
    public void happyPath() throws Exception {
        // The duplication between this test setup and
        // initializeView() is incidental; don't remove it
        final BrowseTransactionsActivity browseTransactionsActivity = new BrowseTransactionsActivity();
        browseTransactionsActivity.onCreate(null);
        final TextView transactionsCountView = (TextView) browseTransactionsActivity
                .findViewById(R.id.transactionsCount);
        final AndroidBrowseTransactionsView androidBrowseTransactionsView = new AndroidBrowseTransactionsView(
                transactionsCountView);

        androidBrowseTransactionsView
                .displayNumberOfTransactions(12);

        assertEquals("12", transactionsCountView.getText().toString());
    }

    // The duplication between initializeView() and the
    // setup for the other tests is incidental; don't
    // remove it
    @Override
    protected BrowseTransactionsView initializeView() {
        final BrowseTransactionsActivity browseTransactionsActivity = new BrowseTransactionsActivity();
        browseTransactionsActivity.onCreate(null);
        final TextView transactionsCountView = (TextView) browseTransactionsActivity
                .findViewById(R.id.transactionsCount);
        final AndroidBrowseTransactionsView androidBrowseTransactionsView = new AndroidBrowseTransactionsView(
                transactionsCountView);
        return androidBrowseTransactionsView;
    }
}