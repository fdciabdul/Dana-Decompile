package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.base.log.a;
import com.huawei.hms.base.log.d;

/* loaded from: classes8.dex */
public class HMSLog {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7495a = new a();

    public static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
                StringBuilder sb = new StringBuilder();
                sb.append("HMS-");
                sb.append(packageInfo.versionName);
                sb.append("(");
                sb.append(packageInfo.versionCode);
                sb.append(")");
                return sb.toString();
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                return "HMS-[unknown-version]";
            }
        }
        return "HMS-[unknown-version]";
    }

    public static void d(String str, String str2) {
        f7495a.a(3, str, str2);
    }

    public static void e(String str, String str2) {
        f7495a.a(6, str, str2);
    }

    public static void i(String str, String str2) {
        f7495a.a(4, str, str2);
    }

    public static void init(Context context, int i, String str) {
        a aVar = f7495a;
        aVar.a(context, i, str);
        StringBuilder sb = new StringBuilder();
        sb.append("============================================================================");
        sb.append('\n');
        sb.append("====== ");
        sb.append(a(context));
        sb.append('\n');
        sb.append("============================================================================");
        aVar.a(str, sb.toString());
    }

    public static boolean isErrorEnable() {
        return f7495a.a(6);
    }

    public static boolean isInfoEnable() {
        return f7495a.a(4);
    }

    public static boolean isWarnEnable() {
        return f7495a.a(5);
    }

    public static void setExtLogger(HMSExtLogger hMSExtLogger, boolean z) throws IllegalArgumentException {
        if (hMSExtLogger != null) {
            d dVar = new d(hMSExtLogger);
            if (z) {
                f7495a.a(dVar);
                return;
            } else {
                f7495a.a().a(dVar);
                return;
            }
        }
        throw new IllegalArgumentException("extLogger is not able to be null");
    }

    public static void w(String str, String str2) {
        f7495a.a(5, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        f7495a.b(6, str, str2, th);
    }

    public static void e(String str, long j, String str2) {
        a aVar = f7495a;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(j);
        sb.append("] ");
        sb.append(str2);
        aVar.a(6, str, sb.toString());
    }

    public static void e(String str, long j, String str2, Throwable th) {
        a aVar = f7495a;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(j);
        sb.append("] ");
        sb.append(str2);
        aVar.b(6, str, sb.toString(), th);
    }
}
