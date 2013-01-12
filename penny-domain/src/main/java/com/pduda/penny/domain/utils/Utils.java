package com.pduda.penny.domain.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

    public static <T> Set<T> asSet(T... testCategories) {
        Set<T> toReturn = new HashSet<T>();
        for (T testCategory : testCategories) {
            toReturn.add(testCategory);
        }

        return toReturn;
    }

    public static <T> List<T> asList(T... testCategories) {
        List<T> toReturn = new ArrayList<T>();
        for (T testCategory : testCategories) {
            toReturn.add(testCategory);
        }

        return toReturn;
    }

    public static int randomInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
