package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.utils.Util;
import java.util.UUID;

/* loaded from: classes8.dex */
public class o {
    public static String MyBillsEntityDataFactory(Context context) {
        String obj;
        SharedPreferences.Editor edit;
        synchronized (o.class) {
            PushPreferences pushPreferences = new PushPreferences(context, "aaid");
            if (!pushPreferences.getAuthRequestContext("aaid")) {
                obj = UUID.randomUUID().toString();
                pushPreferences.MyBillsEntityDataFactory("aaid", obj);
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                SharedPreferences sharedPreferences = pushPreferences.getAuthRequestContext;
                if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
                    edit.putLong("creationTime", valueOf.longValue()).commit();
                }
            } else {
                SharedPreferences sharedPreferences2 = pushPreferences.getAuthRequestContext;
                obj = "";
                if (sharedPreferences2 != null) {
                    obj = sharedPreferences2.getString("aaid", "");
                }
            }
        }
        return obj;
    }

    public static String PlaceComponentResult(Context context) {
        PushPreferences pushPreferences = new PushPreferences(context, "aaid");
        if (pushPreferences.getAuthRequestContext("aaid")) {
            SharedPreferences sharedPreferences = pushPreferences.getAuthRequestContext;
            return sharedPreferences != null ? sharedPreferences.getString("aaid", "") : "";
        }
        return null;
    }

    public static TokenReq BuiltInFictitiousFunctionClassFactory(Context context) {
        SharedPreferences.Editor edit;
        TokenReq tokenReq = new TokenReq();
        tokenReq.setPackageName(context.getPackageName());
        tokenReq.setAppId(null);
        tokenReq.setScope(null);
        tokenReq.setProjectId(null);
        tokenReq.setSubjectId(null);
        tokenReq.setMultiSender(false);
        if (TextUtils.isEmpty(null)) {
            tokenReq.setAppId(Util.getAppId(context));
        }
        if (TextUtils.isEmpty(null)) {
            tokenReq.setProjectId(AGConnectServicesConfig.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory("client/project_id"));
        }
        if (TextUtils.isEmpty(null)) {
            tokenReq.setScope("HCM");
        }
        i BuiltInFictitiousFunctionClassFactory = i.BuiltInFictitiousFunctionClassFactory(context);
        if (!BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2("hasRequestAgreement")) {
            tokenReq.setFirstTime(true);
            SharedPreferences sharedPreferences = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
            if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
                edit.putBoolean("hasRequestAgreement", true).commit();
            }
        } else {
            tokenReq.setFirstTime(false);
        }
        return tokenReq;
    }
}
