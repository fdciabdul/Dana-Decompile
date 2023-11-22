package com.alipay.iap.android.aplog.api;

/* loaded from: classes3.dex */
public interface LogEncryptClient {
    String decrypt(String str);

    byte[] decrypt(byte[] bArr);

    String encrypt(String str);

    byte[] encrypt(byte[] bArr);
}
