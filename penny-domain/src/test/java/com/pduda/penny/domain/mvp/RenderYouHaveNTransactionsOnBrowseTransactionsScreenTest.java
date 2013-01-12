package com.pduda.penny.domain.mvp;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class RenderYouHaveNTransactionsOnBrowseTransactionsScreenTest {

    private Mockery mockery = new Mockery();

    @Test
    public void zero() throws Exception {
        final BrowseTransactionsModel model = mockery.mock(BrowseTransactionsModel.class);
        final BrowseTransactionsView view = mockery.mock(BrowseTransactionsView.class);
        final BrowseTransactionsPresenter presenter = new BrowseTransactionsPresenter(model, view);
        mockery.checking(
                new Expectations() {
                    {
                        allowing(model).countTransactions();
                        will(returnValue(0));
                        oneOf(view).displayNumberOfTransactions(0);
                    }
                });
        presenter.render();
    }
}
