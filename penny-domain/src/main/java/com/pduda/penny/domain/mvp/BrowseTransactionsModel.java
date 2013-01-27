package com.pduda.penny.domain.mvp;

import java.util.Collection;

public interface BrowseTransactionsModel {

    // CONTRACT: result >= 0
    int countTransactions();

    Collection<Object> findAllTransactions();
}
