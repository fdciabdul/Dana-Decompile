package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* loaded from: classes8.dex */
public class c {
    private static Context KClassImpl$Data$declaredNonStaticMembers$2;

    public static Context PlaceComponentResult() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static void getAuthRequestContext(Context context) {
        if (context == null || KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2 = context.getApplicationContext();
    }
}
