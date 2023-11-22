package com.huawei.hms.hatool;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes8.dex */
public abstract class f {

    /* loaded from: classes8.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static String MyBillsEntityDataFactory(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get("CHANNEL")) != null) {
                String obj2 = obj.toString();
                if (obj2.length() <= 256) {
                    return obj2;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            y.moveToNextValue("hmsSdk", "getChannel(): The packageName is not correct!");
        }
        return "Unknown";
    }

    private static Object PlaceComponentResult(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return getAuthRequestContext(Class.forName(str), str2, clsArr, objArr);
        } catch (a unused) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            y.moveToNextValue("hmsSdk", str3);
            return null;
        } catch (ClassNotFoundException unused2) {
            str3 = "invokeStaticFun() Not found class!";
            y.moveToNextValue("hmsSdk", str3);
            return null;
        }
    }

    public static String PlaceComponentResult() {
        String PlaceComponentResult = PlaceComponentResult("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        StringBuilder sb = new StringBuilder();
        sb.append("SystemPropertiesEx: get rom_ver: ");
        sb.append(PlaceComponentResult);
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb.toString());
        if (TextUtils.isEmpty(PlaceComponentResult)) {
            String str = Build.DISPLAY;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SystemProperties: get rom_ver: ");
            sb2.append(str);
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb2.toString());
            return str;
        }
        return PlaceComponentResult;
    }

    private static String PlaceComponentResult(String str, String str2, String str3) {
        Object PlaceComponentResult = PlaceComponentResult(str, "get", new Class[]{String.class, String.class}, new Object[]{str2, str3});
        return PlaceComponentResult != null ? (String) PlaceComponentResult : str3;
    }

    private static Object getAuthRequestContext(Class cls, String str, Class[] clsArr, Object[] objArr) {
        String str2;
        if (cls == null) {
            throw new a("class is null in invokeStaticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new a("paramsType is null, but params is not null");
            }
        } else if (objArr == null) {
            throw new a("paramsType or params should be same");
        } else {
            if (clsArr.length != objArr.length) {
                StringBuilder sb = new StringBuilder();
                sb.append("paramsType len:");
                sb.append(clsArr.length);
                sb.append(" should equal params.len:");
                sb.append(objArr.length);
                throw new a(sb.toString());
            }
        }
        try {
            try {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException unused) {
                str2 = "invokeStaticFun(): method invoke Exception!";
                y.moveToNextValue("hmsSdk", str2);
                return null;
            } catch (IllegalArgumentException unused2) {
                str2 = "invokeStaticFun(): Illegal Argument!";
                y.moveToNextValue("hmsSdk", str2);
                return null;
            } catch (InvocationTargetException unused3) {
                str2 = "invokeStaticFun(): Invocation Target Exception!";
                y.moveToNextValue("hmsSdk", str2);
                return null;
            }
        } catch (NoSuchMethodException unused4) {
            y.moveToNextValue("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
        }
    }

    public static String getAuthRequestContext(Context context) {
        return context == null ? "" : Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2() {
        if (TextUtils.isEmpty("ro.build.version.emui")) {
            return "";
        }
        String PlaceComponentResult = PlaceComponentResult("android.os.SystemProperties", "ro.build.version.emui", "");
        return TextUtils.isEmpty(PlaceComponentResult) ? PlaceComponentResult("com.huawei.android.os.SystemPropertiesEx", "ro.build.version.emui", "") : PlaceComponentResult;
    }

    public static String PlaceComponentResult(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context == null ? "" : context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            y.moveToNextValue("hmsSdk", "getVersion(): The package name is not correct!");
            return "";
        }
    }
}
