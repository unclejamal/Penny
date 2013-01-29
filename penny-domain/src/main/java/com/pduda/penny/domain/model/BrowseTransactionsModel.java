package com.pduda.penny.domain.model;

import java.util.List;

public interface BrowseTransactionsModel {

    // CONTRACT: result >= 0
    int countTransactions();

    List<Transaction> findAllTransactions();
}
