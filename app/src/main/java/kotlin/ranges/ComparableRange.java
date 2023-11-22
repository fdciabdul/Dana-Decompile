package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0013\u001a\u00028\u0000\u0012\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00028\u00008\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00028\u00008\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012"}, d2 = {"Lkotlin/ranges/ComparableRange;", "", "T", "Lkotlin/ranges/ClosedRange;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "endInclusive", "Ljava/lang/Comparable;", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "<init>", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
class ComparableRange<T extends Comparable<? super T>> implements ClosedRange<T> {
    private final T endInclusive;
    private final T start;

    public ComparableRange(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "");
        Intrinsics.checkNotNullParameter(t2, "");
        this.start = t;
        this.endInclusive = t2;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean contains(T t) {
        return ClosedRange.DefaultImpls.contains(this, t);
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    @Override // kotlin.ranges.ClosedRange
    @JvmName(name = "getStart")
    public T getStart() {
        return this.start;
    }

    @Override // kotlin.ranges.ClosedRange
    @JvmName(name = "getEndInclusive")
    public T getEndInclusive() {
        return this.endInclusive;
    }

    public boolean equals(Object other) {
        if (other instanceof ComparableRange) {
            if (!isEmpty() || !((ComparableRange) other).isEmpty()) {
                ComparableRange comparableRange = (ComparableRange) other;
                if (!Intrinsics.areEqual(getStart(), comparableRange.getStart()) || !Intrinsics.areEqual(getEndInclusive(), comparableRange.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getStart());
        sb.append("..");
        sb.append(getEndInclusive());
        return sb.toString();
    }
}
