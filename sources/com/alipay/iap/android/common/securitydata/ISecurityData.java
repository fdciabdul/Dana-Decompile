package com.alipay.iap.android.common.securitydata;

/* loaded from: classes6.dex */
public interface ISecurityData {
    boolean clear();

    boolean delete(String str);

    String fetch(String str);

    boolean save(String str, String str2);

    String securityDecrypt(String str);

    String securityEncrypt(String str);
}
