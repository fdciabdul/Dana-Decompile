package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.util.List;

/* loaded from: classes8.dex */
public class UIUtil {
    public static Activity getActiveActivity(Activity activity, Context context) {
        if (isBackground(context)) {
            StringBuilder sb = new StringBuilder();
            sb.append("isBackground");
            sb.append(isBackground(context));
            HMSLog.i("UIUtil", sb.toString());
            return null;
        } else if (activity == null) {
            HMSLog.i("UIUtil", "activity is null");
            return ActivityMgr.INST.getCurrentActivity();
        } else if (activity.isFinishing()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("activity isFinishing is ");
            sb2.append(activity.isFinishing());
            HMSLog.i("UIUtil", sb2.toString());
            return ActivityMgr.INST.getCurrentActivity();
        } else {
            return activity;
        }
    }

    public static String getProcessName(Context context, int i) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY)) != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == i) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static boolean isActivityFullscreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static boolean isBackground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return true;
        }
        String processName = getProcessName(context, Process.myPid());
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (TextUtils.equals(runningAppProcessInfo.processName, processName)) {
                StringBuilder sb = new StringBuilder();
                sb.append("appProcess.importance is ");
                sb.append(runningAppProcessInfo.importance);
                HMSLog.i("UIUtil", sb.toString());
                boolean z = runningAppProcessInfo.importance == 100;
                boolean isKeyguardLocked = keyguardManager.isKeyguardLocked();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isForground is ");
                sb2.append(z);
                sb2.append("***  isLockedState is ");
                sb2.append(isKeyguardLocked);
                HMSLog.i("UIUtil", sb2.toString());
                return !z || isKeyguardLocked;
            }
        }
        return true;
    }
}
