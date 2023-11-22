package com.alipay.plus.security.lite;

/* loaded from: classes3.dex */
public class SecurityGuardLiteNative {
    static {
        System.loadLibrary("g1a381");
    }

    public native String decrypt(String str, String str2) throws Throwable;

    public native String encrypt(String str, String str2) throws Throwable;

    public native int init(String str, String str2, String str3);

    public native String signRequest(String str, String str2, String str3, int i);
}
