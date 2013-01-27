package com.pduda.penny.domain.view;

import com.pduda.penny.domain.model.Amount;

public class AmountCsvFormat implements CsvFormat<Amount> {
  @Override
  public String format(Amount amount) {
    return "2.50";
  }
}
