package kotlin.ranges;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001bB\u001a\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00038WX\u0096\u0004ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\u00038WX\u0096\u0004ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "value", "", "contains-WZ4Q5Ns", "(I)Z", "contains", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isEmpty", "()Z", "", "toString", "()Ljava/lang/String;", "getEndInclusive-pVg5ArA", "endInclusive", "getStart-pVg5ArA", "start", "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class UIntRange extends UIntProgression implements ClosedRange<UInt> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final UIntRange EMPTY;

    public /* synthetic */ UIntRange(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* synthetic */ boolean contains(UInt uInt) {
        return m4387containsWZ4Q5Ns(uInt.getData());
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* synthetic */ UInt getEndInclusive() {
        return UInt.m3267boximpl(m4388getEndInclusivepVg5ArA());
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* synthetic */ UInt getStart() {
        return UInt.m3267boximpl(m4389getStartpVg5ArA());
    }

    private UIntRange(int i, int i2) {
        super(i, i2, 1, null);
    }

    @JvmName(name = "getStart-pVg5ArA")
    /* renamed from: getStart-pVg5ArA  reason: not valid java name */
    public final int m4389getStartpVg5ArA() {
        return getFirst();
    }

    @JvmName(name = "getEndInclusive-pVg5ArA")
    /* renamed from: getEndInclusive-pVg5ArA  reason: not valid java name */
    public final int m4388getEndInclusivepVg5ArA() {
        return getLast();
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public final boolean m4387containsWZ4Q5Ns(int value) {
        return UnsignedKt.uintCompare(getFirst(), value) <= 0 && UnsignedKt.uintCompare(value, getLast()) <= 0;
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        return UnsignedKt.uintCompare(getFirst(), getLast()) > 0;
    }

    @Override // kotlin.ranges.UIntProgression
    public final boolean equals(Object other) {
        if (other instanceof UIntRange) {
            if (!isEmpty() || !((UIntRange) other).isEmpty()) {
                UIntRange uIntRange = (UIntRange) other;
                if (getFirst() != uIntRange.getFirst() || getLast() != uIntRange.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.UIntProgression
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.ranges.UIntProgression
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) UInt.m3318toStringimpl(getFirst()));
        sb.append("..");
        sb.append((Object) UInt.m3318toStringimpl(getLast()));
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/ranges/UIntRange$Companion;", "", "Lkotlin/ranges/UIntRange;", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getEMPTY")
        public final UIntRange getEMPTY() {
            return UIntRange.EMPTY;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        EMPTY = new UIntRange(-1, 0, defaultConstructorMarker);
    }
}
