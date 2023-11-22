package com.alipay.plus.android.config.sdk.storage;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public class SimpleSecurityEncryptor implements ISecurityEncryptor {
    @Override // com.alipay.plus.android.config.sdk.storage.ISecurityEncryptor
    public String decrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 6);
        }
        return str;
    }

    @Override // com.alipay.plus.android.config.sdk.storage.ISecurityEncryptor
    public String encrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 6);
        }
        return str;
    }
}
