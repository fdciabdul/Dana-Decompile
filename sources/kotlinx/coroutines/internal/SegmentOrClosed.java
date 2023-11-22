package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0081@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0016\u001a\u00028\u00008G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0088\u0001\u0017\u0092\u0001\u0004\u0018\u00010\u0003ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/internal/SegmentOrClosed;", "Lkotlinx/coroutines/internal/Segment;", "S", "", "other", "", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "", "hashCode-impl", "(Ljava/lang/Object;)I", "hashCode", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "isClosed-impl", "(Ljava/lang/Object;)Z", "isClosed", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "segment", "value", "Ljava/lang/Object;", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes6.dex */
public final class SegmentOrClosed<S extends Segment<S>> {
    private final Object value;

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <S extends Segment<S>> Object m4663constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4664equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof SegmentOrClosed) && Intrinsics.areEqual(obj, ((SegmentOrClosed) obj2).getValue());
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4666hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4668toStringimpl(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("SegmentOrClosed(value=");
        sb.append(obj);
        sb.append(')');
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        return m4664equalsimpl(this.value, obj);
    }

    public final int hashCode() {
        return m4666hashCodeimpl(this.value);
    }

    public final String toString() {
        return m4668toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ Object getValue() {
        return this.value;
    }

    @JvmName(name = "isClosed-impl")
    /* renamed from: isClosed-impl  reason: not valid java name */
    public static final boolean m4667isClosedimpl(Object obj) {
        Symbol symbol;
        symbol = ConcurrentLinkedListKt.CLOSED;
        return obj == symbol;
    }

    @JvmName(name = "getSegment-impl")
    /* renamed from: getSegment-impl  reason: not valid java name */
    public static final S m4665getSegmentimpl(Object obj) {
        Symbol symbol;
        symbol = ConcurrentLinkedListKt.CLOSED;
        if (obj != symbol) {
            if (obj != null) {
                return (S) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }
}
