package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\b\u0016\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B$\b\u0000\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00028\u0007ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004ø\u0001\u0001¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u00198\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", "toString", "()Ljava/lang/String;", "first", "J", "getFirst-s-VKNKU", "()J", "last", "getLast-s-VKNKU", "", "step", "getStep", "start", "endInclusive", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public class ULongProgression implements Iterable<ULong>, KMappedMarker {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long first;
    private final long last;
    private final long step;

    public /* synthetic */ ULongProgression(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private ULongProgression(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = j;
        this.last = UProgressionUtilKt.m4369getProgressionLastElement7ftBX0g(j, j2, j3);
        this.step = j3;
    }

    @JvmName(name = "getFirst-s-VKNKU")
    /* renamed from: getFirst-s-VKNKU  reason: not valid java name and from getter */
    public final long getFirst() {
        return this.first;
    }

    @JvmName(name = "getLast-s-VKNKU")
    /* renamed from: getLast-s-VKNKU  reason: not valid java name and from getter */
    public final long getLast() {
        return this.last;
    }

    @JvmName(name = "getStep")
    public final long getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(getFirst(), getLast(), this.step, null);
    }

    public boolean isEmpty() {
        long j = this.step;
        int ulongCompare = UnsignedKt.ulongCompare(getFirst(), getLast());
        return j <= 0 ? ulongCompare < 0 : ulongCompare > 0;
    }

    public boolean equals(Object other) {
        if (other instanceof ULongProgression) {
            if (!isEmpty() || !((ULongProgression) other).isEmpty()) {
                ULongProgression uLongProgression = (ULongProgression) other;
                if (getFirst() != uLongProgression.getFirst() || getLast() != uLongProgression.getLast() || this.step != uLongProgression.step) {
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
        int m3351constructorimpl = (int) ULong.m3351constructorimpl(getFirst() ^ ULong.m3351constructorimpl(getFirst() >>> 32));
        int m3351constructorimpl2 = (int) ULong.m3351constructorimpl(getLast() ^ ULong.m3351constructorimpl(getLast() >>> 32));
        long j = this.step;
        return ((int) (j ^ (j >>> 32))) + (((m3351constructorimpl * 31) + m3351constructorimpl2) * 31);
    }

    public String toString() {
        long j;
        long j2 = this.step;
        StringBuilder sb = new StringBuilder();
        sb.append((Object) ULong.m3396toStringimpl(getFirst()));
        if (j2 > 0) {
            sb.append("..");
            sb.append((Object) ULong.m3396toStringimpl(getLast()));
            sb.append(" step ");
            j = this.step;
        } else {
            sb.append(" downTo ");
            sb.append((Object) ULong.m3396toStringimpl(getLast()));
            sb.append(" step ");
            j = -this.step;
        }
        sb.append(j);
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "Lkotlin/ULong;", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/ULongProgression;", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "fromClosedRange", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: fromClosedRange-7ftBX0g  reason: not valid java name */
        public final ULongProgression m4392fromClosedRange7ftBX0g(long rangeStart, long rangeEnd, long step) {
            return new ULongProgression(rangeStart, rangeEnd, step, null);
        }
    }
}
