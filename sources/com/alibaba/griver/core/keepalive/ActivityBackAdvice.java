package com.alibaba.griver.core.keepalive;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Handler;
import androidx.core.app.ActivityOptionsCompat;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.R;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.util.List;

/* loaded from: classes3.dex */
public class ActivityBackAdvice {
    public static boolean moveTaskToBack(final Activity activity, int i, boolean z) {
        if (activity == null || i == -1) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) activity.getApplication().getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        if (a(activity, i, activityManager, activityManager.getRunningTasks(Integer.MAX_VALUE), z)) {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: com.alibaba.griver.core.keepalive.ActivityBackAdvice.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        activity.moveTaskToBack(false);
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("moveTaskToFront error");
                        sb.append(th);
                        GriverLogger.e("ActivityBackAdvice", sb.toString());
                    }
                }
            });
            return true;
        }
        return false;
    }

    private static boolean a(Activity activity, int i, ActivityManager activityManager, List<ActivityManager.RunningTaskInfo> list, boolean z) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : list) {
            if (i == runningTaskInfo.id) {
                moveTaskToFront(activityManager, activity, runningTaskInfo, z);
                return true;
            }
        }
        return false;
    }

    public static void moveTaskToFront(final ActivityManager activityManager, final Activity activity, final ActivityManager.RunningTaskInfo runningTaskInfo, final boolean z) {
        if (runningTaskInfo == null) {
            return;
        }
        new Handler(activity.getMainLooper()).post(new Runnable() { // from class: com.alibaba.griver.core.keepalive.ActivityBackAdvice.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ActivityBackAdvice.a(activityManager, activity, runningTaskInfo, z);
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("moveTaskToFront error");
                    sb.append(th);
                    GriverLogger.e("ActivityBackAdvice", sb.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ActivityManager activityManager, Activity activity, ActivityManager.RunningTaskInfo runningTaskInfo, boolean z) {
        if (z) {
            activityManager.moveTaskToFront(runningTaskInfo.id, 0, ActivityOptionsCompat.PlaceComponentResult(activity, R.anim.griver_core_app_exit_scale, R.anim.griver_core_app_exit_down_out).MyBillsEntityDataFactory());
            return;
        }
        activityManager.moveTaskToFront(runningTaskInfo.id, 0);
    }
}
