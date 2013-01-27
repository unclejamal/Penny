package com.pduda.penny.domain.model;

import com.pduda.penny.toolkit.ProgrammerMistake;

public final class Category {

    private final String name;

    public Category(String name) {
        if (name == null) {
            throw new ProgrammerMistake(
                    "name can't be null");
        }
        if (name.isEmpty()) {
            throw new ProgrammerMistake(
                    "Category name can't be blank.");
        }
        if (name.trim().isEmpty()) {
            throw new ProgrammerMistake(
                    "Category name can't be only whitespace.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Category) {
            final Category that = (Category) other;
            return this.name.equals(that.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
