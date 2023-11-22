package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectApp;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class a extends AGConnectApp {
    private static final Map<String, AGConnectApp> BuiltInFictitiousFunctionClassFactory = new HashMap();
    private static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
    private static String getAuthRequestContext;
    private AGConnectServicesConfig PlaceComponentResult;

    private a(Context context, String str) {
        this.PlaceComponentResult = AGConnectServicesConfig.getAuthRequestContext(context, str);
    }

    private static AGConnectApp KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        AGConnectApp aGConnectApp;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName can not be empty");
        }
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            Map<String, AGConnectApp> map = BuiltInFictitiousFunctionClassFactory;
            aGConnectApp = map.get(str);
            if (aGConnectApp == null) {
                map.put(str, new a(context, str));
            }
        }
        return aGConnectApp;
    }

    public static AGConnectApp getAuthRequestContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String packageName = context.getPackageName();
        getAuthRequestContext = packageName;
        return KClassImpl$Data$declaredNonStaticMembers$2(context, packageName);
    }
}
