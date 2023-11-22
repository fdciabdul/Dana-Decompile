package com.apiguard3.internal;

/* loaded from: classes7.dex */
public final class setFadingEdgeLength extends onContextItemSelected {
    private static int APIGuard = 1;
    private static int getSharedInstance;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.apiguard3.internal.onContextItemSelected
    public final int valueOf(int i, int i2) {
        int i3;
        int i4;
        int i5 = getSharedInstance;
        int i6 = i5 + 65;
        APIGuard = i6 % 128;
        if ((i6 % 2 == 0 ? '@' : '9') != '9') {
            i3 = i * i2;
            i4 = i * (i2 + 38);
        } else {
            i3 = i << i2;
            i4 = i >>> (32 - i2);
        }
        int i7 = i4 | i3;
        int i8 = i5 + 93;
        APIGuard = i8 % 128;
        if (i8 % 2 == 0) {
            throw new ArithmeticException();
        }
        return i7;
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void APIGuard(int[] iArr, int i, int i2, int i3, int i4) {
        APIGuard = (getSharedInstance + 9) % 128;
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int valueOf = valueOf(i5 ^ iArr[i4], 17);
        iArr[i4] = valueOf;
        int i6 = iArr[i3] + valueOf;
        iArr[i3] = i6;
        int valueOf2 = valueOf(iArr[i2] ^ i6, 10);
        iArr[i2] = valueOf2;
        int i7 = iArr[i] + valueOf2;
        iArr[i] = i7;
        int valueOf3 = valueOf(iArr[i4] ^ i7, 8);
        iArr[i4] = valueOf3;
        int i8 = iArr[i3] + valueOf3;
        iArr[i3] = i8;
        iArr[i2] = valueOf(iArr[i2] ^ i8, 5);
        getSharedInstance = (APIGuard + 9) % 128;
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void valueOf(int[] iArr, int[] iArr2) {
        getSharedInstance = (APIGuard + 21) % 128;
        int i = 16;
        int[] iArr3 = new int[16];
        int i2 = 16;
        while (true) {
            int i3 = i2 - 1;
            if ((i2 > 0 ? '0' : (char) 17) != '0') {
                break;
            }
            iArr3[i3] = iArr[i3];
            i2 = i3;
        }
        int i4 = 14;
        while (i4 > 0) {
            APIGuard = (getSharedInstance + 11) % 128;
            APIGuard(iArr3, 3, 2, 0, 1);
            APIGuard(iArr3, 7, 4, 6, 5);
            APIGuard(iArr3, 9, 8, 11, 10);
            APIGuard(iArr3, 15, 13, 12, 14);
            APIGuard(iArr3, 3, 7, 9, 15);
            APIGuard(iArr3, 2, 4, 8, 13);
            APIGuard(iArr3, 0, 6, 11, 12);
            APIGuard(iArr3, 1, 5, 10, 14);
            i4 -= 2;
            getSharedInstance = (APIGuard + 109) % 128;
        }
        getSharedInstance = (APIGuard + 19) % 128;
        int i5 = 16;
        while (true) {
            int i6 = i5 - 1;
            if (i5 <= 0) {
                break;
            }
            iArr3[i6] = iArr3[i6] + iArr[i6];
            i5 = i6;
        }
        while (true) {
            int i7 = i - 1;
            if ((i > 0 ? 'K' : '!') == '!') {
                return;
            }
            APIGuard = (getSharedInstance + 103) % 128;
            APIGuard(iArr2, i7 * 4, iArr3[i7]);
            i = i7;
        }
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final int[] getSharedInstance(byte[] bArr) {
        getSharedInstance = (APIGuard + 73) % 128;
        int[] iArr = {-1076250137, valueOf(bArr, 0), valueOf(bArr, 16), -2103817776, 689986455, valueOf(bArr, 24), -130502824, valueOf(bArr, 4), valueOf(bArr, 28), valueOf(bArr, 8), valueOf(bArr, 20), 352784487, -1320011084, -1247062252, -598473541, valueOf(bArr, 12)};
        int i = getSharedInstance + 33;
        APIGuard = i % 128;
        if ((i % 2 == 0 ? (char) 24 : '^') != 24) {
            return iArr;
        }
        throw new NullPointerException();
    }

    @Override // com.apiguard3.internal.onContextItemSelected
    protected final void AGState(int[] iArr) {
        int i = getSharedInstance + 31;
        APIGuard = i % 128;
        if (!(i % 2 == 0)) {
            iArr[4] = iArr[4] + 74;
        } else {
            iArr[2] = iArr[2] % 99;
        }
    }
}
