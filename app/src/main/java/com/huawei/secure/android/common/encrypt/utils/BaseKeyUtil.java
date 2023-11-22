package com.huawei.secure.android.common.encrypt.utils;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;

/* loaded from: classes8.dex */
public class BaseKeyUtil {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "BaseKeyUtil";

    private static boolean MyBillsEntityDataFactory(int i) {
        return i >= 16;
    }

    private static boolean PlaceComponentResult(int i, byte[] bArr) {
        return MyBillsEntityDataFactory(i) & BuiltInFictitiousFunctionClassFactory(bArr);
    }

    public static byte[] PlaceComponentResult(String str, String str2, String str3, byte[] bArr, boolean z) {
        return BuiltInFictitiousFunctionClassFactory(str, str2, str3, bArr, 16, z);
    }

    private static byte[] BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, byte[] bArr, int i, boolean z) {
        return KClassImpl$Data$declaredNonStaticMembers$2(str, str2, str3, bArr, i, z);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(byte[] bArr) {
        return bArr.length >= 16;
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3, byte[] bArr, int i, boolean z) {
        byte[] authRequestContext = HexUtil.getAuthRequestContext(str);
        byte[] authRequestContext2 = HexUtil.getAuthRequestContext(str2);
        byte[] authRequestContext3 = HexUtil.getAuthRequestContext(str3);
        int length = authRequestContext.length;
        int length2 = authRequestContext2.length;
        int length3 = authRequestContext3.length;
        if (length2 < length) {
            length = length2;
        }
        if (length3 >= length) {
            length3 = length;
        }
        if (PlaceComponentResult(length3, bArr)) {
            char[] cArr = new char[length3];
            for (int i2 = 0; i2 < length3; i2++) {
                cArr[i2] = (char) ((authRequestContext[i2] ^ authRequestContext2[i2]) ^ authRequestContext3[i2]);
            }
            if (!z) {
                b.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "exportRootKey: sha1");
                return PBKDF2.getAuthRequestContext(cArr, bArr, i * 8);
            }
            b.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, "exportRootKey: sha256");
            return PBKDF2.BuiltInFictitiousFunctionClassFactory(cArr, bArr, i * 8);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }

    public static byte[] getAuthRequestContext(String str, String str2, String str3, String str4, boolean z) {
        return BuiltInFictitiousFunctionClassFactory(str, str2, str3, HexUtil.getAuthRequestContext(str4), 32, z);
    }
}
