package com.apiguard3.internal;

/* loaded from: classes7.dex */
public final class registerForContextMenu extends onContextItemSelected {
    private static int getSharedInstance = 1;
    private static int values;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.apiguard3.internal.onContextItemSelected
    public final int valueOf(int i, int i2) {
        int i3;
        int i4;
        int i5 = getSharedInstance + 59;
        values = i5 % 128;
        if (!(i5 % 2 == 0)) {
            i3 = i >>> i2;
            i4 = i - (41 / i2);
        } else {
            i3 = i << i2;
            i4 = i >>> (32 - i2);
        }
        return i4 | i3;
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void APIGuard(int[] iArr, int i, int i2, int i3, int i4) {
        values = (getSharedInstance + 73) % 128;
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int valueOf = valueOf(i5 ^ iArr[i4], 15);
        iArr[i4] = valueOf;
        int i6 = iArr[i3] + valueOf;
        iArr[i3] = i6;
        int valueOf2 = valueOf(iArr[i2] ^ i6, 10);
        iArr[i2] = valueOf2;
        int i7 = iArr[i] + valueOf2;
        iArr[i] = i7;
        int valueOf3 = valueOf(iArr[i4] ^ i7, 6);
        iArr[i4] = valueOf3;
        int i8 = iArr[i3] + valueOf3;
        iArr[i3] = i8;
        iArr[i2] = valueOf(iArr[i2] ^ i8, 9);
        getSharedInstance = (values + 1) % 128;
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void valueOf(int[] iArr, int[] iArr2) {
        values = (getSharedInstance + 109) % 128;
        int i = 16;
        int[] iArr3 = new int[16];
        int i2 = 16;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            iArr3[i3] = iArr[i3];
            i2 = i3;
        }
        int i4 = 16;
        while (true) {
            if ((i4 > 0 ? '5' : '`') == '`') {
                break;
            }
            getSharedInstance = (values + 67) % 128;
            APIGuard(iArr3, 2, 0, 1, 3);
            APIGuard(iArr3, 5, 4, 7, 6);
            APIGuard(iArr3, 10, 9, 8, 11);
            APIGuard(iArr3, 12, 13, 15, 14);
            APIGuard(iArr3, 2, 5, 10, 12);
            APIGuard(iArr3, 0, 4, 9, 13);
            APIGuard(iArr3, 1, 7, 8, 15);
            APIGuard(iArr3, 3, 6, 11, 14);
            i4 -= 2;
        }
        int i5 = 16;
        while (true) {
            int i6 = i5 - 1;
            if ((i5 > 0 ? (char) 31 : '@') != 31) {
                break;
            }
            iArr3[i6] = iArr3[i6] + iArr[i6];
            i5 = i6;
        }
        while (true) {
            int i7 = i - 1;
            if (i <= 0) {
                return;
            }
            getSharedInstance = (values + 39) % 128;
            APIGuard(iArr2, i7 * 4, iArr3[i7]);
            i = i7;
        }
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final int[] getSharedInstance(byte[] bArr) {
        values = (getSharedInstance + 7) % 128;
        int[] iArr = {1028213265, 885417151, valueOf(bArr, 12), -96508859, valueOf(bArr, 8), valueOf(bArr, 20), valueOf(bArr, 0), valueOf(bArr, 4), 1913507172, valueOf(bArr, 28), valueOf(bArr, 16), 220856283, valueOf(bArr, 24), 260493787, -1057634678, 397208795};
        int i = values + 75;
        getSharedInstance = i % 128;
        if (i % 2 == 0) {
            throw new NullPointerException();
        }
        return iArr;
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void AGState(int[] iArr) {
        int i = (getSharedInstance + 25) % 128;
        values = i;
        iArr[7] = iArr[7] + 82;
        int i2 = i + 111;
        getSharedInstance = i2 % 128;
        if (i2 % 2 == 0) {
            throw new NullPointerException();
        }
    }
}
