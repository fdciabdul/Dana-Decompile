package j$.time.temporal;

import j$.time.DateTimeException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes6.dex */
public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    private ValueRange(long j, long j2, long j3, long j4) {
        this.minSmallest = j;
        this.minLargest = j2;
        this.maxSmallest = j3;
        this.maxLargest = j4;
    }

    private String genInvalidFieldMessage(long j, TemporalField temporalField) {
        if (temporalField == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid value (valid values ");
            sb.append(this);
            sb.append("): ");
            sb.append(j);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Invalid value for ");
        sb2.append(temporalField);
        sb2.append(" (valid values ");
        sb2.append(this);
        sb2.append("): ");
        sb2.append(j);
        return sb2.toString();
    }

    public static ValueRange of(long j, long j2) {
        if (j <= j2) {
            return new ValueRange(j, j, j2, j2);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static ValueRange of(long j, long j2, long j3) {
        if (j <= 1) {
            if (j2 <= j3) {
                if (1 <= j3) {
                    return new ValueRange(j, 1L, j2, j3);
                }
                throw new IllegalArgumentException("Minimum value must be less than maximum value");
            }
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        long j = this.minSmallest;
        long j2 = this.minLargest;
        if (j > j2) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j3 = this.maxSmallest;
        long j4 = this.maxLargest;
        if (j3 > j4) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j2 > j4) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final int checkValidIntValue(long j, TemporalField temporalField) {
        if (isIntValue() && isValidValue(j)) {
            return (int) j;
        }
        throw new DateTimeException(genInvalidFieldMessage(j, temporalField));
    }

    public final void checkValidValue(long j, TemporalField temporalField) {
        if (!isValidValue(j)) {
            throw new DateTimeException(genInvalidFieldMessage(j, temporalField));
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ValueRange) {
            ValueRange valueRange = (ValueRange) obj;
            return this.minSmallest == valueRange.minSmallest && this.minLargest == valueRange.minLargest && this.maxSmallest == valueRange.maxSmallest && this.maxLargest == valueRange.maxLargest;
        }
        return false;
    }

    public final long getMaximum() {
        return this.maxLargest;
    }

    public final long getMinimum() {
        return this.minSmallest;
    }

    public final long getSmallestMaximum() {
        return this.maxSmallest;
    }

    public final int hashCode() {
        long j = this.minSmallest;
        long j2 = this.minLargest;
        long j3 = this.maxSmallest;
        long j4 = this.maxLargest;
        long j5 = j + (j2 << 16) + (j2 >> 48) + (j3 << 32) + (j3 >> 32) + (j4 << 48) + (j4 >> 16);
        return (int) (j5 ^ (j5 >>> 32));
    }

    public final boolean isFixed() {
        return this.minSmallest == this.minLargest && this.maxSmallest == this.maxLargest;
    }

    public final boolean isIntValue() {
        return this.minSmallest >= -2147483648L && this.maxLargest <= 2147483647L;
    }

    public final boolean isValidValue(long j) {
        return j >= this.minSmallest && j <= this.maxLargest;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.minSmallest);
        if (this.minSmallest != this.minLargest) {
            sb.append('/');
            sb.append(this.minLargest);
        }
        sb.append(" - ");
        sb.append(this.maxSmallest);
        if (this.maxSmallest != this.maxLargest) {
            sb.append('/');
            sb.append(this.maxLargest);
        }
        return sb.toString();
    }
}
