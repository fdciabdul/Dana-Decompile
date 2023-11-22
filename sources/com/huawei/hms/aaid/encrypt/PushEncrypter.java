package com.huawei.hms.aaid.encrypt;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.c;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;

/* loaded from: classes7.dex */
public class PushEncrypter {
    public static String BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : AesCbc.BuiltInFictitiousFunctionClassFactory(str, c.KClassImpl$Data$declaredNonStaticMembers$2(context));
    }

    public static String MyBillsEntityDataFactory(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : AesCbc.PlaceComponentResult(str, c.KClassImpl$Data$declaredNonStaticMembers$2(context));
    }
}
