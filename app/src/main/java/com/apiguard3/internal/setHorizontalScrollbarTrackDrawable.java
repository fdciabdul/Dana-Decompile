package com.apiguard3.internal;

/* loaded from: classes7.dex */
public final class setHorizontalScrollbarTrackDrawable extends onContextItemSelected {
    private static int APIGuard = 1;
    private static int values;

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void APIGuard(int[] iArr, int i, int i2, int i3, int i4) {
        APIGuard = (values + 5) % 128;
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int valueOf = valueOf(i5 ^ iArr[i4], 7);
        iArr[i4] = valueOf;
        int i6 = iArr[i3] + valueOf;
        iArr[i3] = i6;
        int valueOf2 = valueOf(iArr[i2] ^ i6, 5);
        iArr[i2] = valueOf2;
        int i7 = iArr[i] + valueOf2;
        iArr[i] = i7;
        int valueOf3 = valueOf(iArr[i4] ^ i7, 15);
        iArr[i4] = valueOf3;
        int i8 = iArr[i3] + valueOf3;
        iArr[i3] = i8;
        iArr[i2] = valueOf(iArr[i2] ^ i8, 14);
        int i9 = values + 33;
        APIGuard = i9 % 128;
        if (i9 % 2 == 0) {
            throw new NullPointerException();
        }
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final int[] getSharedInstance(byte[] bArr) {
        APIGuard = (values + 69) % 128;
        int[] iArr = {valueOf(bArr, 24), 1084384731, valueOf(bArr, 0), valueOf(bArr, 4), -691363443, 1757941256, valueOf(bArr, 16), valueOf(bArr, 8), 1288772461, -533505181, valueOf(bArr, 20), -990770722, valueOf(bArr, 12), -204142500, valueOf(bArr, 28), 2118679623};
        APIGuard = (values + 13) % 128;
        return iArr;
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void valueOf(int[] iArr, int[] iArr2) {
        int i = 16;
        int[] iArr3 = new int[16];
        APIGuard = (values + 65) % 128;
        int i2 = 16;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            values = (APIGuard + 73) % 128;
            iArr3[i3] = iArr[i3];
            i2 = i3;
        }
        values = (APIGuard + 21) % 128;
        int i4 = 20;
        while (true) {
            if (!(i4 > 0)) {
                break;
            }
            APIGuard = (values + 47) % 128;
            APIGuard(iArr3, 3, 0, 2, 1);
            APIGuard(iArr3, 5, 7, 4, 6);
            APIGuard(iArr3, 9, 11, 8, 10);
            APIGuard(iArr3, 14, 12, 13, 15);
            APIGuard(iArr3, 3, 5, 9, 14);
            APIGuard(iArr3, 0, 7, 11, 12);
            APIGuard(iArr3, 2, 4, 8, 13);
            APIGuard(iArr3, 1, 6, 10, 15);
            i4 -= 2;
            values = (APIGuard + 29) % 128;
        }
        int i5 = 16;
        while (true) {
            int i6 = i5 - 1;
            if (!(i5 > 0)) {
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
            APIGuard(iArr2, i7 * 4, iArr3[i7]);
            i = i7;
        }
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void AGState(int[] iArr) {
        int i = (APIGuard + 75) % 128;
        values = i;
        iArr[1] = iArr[1] + 59;
        APIGuard = (i + 35) % 128;
    }
}
