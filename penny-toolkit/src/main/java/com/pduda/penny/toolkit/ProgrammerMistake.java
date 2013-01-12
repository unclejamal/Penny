package com.pduda.penny.toolkit;

public class ProgrammerMistake extends RuntimeException {

    public ProgrammerMistake(String message) {
        super(message);
    }

    public ProgrammerMistake(String message, Throwable cause) {
        super(message, cause);
    }

    public ProgrammerMistake(Throwable cause) {
        super(cause);
    }

    public ProgrammerMistake(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
