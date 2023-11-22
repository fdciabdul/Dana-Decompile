package fsimpl;

import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;

/* loaded from: classes8.dex */
class eL {
    public static int a(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >> 16);
    }

    public static int a(int i, float f) {
        long max = Math.max(2L, a((long) Math.ceil(i / f)));
        if (max <= ConvertUtils.GB) {
            return (int) max;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Too large (");
        sb.append(i);
        sb.append(" expected elements with load factor ");
        sb.append(f);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    public static long a(long j) {
        if (j == 0) {
            return 1L;
        }
        long j2 = j - 1;
        long j3 = j2 | (j2 >> 1);
        long j4 = j3 | (j3 >> 2);
        long j5 = j4 | (j4 >> 4);
        long j6 = j5 | (j5 >> 8);
        long j7 = j6 | (j6 >> 16);
        return (j7 | (j7 >> 32)) + 1;
    }
}
