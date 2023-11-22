package com.huawei.hms.framework.common;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.util.List;

/* loaded from: classes7.dex */
public class ActivityUtil {
    public static boolean isForeground(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) ContextCompat.getSystemService(context, AkuEventParamsKey.KEY_ACTIVITY)) == null) {
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> list = null;
        try {
            list = activityManager.getRunningAppProcesses();
        } catch (RuntimeException e) {
            Logger.w("ActivityUtil", "activityManager getRunningAppProcesses occur exception: ", e);
        }
        if (list != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                if (runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                    Logger.v("ActivityUtil", "isForeground true");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2) {
        if (context == null) {
            Logger.w("ActivityUtil", HummerZCodeConstant.CONTEXT_ERROR_MSG);
            return null;
        }
        try {
            return PendingIntent.getActivities(context, i, intentArr, i2);
        } catch (RuntimeException e) {
            Logger.e("ActivityUtil", "dealType rethrowFromSystemServer:", e);
            return null;
        }
    }
}
