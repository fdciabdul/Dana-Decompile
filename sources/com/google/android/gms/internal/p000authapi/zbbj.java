package com.google.android.gms.internal.p000authapi;

import android.util.Base64;
import java.security.SecureRandom;

/* loaded from: classes3.dex */
public final class zbbj {
    private static final SecureRandom zba = new SecureRandom();

    public static String zba() {
        byte[] bArr = new byte[16];
        zba.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
