package com.pduda.penny.view.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.pduda.penny.controller.android.test.RendersView;
import com.pduda.penny.domain.mvp.BrowseTransactionsView;
import com.pduda.penny.toolkit.ProgrammerMistake;

public class BrowseTransactionsActivity extends Activity implements BrowseTransactionsView {

    private final RendersView rendersView;

    public BrowseTransactionsActivity() {
        this(null);
    }

    public BrowseTransactionsActivity(
            RendersView rendersView) {
        this.rendersView = rendersView;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Arbitrarily, I assume that I should do my work after the superclass, but I don't really know.
        rendersView.render();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final TextView transactionsCountView = (TextView) findViewById(R.id.transactionsCount);
        transactionsCountView.setText(String.valueOf(1));
    }

    public void displayNumberOfTransactions(
            int transactionCount) {
        if (transactionCount < 0) {
            throw new ProgrammerMistake(
                    new IllegalArgumentException(
                    String.format(
                    "number of transactions can't be negative, but it's %1$d",
                    transactionCount)));
        }

        final TextView transactionsCountView = (TextView) findViewById(R.id.transactionsCount);

        transactionsCountView.setText(
                String.format(
                "%1$d", transactionCount));
    }
}
