package com.pduda.hamcrest;

import java.util.regex.Pattern;
import org.hamcrest.*;

public class RegexMatcher
        extends BaseMatcher<CharSequence> {

    private final Pattern regex;

    public RegexMatcher(Pattern regex) {
        this.regex = regex;
    }

    @Override
    public boolean matches(Object object) {
        if (object == null) {
            return false;
        }

        return regex.matcher((CharSequence) object).matches();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(
                "matches /" + regex.pattern() + "/");
    }

    public static RegexMatcher matches(String regexAsText) {
        return new RegexMatcher(Pattern.compile(regexAsText));
    }

    public static RegexMatcher matches(Pattern regex) {
        return new RegexMatcher(regex);
    }
}