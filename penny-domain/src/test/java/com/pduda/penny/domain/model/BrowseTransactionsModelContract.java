package com.pduda.penny.domain.model;

import com.google.common.collect.Lists;
import com.pduda.penny.ObjectMother;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public abstract class BrowseTransactionsModelContract {

    @Test
    public void zeroTransactions() throws Exception {

        final BrowseTransactionsModel model = createBrowseTransactionModelWith(Lists.<Transaction>newArrayList());
        assertEquals(
                Collections.emptyList(),
                model.findAllTransactions());
        assertEquals(0, model.countTransactions());
    }

    @Test
    public void manyTransactions() throws Exception {
        final List<Transaction> transactions = ObjectMother.anyNonEmptyListOfTransactions();
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

    protected abstract BrowseTransactionsModel createBrowseTransactionModelWith(List<Transaction> transactions);

    protected abstract BrowseTransactionsModel createBrowseTransactionsModelWhereFindAllTransactionsFailsWith(final RuntimeException intentionalException);
}
