package com.pduda.penny.domain.mvp;

public class BrowseTransactionsPresenter {

    private final BrowseTransactionsModel model;
    private final BrowseTransactionsView view;

    public BrowseTransactionsPresenter(
            BrowseTransactionsModel model,
            BrowseTransactionsView view) {
        this.model = model;
        this.view = view;
    }

    public void render() {
        view.setNumberOfTransactions(model.countTransactions());
    }
}
