package com.pduda.penny.domain.model;

import java.util.*;

public class InMemoryBrowseTransactionsModelTest extends BrowseTransactionsModelContract {

    @Override
    protected BrowseTransactionsModel createBrowseTransactionModelWith(Collection<Object> transactions) {
        return new InMemoryBrowseTransactionsModel(
                transactions);
    }

    @Override
    protected BrowseTransactionsModel createBrowseTransactionsModelWhereFindAllTransactionsFailsWith(final RuntimeException intentionalException) {
        return new InMemoryBrowseTransactionsModel(null) {
            @Override
            public Collection<Object> findAllTransactions() {
                throw intentionalException;
            }
        };
    }
}
