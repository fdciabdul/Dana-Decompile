package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaomi.push.ad;
import com.xiaomi.push.z;

/* loaded from: classes8.dex */
public class c {
    private static String BuiltInFictitiousFunctionClassFactory;
    private static String MyBillsEntityDataFactory;
    private static String PlaceComponentResult;
    private static final String[] getAuthRequestContext = {"--", "a-", "u-", "v-", "o-", "g-"};

    public static boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        PackageInfo packageInfo = (PackageInfo) z.getAuthRequestContext(context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        return packageInfo == null || packageInfo.applicationInfo == null || ((packageInfo.applicationInfo.flags & 2097152) == 2097152 && (packageInfo.applicationInfo.flags & 8388608) != 8388608);
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2() {
        Object PlaceComponentResult2 = z.PlaceComponentResult("android.os.UserHandle", "myUserId", new Object[0]);
        if (PlaceComponentResult2 == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(PlaceComponentResult2)).intValue();
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        }
        return false;
    }

    public static boolean PlaceComponentResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : getAuthRequestContext) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean getAuthRequestContext(Context context) {
        try {
            return !d.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("failure to read gaid limit:");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            return true;
        }
    }

    public static String getErrorConfigVersion(Context context) {
        String BuiltInFictitiousFunctionClassFactory2;
        synchronized (c.class) {
            BuiltInFictitiousFunctionClassFactory2 = ad.BuiltInFictitiousFunctionClassFactory(scheduleImpl(context));
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }

    public static String moveToNextValue(Context context) {
        synchronized (c.class) {
            String str = PlaceComponentResult;
            if (str != null) {
                return str;
            }
            String BuiltInFictitiousFunctionClassFactory2 = ad.BuiltInFictitiousFunctionClassFactory(scheduleImpl(context));
            PlaceComponentResult = BuiltInFictitiousFunctionClassFactory2;
            return BuiltInFictitiousFunctionClassFactory2;
        }
    }

    private static String scheduleImpl(Context context) {
        String str = MyBillsEntityDataFactory;
        if (str != null) {
            return str;
        }
        try {
            MyBillsEntityDataFactory = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("failure to get androidId: ");
            sb.append(th);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
        return MyBillsEntityDataFactory;
    }

    public static String PlaceComponentResult(Context context) {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            String scheduleImpl = scheduleImpl(context);
            StringBuilder sb = new StringBuilder();
            String[] strArr = getAuthRequestContext;
            sb.append(5 >= strArr.length ? strArr[0] : strArr[5]);
            sb.append(ad.BuiltInFictitiousFunctionClassFactory(scheduleImpl));
            BuiltInFictitiousFunctionClassFactory = sb.toString();
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static String MyBillsEntityDataFactory(Context context) {
        if (getAuthRequestContext(context)) {
            try {
                return d.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("failure to get gaid:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                return null;
            }
        }
        return null;
    }
}
