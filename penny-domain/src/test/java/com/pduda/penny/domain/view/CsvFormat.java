package com.pduda.penny.domain.view;

public interface CsvFormat<T> {

    String format(T t);
}
