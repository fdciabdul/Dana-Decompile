package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.ranges.UIntRange;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087@\u0018\u0000 z2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001zB\u0014\b\u0000\u0012\u0006\u0010u\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\by\u0010\u0013J\u001b\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\fH\u0086\nø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000fH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0014\u001a\u00020\u0000H\u0086\nø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\tJ\u001b\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0004J\u001b\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0011J\u001a\u0010\u001f\u001a\u00020\u001c2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b \u0010\tJ\u001b\u0010!\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0004J\u001b\u0010!\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010\u0019J\u001b\u0010!\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0086\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u0011J\u0010\u0010&\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b%\u0010\u0013J\u0013\u0010(\u001a\u00020\u0000H\u0086\nø\u0001\u0001¢\u0006\u0004\b'\u0010\u0013J\u0013\u0010*\u001a\u00020\u0000H\u0086\bø\u0001\u0001¢\u0006\u0004\b)\u0010\u0013J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b+\u0010\tJ\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0004J\u001b\u0010,\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0086\nø\u0001\u0000¢\u0006\u0004\b.\u0010\u0019J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0086\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u0011J\u001b\u00102\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001b\u00102\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b3\u0010\u0004J\u001b\u00102\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0086\bø\u0001\u0000¢\u0006\u0004\b4\u0010\u0019J\u001b\u00102\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000fH\u0086\bø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00108\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\b7\u0010\u0004J\u001b\u0010:\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b9\u0010\tJ\u001b\u0010:\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0004J\u001b\u0010:\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0086\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u0019J\u001b\u0010:\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0086\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0011J\u001b\u0010A\u001a\u00020>2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001b\u0010C\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\bB\u0010\tJ\u001b\u0010C\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u0004J\u001b\u0010C\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0086\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u0019J\u001b\u0010C\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0086\nø\u0001\u0000¢\u0006\u0004\bF\u0010\u0011J\u001b\u0010I\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0007H\u0086\fø\u0001\u0001¢\u0006\u0004\bH\u0010\u0004J\u001b\u0010K\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0007H\u0086\fø\u0001\u0001¢\u0006\u0004\bJ\u0010\u0004J\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\bL\u0010\tJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u0004J\u001b\u0010M\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0086\nø\u0001\u0000¢\u0006\u0004\bO\u0010\u0019J\u001b\u0010M\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0086\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u0011J\u0010\u0010T\u001a\u00020QH\u0086\b¢\u0006\u0004\bR\u0010SJ\u0010\u0010X\u001a\u00020UH\u0086\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010\\\u001a\u00020YH\u0086\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010^\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b]\u0010\u0013J\u0010\u0010b\u001a\u00020_H\u0086\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010f\u001a\u00020cH\u0086\b¢\u0006\u0004\bd\u0010eJ\u000f\u0010j\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u0013\u0010l\u001a\u00020\u0006H\u0086\bø\u0001\u0001¢\u0006\u0004\bk\u0010SJ\u0013\u0010n\u001a\u00020\u0000H\u0086\bø\u0001\u0001¢\u0006\u0004\bm\u0010\u0013J\u0013\u0010p\u001a\u00020\fH\u0086\bø\u0001\u0001¢\u0006\u0004\bo\u0010aJ\u0013\u0010r\u001a\u00020\u000fH\u0086\bø\u0001\u0001¢\u0006\u0004\bq\u0010eJ\u001b\u0010t\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\bs\u0010\u0004R\u001a\u0010u\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\bu\u0010v\u0012\u0004\bw\u0010x\u0088\u0001u\u0092\u0001\u00020\u0007ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/UInt;", "", "other", "and-WZ4Q5Ns", "(II)I", "and", "Lkotlin/UByte;", "", "compareTo-7apg3OU", "(IB)I", "compareTo", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec-pVg5ArA", "(I)I", "dec", "div-7apg3OU", "div", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "equals", "floorDiv-7apg3OU", "floorDiv", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode-impl", "hashCode", "inc-pVg5ArA", "inc", "inv-pVg5ArA", "inv", "minus-7apg3OU", "minus", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod-7apg3OU", "(IB)B", "mod", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or-WZ4Q5Ns", "or", "plus-7apg3OU", "plus", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeTo", "rem-7apg3OU", "rem", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "bitCount", "shl-pVg5ArA", "shl", "shr-pVg5ArA", "shr", "times-7apg3OU", "times", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "", "toByte-impl", "(I)B", "toByte", "", "toDouble-impl", "(I)D", "toDouble", "", "toFloat-impl", "(I)F", "toFloat", "toInt-impl", "toInt", "", "toLong-impl", "(I)J", "toLong", "", "toShort-impl", "(I)S", "toShort", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "toUByte-w2LRezQ", "toUByte", "toUInt-pVg5ArA", "toUInt", "toULong-s-VKNKU", "toULong", "toUShort-Mh2AYeg", "toUShort", "xor-WZ4Q5Ns", "xor", "data", "I", "getData$annotations", "()V", "constructor-impl", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class UInt implements Comparable<UInt> {
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    public final int data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UInt m3267boximpl(int i) {
        return new UInt(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m3273constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3279equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).getData();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3280equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3285hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m3312toByteimpl(int i) {
        return (byte) i;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m3315toIntimpl(int i) {
        return i;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m3316toLongimpl(int i) {
        return i & 4294967295L;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m3317toShortimpl(int i) {
        return (short) i;
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m3320toUIntpVg5ArA(int i) {
        return i;
    }

    public final boolean equals(Object obj) {
        return m3279equalsimpl(this.data, obj);
    }

    public final int hashCode() {
        return m3285hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ int getData() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(getData(), uInt.getData());
    }

    private /* synthetic */ UInt(int i) {
        this.data = i;
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m3268compareTo7apg3OU(int i, byte b) {
        return UnsignedKt.uintCompare(i, m3273constructorimpl(b & 255));
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m3272compareToxj2QHRw(int i, short s) {
        return UnsignedKt.uintCompare(i, m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private int m3270compareToWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(getData(), i);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static int m3271compareToWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m3269compareToVKZWuLQ(int i, long j) {
        return UnsignedKt.ulongCompare(ULong.m3351constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m3297plus7apg3OU(int i, byte b) {
        return m3273constructorimpl(i + m3273constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m3300plusxj2QHRw(int i, short s) {
        return m3273constructorimpl(i + m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m3299plusWZ4Q5Ns(int i, int i2) {
        return m3273constructorimpl(i + i2);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m3298plusVKZWuLQ(int i, long j) {
        return ULong.m3351constructorimpl(ULong.m3351constructorimpl(i & 4294967295L) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m3288minus7apg3OU(int i, byte b) {
        return m3273constructorimpl(i - m3273constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m3291minusxj2QHRw(int i, short s) {
        return m3273constructorimpl(i - m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m3290minusWZ4Q5Ns(int i, int i2) {
        return m3273constructorimpl(i - i2);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m3289minusVKZWuLQ(int i, long j) {
        return ULong.m3351constructorimpl(ULong.m3351constructorimpl(i & 4294967295L) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m3308times7apg3OU(int i, byte b) {
        return m3273constructorimpl(i * m3273constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m3311timesxj2QHRw(int i, short s) {
        return m3273constructorimpl(i * m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m3310timesWZ4Q5Ns(int i, int i2) {
        return m3273constructorimpl(i * i2);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m3309timesVKZWuLQ(int i, long j) {
        return ULong.m3351constructorimpl(ULong.m3351constructorimpl(i & 4294967295L) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m3275div7apg3OU(int i, byte b) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(i, m3273constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m3278divxj2QHRw(int i, short s) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(i, m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m3277divWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(i, i2);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m3276divVKZWuLQ(int i, long j) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(ULong.m3351constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m3302rem7apg3OU(int i, byte b) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(i, m3273constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m3305remxj2QHRw(int i, short s) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(i, m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m3304remWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(i, i2);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m3303remVKZWuLQ(int i, long j) {
        return UnsignedKt.m3529ulongRemaindereb3DHEI(ULong.m3351constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m3281floorDiv7apg3OU(int i, byte b) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(i, m3273constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m3284floorDivxj2QHRw(int i, short s) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(i, m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m3283floorDivWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m3526uintDivideJ1ME1BU(i, i2);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m3282floorDivVKZWuLQ(int i, long j) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(ULong.m3351constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m3292mod7apg3OU(int i, byte b) {
        return UByte.m3197constructorimpl((byte) UnsignedKt.m3527uintRemainderJ1ME1BU(i, m3273constructorimpl(b & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m3295modxj2QHRw(int i, short s) {
        return UShort.m3457constructorimpl((short) UnsignedKt.m3527uintRemainderJ1ME1BU(i, m3273constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m3294modWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m3527uintRemainderJ1ME1BU(i, i2);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m3293modVKZWuLQ(int i, long j) {
        return UnsignedKt.m3529ulongRemaindereb3DHEI(ULong.m3351constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: inc-pVg5ArA  reason: not valid java name */
    private static final int m3286incpVg5ArA(int i) {
        return m3273constructorimpl(i + 1);
    }

    /* renamed from: dec-pVg5ArA  reason: not valid java name */
    private static final int m3274decpVg5ArA(int i) {
        return m3273constructorimpl(i - 1);
    }

    /* renamed from: rangeTo-WZ4Q5Ns  reason: not valid java name */
    private static final UIntRange m3301rangeToWZ4Q5Ns(int i, int i2) {
        return new UIntRange(i, i2, null);
    }

    /* renamed from: shl-pVg5ArA  reason: not valid java name */
    private static final int m3306shlpVg5ArA(int i, int i2) {
        return m3273constructorimpl(i << i2);
    }

    /* renamed from: shr-pVg5ArA  reason: not valid java name */
    private static final int m3307shrpVg5ArA(int i, int i2) {
        return m3273constructorimpl(i >>> i2);
    }

    /* renamed from: and-WZ4Q5Ns  reason: not valid java name */
    private static final int m3266andWZ4Q5Ns(int i, int i2) {
        return m3273constructorimpl(i & i2);
    }

    /* renamed from: or-WZ4Q5Ns  reason: not valid java name */
    private static final int m3296orWZ4Q5Ns(int i, int i2) {
        return m3273constructorimpl(i | i2);
    }

    /* renamed from: xor-WZ4Q5Ns  reason: not valid java name */
    private static final int m3323xorWZ4Q5Ns(int i, int i2) {
        return m3273constructorimpl(i ^ i2);
    }

    /* renamed from: inv-pVg5ArA  reason: not valid java name */
    private static final int m3287invpVg5ArA(int i) {
        return m3273constructorimpl(i ^ (-1));
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m3319toUBytew2LRezQ(int i) {
        return UByte.m3197constructorimpl((byte) i);
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m3322toUShortMh2AYeg(int i) {
        return UShort.m3457constructorimpl((short) i);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m3321toULongsVKNKU(int i) {
        return ULong.m3351constructorimpl(i & 4294967295L);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m3314toFloatimpl(int i) {
        return (float) UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m3313toDoubleimpl(int i) {
        return UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3318toStringimpl(int i) {
        return String.valueOf(i & 4294967295L);
    }

    public final String toString() {
        return m3318toStringimpl(this.data);
    }
}
