package com.alipay.iap.android.f2fpay.util;

import android.util.Base64;

/* loaded from: classes3.dex */
public class Base64Utils {
    public static byte[] decode(String str) {
        return Base64.decode(str, 2);
    }

    public static String encodeToString(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }
}
