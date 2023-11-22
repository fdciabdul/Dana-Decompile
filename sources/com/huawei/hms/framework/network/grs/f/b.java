package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class b {
    public a MyBillsEntityDataFactory;
    private static final Map<String, b> PlaceComponentResult = new ConcurrentHashMap(16);
    private static final Object BuiltInFictitiousFunctionClassFactory = new Object();

    public b(Context context, GrsBaseInfo grsBaseInfo) {
        PlaceComponentResult(context);
        Map<String, b> map = PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(grsBaseInfo.uniqueCode());
        map.put(sb.toString(), this);
    }

    public static b BuiltInFictitiousFunctionClassFactory(String str, GrsBaseInfo grsBaseInfo) {
        Map<String, b> map = PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(grsBaseInfo.uniqueCode());
        return map.get(sb.toString());
    }

    public static void MyBillsEntityDataFactory(Context context, GrsBaseInfo grsBaseInfo) {
        b BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(context.getPackageName(), grsBaseInfo);
        if (BuiltInFictitiousFunctionClassFactory2 != null) {
            Logger.i("LocalManagerProxy", "appGrs is not null and clear services.");
            synchronized (BuiltInFictitiousFunctionClassFactory) {
                BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory.PlaceComponentResult();
            }
        }
    }

    private void PlaceComponentResult(Context context) {
        String[] list = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
        List<String> arrayList = list == null ? new ArrayList<>() : Arrays.asList(list);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        StringBuilder sb = new StringBuilder();
        sb.append("appConfigName is");
        sb.append(appConfigName);
        Logger.i("LocalManagerProxy", sb.toString());
        this.MyBillsEntityDataFactory = new d(true);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.MyBillsEntityDataFactory = new d(context, appConfigName, true);
        }
        if (!this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.MyBillsEntityDataFactory = new c(context, true);
        }
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(context, arrayList);
    }

    public final String getAuthRequestContext(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2) {
        synchronized (BuiltInFictitiousFunctionClassFactory) {
            String authRequestContext = this.MyBillsEntityDataFactory.getAuthRequestContext(context, aVar, grsBaseInfo, str, str2);
            if (TextUtils.isEmpty(authRequestContext) && this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory()) {
                PlaceComponentResult(context);
                this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(grsBaseInfo);
                Map<String, b> map = PlaceComponentResult;
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append(grsBaseInfo.uniqueCode());
                map.put(sb.toString(), this);
                return this.MyBillsEntityDataFactory.getAuthRequestContext(context, aVar, grsBaseInfo, str, str2);
            }
            return authRequestContext;
        }
    }

    public final Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        synchronized (BuiltInFictitiousFunctionClassFactory) {
            Map<String, String> MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(context, aVar, grsBaseInfo, str, z);
            if ((MyBillsEntityDataFactory == null || MyBillsEntityDataFactory.isEmpty()) && this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory()) {
                PlaceComponentResult(context);
                this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(grsBaseInfo);
                Map<String, b> map = PlaceComponentResult;
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append(grsBaseInfo.uniqueCode());
                map.put(sb.toString(), this);
                return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(context, aVar, grsBaseInfo, str, z);
            }
            return MyBillsEntityDataFactory;
        }
    }
}
