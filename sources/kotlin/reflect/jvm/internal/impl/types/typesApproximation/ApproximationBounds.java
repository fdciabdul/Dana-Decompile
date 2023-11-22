package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class ApproximationBounds<T> {
    private final T lower;
    private final T upper;

    public final T component1() {
        return this.lower;
    }

    public final T component2() {
        return this.upper;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApproximationBounds) {
            ApproximationBounds approximationBounds = (ApproximationBounds) obj;
            return Intrinsics.areEqual(this.lower, approximationBounds.lower) && Intrinsics.areEqual(this.upper, approximationBounds.upper);
        }
        return false;
    }

    public final int hashCode() {
        T t = this.lower;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.upper;
        return (hashCode * 31) + (t2 != null ? t2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApproximationBounds(lower=");
        sb.append(this.lower);
        sb.append(", upper=");
        sb.append(this.upper);
        sb.append(')');
        return sb.toString();
    }

    public ApproximationBounds(T t, T t2) {
        this.lower = t;
        this.upper = t2;
    }

    public final T getLower() {
        return this.lower;
    }

    public final T getUpper() {
        return this.upper;
    }
}
