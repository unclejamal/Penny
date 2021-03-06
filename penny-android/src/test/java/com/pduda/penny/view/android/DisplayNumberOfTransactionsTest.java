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
        final BrowseTransactionsActivity browseTransactionsActivity = new BrowseTransactionsActivity();
        browseTransactionsActivity.onCreate(null);
        final TextView transactionsCountView = (TextView) browseTransactionsActivity
                .findViewById(R.id.transactionsCount);
        final AndroidBrowseTransactionsView androidBrowseTransactionsView = new AndroidBrowseTransactionsView(
                transactionsCountView);

        androidBrowseTransactionsView
                .displayNumberOfTransactions(12);

        assertEquals(
                "12", transactionsCountView.getText().toString());
    }

    @Override
    protected BrowseTransactionsView initializeView() {
        return new AndroidBrowseTransactionsView(null);
    }
}