package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.channel.commonutils.android.k;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.service.az;
import java.util.Locale;

/* loaded from: classes8.dex */
public class q {
    public final String BuiltInFictitiousFunctionClassFactory;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String MyBillsEntityDataFactory;
    public final int PlaceComponentResult;
    public final String getAuthRequestContext;
    public final String lookAheadTest;
    public final String moveToNextValue;

    public q(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.MyBillsEntityDataFactory = str4;
        this.lookAheadTest = str5;
        this.moveToNextValue = str6;
        this.PlaceComponentResult = i;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            return com.xiaomi.channel.commonutils.android.j.PlaceComponentResult(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean MyBillsEntityDataFactory(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private static String PlaceComponentResult(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (TextUtils.isEmpty(null)) {
                String KClassImpl$Data$declaredNonStaticMembers$2 = com.xiaomi.channel.commonutils.android.f.KClassImpl$Data$declaredNonStaticMembers$2("ro.miui.region");
                return TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$2) ? com.xiaomi.channel.commonutils.android.f.KClassImpl$Data$declaredNonStaticMembers$2("ro.product.locale.region") : KClassImpl$Data$declaredNonStaticMembers$2;
            }
            return null;
        }
        return com.xiaomi.channel.commonutils.android.f.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final az.b MyBillsEntityDataFactory(az.b bVar, Context context, j jVar, String str) {
        bVar.NetworkUserEntityData$$ExternalSyntheticLambda0 = context.getPackageName();
        bVar.DatabaseTableConfigUtil = this.BuiltInFictitiousFunctionClassFactory;
        bVar.isLayoutRequested = this.KClassImpl$Data$declaredNonStaticMembers$2;
        bVar.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.getAuthRequestContext;
        bVar.newProxyInstance = "5";
        bVar.NetworkUserEntityData$$ExternalSyntheticLambda1 = "XMPUSH-PASS";
        bVar.scheduleImpl = false;
        k.a aVar = new k.a();
        aVar.KClassImpl$Data$declaredNonStaticMembers$2(HiAnalyticsConstant.BI_KEY_SDK_VER, 48).KClassImpl$Data$declaredNonStaticMembers$2("cpvn", BuildConfig.VERSION_NAME).KClassImpl$Data$declaredNonStaticMembers$2("cpvc", Integer.valueOf((int) BuildConfig.VERSION_CODE)).KClassImpl$Data$declaredNonStaticMembers$2("country_code", a.BuiltInFictitiousFunctionClassFactory(context).PlaceComponentResult()).KClassImpl$Data$declaredNonStaticMembers$2("region", a.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2()).KClassImpl$Data$declaredNonStaticMembers$2("miui_vn", com.xiaomi.channel.commonutils.android.f.getErrorConfigVersion()).KClassImpl$Data$declaredNonStaticMembers$2("miui_vc", Integer.valueOf(com.xiaomi.channel.commonutils.android.f.getAuthRequestContext())).KClassImpl$Data$declaredNonStaticMembers$2("xmsf_vc", Integer.valueOf(com.xiaomi.channel.commonutils.android.a.KClassImpl$Data$declaredNonStaticMembers$2(context, "com.xiaomi.xmsf"))).KClassImpl$Data$declaredNonStaticMembers$2("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).KClassImpl$Data$declaredNonStaticMembers$2("n_belong_to_app", Boolean.valueOf(aq.getAuthRequestContext(context))).KClassImpl$Data$declaredNonStaticMembers$2("systemui_vc", Integer.valueOf(com.xiaomi.channel.commonutils.android.a.MyBillsEntityDataFactory(context)));
        String PlaceComponentResult = PlaceComponentResult(context);
        if (!TextUtils.isEmpty(PlaceComponentResult)) {
            aVar.KClassImpl$Data$declaredNonStaticMembers$2("latest_country_code", PlaceComponentResult);
        }
        bVar.GetContactSyncConfig = aVar.toString();
        String str2 = BuiltInFictitiousFunctionClassFactory(context) ? "1000271" : this.MyBillsEntityDataFactory;
        k.a aVar2 = new k.a();
        aVar2.KClassImpl$Data$declaredNonStaticMembers$2("appid", str2).KClassImpl$Data$declaredNonStaticMembers$2("locale", Locale.getDefault().toString()).KClassImpl$Data$declaredNonStaticMembers$2("sync", 1);
        if (MyBillsEntityDataFactory(context)) {
            aVar2.KClassImpl$Data$declaredNonStaticMembers$2("ab", str);
        }
        bVar.PrepareContext = aVar2.toString();
        bVar.getErrorConfigVersion = jVar;
        return bVar;
    }
}
