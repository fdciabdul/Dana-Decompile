package com.iap.ac.config.lite.storage;

import android.text.TextUtils;

/* loaded from: classes8.dex */
public class SimpleSecurityEncryptor implements ISecurityEncryptor {
    @Override // com.iap.ac.config.lite.storage.ISecurityEncryptor
    public String decrypt(String str) {
        if (str == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 6);
        }
        return new String(bytes);
    }

    @Override // com.iap.ac.config.lite.storage.ISecurityEncryptor
    public String encrypt(String str) {
        if (str == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 6);
        }
        return new String(bytes);
    }
}
