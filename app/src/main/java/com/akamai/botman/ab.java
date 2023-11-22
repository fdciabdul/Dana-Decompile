package com.akamai.botman;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public final class ab {
    public static long KClassImpl$Data$declaredNonStaticMembers$2(long j, int i) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i2 = (int) j;
        int i3 = (int) (j >> 32);
        int i4 = 0;
        while (i4 < 16) {
            int i5 = i3 ^ (((i >>> (32 - i4)) | (i << i4)) ^ i2);
            i4++;
            int i6 = i2;
            i2 = i5;
            i3 = i6;
        }
        long j2 = i2;
        long uptimeMillis2 = SystemClock.uptimeMillis();
        StringBuilder sb = new StringBuilder("FeistelCipherEncode-Time: ");
        sb.append(uptimeMillis2 - uptimeMillis);
        sb.append("ms");
        ah.PlaceComponentResult("FeistelCipher", sb.toString(), new Throwable[0]);
        return (i3 << 32) | (4294967295L & j2);
    }
}
