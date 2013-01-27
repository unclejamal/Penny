package com.pduda.penny.domain.view;

import org.joda.time.LocalDate;

public class DateCsvFormat implements CsvFormat<LocalDate> {

    @Override
    public String format(LocalDate date) {
        return "2012-11-14";
    }
}