package com.pduda.penny.domain.presenter;

import com.pduda.penny.domain.model.BrowseTransactionsModel;
import com.pduda.penny.domain.view.BrowseTransactionsView;

public class BrowseTransactionsPresenter implements RendersView {

    private final BrowseTransactionsModel model;
    private final BrowseTransactionsView view;

    public BrowseTransactionsPresenter(
            BrowseTransactionsModel model,
            BrowseTransactionsView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void render() {
        view.displayNumberOfTransactions(model.countTransactions());
    }
}
