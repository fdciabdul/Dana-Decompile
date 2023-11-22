package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;

/* loaded from: classes8.dex */
public class bf {
    private static bf BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private Context PlaceComponentResult;

    private bf(Context context) {
        this.PlaceComponentResult = context.getApplicationContext();
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return com.xiaomi.push.j.MyBillsEntityDataFactory.contains("xmsf") || com.xiaomi.push.j.MyBillsEntityDataFactory.contains("xiaomi") || com.xiaomi.push.j.MyBillsEntityDataFactory.contains("miui");
    }

    public static Uri PlaceComponentResult() {
        return Settings.Global.getUriFor("device_provisioned");
    }

    public static bf PlaceComponentResult(Context context) {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new bf(context);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final int MyBillsEntityDataFactory() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 0) {
            return i;
        }
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Settings.Global.getInt(this.PlaceComponentResult.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
