package kotlin;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\f\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u0019\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\n\u001a\u0019\u0010\f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\u000b\u001a\u0014\u0010\r\u001a\u00020\u0000*\u00020\u0000H\u0086\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\r\u001a\u00020\u0004*\u00020\u0004H\u0086\b¢\u0006\u0004\b\r\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0000*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u0004*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0010\u0010\u000f"}, d2 = {"", "", "countLeadingZeroBits", "(B)I", "", "(S)I", "countOneBits", "countTrailingZeroBits", "bitCount", "rotateLeft", "(BI)B", "(SI)S", "rotateRight", "takeHighestOneBit", "(B)B", "(S)S", "takeLowestOneBit"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/NumbersKt")
/* loaded from: classes9.dex */
class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    public static final byte rotateLeft(byte b, int i) {
        int i2 = i & 7;
        return (byte) ((b << i2) | ((b & 255) >>> (8 - i2)));
    }

    public static final short rotateLeft(short s, int i) {
        int i2 = i & 15;
        return (short) ((s << i2) | ((65535 & s) >>> (16 - i2)));
    }

    public static final byte rotateRight(byte b, int i) {
        int i2 = i & 7;
        return (byte) ((b << (8 - i2)) | ((b & 255) >>> i2));
    }

    public static final short rotateRight(short s, int i) {
        int i2 = i & 15;
        return (short) ((s << (16 - i2)) | ((65535 & s) >>> i2));
    }

    private static final int countOneBits(byte b) {
        return Integer.bitCount(b & 255);
    }

    private static final int countLeadingZeroBits(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    private static final int countTrailingZeroBits(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    private static final byte takeHighestOneBit(byte b) {
        return (byte) Integer.highestOneBit(b & 255);
    }

    private static final byte takeLowestOneBit(byte b) {
        return (byte) Integer.lowestOneBit(b);
    }

    private static final int countOneBits(short s) {
        return Integer.bitCount(s & UShort.MAX_VALUE);
    }

    private static final int countLeadingZeroBits(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    private static final int countTrailingZeroBits(short s) {
        return Integer.numberOfTrailingZeros(s | UShort.MIN_VALUE);
    }

    private static final short takeHighestOneBit(short s) {
        return (short) Integer.highestOneBit(s & UShort.MAX_VALUE);
    }

    private static final short takeLowestOneBit(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
