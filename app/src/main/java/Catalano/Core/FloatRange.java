package Catalano.Core;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class FloatRange implements Serializable {
    float max;
    float min;

    public FloatRange() {
    }

    public FloatRange(float f, float f2) {
        this.min = f;
        this.max = f2;
    }

    public float getMin() {
        return this.min;
    }

    public void setMin(float f) {
        this.min = f;
    }

    public float getMax() {
        return this.max;
    }

    public void setMax(float f) {
        this.max = f;
    }

    public float length() {
        return this.max - this.min;
    }

    public boolean isInside(float f) {
        return f >= this.min && f <= this.max;
    }

    public boolean IsOverlapping(FloatRange floatRange) {
        return isInside(floatRange.min) || isInside(floatRange.max) || floatRange.isInside(this.min) || floatRange.isInside(this.max);
    }

    public IntRange toIntRange() {
        return new IntRange((int) this.min, (int) this.max);
    }

    public DoubleRange toDoubleRange() {
        return new DoubleRange(this.min, this.max);
    }

    public boolean equals(Object obj) {
        if (obj.getClass().isAssignableFrom(FloatRange.class)) {
            FloatRange floatRange = (FloatRange) obj;
            return this.min == floatRange.getMin() && this.max == floatRange.getMax();
        }
        return false;
    }

    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.min) + 57;
        return floatToIntBits + (floatToIntBits * 19) + Float.floatToIntBits(this.max);
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
