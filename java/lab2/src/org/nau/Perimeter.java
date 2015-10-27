package org.nau;

/**
 * Інкапсулює периметр.
 */
public class Perimeter {
    /** Значення периметру. */
    private double value;

    public Perimeter(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public boolean equals(Object obj) {
        return obj == null ? false : obj instanceof Perimeter ? ((Perimeter) obj).getValue() == value : super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
