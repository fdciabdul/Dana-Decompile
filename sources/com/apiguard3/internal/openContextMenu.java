package com.apiguard3.internal;

import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class openContextMenu extends onContextItemSelected {
    private static int getSharedInstance = 1;
    private static int values;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.apiguard3.internal.onContextItemSelected
    public final int valueOf(byte[] bArr, int i) {
        int i2 = (values + 51) % 128;
        getSharedInstance = i2;
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        values = (i2 + 125) % 128;
        return ((b4 & 255) << 24) | (b & 255) | ((b2 & 255) << 8) | ((b3 & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.apiguard3.internal.onContextItemSelected
    public final void APIGuard(int[] iArr, int i, int i2) {
        int i3 = values + 81;
        getSharedInstance = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 1 : (char) 17) != 1) {
            iArr[i] = i2;
            int i4 = i2 >>> 8;
            iArr[i + 1] = i4;
            int i5 = i4 >>> 8;
            iArr[i + 2] = i5;
            iArr[i + 3] = i5 >>> 8;
            return;
        }
        iArr[i] = i2;
        int i6 = i2 / 40;
        iArr[i + 0] = i6;
        int i7 = i6 * 89;
        iArr[i - 5] = i7;
        iArr[i + 4] = i7 * 64;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.apiguard3.internal.onContextItemSelected
    public final int valueOf(int i, int i2) {
        int i3 = (getSharedInstance + 87) % 128;
        values = i3;
        getSharedInstance = (i3 + 99) % 128;
        return (i << i2) | (i >>> (32 - i2));
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void APIGuard(int[] iArr, int i, int i2, int i3, int i4) {
        getSharedInstance = (values + 3) % 128;
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int valueOf = valueOf(i5 ^ iArr[i4], 18);
        iArr[i4] = valueOf;
        int i6 = iArr[i3] + valueOf;
        iArr[i3] = i6;
        int valueOf2 = valueOf(iArr[i2] ^ i6, 13);
        iArr[i2] = valueOf2;
        int i7 = iArr[i] + valueOf2;
        iArr[i] = i7;
        int valueOf3 = valueOf(iArr[i4] ^ i7, 11);
        iArr[i4] = valueOf3;
        int i8 = iArr[i3] + valueOf3;
        iArr[i3] = i8;
        iArr[i2] = valueOf(iArr[i2] ^ i8, 4);
        int i9 = getSharedInstance + 123;
        values = i9 % 128;
        if (i9 % 2 == 0) {
            return;
        }
        throw new ArithmeticException();
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void valueOf(int[] iArr, int[] iArr2) {
        int i = 16;
        int[] iArr3 = new int[16];
        int i2 = 16;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            iArr3[i3] = iArr[i3];
            getSharedInstance = (values + 19) % 128;
            i2 = i3;
        }
        int i4 = 22;
        while (true) {
            if ((i4 > 0 ? '\f' : Typography.less) == '<') {
                break;
            }
            APIGuard(iArr3, 3, 1, 0, 2);
            APIGuard(iArr3, 4, 5, 7, 6);
            APIGuard(iArr3, 10, 11, 9, 8);
            APIGuard(iArr3, 12, 15, 14, 13);
            APIGuard(iArr3, 0, 7, 11, 12);
            APIGuard(iArr3, 2, 6, 10, 14);
            APIGuard(iArr3, 3, 5, 9, 13);
            APIGuard(iArr3, 1, 4, 8, 15);
            i4 -= 2;
        }
        int i5 = 16;
        while (true) {
            int i6 = i5 - 1;
            if (i5 <= 0) {
                break;
            }
            int i7 = getSharedInstance + 1;
            values = i7 % 128;
            if (!(i7 % 2 != 0)) {
                iArr3[i6] = iArr3[i6] + iArr[i6];
            } else {
                iArr3[i6] = iArr3[i6] % iArr[i6];
            }
            i5 = i6;
        }
        while (true) {
            int i8 = i - 1;
            if ((i > 0 ? (char) 31 : 'X') == 'X') {
                return;
            }
            APIGuard(iArr2, i8 * 4, iArr3[i8]);
            i = i8;
        }
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final int[] getSharedInstance(byte[] bArr) {
        getSharedInstance = (values + 49) % 128;
        int[] iArr = {788219237, 1289391221, -1140365098, -263010167, 724521378, valueOf(bArr, 12), valueOf(bArr, 16), valueOf(bArr, 0), valueOf(bArr, 24), -2044206312, valueOf(bArr, 20), -1368185624, valueOf(bArr, 8), 885228236, valueOf(bArr, 28), valueOf(bArr, 4)};
        int i = values + 41;
        getSharedInstance = i % 128;
        if ((i % 2 == 0 ? 'R' : 'T') == 'T') {
            return iArr;
        }
        throw new ArithmeticException();
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void AGState(int[] iArr) {
        int i = (getSharedInstance + 89) % 128;
        values = i;
        iArr[15] = iArr[15] + 68;
        int i2 = i + 85;
        getSharedInstance = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return;
        }
        throw new ArithmeticException();
    }
}
