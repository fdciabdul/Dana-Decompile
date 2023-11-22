package com.huawei.hms.framework.common;

import android.content.Context;

/* loaded from: classes7.dex */
public class ContextHolder {
    private static Context KClassImpl$Data$declaredNonStaticMembers$2;
    private static Context PlaceComponentResult;

    public static Context getAppContext() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static Context getResourceContext() {
        if (getKitContext() != null) {
            return getKitContext();
        }
        return getAppContext();
    }

    public static Context getKitContext() {
        return PlaceComponentResult;
    }

    public static void setAppContext(Context context) {
        CheckParamUtils.checkNotNull(context, "sAppContext == null");
        KClassImpl$Data$declaredNonStaticMembers$2 = context.getApplicationContext();
    }

    public static void setKitContext(Context context) {
        CheckParamUtils.checkNotNull(context, "sKitContext == null");
        PlaceComponentResult = context;
    }
}
