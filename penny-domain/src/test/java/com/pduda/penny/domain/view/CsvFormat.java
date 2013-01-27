package com.pduda.penny.domain.view;

public interface CsvFormat<ValueType> {

    String format(ValueType value);
}
