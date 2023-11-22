package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.config.impl.c;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes7.dex */
public abstract class AGConnectServicesConfig implements AGConnectOptions {
    private static final Map<String, AGConnectServicesConfig> MyBillsEntityDataFactory = new HashMap();
    private static final Object getAuthRequestContext = new Object();

    public static AGConnectServicesConfig PlaceComponentResult(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return getAuthRequestContext(context, context.getPackageName());
    }

    public static AGConnectServicesConfig getAuthRequestContext(Context context, String str) {
        AGConnectServicesConfig aGConnectServicesConfig;
        synchronized (getAuthRequestContext) {
            Map<String, AGConnectServicesConfig> map = MyBillsEntityDataFactory;
            aGConnectServicesConfig = map.get(str);
            if (aGConnectServicesConfig == null) {
                aGConnectServicesConfig = new c(context, str);
                map.put(str, aGConnectServicesConfig);
            }
        }
        return aGConnectServicesConfig;
    }
}
