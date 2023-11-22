package com.alibaba.ariver.kernel.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.exthub.common.ExtHubLogger;
import id.dana.danah5.akulaku.AkuEventParamsKey;

/* loaded from: classes2.dex */
public class ProcessUtils {
    public static final String ACTIVITY_THREAD = "android.app.ActivityThread";
    public static final String CURRENT_ACTIVITY_THREAD = "currentActivityThread";
    public static final String GET_PROCESS_NAME = "getProcessName";

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f6163a;
    private static Boolean b;
    private static Context c;
    private static String d;

    public static void setAppContext(Context context) {
        c = context;
    }

    public static Context getContext() {
        Context context = c;
        if (context != null) {
            return context;
        }
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService != null) {
            return rVEnvironmentService.getApplicationContext();
        }
        return null;
    }

    public static int getPid() {
        return Process.myPid();
    }

    public static String getProcessName() {
        String str;
        try {
            str = d;
        } catch (Exception e) {
            ExtHubLogger.e("AriverKernel", "getProcessName error", e);
        }
        if (str != null && str.length() > 0) {
            return d;
        }
        try {
            d = (String) ReflectUtils.invokeMethod(ReflectUtils.invokeMethod(ACTIVITY_THREAD, CURRENT_ACTIVITY_THREAD), GET_PROCESS_NAME);
            StringBuilder sb = new StringBuilder();
            sb.append("getProcessName from ActivityThread: ");
            sb.append(d);
            ExtHubLogger.d("AriverKernel", sb.toString());
        } catch (Throwable th) {
            ExtHubLogger.e("AriverKernel", "getProcessName error!", th);
        }
        if (d == null) {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    d = runningAppProcessInfo.processName;
                }
            }
        }
        return d;
    }

    public static boolean isMainProcess() {
        if (isInTestProcess()) {
            return true;
        }
        if (f6163a == null) {
            Context context = getContext();
            if (context == null) {
                ExtHubLogger.w("AriverKernel", "Context is null in isMainProcess()");
                return true;
            }
            String processName = getProcessName();
            f6163a = Boolean.valueOf(context != null && TextUtils.equals(processName, context.getPackageName()));
            StringBuilder sb = new StringBuilder();
            sb.append("isMainProcess ");
            sb.append(f6163a);
            sb.append(" processName: ");
            sb.append(processName);
            sb.append(" stack: ");
            sb.append(Log.getStackTraceString(new Throwable("Just Print!")));
            ExtHubLogger.d("AriverKernel", sb.toString());
        }
        return f6163a.booleanValue();
    }

    public static boolean isInTestProcess() {
        return "robolectric".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean isTinyProcess() {
        if (b == null) {
            String processName = getProcessName();
            b = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.contains("lite"));
        }
        return b.booleanValue();
    }
}
