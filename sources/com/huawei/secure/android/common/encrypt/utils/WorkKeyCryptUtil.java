package com.huawei.secure.android.common.encrypt.utils;

import com.huawei.secure.android.common.encrypt.aes.AesCbc;

/* loaded from: classes8.dex */
public class WorkKeyCryptUtil {
    private WorkKeyCryptUtil() {
    }

    public static String PlaceComponentResult(String str, RootKeyUtil rootKeyUtil) {
        return AesCbc.PlaceComponentResult(str, rootKeyUtil.getAuthRequestContext());
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str, byte[] bArr) {
        return AesCbc.getAuthRequestContext(str, bArr);
    }

    public static String PlaceComponentResult(String str, byte[] bArr) {
        return AesCbc.PlaceComponentResult(str, bArr);
    }
}
