package com.pduda.penny.domain.view;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateCsvFormat implements CsvFormat<LocalDate> {

    public static final DateTimeFormatter ISO_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd");

    @Override
    public String format(LocalDate date) {
        return ISO_FORMAT.print(date);
    }
}