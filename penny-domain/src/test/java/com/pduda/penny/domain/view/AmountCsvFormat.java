package com.pduda.penny.domain.view;

import com.pduda.penny.domain.model.Amount;

public class AmountCsvFormat implements CsvFormat<Amount> {

    @Override
    public String format(Amount amount) {
        return String.format("%1$.2f", amount.inDollars());

    }
}
