package com.pduda.penny.domain.presenter;

import com.pduda.penny.domain.model.Transaction;
import java.io.IOException;
import java.util.List;

public interface ExportAllTransactionsAction {

    void execute(List<Transaction> transactions) throws IOException;
}