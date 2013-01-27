package com.pduda.penny.domain.view;

import com.google.common.base.Function;
import javax.annotation.Nullable;

class SurroundWithQuotes
        implements Function<String, String> {

    public static final SurroundWithQuotes INSTANCE = new SurroundWithQuotes();

    @Override
    public String apply(@Nullable String text) {
        return "\"" + text + "\"";
    }
}