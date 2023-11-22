package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.utils.ha.PushAnalyticsCenter;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class e {
    public static final String PlaceComponentResult = "e";

    public static void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    public static void getAuthRequestContext(Context context, String str, String str2, String str3) {
        PushProxy pushProxy;
        if (PushAnalyticsCenter.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("sdkVer", "60500300");
        bundle.putString("pkgName", context.getPackageName());
        bundle.putString("aaid", com.huawei.hms.opendevice.o.MyBillsEntityDataFactory(HmsInstanceId.getAuthRequestContext(context).PlaceComponentResult));
        pushProxy = ProxyCenter.a.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (pushProxy != null) {
            bundle.putString("proxyType", pushProxy.KClassImpl$Data$declaredNonStaticMembers$2());
        }
        bundle.putString("msgId", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("analyticInfo", str2);
        }
        String str4 = PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append("eventId:");
        sb.append(str3);
        HMSLog.i(str4, sb.toString());
    }
}
