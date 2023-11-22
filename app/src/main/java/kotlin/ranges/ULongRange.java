package kotlin.ranges;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001cB\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00038WX\u0096\u0004ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00038WX\u0096\u0004ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "value", "", "contains-VKZWuLQ", "(J)Z", "contains", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isEmpty", "()Z", "", "toString", "()Ljava/lang/String;", "getEndInclusive-s-VKNKU", "()J", "endInclusive", "getStart-s-VKNKU", "start", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ULongRange extends ULongProgression implements ClosedRange<ULong> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ULongRange EMPTY = new ULongRange(-1, 0, null);

    public /* synthetic */ ULongRange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* synthetic */ boolean contains(ULong uLong) {
        return m4393containsVKZWuLQ(uLong.getData());
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* synthetic */ ULong getEndInclusive() {
        return ULong.m3345boximpl(m4394getEndInclusivesVKNKU());
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* synthetic */ ULong getStart() {
        return ULong.m3345boximpl(m4395getStartsVKNKU());
    }

    private ULongRange(long j, long j2) {
        super(j, j2, 1L, null);
    }

    @JvmName(name = "getStart-s-VKNKU")
    /* renamed from: getStart-s-VKNKU  reason: not valid java name */
    public final long m4395getStartsVKNKU() {
        return getFirst();
    }

    @JvmName(name = "getEndInclusive-s-VKNKU")
    /* renamed from: getEndInclusive-s-VKNKU  reason: not valid java name */
    public final long m4394getEndInclusivesVKNKU() {
        return getLast();
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public final boolean m4393containsVKZWuLQ(long value) {
        return UnsignedKt.ulongCompare(getFirst(), value) <= 0 && UnsignedKt.ulongCompare(value, getLast()) <= 0;
    }

    @Override // kotlin.ranges.ULongProgression, kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        return UnsignedKt.ulongCompare(getFirst(), getLast()) > 0;
    }

    @Override // kotlin.ranges.ULongProgression
    public final boolean equals(Object other) {
        if (other instanceof ULongRange) {
            if (!isEmpty() || !((ULongRange) other).isEmpty()) {
                ULongRange uLongRange = (ULongRange) other;
                if (getFirst() != uLongRange.getFirst() || getLast() != uLongRange.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ULongProgression
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return ((int) ULong.m3351constructorimpl(getLast() ^ ULong.m3351constructorimpl(getLast() >>> 32))) + (((int) ULong.m3351constructorimpl(getFirst() ^ ULong.m3351constructorimpl(getFirst() >>> 32))) * 31);
    }

    @Override // kotlin.ranges.ULongProgression
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) ULong.m3396toStringimpl(getFirst()));
        sb.append("..");
        sb.append((Object) ULong.m3396toStringimpl(getLast()));
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/ranges/ULongRange$Companion;", "", "Lkotlin/ranges/ULongRange;", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getEMPTY")
        public final ULongRange getEMPTY() {
            return ULongRange.EMPTY;
        }
    }
}
