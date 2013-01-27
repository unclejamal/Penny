package com.pduda.penny.domain.model;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;

public abstract class BrowseTransactionsModelContract {

    @Test
    public void zeroTransactions() throws Exception {

        final BrowseTransactionsModel model = createBrowseTransactionModelWith(Lists.newArrayList());
        assertEquals(
                Collections.emptyList(),
                model.findAllTransactions());
        assertEquals(0, model.countTransactions());
    }

    @Test
    public void manyTransactions() throws Exception {
        final Collection<Object> transactions = Lists
                .newArrayList(
                new Object(), new Object(), new Object());
        final BrowseTransactionsModel model = createBrowseTransactionModelWith(transactions);
        assertEquals(transactions, model.findAllTransactions());
        assertEquals(3, model.countTransactions());
    }

    @Test
    public void findAllTransactionsFails() throws Exception {
        final BrowseTransactionsModel model = createBrowseTransactionsModelWhereFindAllTransactionsFailsWith(new InternalStorageException());

        try {
            model.countTransactions();
            fail(
                    "How did you count the transactions when you can't find them?!");
        } catch (InternalStorageException success) {
        }
    }

    protected abstract BrowseTransactionsModel createBrowseTransactionModelWith(Collection<Object> transactions);

    protected abstract BrowseTransactionsModel createBrowseTransactionsModelWhereFindAllTransactionsFailsWith(final RuntimeException intentionalException);
}
