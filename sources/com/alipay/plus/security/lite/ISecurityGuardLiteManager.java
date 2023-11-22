package com.alipay.plus.security.lite;

/* loaded from: classes3.dex */
public interface ISecurityGuardLiteManager {
    String decrypt(String str) throws SecLiteException;

    String encrypt(String str) throws SecLiteException;

    String signRequest(SecurityGuardLiteParamContext securityGuardLiteParamContext, String str) throws SecLiteException;
}
