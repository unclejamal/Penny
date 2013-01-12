package com.pduda.penny.view.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.pduda.penny.toolkit.ProgrammerMistake;

public class BrowseTransactionsActivity extends Activity implements BrowseTransactionsView {

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
