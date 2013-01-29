package com.pduda.penny;

import com.google.common.collect.Lists;
import com.pduda.penny.domain.model.Amount;
import com.pduda.penny.domain.model.Category;
import com.pduda.penny.domain.model.Transaction;
import org.joda.time.LocalDate;

import java.util.List;

public class ObjectMother {

    public static Transaction createAnyNonNullTransaction() {
        return new Transaction(
                new LocalDate(2012, 8, 4), new Category(
                "irrelevant category"), Amount.cents(
                26123));
    }

    public static List<Transaction> anyNonEmptyListOfTransactions() {
        return Lists.newArrayList(
                createAnyNonNullTransaction(),
                createAnyNonNullTransaction(),
                createAnyNonNullTransaction());
    }
}