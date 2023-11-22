package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;

/* loaded from: classes8.dex */
public class RootKeyUtil {
    private static final String PlaceComponentResult = "RootKeyUtil";
    private byte[] getAuthRequestContext = null;

    private RootKeyUtil() {
    }

    public static RootKeyUtil BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, String str4) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        byte[] authRequestContext = HexUtil.getAuthRequestContext(str4);
        if (Build.VERSION.SDK_INT < 26) {
            b.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, "initRootKey: sha1");
            rootKeyUtil.getAuthRequestContext = BaseKeyUtil.PlaceComponentResult(str, str2, str3, authRequestContext, false);
        } else {
            b.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, "initRootKey: sha256");
            rootKeyUtil.getAuthRequestContext = BaseKeyUtil.PlaceComponentResult(str, str2, str3, authRequestContext, true);
        }
        return rootKeyUtil;
    }

    public final byte[] getAuthRequestContext() {
        return (byte[]) this.getAuthRequestContext.clone();
    }
}
