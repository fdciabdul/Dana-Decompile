package com.huawei.hms.opendevice;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class p {
    public static String PlaceComponentResult;

    private static long BuiltInFictitiousFunctionClassFactory(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    private static String BuiltInFictitiousFunctionClassFactory() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            bufferedReader.close();
                            inputStreamReader.close();
                            fileInputStream.close();
                            return "";
                        }
                        String trim = readLine.trim();
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        return trim;
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            HMSLog.e("CommFun", "get current app processes IOException!");
            return "";
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("get current app processes exception!");
            sb.append(e.getMessage());
            HMSLog.e("CommFun", sb.toString());
            return "";
        }
    }

    public static boolean MyBillsEntityDataFactory(Context context) {
        return PlaceComponentResult() && HwBuildEx.VERSION.EMUI_SDK_INT < 21 && BuiltInFictitiousFunctionClassFactory(context) < 110001400;
    }

    public static String PlaceComponentResult(Context context) {
        String parent;
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.createDeviceProtectedStorageContext().getDataDir());
            parent = sb.toString();
        } else {
            parent = context.getFilesDir().getParent();
        }
        if (TextUtils.isEmpty(parent)) {
            HMSLog.e("CommFun", "get storage root path of the current user failed.");
        }
        return parent;
    }

    public static boolean PlaceComponentResult() {
        int i = HwBuildEx.VERSION.EMUI_SDK_INT;
        StringBuilder sb = new StringBuilder();
        sb.append("Emui Api Level:");
        sb.append(i);
        HMSLog.d("CommFun", sb.toString());
        return i > 0;
    }

    public static String getAuthRequestContext(Context context) {
        if (!TextUtils.isEmpty(PlaceComponentResult)) {
            return PlaceComponentResult;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        String str = "";
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
                int myPid = Process.myPid();
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid && next.processName != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("info.pid -> ");
                        sb.append(next.pid);
                        sb.append(", info.processName -> ");
                        sb.append(next.processName);
                        HMSLog.i("CommFun", sb.toString());
                        str = next.processName;
                        break;
                    }
                }
            } else {
                HMSLog.w("CommFun", "get running app processes null!");
            }
        }
        PlaceComponentResult = str;
        if (!TextUtils.isEmpty(str)) {
            return PlaceComponentResult;
        }
        String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
        return BuiltInFictitiousFunctionClassFactory;
    }
}
