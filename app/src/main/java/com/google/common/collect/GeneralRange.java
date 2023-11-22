package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    @CheckForNull
    private final T lowerEndpoint;
    @CheckForNull
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;
    @CheckForNull
    private final T upperEndpoint;

    static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        return new GeneralRange<>(Ordering.natural(), range.hasLowerBound(), range.hasLowerBound() ? range.lowerEndpoint() : null, range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN, range.hasUpperBound(), range.hasUpperBound() ? range.upperEndpoint() : null, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> all(Comparator<? super T> comparator) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> downTo(Comparator<? super T> comparator, @ParametricNullness T t, BoundType boundType) {
        return new GeneralRange<>(comparator, true, t, boundType, false, null, BoundType.OPEN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> upTo(Comparator<? super T> comparator, @ParametricNullness T t, BoundType boundType) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, true, t, boundType);
    }

    static <T> GeneralRange<T> range(Comparator<? super T> comparator, @ParametricNullness T t, BoundType boundType, @ParametricNullness T t2, BoundType boundType2) {
        return new GeneralRange<>(comparator, true, t, boundType, true, t2, boundType2);
    }

    private GeneralRange(Comparator<? super T> comparator, boolean z, @CheckForNull T t, BoundType boundType, boolean z2, @CheckForNull T t2, BoundType boundType2) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        this.hasLowerBound = z;
        this.hasUpperBound = z2;
        this.lowerEndpoint = t;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t2;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z) {
            comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(t), (Object) NullnessCasts.uncheckedCastNullableTToT(t));
        }
        if (z2) {
            comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(t2), (Object) NullnessCasts.uncheckedCastNullableTToT(t2));
        }
        if (z && z2) {
            int compare = comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(t), (Object) NullnessCasts.uncheckedCastNullableTToT(t2));
            Preconditions.checkArgument(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                Preconditions.checkArgument((boundType == BoundType.OPEN && boundType2 == BoundType.OPEN) ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Comparator<? super T> comparator() {
        return this.comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final boolean isEmpty() {
        return (hasUpperBound() && tooLow(NullnessCasts.uncheckedCastNullableTToT(getUpperEndpoint()))) || (hasLowerBound() && tooHigh(NullnessCasts.uncheckedCastNullableTToT(getLowerEndpoint())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean tooLow(@ParametricNullness T t) {
        if (hasLowerBound()) {
            int compare = this.comparator.compare(t, NullnessCasts.uncheckedCastNullableTToT(getLowerEndpoint()));
            return ((compare == 0) & (getLowerBoundType() == BoundType.OPEN)) | (compare < 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean tooHigh(@ParametricNullness T t) {
        if (hasUpperBound()) {
            int compare = this.comparator.compare(t, NullnessCasts.uncheckedCastNullableTToT(getUpperEndpoint()));
            return ((compare == 0) & (getUpperBoundType() == BoundType.OPEN)) | (compare > 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean contains(@ParametricNullness T t) {
        return (tooLow(t) || tooHigh(t)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
    
        if (r12.getLowerBoundType() == com.google.common.collect.BoundType.OPEN) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.common.collect.GeneralRange<T> intersect(com.google.common.collect.GeneralRange<T> r12) {
        /*
            r11 = this;
            com.google.common.base.Preconditions.checkNotNull(r12)
            java.util.Comparator<? super T> r0 = r11.comparator
            java.util.Comparator<? super T> r1 = r12.comparator
            boolean r0 = r0.equals(r1)
            com.google.common.base.Preconditions.checkArgument(r0)
            boolean r0 = r11.hasLowerBound
            java.lang.Object r1 = r11.getLowerEndpoint()
            com.google.common.collect.BoundType r2 = r11.getLowerBoundType()
            boolean r3 = r11.hasLowerBound()
            if (r3 != 0) goto L21
            boolean r0 = r12.hasLowerBound
            goto L41
        L21:
            boolean r3 = r12.hasLowerBound()
            if (r3 == 0) goto L49
            java.util.Comparator<? super T> r3 = r11.comparator
            java.lang.Object r4 = r11.getLowerEndpoint()
            java.lang.Object r5 = r12.getLowerEndpoint()
            int r3 = r3.compare(r4, r5)
            if (r3 < 0) goto L41
            if (r3 != 0) goto L49
            com.google.common.collect.BoundType r3 = r12.getLowerBoundType()
            com.google.common.collect.BoundType r4 = com.google.common.collect.BoundType.OPEN
            if (r3 != r4) goto L49
        L41:
            java.lang.Object r1 = r12.getLowerEndpoint()
            com.google.common.collect.BoundType r2 = r12.getLowerBoundType()
        L49:
            r5 = r0
            boolean r0 = r11.hasUpperBound
            java.lang.Object r3 = r11.getUpperEndpoint()
            com.google.common.collect.BoundType r4 = r11.getUpperBoundType()
            boolean r6 = r11.hasUpperBound()
            if (r6 != 0) goto L65
            boolean r0 = r12.hasUpperBound
            java.lang.Object r3 = r12.getUpperEndpoint()
            com.google.common.collect.BoundType r4 = r12.getUpperBoundType()
            goto L8d
        L65:
            boolean r6 = r12.hasUpperBound()
            if (r6 == 0) goto L8d
            java.util.Comparator<? super T> r6 = r11.comparator
            java.lang.Object r7 = r11.getUpperEndpoint()
            java.lang.Object r8 = r12.getUpperEndpoint()
            int r6 = r6.compare(r7, r8)
            if (r6 > 0) goto L85
            if (r6 != 0) goto L8d
            com.google.common.collect.BoundType r6 = r12.getUpperBoundType()
            com.google.common.collect.BoundType r7 = com.google.common.collect.BoundType.OPEN
            if (r6 != r7) goto L8d
        L85:
            java.lang.Object r3 = r12.getUpperEndpoint()
            com.google.common.collect.BoundType r4 = r12.getUpperBoundType()
        L8d:
            r8 = r0
            r9 = r3
            if (r5 == 0) goto Lad
            if (r8 == 0) goto Lad
            java.util.Comparator<? super T> r12 = r11.comparator
            int r12 = r12.compare(r1, r9)
            if (r12 > 0) goto La5
            if (r12 != 0) goto Lad
            com.google.common.collect.BoundType r12 = com.google.common.collect.BoundType.OPEN
            if (r2 != r12) goto Lad
            com.google.common.collect.BoundType r12 = com.google.common.collect.BoundType.OPEN
            if (r4 != r12) goto Lad
        La5:
            com.google.common.collect.BoundType r12 = com.google.common.collect.BoundType.OPEN
            com.google.common.collect.BoundType r0 = com.google.common.collect.BoundType.CLOSED
            r7 = r12
            r10 = r0
            r6 = r9
            goto Lb0
        Lad:
            r6 = r1
            r7 = r2
            r10 = r4
        Lb0:
            com.google.common.collect.GeneralRange r12 = new com.google.common.collect.GeneralRange
            java.util.Comparator<? super T> r4 = r11.comparator
            r3 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.GeneralRange.intersect(com.google.common.collect.GeneralRange):com.google.common.collect.GeneralRange");
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof GeneralRange) {
            GeneralRange generalRange = (GeneralRange) obj;
            return this.comparator.equals(generalRange.comparator) && this.hasLowerBound == generalRange.hasLowerBound && this.hasUpperBound == generalRange.hasUpperBound && getLowerBoundType().equals(generalRange.getLowerBoundType()) && getUpperBoundType().equals(generalRange.getUpperBoundType()) && Objects.equal(getLowerEndpoint(), generalRange.getLowerEndpoint()) && Objects.equal(getUpperEndpoint(), generalRange.getUpperEndpoint());
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    final GeneralRange<T> reverse() {
        GeneralRange<T> generalRange = this.reverse;
        if (generalRange == null) {
            GeneralRange<T> generalRange2 = new GeneralRange<>(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
            generalRange2.reverse = this;
            this.reverse = generalRange2;
            return generalRange2;
        }
        return generalRange;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.comparator);
        sb.append(":");
        sb.append(this.lowerBoundType == BoundType.CLOSED ? '[' : '(');
        sb.append(this.hasLowerBound ? this.lowerEndpoint : "-∞");
        sb.append(',');
        sb.append(this.hasUpperBound ? this.upperEndpoint : "∞");
        sb.append(this.upperBoundType == BoundType.CLOSED ? ']' : ')');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public final T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public final T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BoundType getUpperBoundType() {
        return this.upperBoundType;
    }
}
