package com.pduda.penny.domain.model;

import java.util.*;

public class InMemoryBrowseTransactionsModelTest extends BrowseTransactionsModelContract {

    @Override
    protected BrowseTransactionsModel createBrowseTransactionModelWith(List<Transaction> transactions) {
        return new InMemoryBrowseTransactionsModel(
                transactions);
    }

    @Override
    protected BrowseTransactionsModel createBrowseTransactionsModelWhereFindAllTransactionsFailsWith(final RuntimeException intentionalException) {
        return new InMemoryBrowseTransactionsModel(null) {
            @Override
            public List<Transaction> findAllTransactions() {
                throw intentionalException;
            }
        };
    }
}
