package com.apiguard3.internal;

/* loaded from: classes3.dex */
public final class setBackgroundTintBlendMode {
    public static int AGState = 0;
    public static int valueOf;
    public static int values;
    public static final Object getSharedInstance = new Object();
    private static int APIGuard = 0;
    private static int analyzeResponse = (APIGuard + 63) % 128;

    public static void values(int[] iArr) {
        analyzeResponse = (APIGuard + 19) % 128;
        int i = 0;
        while (true) {
            if ((i < iArr.length / 2 ? 'b' : 'Z') != 'b') {
                return;
            }
            APIGuard = (analyzeResponse + 29) % 128;
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
            i++;
        }
    }

    public static int valueOf(int i) {
        analyzeResponse = (APIGuard + 5) % 128;
        setBackgroundColor setbackgroundcolor = setBackgroundColor.valueOf;
        int i2 = setbackgroundcolor.APIGuard[0][i >>> 24];
        int i3 = setbackgroundcolor.APIGuard[1][(i >>> 16) & 255];
        int i4 = setbackgroundcolor.APIGuard[2][(i >>> 8) & 255];
        int i5 = setbackgroundcolor.APIGuard[3][i & 255];
        int i6 = analyzeResponse + 109;
        APIGuard = i6 % 128;
        if ((i6 % 2 != 0 ? (char) 31 : (char) 29) != 31) {
            return ((i2 + i3) ^ i4) + i5;
        }
        throw null;
    }
}
