package com.huawei.hms.push.utils;

import android.content.Context;
import com.huawei.hms.push.e;

/* loaded from: classes8.dex */
public class PluginUtil {
    public static void PlaceComponentResult(Context context, String str, String str2) {
        e.getAuthRequestContext(context, str, str2, "1");
        e.getAuthRequestContext(context, str, str2, "appHasOpenedId");
        e.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
