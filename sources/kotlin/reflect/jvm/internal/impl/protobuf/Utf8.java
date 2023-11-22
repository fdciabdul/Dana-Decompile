package kotlin.reflect.jvm.internal.impl.protobuf;

import com.google.common.base.Ascii;

/* loaded from: classes.dex */
final class Utf8 {
    private static int incompleteStateFor(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    private static int incompleteStateFor(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    private static int incompleteStateFor(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return isValidUtf8(bArr, 0, bArr.length);
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        return partialIsValidUtf8(bArr, i, i2) == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r7[r8] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
    
        if (r7[r8] > (-65)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
    
        if (r7[r6] > (-65)) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int partialIsValidUtf8(int r6, byte[] r7, int r8, int r9) {
        /*
            if (r6 == 0) goto L85
            if (r8 < r9) goto L5
            return r6
        L5:
            byte r0 = (byte) r6
            r1 = -32
            r2 = -1
            r3 = -65
            if (r0 >= r1) goto L1b
            r6 = -62
            if (r0 < r6) goto L1a
            int r6 = r8 + 1
            r8 = r7[r8]
            if (r8 > r3) goto L1a
        L17:
            r8 = r6
            goto L85
        L1a:
            return r2
        L1b:
            r4 = -16
            if (r0 >= r4) goto L48
            int r6 = r6 >> 8
            r6 = r6 ^ r2
            byte r6 = (byte) r6
            if (r6 != 0) goto L33
            int r6 = r8 + 1
            r8 = r7[r8]
            if (r6 < r9) goto L30
            int r6 = incompleteStateFor(r0, r8)
            return r6
        L30:
            r5 = r8
            r8 = r6
            r6 = r5
        L33:
            if (r6 > r3) goto L47
            r4 = -96
            if (r0 != r1) goto L3b
            if (r6 < r4) goto L47
        L3b:
            r1 = -19
            if (r0 != r1) goto L41
            if (r6 >= r4) goto L47
        L41:
            int r6 = r8 + 1
            r8 = r7[r8]
            if (r8 <= r3) goto L17
        L47:
            return r2
        L48:
            int r1 = r6 >> 8
            r1 = r1 ^ r2
            byte r1 = (byte) r1
            if (r1 != 0) goto L5b
            int r6 = r8 + 1
            r1 = r7[r8]
            if (r6 < r9) goto L59
            int r6 = incompleteStateFor(r0, r1)
            return r6
        L59:
            r8 = 0
            goto L61
        L5b:
            int r6 = r6 >> 16
            byte r6 = (byte) r6
            r5 = r8
            r8 = r6
            r6 = r5
        L61:
            if (r8 != 0) goto L71
            int r8 = r6 + 1
            r6 = r7[r6]
            if (r8 < r9) goto L6e
            int r6 = incompleteStateFor(r0, r1, r6)
            return r6
        L6e:
            r5 = r8
            r8 = r6
            r6 = r5
        L71:
            if (r1 > r3) goto L84
            int r0 = r0 << 28
            int r1 = r1 + 112
            int r0 = r0 + r1
            int r0 = r0 >> 30
            if (r0 != 0) goto L84
            if (r8 > r3) goto L84
            int r8 = r6 + 1
            r6 = r7[r6]
            if (r6 <= r3) goto L85
        L84:
            return r2
        L85:
            int r6 = partialIsValidUtf8(r7, r8, r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.Utf8.partialIsValidUtf8(int, byte[], int, int):int");
    }

    public static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i2) {
            return 0;
        }
        return partialIsValidUtf8NonAscii(bArr, i, i2);
    }

    private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i2) {
        while (i < i2) {
            int i3 = i + 1;
            byte b = bArr[i];
            if (b < 0) {
                if (b < -32) {
                    if (i3 >= i2) {
                        return b;
                    }
                    if (b >= -62) {
                        i = i3 + 1;
                        if (bArr[i3] > -65) {
                        }
                    }
                    return -1;
                } else if (b >= -16) {
                    if (i3 >= i2 - 2) {
                        return incompleteStateFor(bArr, i3, i2);
                    }
                    int i4 = i3 + 1;
                    byte b2 = bArr[i3];
                    if (b2 <= -65 && (((b << Ascii.FS) + (b2 + 112)) >> 30) == 0) {
                        int i5 = i4 + 1;
                        if (bArr[i4] <= -65) {
                            i3 = i5 + 1;
                            if (bArr[i5] > -65) {
                            }
                        }
                    }
                    return -1;
                } else if (i3 >= i2 - 1) {
                    return incompleteStateFor(bArr, i3, i2);
                } else {
                    int i6 = i3 + 1;
                    byte b3 = bArr[i3];
                    if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                        i = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return -1;
                }
            }
            i = i3;
        }
        return 0;
    }

    private static int incompleteStateFor(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return incompleteStateFor(b, bArr[i], bArr[i + 1]);
                }
                throw new AssertionError();
            }
            return incompleteStateFor(b, bArr[i]);
        }
        return incompleteStateFor(b);
    }
}
