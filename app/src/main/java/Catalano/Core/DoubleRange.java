package Catalano.Core;

import com.alibaba.wireless.security.SecExceptionCode;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class DoubleRange implements Serializable {
    double max;
    double min;

    public DoubleRange() {
    }

    public DoubleRange(double d, double d2) {
        this.min = d;
        this.max = d2;
    }

    public double getMin() {
        return this.min;
    }

    public void setMin(double d) {
        this.min = d;
    }

    public double getMax() {
        return this.max;
    }

    public void setMax(double d) {
        this.max = d;
    }

    public double length() {
        return this.max - this.min;
    }

    public boolean isInside(double d) {
        return d >= this.min && d <= this.max;
    }

    public boolean IsOverlapping(DoubleRange doubleRange) {
        return isInside(doubleRange.min) || isInside(doubleRange.max) || doubleRange.isInside(this.min) || doubleRange.isInside(this.max);
    }

    public IntRange toIntRange() {
        return new IntRange((int) this.min, (int) this.max);
    }

    public FloatRange toFloatRange() {
        return new FloatRange((float) this.min, (float) this.max);
    }

    public boolean equals(Object obj) {
        if (obj.getClass().isAssignableFrom(DoubleRange.class)) {
            DoubleRange doubleRange = (DoubleRange) obj;
            return this.min == doubleRange.getMin() && this.max == doubleRange.getMax();
        }
        return false;
    }

    public int hashCode() {
        int doubleToLongBits = ((int) (Double.doubleToLongBits(this.min) ^ (Double.doubleToLongBits(this.min) >>> 32))) + SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE_DATA;
        return doubleToLongBits + (doubleToLongBits * 61) + ((int) (Double.doubleToLongBits(this.max) ^ (Double.doubleToLongBits(this.max) >>> 32)));
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
