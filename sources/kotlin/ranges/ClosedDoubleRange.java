package kotlin.ranges;

import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b"}, d2 = {"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "value", "", "contains", "(D)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isEmpty", "()Z", "a", "b", "lessThanOrEquals", "(DD)Z", "", "toString", "()Ljava/lang/String;", "_endInclusive", SummaryActivity.DAYS, "_start", "getEndInclusive", "()Ljava/lang/Double;", "endInclusive", "getStart", "start", "<init>", "(DD)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClosedDoubleRange implements ClosedFloatingPointRange<Double> {
    private final double _endInclusive;
    private final double _start;

    public final boolean lessThanOrEquals(double a2, double b) {
        return a2 <= b;
    }

    public ClosedDoubleRange(double d, double d2) {
        this._start = d;
        this._endInclusive = d2;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public final /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).doubleValue());
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public final /* synthetic */ boolean lessThanOrEquals(Double d, Double d2) {
        return lessThanOrEquals(d.doubleValue(), d2.doubleValue());
    }

    @Override // kotlin.ranges.ClosedRange
    @JvmName(name = "getStart")
    public final Double getStart() {
        return Double.valueOf(this._start);
    }

    @Override // kotlin.ranges.ClosedRange
    @JvmName(name = "getEndInclusive")
    public final Double getEndInclusive() {
        return Double.valueOf(this._endInclusive);
    }

    public final boolean contains(double value) {
        return value >= this._start && value <= this._endInclusive;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        return this._start > this._endInclusive;
    }

    public final boolean equals(Object other) {
        if (other instanceof ClosedDoubleRange) {
            if (!isEmpty() || !((ClosedDoubleRange) other).isEmpty()) {
                ClosedDoubleRange closedDoubleRange = (ClosedDoubleRange) other;
                if (!(this._start == closedDoubleRange._start)) {
                    return false;
                }
                if (!(this._endInclusive == closedDoubleRange._endInclusive)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this._start).hashCode() * 31) + Double.valueOf(this._endInclusive).hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._start);
        sb.append("..");
        sb.append(this._endInclusive);
        return sb.toString();
    }
}
