package kotlin;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000*\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0005\u001a\u001c\u0010\u0003\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u0003\u0010\t\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0003\u0010\n\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0003\u0010\u000b\u001a\u001c\u0010\u0003\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0003\u0010\f\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u0003\u0010\r\u001a\u001c\u0010\u0003\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0003\u0010\u000e\u001a\u001c\u0010\u0003\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0003\u0010\u000f\u001a\u001c\u0010\u0003\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0010\u001a\u001c\u0010\u0003\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u0003\u0010\u0011\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0012\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0013\u001a\u001c\u0010\u0003\u001a\u00020\u0006*\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0014\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\b2\u0006\u0010\u0001\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u0003\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001c\u0010\u0016\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0005\u001a\u001c\u0010\u0016\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0007\u001a\u001c\u0010\u0016\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u0016\u0010\u0018\u001a\u001c\u0010\u0016\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u0001\u001a\u00020\u0019H\u0086\b¢\u0006\u0004\b\u0016\u0010\u001a\u001a\u001c\u0010\u0016\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u0001\u001a\u00020\u001bH\u0086\b¢\u0006\u0004\b\u0016\u0010\u001c\u001a\u001c\u0010\u0016\u001a\u00020\u0019*\u00020\u001b2\u0006\u0010\u0001\u001a\u00020\u0019H\u0086\b¢\u0006\u0004\b\u0016\u0010\u001d\u001a\u001c\u0010\u0016\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0001\u001a\u00020\u001bH\u0086\b¢\u0006\u0004\b\u0016\u0010\u001e\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0016\u0010\u001f\u001a\u001c\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0016\u0010\u000b\u001a\u001c\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0016\u0010\f\u001a\u001c\u0010\u0016\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u0016\u0010 \u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0016\u0010!\u001a\u001c\u0010\u0016\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0016\u0010\"\u001a\u001c\u0010\u0016\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0010\u001a\u001c\u0010\u0016\u001a\u00020\b*\u00020\u00062\u0006\u0010\u0001\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u0016\u0010#\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0016\u0010$\u001a\u001c\u0010\u0016\u001a\u00020\u0002*\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0013\u001a\u001c\u0010\u0016\u001a\u00020\u0006*\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0014\u001a\u001c\u0010\u0016\u001a\u00020\b*\u00020\b2\u0006\u0010\u0001\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u0016\u0010%"}, d2 = {"", "other", "", "floorDiv", "(BB)I", "(BI)I", "", "(BJ)J", "", "(BS)I", "(IB)I", "(II)I", "(IJ)J", "(IS)I", "(JB)J", "(JI)J", "(JJ)J", "(JS)J", "(SB)I", "(SI)I", "(SJ)J", "(SS)I", "mod", "(BB)B", "(BS)S", "", "(DD)D", "", "(DF)D", "(FD)D", "(FF)F", "(IB)B", "(IS)S", "(JB)B", "(JI)I", "(JS)S", "(SB)B", "(SS)S"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/NumbersKt")
/* loaded from: classes9.dex */
public class NumbersKt__FloorDivModKt extends NumbersKt__BigIntegersKt {
    private static final int floorDiv(byte b, byte b2) {
        int i = b / b2;
        return ((b ^ b2) >= 0 || b2 * i == b) ? i : i - 1;
    }

    private static final byte mod(byte b, byte b2) {
        int i = b % b2;
        return (byte) (i + (b2 & (((i ^ b2) & ((-i) | i)) >> 31)));
    }

    private static final int floorDiv(byte b, short s) {
        int i = b / s;
        return ((b ^ s) >= 0 || s * i == b) ? i : i - 1;
    }

    private static final short mod(byte b, short s) {
        int i = b % s;
        return (short) (i + (s & (((i ^ s) & ((-i) | i)) >> 31)));
    }

    private static final int floorDiv(byte b, int i) {
        int i2 = b / i;
        return ((b ^ i) >= 0 || i * i2 == b) ? i2 : i2 - 1;
    }

    private static final int mod(byte b, int i) {
        int i2 = b % i;
        return i2 + (i & (((i2 ^ i) & ((-i2) | i2)) >> 31));
    }

    private static final long floorDiv(byte b, long j) {
        long j2 = b;
        long j3 = j2 / j;
        return ((j2 ^ j) >= 0 || j * j3 == j2) ? j3 : j3 - 1;
    }

    private static final long mod(byte b, long j) {
        long j2 = b % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    private static final int floorDiv(short s, byte b) {
        int i = s / b;
        return ((s ^ b) >= 0 || b * i == s) ? i : i - 1;
    }

    private static final byte mod(short s, byte b) {
        int i = s % b;
        return (byte) (i + (b & (((i ^ b) & ((-i) | i)) >> 31)));
    }

    private static final int floorDiv(short s, short s2) {
        int i = s / s2;
        return ((s ^ s2) >= 0 || s2 * i == s) ? i : i - 1;
    }

    private static final short mod(short s, short s2) {
        int i = s % s2;
        return (short) (i + (s2 & (((i ^ s2) & ((-i) | i)) >> 31)));
    }

    private static final int floorDiv(short s, int i) {
        int i2 = s / i;
        return ((s ^ i) >= 0 || i * i2 == s) ? i2 : i2 - 1;
    }

    private static final int mod(short s, int i) {
        int i2 = s % i;
        return i2 + (i & (((i2 ^ i) & ((-i2) | i2)) >> 31));
    }

    private static final long floorDiv(short s, long j) {
        long j2 = s;
        long j3 = j2 / j;
        return ((j2 ^ j) >= 0 || j * j3 == j2) ? j3 : j3 - 1;
    }

    private static final long mod(short s, long j) {
        long j2 = s % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    private static final int floorDiv(int i, byte b) {
        int i2 = i / b;
        return ((i ^ b) >= 0 || b * i2 == i) ? i2 : i2 - 1;
    }

    private static final byte mod(int i, byte b) {
        int i2 = i % b;
        return (byte) (i2 + (b & (((i2 ^ b) & ((-i2) | i2)) >> 31)));
    }

    private static final int floorDiv(int i, short s) {
        int i2 = i / s;
        return ((i ^ s) >= 0 || s * i2 == i) ? i2 : i2 - 1;
    }

    private static final short mod(int i, short s) {
        int i2 = i % s;
        return (short) (i2 + (s & (((i2 ^ s) & ((-i2) | i2)) >> 31)));
    }

    private static final int floorDiv(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    private static final int mod(int i, int i2) {
        int i3 = i % i2;
        return i3 + (i2 & (((i3 ^ i2) & ((-i3) | i3)) >> 31));
    }

    private static final long floorDiv(int i, long j) {
        long j2 = i;
        long j3 = j2 / j;
        return ((j2 ^ j) >= 0 || j * j3 == j2) ? j3 : j3 - 1;
    }

    private static final long mod(int i, long j) {
        long j2 = i % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    private static final long floorDiv(long j, byte b) {
        long j2 = b;
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    private static final byte mod(long j, byte b) {
        long j2 = j % b;
        return (byte) (j2 + (r0 & (((j2 ^ r0) & ((-j2) | j2)) >> 63)));
    }

    private static final long floorDiv(long j, short s) {
        long j2 = s;
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    private static final short mod(long j, short s) {
        long j2 = j % s;
        return (short) (j2 + (r0 & (((j2 ^ r0) & ((-j2) | j2)) >> 63)));
    }

    private static final long floorDiv(long j, int i) {
        long j2 = i;
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    private static final int mod(long j, int i) {
        long j2 = i;
        long j3 = j % j2;
        return (int) (j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63)));
    }

    private static final long floorDiv(long j, long j2) {
        long j3 = j / j2;
        return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
    }

    private static final long mod(long j, long j2) {
        long j3 = j % j2;
        return j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63));
    }

    private static final float mod(float f, float f2) {
        float f3 = f % f2;
        if (f3 == 0.0f) {
            return f3;
        }
        return !(Math.signum(f3) == Math.signum(f2)) ? f3 + f2 : f3;
    }

    private static final double mod(float f, double d) {
        double d2 = f;
        Double.isNaN(d2);
        double d3 = d2 % d;
        if (d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return d3;
        }
        return !(Math.signum(d3) == Math.signum(d)) ? d3 + d : d3;
    }

    private static final double mod(double d, float f) {
        double d2 = f;
        Double.isNaN(d2);
        double d3 = d % d2;
        if (d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return d3;
        }
        if (Math.signum(d3) == Math.signum(d2)) {
            return d3;
        }
        Double.isNaN(d2);
        return d3 + d2;
    }

    private static final double mod(double d, double d2) {
        double d3 = d % d2;
        if (d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return d3;
        }
        return !(Math.signum(d3) == Math.signum(d2)) ? d3 + d2 : d3;
    }
}
