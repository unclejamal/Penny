package com.pduda.penny.domain.model;

import java.util.Collection;

public interface BrowseTransactionsModel {

    // CONTRACT: result >= 0
    int countTransactions();

    Collection<Object> findAllTransactions();
}
