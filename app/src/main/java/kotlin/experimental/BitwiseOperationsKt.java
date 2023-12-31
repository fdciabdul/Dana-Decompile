package kotlin.experimental;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0006\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0002\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\f¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0004*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0006\u0010\b\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\t\u0010\u0003\u001a\u001c\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\f¢\u0006\u0004\b\t\u0010\u0005\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\n\u0010\u0003\u001a\u001c\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\f¢\u0006\u0004\b\n\u0010\u0005"}, d2 = {"", "other", "and", "(BB)B", "", "(SS)S", "inv", "(B)B", "(S)S", "or", "xor"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class BitwiseOperationsKt {
    private static final byte and(byte b, byte b2) {
        return (byte) (b & b2);
    }

    private static final short and(short s, short s2) {
        return (short) (s & s2);
    }

    private static final byte inv(byte b) {
        return (byte) (b ^ (-1));
    }

    private static final short inv(short s) {
        return (short) (s ^ (-1));
    }

    private static final byte or(byte b, byte b2) {
        return (byte) (b | b2);
    }

    private static final short or(short s, short s2) {
        return (short) (s | s2);
    }

    private static final byte xor(byte b, byte b2) {
        return (byte) (b ^ b2);
    }

    private static final short xor(short s, short s2) {
        return (short) (s ^ s2);
    }
}
