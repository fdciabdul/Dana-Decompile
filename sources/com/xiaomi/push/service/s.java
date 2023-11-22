package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class s {
    private static s PlaceComponentResult;
    Context BuiltInFictitiousFunctionClassFactory;
    List<String> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    final List<String> getAuthRequestContext = new ArrayList();
    final List<String> MyBillsEntityDataFactory = new ArrayList();

    private s(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.BuiltInFictitiousFunctionClassFactory = applicationContext;
        if (applicationContext == null) {
            this.BuiltInFictitiousFunctionClassFactory = context;
        }
        SharedPreferences sharedPreferences = this.BuiltInFictitiousFunctionClassFactory.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.getAuthRequestContext.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.MyBillsEntityDataFactory.add(str3);
            }
        }
    }

    public static s getAuthRequestContext(Context context) {
        if (PlaceComponentResult == null) {
            PlaceComponentResult = new s(context);
        }
        return PlaceComponentResult;
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        synchronized (this.MyBillsEntityDataFactory) {
            if (this.MyBillsEntityDataFactory.contains(str)) {
                this.MyBillsEntityDataFactory.remove(str);
                this.BuiltInFictitiousFunctionClassFactory.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.ad.PlaceComponentResult(this.MyBillsEntityDataFactory, ",")).commit();
            }
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        boolean contains;
        synchronized (this.getAuthRequestContext) {
            contains = this.getAuthRequestContext.contains(str);
        }
        return contains;
    }

    public final boolean MyBillsEntityDataFactory(String str) {
        boolean contains;
        synchronized (this.MyBillsEntityDataFactory) {
            contains = this.MyBillsEntityDataFactory.contains(str);
        }
        return contains;
    }

    public final void PlaceComponentResult(String str) {
        synchronized (this.getAuthRequestContext) {
            if (this.getAuthRequestContext.contains(str)) {
                this.getAuthRequestContext.remove(str);
                this.BuiltInFictitiousFunctionClassFactory.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.ad.PlaceComponentResult(this.getAuthRequestContext, ",")).commit();
            }
        }
    }

    public final boolean getAuthRequestContext(String str) {
        boolean contains;
        synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            contains = this.KClassImpl$Data$declaredNonStaticMembers$2.contains(str);
        }
        return contains;
    }
}
