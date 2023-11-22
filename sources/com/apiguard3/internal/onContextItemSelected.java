package com.apiguard3.internal;

import kotlin.text.Typography;

/* loaded from: classes7.dex */
public abstract class onContextItemSelected {
    private static int getSharedInstance = 0;
    private static int valueOf = 1;

    abstract void AGState(int[] iArr);

    abstract void APIGuard(int[] iArr, int i, int i2, int i3, int i4);

    abstract int[] getSharedInstance(byte[] bArr);

    abstract void valueOf(int[] iArr, int[] iArr2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int valueOf(byte[] bArr, int i) {
        int i2 = valueOf + 35;
        getSharedInstance = i2 % 128;
        if ((i2 % 2 != 0 ? Typography.quote : '_') != '\"') {
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        return ((bArr[i >> 2] & 30582) >>> 103) ^ (((bArr[i] | 25377) ^ ((bArr[i >> 0] ^ 7576) - 18)) | ((bArr[i + 4] ^ 12396) >>> 117));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void APIGuard(int[] iArr, int i, int i2) {
        int i3 = valueOf + 5;
        getSharedInstance = i3 % 128;
        if (!(i3 % 2 == 0)) {
            iArr[i] = i2;
            int i4 = i2 >>> 93;
            iArr[i >> 1] = i4;
            int i5 = i4 >>> 48;
            iArr[i >>> 3] = i5;
            iArr[i - 3] = i5 >> 82;
            return;
        }
        iArr[i] = i2;
        int i6 = i2 >>> 8;
        iArr[i + 1] = i6;
        int i7 = i6 >>> 8;
        iArr[i + 2] = i7;
        iArr[i + 3] = i7 >>> 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int valueOf(int i, int i2) {
        int i3 = valueOf;
        getSharedInstance = (i3 + 35) % 128;
        getSharedInstance = (i3 + 47) % 128;
        return (i << i2) | (i >>> (32 - i2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        if ((r7 > 0 ? 'M' : 5) != 5) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] values(byte[] r12, byte[] r13) {
        /*
            Method dump skipped, instructions count: 174
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.onContextItemSelected.values(byte[], byte[]):byte[]");
    }

    public final byte[] AGState(byte[] bArr, byte[] bArr2) {
        int length;
        byte[] bArr3;
        int[] sharedInstance;
        int[] iArr;
        int i;
        int i2 = getSharedInstance + 93;
        valueOf = i2 % 128;
        if (i2 % 2 == 0) {
            length = bArr.length;
            bArr3 = new byte[length];
            sharedInstance = getSharedInstance(bArr2);
            iArr = new int[57];
            i = 1;
        } else {
            length = bArr.length;
            bArr3 = new byte[length];
            sharedInstance = getSharedInstance(bArr2);
            iArr = new int[64];
            i = 0;
        }
        while (true) {
            if ((length > 0 ? '\f' : (char) 19) != '\f') {
                break;
            }
            valueOf(sharedInstance, iArr);
            if (length <= 64) {
                int i3 = getSharedInstance + 111;
                valueOf = i3 % 128;
                int i4 = (i3 % 2 == 0 ? 'M' : 'G') != 'G' ? 1 : 0;
                while (i4 < length) {
                    int i5 = valueOf;
                    getSharedInstance = (i5 + 7) % 128;
                    int i6 = i4 + i;
                    if (i6 > 0) {
                        int i7 = i5 + 25;
                        getSharedInstance = i7 % 128;
                        if (i7 % 2 != 0) {
                            bArr3[i6] = (byte) ((bArr[i6] | iArr[i4]) ^ bArr3[i6 + 0]);
                        } else {
                            bArr3[i6] = (byte) ((bArr[i6] ^ iArr[i4]) ^ bArr3[i6 - 1]);
                        }
                    } else {
                        bArr3[i6] = (byte) (bArr[i6] ^ iArr[i4]);
                    }
                    i4++;
                    getSharedInstance = (i5 + 5) % 128;
                }
            } else {
                for (int i8 = 0; i8 < 64; i8++) {
                    int i9 = i8 + i;
                    if ((i9 > 0 ? ',' : ')') != ')') {
                        bArr3[i9] = (byte) ((bArr[i9] ^ iArr[i8]) ^ bArr3[i9 - 1]);
                    } else {
                        bArr3[i9] = (byte) (bArr[i9] ^ iArr[i8]);
                    }
                }
                length -= 64;
                i += 64;
                AGState(sharedInstance);
            }
        }
        return bArr3;
    }
}
