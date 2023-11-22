package com.alipay.plus.android.config.sdk.storage;

/* loaded from: classes7.dex */
public interface ISecurityEncryptor {

    /* loaded from: classes7.dex */
    public static class Mock implements ISecurityEncryptor {
        @Override // com.alipay.plus.android.config.sdk.storage.ISecurityEncryptor
        public String decrypt(String str) {
            return str;
        }

        @Override // com.alipay.plus.android.config.sdk.storage.ISecurityEncryptor
        public String encrypt(String str) {
            return str;
        }
    }

    String decrypt(String str);

    String encrypt(String str);
}
