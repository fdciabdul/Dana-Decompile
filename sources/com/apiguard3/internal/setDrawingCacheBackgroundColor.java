package com.apiguard3.internal;

/* loaded from: classes3.dex */
public final class setDrawingCacheBackgroundColor {
    private static int APIGuard = 0;
    private static int values = 1;

    public static void APIGuard(int i, int i2, boolean z, int i3, int[] iArr, int[][] iArr2, int[] iArr3) {
        int i4;
        int AGState;
        if ((!z ? '^' : '_') != '_') {
            int i5 = values + 33;
            APIGuard = i5 % 128;
            if (i5 % 2 != 0) {
                getSharedInstance(iArr);
                throw null;
            }
            getSharedInstance(iArr);
        }
        values = (APIGuard + 95) % 128;
        int i6 = 0;
        while (i6 < i3) {
            int i7 = APIGuard + 103;
            values = i7 % 128;
            if (i7 % 2 == 0) {
                i4 = i ^ iArr[i6];
                AGState = i2 | AGState(i4, iArr2);
                i6 += 73;
            } else {
                i4 = i ^ iArr[i6];
                AGState = i2 ^ AGState(i4, iArr2);
                i6++;
            }
            int i8 = AGState;
            i2 = i4;
            i = i8;
        }
        int i9 = iArr[iArr.length - 2];
        int i10 = iArr[iArr.length - 1];
        if ((!z) != false) {
            int i11 = APIGuard + 121;
            values = i11 % 128;
            if (!(i11 % 2 != 0)) {
                getSharedInstance(iArr);
                throw null;
            }
            getSharedInstance(iArr);
        }
        iArr3[0] = i2 ^ i10;
        iArr3[1] = i ^ i9;
    }

    private static void getSharedInstance(int[] iArr) {
        APIGuard = (values + 13) % 128;
        int i = 0;
        while (true) {
            if ((i < iArr.length / 2 ? '7' : 'B') != '7') {
                return;
            }
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
            i++;
            APIGuard = (values + 9) % 128;
        }
    }

    private static int AGState(int i, int[][] iArr) {
        int i2 = values;
        APIGuard = (i2 + 63) % 128;
        int i3 = iArr[0][i >>> 24];
        int i4 = iArr[1][(i >>> 16) & 255];
        int i5 = iArr[2][(i >>> 8) & 255];
        int i6 = iArr[3][i & 255];
        APIGuard = (i2 + 73) % 128;
        return ((i3 + i4) ^ i5) + i6;
    }
}
