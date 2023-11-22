package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087@\u0018\u0000 u2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001uB\u0014\b\u0000\u0012\u0006\u0010p\u001a\u00020_ø\u0001\u0000¢\u0006\u0004\bt\u0010\u0014J\u001b\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000eH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\u00020\u0000H\u0086\nø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\tJ\u001b\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\rJ\u001b\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010 \u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b!\u0010\tJ\u001b\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010\rJ\u001b\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0086\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u001aJ\u001b\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u0012J\u0010\u0010(\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b&\u0010'J\u0013\u0010*\u001a\u00020\u0000H\u0086\nø\u0001\u0001¢\u0006\u0004\b)\u0010\u0014J\u0013\u0010,\u001a\u00020\u0000H\u0086\bø\u0001\u0001¢\u0006\u0004\b+\u0010\u0014J\u001b\u0010.\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b-\u0010\tJ\u001b\u0010.\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\b/\u0010\rJ\u001b\u0010.\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0086\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u001aJ\u001b\u0010.\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0012J\u001b\u00104\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001b\u00104\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b5\u0010\rJ\u001b\u00104\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0086\bø\u0001\u0000¢\u0006\u0004\b6\u0010\u001aJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b7\u0010\u0004J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\b8\u0010\u0004J\u001b\u0010;\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b:\u0010\tJ\u001b\u0010;\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\b<\u0010\rJ\u001b\u0010;\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0086\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u001aJ\u001b\u0010;\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u0012J\u001b\u0010B\u001a\u00020?2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u001b\u0010D\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\bC\u0010\tJ\u001b\u0010D\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\bE\u0010\rJ\u001b\u0010D\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0086\nø\u0001\u0000¢\u0006\u0004\bF\u0010\u001aJ\u001b\u0010D\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\bG\u0010\u0012J\u001b\u0010I\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\bH\u0010\tJ\u001b\u0010I\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\rJ\u001b\u0010I\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0086\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u001aJ\u001b\u0010I\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0012J\u0010\u0010P\u001a\u00020MH\u0086\b¢\u0006\u0004\bN\u0010OJ\u0010\u0010T\u001a\u00020QH\u0086\b¢\u0006\u0004\bR\u0010SJ\u0010\u0010X\u001a\u00020UH\u0086\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010Z\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\bY\u0010'J\u0010\u0010^\u001a\u00020[H\u0086\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010a\u001a\u00020_H\u0086\b¢\u0006\u0004\b`\u0010\u0014J\u000f\u0010e\u001a\u00020bH\u0016¢\u0006\u0004\bc\u0010dJ\u0013\u0010g\u001a\u00020\u0006H\u0086\bø\u0001\u0001¢\u0006\u0004\bf\u0010OJ\u0013\u0010i\u001a\u00020\u000bH\u0086\bø\u0001\u0001¢\u0006\u0004\bh\u0010'J\u0013\u0010k\u001a\u00020\u000eH\u0086\bø\u0001\u0001¢\u0006\u0004\bj\u0010]J\u0013\u0010m\u001a\u00020\u0000H\u0086\bø\u0001\u0001¢\u0006\u0004\bl\u0010\u0014J\u001b\u0010o\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\bn\u0010\u0004R\u001a\u0010p\u001a\u00020_8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bp\u0010q\u0012\u0004\br\u0010s\u0088\u0001p\u0092\u0001\u00020_ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/UShort;", "", "other", "and-xj2QHRw", "(SS)S", "and", "Lkotlin/UByte;", "", "compareTo-7apg3OU", "(SB)I", "compareTo", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec-Mh2AYeg", "(S)S", "dec", "div-7apg3OU", "div", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "equals", "floorDiv-7apg3OU", "floorDiv", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode-impl", "(S)I", "hashCode", "inc-Mh2AYeg", "inc", "inv-Mh2AYeg", "inv", "minus-7apg3OU", "minus", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod-7apg3OU", "(SB)B", "mod", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or-xj2QHRw", "or", "plus-7apg3OU", "plus", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeTo", "rem-7apg3OU", "rem", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times-7apg3OU", "times", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "", "toByte-impl", "(S)B", "toByte", "", "toDouble-impl", "(S)D", "toDouble", "", "toFloat-impl", "(S)F", "toFloat", "toInt-impl", "toInt", "", "toLong-impl", "(S)J", "toLong", "", "toShort-impl", "toShort", "", "toString-impl", "(S)Ljava/lang/String;", "toString", "toUByte-w2LRezQ", "toUByte", "toUInt-pVg5ArA", "toUInt", "toULong-s-VKNKU", "toULong", "toUShort-Mh2AYeg", "toUShort", "xor-xj2QHRw", "xor", "data", "S", "getData$annotations", "()V", "constructor-impl", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes3.dex */
public final class UShort implements Comparable<UShort> {
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    public final short data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShort m3451boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m3457constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3463equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).getData();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3464equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3469hashCodeimpl(short s) {
        return s;
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m3494toByteimpl(short s) {
        return (byte) s;
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m3495toDoubleimpl(short s) {
        return s & MAX_VALUE;
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m3496toFloatimpl(short s) {
        return s & MAX_VALUE;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m3497toIntimpl(short s) {
        return s & MAX_VALUE;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m3498toLongimpl(short s) {
        return s & 65535;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m3499toShortimpl(short s) {
        return s;
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m3504toUShortMh2AYeg(short s) {
        return s;
    }

    public final boolean equals(Object obj) {
        return m3463equalsimpl(this.data, obj);
    }

    public final int hashCode() {
        return m3469hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ short getData() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(getData() & MAX_VALUE, uShort.getData() & MAX_VALUE);
    }

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m3452compareTo7apg3OU(short s, byte b) {
        return Intrinsics.compare(s & MAX_VALUE, b & 255);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private int m3455compareToxj2QHRw(short s) {
        return Intrinsics.compare(getData() & MAX_VALUE, s & MAX_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static int m3456compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare(s & MAX_VALUE, s2 & MAX_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m3454compareToWZ4Q5Ns(short s, int i) {
        return UnsignedKt.uintCompare(UInt.m3273constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m3453compareToVKZWuLQ(short s, long j) {
        return UnsignedKt.ulongCompare(ULong.m3351constructorimpl(s & 65535), j);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m3481plus7apg3OU(short s, byte b) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(s & MAX_VALUE) + UInt.m3273constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m3484plusxj2QHRw(short s, short s2) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(s & MAX_VALUE) + UInt.m3273constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m3483plusWZ4Q5Ns(short s, int i) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(s & MAX_VALUE) + i);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m3482plusVKZWuLQ(short s, long j) {
        return ULong.m3351constructorimpl(ULong.m3351constructorimpl(s & 65535) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m3472minus7apg3OU(short s, byte b) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(s & MAX_VALUE) - UInt.m3273constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m3475minusxj2QHRw(short s, short s2) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(s & MAX_VALUE) - UInt.m3273constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m3474minusWZ4Q5Ns(short s, int i) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(s & MAX_VALUE) - i);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m3473minusVKZWuLQ(short s, long j) {
        return ULong.m3351constructorimpl(ULong.m3351constructorimpl(s & 65535) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m3490times7apg3OU(short s, byte b) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(s & MAX_VALUE) * UInt.m3273constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m3493timesxj2QHRw(short s, short s2) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(s & MAX_VALUE) * UInt.m3273constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m3492timesWZ4Q5Ns(short s, int i) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(s & MAX_VALUE) * i);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m3491timesVKZWuLQ(short s, long j) {
        return ULong.m3351constructorimpl(ULong.m3351constructorimpl(s & 65535) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m3459div7apg3OU(short s, byte b) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), UInt.m3273constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m3462divxj2QHRw(short s, short s2) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), UInt.m3273constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m3461divWZ4Q5Ns(short s, int i) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m3460divVKZWuLQ(short s, long j) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(ULong.m3351constructorimpl(s & 65535), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m3486rem7apg3OU(short s, byte b) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), UInt.m3273constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m3489remxj2QHRw(short s, short s2) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), UInt.m3273constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m3488remWZ4Q5Ns(short s, int i) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m3487remVKZWuLQ(short s, long j) {
        return UnsignedKt.m3529ulongRemaindereb3DHEI(ULong.m3351constructorimpl(s & 65535), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m3465floorDiv7apg3OU(short s, byte b) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), UInt.m3273constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m3468floorDivxj2QHRw(short s, short s2) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), UInt.m3273constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m3467floorDivWZ4Q5Ns(short s, int i) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m3466floorDivVKZWuLQ(short s, long j) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(ULong.m3351constructorimpl(s & 65535), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m3476mod7apg3OU(short s, byte b) {
        return UByte.m3197constructorimpl((byte) UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), UInt.m3273constructorimpl(b & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m3479modxj2QHRw(short s, short s2) {
        return m3457constructorimpl((short) UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), UInt.m3273constructorimpl(s2 & MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m3478modWZ4Q5Ns(short s, int i) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m3477modVKZWuLQ(short s, long j) {
        return UnsignedKt.m3529ulongRemaindereb3DHEI(ULong.m3351constructorimpl(s & 65535), j);
    }

    /* renamed from: inc-Mh2AYeg  reason: not valid java name */
    private static final short m3470incMh2AYeg(short s) {
        return m3457constructorimpl((short) (s + 1));
    }

    /* renamed from: dec-Mh2AYeg  reason: not valid java name */
    private static final short m3458decMh2AYeg(short s) {
        return m3457constructorimpl((short) (s - 1));
    }

    /* renamed from: rangeTo-xj2QHRw  reason: not valid java name */
    private static final UIntRange m3485rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m3273constructorimpl(s & MAX_VALUE), UInt.m3273constructorimpl(s2 & MAX_VALUE), null);
    }

    /* renamed from: and-xj2QHRw  reason: not valid java name */
    private static final short m3450andxj2QHRw(short s, short s2) {
        return m3457constructorimpl((short) (s & s2));
    }

    /* renamed from: or-xj2QHRw  reason: not valid java name */
    private static final short m3480orxj2QHRw(short s, short s2) {
        return m3457constructorimpl((short) (s | s2));
    }

    /* renamed from: xor-xj2QHRw  reason: not valid java name */
    private static final short m3505xorxj2QHRw(short s, short s2) {
        return m3457constructorimpl((short) (s ^ s2));
    }

    /* renamed from: inv-Mh2AYeg  reason: not valid java name */
    private static final short m3471invMh2AYeg(short s) {
        return m3457constructorimpl((short) (s ^ (-1)));
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m3501toUBytew2LRezQ(short s) {
        return UByte.m3197constructorimpl((byte) s);
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m3502toUIntpVg5ArA(short s) {
        return UInt.m3273constructorimpl(s & MAX_VALUE);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m3503toULongsVKNKU(short s) {
        return ULong.m3351constructorimpl(s & 65535);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3500toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    public final String toString() {
        return m3500toStringimpl(this.data);
    }
}
