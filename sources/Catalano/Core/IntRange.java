package Catalano.Core;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class IntRange implements Serializable {
    int max;
    int min;

    public IntRange() {
    }

    public IntRange(int i, int i2) {
        this.min = i;
        this.max = i2;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(int i) {
        this.min = i;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public double length() {
        return this.max - this.min;
    }

    public boolean isInside(int i) {
        return i >= this.min && i <= this.max;
    }

    public boolean IsOverlapping(IntRange intRange) {
        return isInside(intRange.min) || isInside(intRange.max) || intRange.isInside(this.min) || intRange.isInside(this.max);
    }

    public FloatRange toFloatRange() {
        return new FloatRange(this.min, this.max);
    }

    public DoubleRange toDoubleRange() {
        return new DoubleRange(this.min, this.max);
    }

    public boolean equals(Object obj) {
        if (obj.getClass().isAssignableFrom(IntRange.class)) {
            IntRange intRange = (IntRange) obj;
            return this.min == intRange.getMin() && this.max == intRange.getMax();
        }
        return false;
    }

    public int hashCode() {
        return ((this.min + 355) * 71) + this.max;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Minimum: ");
        sb.append(this.min);
        sb.append(" Maximum: ");
        sb.append(this.max);
        return sb.toString();
    }
}
