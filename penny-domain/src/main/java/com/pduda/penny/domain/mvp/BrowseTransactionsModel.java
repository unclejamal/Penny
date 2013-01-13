package com.pduda.penny.domain.mvp;

public interface BrowseTransactionsModel {

    // CONTRACT: result >= 0
    int countTransactions();
}
