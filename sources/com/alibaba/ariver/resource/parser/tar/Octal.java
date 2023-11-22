package com.alibaba.ariver.resource.parser.tar;

import com.alibaba.ariver.kernel.common.utils.IOUtils;

/* loaded from: classes6.dex */
public class Octal {
    public static long parseOctal(byte[] bArr, int i, int i2) {
        byte b;
        boolean z = true;
        long j = 0;
        for (int i3 = i; i3 < i2 + i && (b = bArr[i3]) != 0; i3++) {
            if (b == 32 || b == 48) {
                if (z) {
                    continue;
                } else if (b == 32) {
                    break;
                }
            }
            z = false;
            j = (j << 3) + ((long) (b - 48));
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:11:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getOctalBytes(long r7, byte[] r9, int r10, int r11) {
        /*
            int r0 = r11 + (-1)
            int r1 = r10 + r0
            r2 = 0
            r9[r1] = r2
            int r0 = r0 + (-1)
            int r1 = r10 + r0
            r2 = 32
            r9[r1] = r2
            int r0 = r0 + (-1)
            r1 = 48
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 != 0) goto L1e
            int r7 = r10 + r0
            r9[r7] = r1
            goto L3a
        L1e:
            if (r0 < 0) goto L34
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 <= 0) goto L34
            r5 = 7
            long r5 = r5 & r7
            int r6 = (int) r5
            byte r5 = (byte) r6
            int r5 = r5 + r1
            byte r5 = (byte) r5
            int r6 = r10 + r0
            r9[r6] = r5
            r5 = 3
            long r7 = r7 >> r5
            int r0 = r0 + (-1)
            goto L1e
        L34:
            if (r0 < 0) goto L3d
            int r7 = r10 + r0
            r9[r7] = r2
        L3a:
            int r0 = r0 + (-1)
            goto L34
        L3d:
            int r10 = r10 + r11
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.parser.tar.Octal.getOctalBytes(long, byte[], int, int):int");
    }

    public static int getCheckSumOctalBytes(long j, byte[] bArr, int i, int i2) {
        getOctalBytes(j, bArr, i, i2);
        int i3 = i + i2;
        bArr[i3 - 1] = 32;
        bArr[i3 - 2] = 0;
        return i3;
    }

    public static int getLongOctalBytes(long j, byte[] bArr, int i, int i2) {
        int i3 = i2 + 1;
        byte[] buf = IOUtils.getBuf(i3);
        getOctalBytes(j, buf, 0, i3);
        System.arraycopy(buf, 0, bArr, i, i2);
        IOUtils.returnBuf(buf);
        return i + i2;
    }
}
