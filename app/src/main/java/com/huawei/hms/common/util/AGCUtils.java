package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.agconnect.config.impl.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;

/* loaded from: classes7.dex */
public class AGCUtils {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r13, java.lang.String r14) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "Get "
            java.lang.String r2 = "AGCUtils"
            r3 = 0
            com.huawei.agconnect.AGConnectOptionsBuilder r4 = new com.huawei.agconnect.AGConnectOptionsBuilder     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            r4.<init>()     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            android.content.res.Resources r5 = r13.getResources()     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            java.lang.String r6 = "agconnect-services.json"
            java.io.InputStream r3 = r5.open(r6)     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            r4.BuiltInFictitiousFunctionClassFactory = r3     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            com.huawei.agconnect.config.impl.b r12 = new com.huawei.agconnect.config.impl.b     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            java.lang.String r7 = r4.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            com.huawei.agconnect.AGCRoutePolicy r8 = r4.PlaceComponentResult     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            java.io.InputStream r9 = r4.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            java.util.Map<java.lang.String, java.lang.String> r10 = r4.getAuthRequestContext     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            java.util.List<com.huawei.agconnect.core.Service> r11 = r4.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            r5 = r12
            r6 = r13
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            java.lang.String r13 = r12.BuiltInFictitiousFunctionClassFactory(r14)     // Catch: java.lang.Throwable -> L32 java.lang.NullPointerException -> L34 java.io.IOException -> L50
            goto L6c
        L32:
            r13 = move-exception
            goto L90
        L34:
            r13 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r4.<init>()     // Catch: java.lang.Throwable -> L32
            r4.append(r1)     // Catch: java.lang.Throwable -> L32
            r4.append(r14)     // Catch: java.lang.Throwable -> L32
            java.lang.String r1 = " with AGConnectServicesConfig failed: "
            r4.append(r1)     // Catch: java.lang.Throwable -> L32
            r4.append(r13)     // Catch: java.lang.Throwable -> L32
            java.lang.String r13 = r4.toString()     // Catch: java.lang.Throwable -> L32
            com.huawei.hms.support.log.HMSLog.e(r2, r13)     // Catch: java.lang.Throwable -> L32
            goto L6b
        L50:
            r13 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r4.<init>()     // Catch: java.lang.Throwable -> L32
            r4.append(r1)     // Catch: java.lang.Throwable -> L32
            r4.append(r14)     // Catch: java.lang.Throwable -> L32
            java.lang.String r1 = " failed: "
            r4.append(r1)     // Catch: java.lang.Throwable -> L32
            r4.append(r13)     // Catch: java.lang.Throwable -> L32
            java.lang.String r13 = r4.toString()     // Catch: java.lang.Throwable -> L32
            com.huawei.hms.support.log.HMSLog.e(r2, r13)     // Catch: java.lang.Throwable -> L32
        L6b:
            r13 = r0
        L6c:
            com.huawei.hms.utils.IOUtils.closeQuietly(r3)
            boolean r1 = android.text.TextUtils.isEmpty(r13)
            if (r1 != 0) goto L76
            return r13
        L76:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r1 = "The "
            r13.append(r1)
            r13.append(r14)
            java.lang.String r14 = " is null."
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.huawei.hms.support.log.HMSLog.e(r2, r13)
            return r0
        L90:
            com.huawei.hms.utils.IOUtils.closeQuietly(r3)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.AGCUtils.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String b(Context context) {
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get("com.huawei.hms.client.cpid")) != null) {
                String valueOf = String.valueOf(obj);
                return valueOf.startsWith("cpid=") ? valueOf.substring(5) : valueOf;
            }
            HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        } catch (RuntimeException e) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.", e);
            return "";
        }
    }

    public static boolean c(Context context) {
        return context.getPackageName().equals(HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService());
    }

    public static String getAppId(Context context) {
        String str;
        if (c(context)) {
            str = a(context, "client/app_id");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        } else {
            str = null;
        }
        try {
            AGConnectInstance KClassImpl$Data$declaredNonStaticMembers$2 = AGConnectInstance.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory() != context) {
                AGConnectOptionsBuilder aGConnectOptionsBuilder = new AGConnectOptionsBuilder();
                KClassImpl$Data$declaredNonStaticMembers$2 = AGConnectInstance.getAuthRequestContext(new b(context, aGConnectOptionsBuilder.KClassImpl$Data$declaredNonStaticMembers$2, aGConnectOptionsBuilder.PlaceComponentResult, aGConnectOptionsBuilder.BuiltInFictitiousFunctionClassFactory, aGConnectOptionsBuilder.getAuthRequestContext, aGConnectOptionsBuilder.MyBillsEntityDataFactory));
            }
            str = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory("client/app_id");
        } catch (NullPointerException unused) {
            HMSLog.e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        }
        if (TextUtils.isEmpty(str)) {
            String a2 = a(context);
            return !TextUtils.isEmpty(a2) ? a2 : a(context, "client/app_id");
        }
        return str;
    }

    public static String getCpId(Context context) {
        String str;
        if (c(context)) {
            return a(context, "client/cp_id");
        }
        try {
            AGConnectInstance KClassImpl$Data$declaredNonStaticMembers$2 = AGConnectInstance.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory() != context) {
                AGConnectOptionsBuilder aGConnectOptionsBuilder = new AGConnectOptionsBuilder();
                KClassImpl$Data$declaredNonStaticMembers$2 = AGConnectInstance.getAuthRequestContext(new b(context, aGConnectOptionsBuilder.KClassImpl$Data$declaredNonStaticMembers$2, aGConnectOptionsBuilder.PlaceComponentResult, aGConnectOptionsBuilder.BuiltInFictitiousFunctionClassFactory, aGConnectOptionsBuilder.getAuthRequestContext, aGConnectOptionsBuilder.MyBillsEntityDataFactory));
            }
            str = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory("client/cp_id");
        } catch (NullPointerException unused) {
            HMSLog.e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            String b = b(context);
            return !TextUtils.isEmpty(b) ? b : a(context, "client/cp_id");
        }
        return str;
    }

    public static String a(Context context) {
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get("com.huawei.hms.client.appid")) != null) {
                String valueOf = String.valueOf(obj);
                return valueOf.startsWith("appid=") ? valueOf.substring(6) : valueOf;
            }
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (RuntimeException e) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.", e);
            return "";
        }
    }
}
