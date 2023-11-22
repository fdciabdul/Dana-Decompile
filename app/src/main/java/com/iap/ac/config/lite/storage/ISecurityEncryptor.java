package com.iap.ac.config.lite.storage;

/* loaded from: classes3.dex */
public interface ISecurityEncryptor {

    /* loaded from: classes8.dex */
    public static class Mock implements ISecurityEncryptor {
        @Override // com.iap.ac.config.lite.storage.ISecurityEncryptor
        public String decrypt(String str) {
            return str;
        }

        @Override // com.iap.ac.config.lite.storage.ISecurityEncryptor
        public String encrypt(String str) {
            return str;
        }
    }

    String decrypt(String str);

    String encrypt(String str);
}
