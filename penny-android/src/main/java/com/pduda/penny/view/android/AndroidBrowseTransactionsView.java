package com.pduda.penny.view.android;

import android.widget.TextView;
import com.pduda.penny.domain.view.BrowseTransactionsView;
import com.pduda.penny.toolkit.ProgrammerMistake;

public class AndroidBrowseTransactionsView
        implements BrowseTransactionsView {

    private BrowseTransactionsActivity browseTransactionsActivity;
    private final TextView transactionsCountView;

    public AndroidBrowseTransactionsView(TextView transactionsCountView) {
        this.transactionsCountView = transactionsCountView;
    }

    @Override
    public void displayNumberOfTransactions(
            int numberOfTransactions) {
        if (numberOfTransactions < 0) {
            throw new ProgrammerMistake(
                    new IllegalArgumentException(
                    String.format(
                    "number of transactions can't be "
                    + "negative, but it's %1$d",
                    numberOfTransactions)));
        }

        final TextView transactionsCountView = (TextView) browseTransactionsActivity
                .findViewById(
                R.id.transactionsCount);
        transactionsCountView.setText(
                String.format(
                "%1$d", numberOfTransactions));
    }
}
