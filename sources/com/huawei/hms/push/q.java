package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Date;
import java.util.List;

/* loaded from: classes8.dex */
public class q {
    public static String BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("get the app name of package:");
            sb.append(str);
            sb.append(" failed.");
            HMSLog.i("PushSelfShowLog", sb.toString());
            return null;
        }
    }

    public static boolean BuiltInFictitiousFunctionClassFactory() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static Intent MyBillsEntityDataFactory(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" not have launch activity");
            HMSLog.w("PushSelfShowLog", sb.toString());
            return null;
        }
    }

    public static boolean PlaceComponentResult(Context context, String str) {
        if (context != null && str != null && !"".equals(str)) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" is installed");
                HMSLog.d("PushSelfShowLog", sb.toString());
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean getAuthRequestContext() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2() {
        return MyBillsEntityDataFactory() ? 67108864 : 134217728;
    }

    private static boolean MyBillsEntityDataFactory() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static Boolean MyBillsEntityDataFactory(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                int size = queryIntentActivities.size();
                for (int i = 0; i < size; i++) {
                    if (queryIntentActivities.get(i).activityInfo != null && str.equals(queryIntentActivities.get(i).activityInfo.applicationInfo.packageName)) {
                        return Boolean.TRUE;
                    }
                }
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", e.toString(), e);
        }
        return Boolean.FALSE;
    }

    public static long PlaceComponentResult(String str) {
        if (str == null) {
            str = "";
        }
        try {
            Date date = new Date();
            int hours = (date.getHours() * 2) + (date.getMinutes() / 30);
            String concat = str.concat(str);
            StringBuilder sb = new StringBuilder();
            sb.append("startIndex is ");
            sb.append(hours);
            sb.append(",ap is:");
            sb.append(concat);
            sb.append(",length is:");
            sb.append(concat.length());
            HMSLog.i("PushSelfShowLog", sb.toString());
            int length = concat.length();
            for (int i = hours; i < length; i++) {
                if (concat.charAt(i) != '0') {
                    long minutes = (((i - hours) * 30) - (date.getMinutes() % 30)) * 60000;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("startIndex is:");
                    sb2.append(hours);
                    sb2.append(" i is:");
                    sb2.append(i);
                    sb2.append(" delay:");
                    sb2.append(minutes);
                    HMSLog.d("PushSelfShowLog", sb2.toString());
                    if (minutes >= 0) {
                        return minutes;
                    }
                    return 0L;
                }
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "error ", e);
        }
        return 0L;
    }

    public static void PlaceComponentResult(Context context, Intent intent, long j) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("enter setAPDelayAlarm(interval:");
            sb.append(j);
            sb.append("ms.");
            HMSLog.d("PushSelfShowLog", sb.toString());
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager != null) {
                alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() / 1000), intent, MyBillsEntityDataFactory() ? 67108864 : 134217728));
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("set DelayAlarm error");
            sb2.append(e.toString());
            HMSLog.w("PushSelfShowLog", sb2.toString());
        }
    }

    public static boolean PlaceComponentResult(Context context) {
        return "com.huawei.hwid".equals(context.getPackageName());
    }

    public static void getAuthRequestContext(Context context, int i) {
        if (context == null) {
            HMSLog.e("PushSelfShowLog", HummerZCodeConstant.CONTEXT_ERROR_MSG);
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(i);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeNotifiCationById err:");
            sb.append(e.toString());
            HMSLog.e("PushSelfShowLog", sb.toString());
        }
    }

    public static void MyBillsEntityDataFactory(Context context, Intent intent) {
        try {
            int intExtra = intent.getIntExtra("selfshow_auto_clear_id", 0);
            StringBuilder sb = new StringBuilder();
            sb.append("setDelayAlarm(cancel) alarmNotityId ");
            sb.append(intExtra);
            HMSLog.d("PushSelfShowLog", sb.toString());
            if (intExtra == 0) {
                return;
            }
            Intent intent2 = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
            intent2.setPackage(context.getPackageName()).setFlags(32);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, intExtra, intent2, getAuthRequestContext() ? 603979776 : 536870912);
            if (broadcast != null && alarmManager != null) {
                HMSLog.d("PushSelfShowLog", "alarm cancel");
                alarmManager.cancel(broadcast);
                return;
            }
            HMSLog.d("PushSelfShowLog", "alarm not exist");
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("cancelAlarm err:");
            sb2.append(e.toString());
            HMSLog.e("PushSelfShowLog", sb2.toString());
        }
    }
}
