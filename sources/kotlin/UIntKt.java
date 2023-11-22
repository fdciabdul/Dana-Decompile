package kotlin;

@Metadata(d1 = {"\u0000*\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0000\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\t\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u000b\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"", "Lkotlin/UInt;", "toUInt", "(B)I", "", "(D)I", "", "(F)I", "", "(I)I", "", "(J)I", "", "(S)I"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class UIntKt {
    private static final int toUInt(byte b) {
        return UInt.m3273constructorimpl(b);
    }

    private static final int toUInt(short s) {
        return UInt.m3273constructorimpl(s);
    }

    private static final int toUInt(int i) {
        return UInt.m3273constructorimpl(i);
    }

    private static final int toUInt(long j) {
        return UInt.m3273constructorimpl((int) j);
    }

    private static final int toUInt(float f) {
        return UnsignedKt.doubleToUInt(f);
    }

    private static final int toUInt(double d) {
        return UnsignedKt.doubleToUInt(d);
    }
}
