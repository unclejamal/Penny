package com.pduda.penny.domain.view;

import com.pduda.penny.domain.model.Category;


public class CategoryCsvFormat
    implements CsvFormat<Category> {
  @Override
  public String format(Category category) {
    return "Bowling Winnings";
  }
}