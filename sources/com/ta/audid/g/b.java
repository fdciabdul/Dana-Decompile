package com.ta.audid.g;

/* loaded from: classes.dex */
public class b {
    public static long a(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (255 & bArr[3]);
    }
}
