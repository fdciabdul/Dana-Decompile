package io.opentelemetry.internal.shaded.jctools.util;

/* loaded from: classes6.dex */
public final class Pow2 {
    public static final int MAX_POW2 = 1073741824;

    public static boolean isPowerOfTwo(int i) {
        return (i & (i + (-1))) == 0;
    }

    public static int roundToPowerOfTwo(int i) {
        if (i > 1073741824) {
            StringBuilder sb = new StringBuilder();
            sb.append("There is no larger power of 2 int for value:");
            sb.append(i);
            sb.append(" since it exceeds 2^31.");
            throw new IllegalArgumentException(sb.toString());
        } else if (i < 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Given value:");
            sb2.append(i);
            sb2.append(". Expecting value >= 0.");
            throw new IllegalArgumentException(sb2.toString());
        } else {
            return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
        }
    }

    public static long align(long j, int i) {
        if (isPowerOfTwo(i)) {
            return (j + (i - 1)) & (r4 ^ (-1));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("alignment must be a power of 2:");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
