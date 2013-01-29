package com.pduda.penny.domain.model;

public final class Amount {

    private final int cents;

    public Amount(int cents) {
        this.cents = cents;
    }

    public static Amount cents(int cents) {
        return new Amount(cents);
    }

    public double inDollars() {
        return cents / 100.0d;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.cents;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Amount other = (Amount) obj;
        if (this.cents != other.cents) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%1d cents", cents);
    }
}
