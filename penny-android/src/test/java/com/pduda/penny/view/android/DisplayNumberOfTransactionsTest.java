package com.pduda.penny.view.android;

import android.widget.TextView;
import com.pduda.penny.domain.mvp.BrowseTransactionsView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class DisplayNumberOfTransactionsTest
    extends BrowseTransactionsViewContract {

  @Test
  public void happyPath() throws Exception {
    final BrowseTransactionsActivity
        browseTransactionsActivity
        = new BrowseTransactionsActivity();

    browseTransactionsActivity.onCreate(null);

    browseTransactionsActivity.displayNumberOfTransactions(
        12);

    final TextView transactionsCountView
        = (TextView) browseTransactionsActivity
        .findViewById(R.id.transactionsCount);

    assertEquals(
        "12", transactionsCountView.getText().toString()
    );
  }

  @Override
  protected BrowseTransactionsView initializeView() {
    final BrowseTransactionsActivity
        browseTransactionsActivity
        = new BrowseTransactionsActivity();

    browseTransactionsActivity.onCreate(null);

    return browseTransactionsActivity;
  }
}