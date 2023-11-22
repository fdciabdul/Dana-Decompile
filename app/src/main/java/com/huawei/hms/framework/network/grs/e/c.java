package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class c {
    private static final String MyBillsEntityDataFactory = "c";
    private static final Map<String, PLSharedPreferences> PlaceComponentResult = new ConcurrentHashMap(16);
    public final PLSharedPreferences KClassImpl$Data$declaredNonStaticMembers$2;

    public final Map<String, ?> KClassImpl$Data$declaredNonStaticMembers$2() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (pLSharedPreferences == null) {
            return new HashMap();
        }
        synchronized (pLSharedPreferences) {
            all = this.KClassImpl$Data$declaredNonStaticMembers$2.getAll();
        }
        return all;
    }

    public final String getAuthRequestContext(String str, String str2) {
        String string;
        PLSharedPreferences pLSharedPreferences = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (pLSharedPreferences == null) {
            return str2;
        }
        synchronized (pLSharedPreferences) {
            string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(str, str2);
        }
        return string;
    }

    public c(Context context, String str) {
        String packageName = context.getPackageName();
        Logger.d(MyBillsEntityDataFactory, "get pkgname from context is{%s}", packageName);
        Map<String, PLSharedPreferences> map = PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(packageName);
        if (map.containsKey(sb.toString())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(packageName);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = map.get(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(packageName);
            PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(context, sb3.toString());
            this.KClassImpl$Data$declaredNonStaticMembers$2 = pLSharedPreferences;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(packageName);
            map.put(sb4.toString(), pLSharedPreferences);
        }
        String str2 = MyBillsEntityDataFactory;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ContextHolder.getAppContext() from GRS is:");
        sb5.append(ContextHolder.getAppContext());
        Logger.i(str2, sb5.toString());
        context = ContextHolder.getAppContext() != null ? ContextHolder.getAppContext() : context;
        try {
            String l = Long.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
            String authRequestContext = getAuthRequestContext("version", "");
            if (l.equals(authRequestContext)) {
                return;
            }
            Logger.i(str2, "app version changed! old version{%s} and new version{%s}", authRequestContext, l);
            PLSharedPreferences pLSharedPreferences2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (pLSharedPreferences2 != null) {
                synchronized (pLSharedPreferences2) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
                }
            }
            PLSharedPreferences pLSharedPreferences3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (pLSharedPreferences3 != null) {
                synchronized (pLSharedPreferences3) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.putString("version", l);
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.w(MyBillsEntityDataFactory, "get app version failed and catch NameNotFoundException");
        }
    }
}
