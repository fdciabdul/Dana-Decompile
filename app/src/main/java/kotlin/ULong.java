package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.ranges.ULongRange;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087@\u0018\u0000 }2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001}B\u0014\b\u0000\u0012\u0006\u0010x\u001a\u00020cø\u0001\u0000¢\u0006\u0004\b|\u0010\u0014J\u001b\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\u00020\u0000H\u0086\nø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0004J\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\"\u001a\u00020\u001f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010\u0017J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u001aJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u0004J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u001dJ\u0010\u0010*\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0013\u0010,\u001a\u00020\u0000H\u0086\nø\u0001\u0001¢\u0006\u0004\b+\u0010\u0014J\u0013\u0010.\u001a\u00020\u0000H\u0086\bø\u0001\u0001¢\u0006\u0004\b-\u0010\u0014J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u0017J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u001aJ\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0004J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001dJ\u001b\u00106\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b4\u00105J\u001b\u00106\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b7\u0010\rJ\u001b\u00106\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u0004J\u001b\u00106\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\bø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010<\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\b;\u0010\u0004J\u001b\u0010>\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0017J\u001b\u0010>\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u001aJ\u001b\u0010>\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0004J\u001b\u0010>\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001dJ\u001b\u0010E\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u001b\u0010G\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\bF\u0010\u0017J\u001b\u0010G\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\bH\u0010\u001aJ\u001b\u0010G\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u0004J\u001b\u0010G\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u001dJ\u001b\u0010M\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u0007H\u0086\fø\u0001\u0001¢\u0006\u0004\bL\u0010\u001aJ\u001b\u0010O\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u0007H\u0086\fø\u0001\u0001¢\u0006\u0004\bN\u0010\u001aJ\u001b\u0010Q\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u0017J\u001b\u0010Q\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\nø\u0001\u0000¢\u0006\u0004\bR\u0010\u001aJ\u001b\u0010Q\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u0004J\u001b\u0010Q\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\nø\u0001\u0000¢\u0006\u0004\bT\u0010\u001dJ\u0010\u0010X\u001a\u00020UH\u0086\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010\\\u001a\u00020YH\u0086\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010`\u001a\u00020]H\u0086\b¢\u0006\u0004\b^\u0010_J\u0010\u0010b\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\ba\u0010)J\u0010\u0010e\u001a\u00020cH\u0086\b¢\u0006\u0004\bd\u0010\u0014J\u0010\u0010i\u001a\u00020fH\u0086\b¢\u0006\u0004\bg\u0010hJ\u000f\u0010m\u001a\u00020jH\u0016¢\u0006\u0004\bk\u0010lJ\u0013\u0010o\u001a\u00020\u0006H\u0086\bø\u0001\u0001¢\u0006\u0004\bn\u0010WJ\u0013\u0010q\u001a\u00020\u000bH\u0086\bø\u0001\u0001¢\u0006\u0004\bp\u0010)J\u0013\u0010s\u001a\u00020\u0000H\u0086\bø\u0001\u0001¢\u0006\u0004\br\u0010\u0014J\u0013\u0010u\u001a\u00020\u0010H\u0086\bø\u0001\u0001¢\u0006\u0004\bt\u0010hJ\u001b\u0010w\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\fø\u0001\u0000¢\u0006\u0004\bv\u0010\u0004R\u001a\u0010x\u001a\u00020c8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bx\u0010y\u0012\u0004\bz\u0010{\u0088\u0001x\u0092\u0001\u00020cø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/ULong;", "", "other", "and-VKZWuLQ", "(JJ)J", "and", "Lkotlin/UByte;", "", "compareTo-7apg3OU", "(JB)I", "compareTo", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec-s-VKNKU", "(J)J", "dec", "div-7apg3OU", "(JB)J", "div", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "floorDiv-7apg3OU", "floorDiv", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode-impl", "(J)I", "hashCode", "inc-s-VKNKU", "inc", "inv-s-VKNKU", "inv", "minus-7apg3OU", "minus", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod-7apg3OU", "(JB)B", "mod", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or-VKZWuLQ", "or", "plus-7apg3OU", "plus", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeTo", "rem-7apg3OU", "rem", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "bitCount", "shl-s-VKNKU", "shl", "shr-s-VKNKU", "shr", "times-7apg3OU", "times", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "", "toByte-impl", "(J)B", "toByte", "", "toDouble-impl", "(J)D", "toDouble", "", "toFloat-impl", "(J)F", "toFloat", "toInt-impl", "toInt", "", "toLong-impl", "toLong", "", "toShort-impl", "(J)S", "toShort", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "toUByte-w2LRezQ", "toUByte", "toUInt-pVg5ArA", "toUInt", "toULong-s-VKNKU", "toULong", "toUShort-Mh2AYeg", "toUShort", "xor-VKZWuLQ", "xor", "data", "J", "getData$annotations", "()V", "constructor-impl", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class ULong implements Comparable<ULong> {
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    public final long data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULong m3345boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m3351constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3357equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).getData();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3358equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3363hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m3390toByteimpl(long j) {
        return (byte) j;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m3393toIntimpl(long j) {
        return (int) j;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m3394toLongimpl(long j) {
        return j;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m3395toShortimpl(long j) {
        return (short) j;
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m3399toULongsVKNKU(long j) {
        return j;
    }

    public final boolean equals(Object obj) {
        return m3357equalsimpl(this.data, obj);
    }

    public final int hashCode() {
        return m3363hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ long getData() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.ulongCompare(getData(), uLong.getData());
    }

    private /* synthetic */ ULong(long j) {
        this.data = j;
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m3346compareTo7apg3OU(long j, byte b) {
        return UnsignedKt.ulongCompare(j, m3351constructorimpl(b & 255));
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m3350compareToxj2QHRw(long j, short s) {
        return UnsignedKt.ulongCompare(j, m3351constructorimpl(s & 65535));
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m3349compareToWZ4Q5Ns(long j, int i) {
        return UnsignedKt.ulongCompare(j, m3351constructorimpl(i & 4294967295L));
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private int m3347compareToVKZWuLQ(long j) {
        return UnsignedKt.ulongCompare(getData(), j);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static int m3348compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final long m3375plus7apg3OU(long j, byte b) {
        return m3351constructorimpl(j + m3351constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final long m3378plusxj2QHRw(long j, short s) {
        return m3351constructorimpl(j + m3351constructorimpl(s & 65535));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final long m3377plusWZ4Q5Ns(long j, int i) {
        return m3351constructorimpl(j + m3351constructorimpl(i & 4294967295L));
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m3376plusVKZWuLQ(long j, long j2) {
        return m3351constructorimpl(j + j2);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final long m3366minus7apg3OU(long j, byte b) {
        return m3351constructorimpl(j - m3351constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final long m3369minusxj2QHRw(long j, short s) {
        return m3351constructorimpl(j - m3351constructorimpl(s & 65535));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final long m3368minusWZ4Q5Ns(long j, int i) {
        return m3351constructorimpl(j - m3351constructorimpl(i & 4294967295L));
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m3367minusVKZWuLQ(long j, long j2) {
        return m3351constructorimpl(j - j2);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final long m3386times7apg3OU(long j, byte b) {
        return m3351constructorimpl(j * m3351constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final long m3389timesxj2QHRw(long j, short s) {
        return m3351constructorimpl(j * m3351constructorimpl(s & 65535));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final long m3388timesWZ4Q5Ns(long j, int i) {
        return m3351constructorimpl(j * m3351constructorimpl(i & 4294967295L));
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m3387timesVKZWuLQ(long j, long j2) {
        return m3351constructorimpl(j * j2);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final long m3353div7apg3OU(long j, byte b) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(j, m3351constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final long m3356divxj2QHRw(long j, short s) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(j, m3351constructorimpl(s & 65535));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final long m3355divWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(j, m3351constructorimpl(i & 4294967295L));
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m3354divVKZWuLQ(long j, long j2) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final long m3380rem7apg3OU(long j, byte b) {
        return UnsignedKt.m3529ulongRemaindereb3DHEI(j, m3351constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final long m3383remxj2QHRw(long j, short s) {
        return UnsignedKt.m3529ulongRemaindereb3DHEI(j, m3351constructorimpl(s & 65535));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final long m3382remWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m3529ulongRemaindereb3DHEI(j, m3351constructorimpl(i & 4294967295L));
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m3381remVKZWuLQ(long j, long j2) {
        return UnsignedKt.m3529ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final long m3359floorDiv7apg3OU(long j, byte b) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(j, m3351constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final long m3362floorDivxj2QHRw(long j, short s) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(j, m3351constructorimpl(s & 65535));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final long m3361floorDivWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(j, m3351constructorimpl(i & 4294967295L));
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m3360floorDivVKZWuLQ(long j, long j2) {
        return UnsignedKt.m3528ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m3370mod7apg3OU(long j, byte b) {
        return UByte.m3197constructorimpl((byte) UnsignedKt.m3529ulongRemaindereb3DHEI(j, m3351constructorimpl(b & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m3373modxj2QHRw(long j, short s) {
        return UShort.m3457constructorimpl((short) UnsignedKt.m3529ulongRemaindereb3DHEI(j, m3351constructorimpl(s & 65535)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m3372modWZ4Q5Ns(long j, int i) {
        return UInt.m3273constructorimpl((int) UnsignedKt.m3529ulongRemaindereb3DHEI(j, m3351constructorimpl(i & 4294967295L)));
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m3371modVKZWuLQ(long j, long j2) {
        return UnsignedKt.m3529ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: inc-s-VKNKU  reason: not valid java name */
    private static final long m3364incsVKNKU(long j) {
        return m3351constructorimpl(j + 1);
    }

    /* renamed from: dec-s-VKNKU  reason: not valid java name */
    private static final long m3352decsVKNKU(long j) {
        return m3351constructorimpl(j - 1);
    }

    /* renamed from: rangeTo-VKZWuLQ  reason: not valid java name */
    private static final ULongRange m3379rangeToVKZWuLQ(long j, long j2) {
        return new ULongRange(j, j2, null);
    }

    /* renamed from: shl-s-VKNKU  reason: not valid java name */
    private static final long m3384shlsVKNKU(long j, int i) {
        return m3351constructorimpl(j << i);
    }

    /* renamed from: shr-s-VKNKU  reason: not valid java name */
    private static final long m3385shrsVKNKU(long j, int i) {
        return m3351constructorimpl(j >>> i);
    }

    /* renamed from: and-VKZWuLQ  reason: not valid java name */
    private static final long m3344andVKZWuLQ(long j, long j2) {
        return m3351constructorimpl(j & j2);
    }

    /* renamed from: or-VKZWuLQ  reason: not valid java name */
    private static final long m3374orVKZWuLQ(long j, long j2) {
        return m3351constructorimpl(j | j2);
    }

    /* renamed from: xor-VKZWuLQ  reason: not valid java name */
    private static final long m3401xorVKZWuLQ(long j, long j2) {
        return m3351constructorimpl(j ^ j2);
    }

    /* renamed from: inv-s-VKNKU  reason: not valid java name */
    private static final long m3365invsVKNKU(long j) {
        return m3351constructorimpl(j ^ (-1));
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m3397toUBytew2LRezQ(long j) {
        return UByte.m3197constructorimpl((byte) j);
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m3400toUShortMh2AYeg(long j) {
        return UShort.m3457constructorimpl((short) j);
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m3398toUIntpVg5ArA(long j) {
        return UInt.m3273constructorimpl((int) j);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m3392toFloatimpl(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m3391toDoubleimpl(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3396toStringimpl(long j) {
        return UnsignedKt.ulongToString(j);
    }

    public final String toString() {
        return m3396toStringimpl(this.data);
    }
}
