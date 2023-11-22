package com.huawei.hms.hatool;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes8.dex */
public class g0 {
    public static String KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        String packageName = context.getPackageName();
        String initRecordTimeStamp = c.initRecordTimeStamp("_hms_config_tag", "oper");
        if (TextUtils.isEmpty(initRecordTimeStamp)) {
            StringBuilder sb = new StringBuilder();
            sb.append("hms_");
            sb.append(str);
            sb.append("_");
            sb.append(packageName);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("hms_");
        sb2.append(str);
        sb2.append("_");
        sb2.append(packageName);
        sb2.append("_");
        sb2.append(initRecordTimeStamp);
        return sb2.toString();
    }

    public static long getAuthRequestContext(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            y.moveToNextValue("hmsSdk", "context is null or spName empty or spkey is empty");
            return -1L;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(KClassImpl$Data$declaredNonStaticMembers$2(context, str), 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str2, -1L);
        }
        return -1L;
    }

    public static String MyBillsEntityDataFactory(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            y.moveToNextValue("hmsSdk", "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(KClassImpl$Data$declaredNonStaticMembers$2(context, str), 0);
        return sharedPreferences != null ? sharedPreferences.getString(str2, str3) : str3;
    }

    public static Map<String, ?> PlaceComponentResult(Context context, String str) {
        return context.getSharedPreferences(KClassImpl$Data$declaredNonStaticMembers$2(context, str), 0).getAll();
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String... strArr) {
        if (context == null || TextUtils.isEmpty(str)) {
            y.moveToNextValue("hmsSdk", "clearData(): parameter error.context,spname");
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(KClassImpl$Data$declaredNonStaticMembers$2(context, str), 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (strArr.length == 0) {
                edit.clear();
                edit.commit();
                return;
            }
            for (String str2 : strArr) {
                if (sharedPreferences.contains(str2)) {
                    edit.remove(str2);
                    edit.commit();
                }
            }
        }
    }

    public static void MyBillsEntityDataFactory(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            y.moveToNextValue("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(KClassImpl$Data$declaredNonStaticMembers$2(context, str), 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(str2, j);
            edit.commit();
        }
    }

    public static void getAuthRequestContext(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            y.PlaceComponentResult("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(KClassImpl$Data$declaredNonStaticMembers$2(context, str), 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }
}
