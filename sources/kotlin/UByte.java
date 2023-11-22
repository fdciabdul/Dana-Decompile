package kotlin;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087@\u0018\u0000 u2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001uB\u0014\b\u0000\u0012\u0006\u0010p\u001a\u00020Mø\u0001\u0000¢\u0006\u0004\bt\u0010\u0014J\u001b\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\nø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\nH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\rH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\u00020\u0000H\u0086\nø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\bJ\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\fJ\u001b\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010 \u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\"\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b!\u0010\bJ\u001b\u0010\"\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010\fJ\u001b\u0010\"\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0086\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u001aJ\u001b\u0010\"\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u0012J\u0010\u0010(\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b&\u0010'J\u0013\u0010*\u001a\u00020\u0000H\u0086\nø\u0001\u0001¢\u0006\u0004\b)\u0010\u0014J\u0013\u0010,\u001a\u00020\u0000H\u0086\bø\u0001\u0001¢\u0006\u0004\b+\u0010\u0014J\u001b\u0010.\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b-\u0010\bJ\u001b\u0010.\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0086\nø\u0001\u0000¢\u0006\u0004\b/\u0010\fJ\u001b\u0010.\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0086\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u001aJ\u001b\u0010.\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0012J\u001b\u00103\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b2\u0010\u0004J\u001b\u00103\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b4\u0010\fJ\u001b\u00103\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0086\bø\u0001\u0000¢\u0006\u0004\b5\u0010\u001aJ\u001b\u00103\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\bø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\b8\u0010\u0004J\u001b\u0010;\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b:\u0010\bJ\u001b\u0010;\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0086\nø\u0001\u0000¢\u0006\u0004\b<\u0010\fJ\u001b\u0010;\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0086\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u001aJ\u001b\u0010;\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u0012J\u001b\u0010B\u001a\u00020?2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u001b\u0010D\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\bC\u0010\bJ\u001b\u0010D\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0086\nø\u0001\u0000¢\u0006\u0004\bE\u0010\fJ\u001b\u0010D\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0086\nø\u0001\u0000¢\u0006\u0004\bF\u0010\u001aJ\u001b\u0010D\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\bG\u0010\u0012J\u001b\u0010I\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\bH\u0010\bJ\u001b\u0010I\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0086\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\fJ\u001b\u0010I\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0086\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u001aJ\u001b\u0010I\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0012J\u0010\u0010O\u001a\u00020MH\u0086\b¢\u0006\u0004\bN\u0010\u0014J\u0010\u0010S\u001a\u00020PH\u0086\b¢\u0006\u0004\bQ\u0010RJ\u0010\u0010W\u001a\u00020TH\u0086\b¢\u0006\u0004\bU\u0010VJ\u0010\u0010Y\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\bX\u0010'J\u0010\u0010]\u001a\u00020ZH\u0086\b¢\u0006\u0004\b[\u0010\\J\u0010\u0010a\u001a\u00020^H\u0086\b¢\u0006\u0004\b_\u0010`J\u000f\u0010e\u001a\u00020bH\u0016¢\u0006\u0004\bc\u0010dJ\u0013\u0010g\u001a\u00020\u0000H\u0086\bø\u0001\u0001¢\u0006\u0004\bf\u0010\u0014J\u0013\u0010i\u001a\u00020\nH\u0086\bø\u0001\u0001¢\u0006\u0004\bh\u0010'J\u0013\u0010k\u001a\u00020\rH\u0086\bø\u0001\u0001¢\u0006\u0004\bj\u0010\\J\u0013\u0010m\u001a\u00020\u0010H\u0086\bø\u0001\u0001¢\u0006\u0004\bl\u0010`J\u001b\u0010o\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\bn\u0010\u0004R\u001a\u0010p\u001a\u00020M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bp\u0010q\u0012\u0004\br\u0010s\u0088\u0001p\u0092\u0001\u00020Mø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/UByte;", "", "other", "and-7apg3OU", "(BB)B", "and", "", "compareTo-7apg3OU", "(BB)I", "compareTo", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec-w2LRezQ", "(B)B", "dec", "div-7apg3OU", "div", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "equals", "floorDiv-7apg3OU", "floorDiv", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode-impl", "(B)I", "hashCode", "inc-w2LRezQ", "inc", "inv-w2LRezQ", "inv", "minus-7apg3OU", "minus", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod-7apg3OU", "mod", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or-7apg3OU", "or", "plus-7apg3OU", "plus", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeTo", "rem-7apg3OU", "rem", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times-7apg3OU", "times", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "", "toByte-impl", "toByte", "", "toDouble-impl", "(B)D", "toDouble", "", "toFloat-impl", "(B)F", "toFloat", "toInt-impl", "toInt", "", "toLong-impl", "(B)J", "toLong", "", "toShort-impl", "(B)S", "toShort", "", "toString-impl", "(B)Ljava/lang/String;", "toString", "toUByte-w2LRezQ", "toUByte", "toUInt-pVg5ArA", "toUInt", "toULong-s-VKNKU", "toULong", "toUShort-Mh2AYeg", "toUShort", "xor-7apg3OU", "xor", "data", DiskFormatter.B, "getData$annotations", "()V", "constructor-impl", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes3.dex */
public final class UByte implements Comparable<UByte> {
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    public final byte data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m3191boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m3197constructorimpl(byte b) {
        return b;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3203equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).getData();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3204equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3209hashCodeimpl(byte b) {
        return b;
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m3234toByteimpl(byte b) {
        return b;
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m3235toDoubleimpl(byte b) {
        return b & 255;
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m3236toFloatimpl(byte b) {
        return b & 255;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m3237toIntimpl(byte b) {
        return b & 255;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m3238toLongimpl(byte b) {
        return b & 255;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m3239toShortimpl(byte b) {
        return (short) (b & 255);
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m3241toUBytew2LRezQ(byte b) {
        return b;
    }

    public final boolean equals(Object obj) {
        return m3203equalsimpl(this.data, obj);
    }

    public final int hashCode() {
        return m3209hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ byte getData() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.compare(getData() & 255, uByte.getData() & 255);
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private int m3192compareTo7apg3OU(byte b) {
        return Intrinsics.compare(getData() & 255, b & 255);
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static int m3193compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m3196compareToxj2QHRw(byte b, short s) {
        return Intrinsics.compare(b & 255, s & UShort.MAX_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m3195compareToWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.uintCompare(UInt.m3273constructorimpl(b & 255), i);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m3194compareToVKZWuLQ(byte b, long j) {
        return UnsignedKt.ulongCompare(ULong.m3351constructorimpl(b & 255), j);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m3221plus7apg3OU(byte b, byte b2) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(b & 255) + UInt.m3273constructorimpl(b2 & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m3224plusxj2QHRw(byte b, short s) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(b & 255) + UInt.m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m3223plusWZ4Q5Ns(byte b, int i) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(b & 255) + i);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m3222plusVKZWuLQ(byte b, long j) {
        return ULong.m3351constructorimpl(ULong.m3351constructorimpl(b & 255) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m3212minus7apg3OU(byte b, byte b2) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(b & 255) - UInt.m3273constructorimpl(b2 & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m3215minusxj2QHRw(byte b, short s) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(b & 255) - UInt.m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m3214minusWZ4Q5Ns(byte b, int i) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(b & 255) - i);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m3213minusVKZWuLQ(byte b, long j) {
        return ULong.m3351constructorimpl(ULong.m3351constructorimpl(b & 255) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m3230times7apg3OU(byte b, byte b2) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(b & 255) * UInt.m3273constructorimpl(b2 & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m3233timesxj2QHRw(byte b, short s) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(b & 255) * UInt.m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m3232timesWZ4Q5Ns(byte b, int i) {
        return UInt.m3273constructorimpl(UInt.m3273constructorimpl(b & 255) * i);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m3231timesVKZWuLQ(byte b, long j) {
        return ULong.m3351constructorimpl(ULong.m3351constructorimpl(b & 255) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m3199div7apg3OU(byte b, byte b2) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(b & 255), UInt.m3273constructorimpl(b2 & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m3202divxj2QHRw(byte b, short s) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(b & 255), UInt.m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m3201divWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(b & 255), i);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m3200divVKZWuLQ(byte b, long j) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(ULong.m3351constructorimpl(b & 255), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m3226rem7apg3OU(byte b, byte b2) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(b & 255), UInt.m3273constructorimpl(b2 & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m3229remxj2QHRw(byte b, short s) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(b & 255), UInt.m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m3228remWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(b & 255), i);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m3227remVKZWuLQ(byte b, long j) {
        return UnsignedKt.m3529ulongRemaindereb3DHEI(ULong.m3351constructorimpl(b & 255), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m3205floorDiv7apg3OU(byte b, byte b2) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(b & 255), UInt.m3273constructorimpl(b2 & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m3208floorDivxj2QHRw(byte b, short s) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(b & 255), UInt.m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m3207floorDivWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(UInt.m3273constructorimpl(b & 255), i);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m3206floorDivVKZWuLQ(byte b, long j) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(ULong.m3351constructorimpl(b & 255), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m3216mod7apg3OU(byte b, byte b2) {
        return m3197constructorimpl((byte) UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(b & 255), UInt.m3273constructorimpl(b2 & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m3219modxj2QHRw(byte b, short s) {
        return UShort.m3457constructorimpl((short) UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(b & 255), UInt.m3273constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m3218modWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(UInt.m3273constructorimpl(b & 255), i);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m3217modVKZWuLQ(byte b, long j) {
        return UnsignedKt.m3529ulongRemaindereb3DHEI(ULong.m3351constructorimpl(b & 255), j);
    }

    /* renamed from: inc-w2LRezQ  reason: not valid java name */
    private static final byte m3210incw2LRezQ(byte b) {
        return m3197constructorimpl((byte) (b + 1));
    }

    /* renamed from: dec-w2LRezQ  reason: not valid java name */
    private static final byte m3198decw2LRezQ(byte b) {
        return m3197constructorimpl((byte) (b - 1));
    }

    /* renamed from: rangeTo-7apg3OU  reason: not valid java name */
    private static final UIntRange m3225rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(UInt.m3273constructorimpl(b & 255), UInt.m3273constructorimpl(b2 & 255), null);
    }

    /* renamed from: and-7apg3OU  reason: not valid java name */
    private static final byte m3190and7apg3OU(byte b, byte b2) {
        return m3197constructorimpl((byte) (b & b2));
    }

    /* renamed from: or-7apg3OU  reason: not valid java name */
    private static final byte m3220or7apg3OU(byte b, byte b2) {
        return m3197constructorimpl((byte) (b | b2));
    }

    /* renamed from: xor-7apg3OU  reason: not valid java name */
    private static final byte m3245xor7apg3OU(byte b, byte b2) {
        return m3197constructorimpl((byte) (b ^ b2));
    }

    /* renamed from: inv-w2LRezQ  reason: not valid java name */
    private static final byte m3211invw2LRezQ(byte b) {
        return m3197constructorimpl((byte) (b ^ (-1)));
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m3244toUShortMh2AYeg(byte b) {
        return UShort.m3457constructorimpl((short) (b & 255));
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m3242toUIntpVg5ArA(byte b) {
        return UInt.m3273constructorimpl(b & 255);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m3243toULongsVKNKU(byte b) {
        return ULong.m3351constructorimpl(b & 255);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3240toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    public final String toString() {
        return m3240toStringimpl(this.data);
    }
}
