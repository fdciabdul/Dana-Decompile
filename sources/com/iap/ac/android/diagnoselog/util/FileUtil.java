package com.iap.ac.android.diagnoselog.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class FileUtil {
    public static String a(Context context) {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        FileInputStream fileInputStream;
        int myPid = Process.myPid();
        if (context == null || myPid <= 0) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        FileInputStream fileInputStream2 = null;
        if (activityManager != null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runningAppProcessInfo = null;
                            break;
                        }
                        runningAppProcessInfo = it.next();
                        if (runningAppProcessInfo.pid == myPid) {
                            break;
                        }
                    }
                    if (runningAppProcessInfo != null) {
                        return runningAppProcessInfo.processName;
                    }
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("getProcessNameInternal exception:");
                sb.append(e.getMessage());
                LoggerWrapper.e("ProcessUtil", sb.toString());
            }
        }
        byte[] bArr = new byte[128];
        try {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("/proc/");
                sb2.append(myPid);
                sb2.append("/cmdline");
                fileInputStream = new FileInputStream(sb2.toString());
                try {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        for (int i = 0; i < read; i++) {
                            byte b = bArr[i];
                            if ((b & 255) > 128 || b <= 0) {
                                read = i;
                                break;
                            }
                        }
                        String str = new String(bArr, 0, read);
                        try {
                            fileInputStream.close();
                        } catch (Exception unused) {
                        }
                        return str;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("getProcessNameInternal exception:");
                    sb3.append(e.getMessage());
                    LoggerWrapper.e("ProcessUtil", sb3.toString());
                    if (fileInputStream2 != null) {
                        fileInputStream = fileInputStream2;
                        fileInputStream.close();
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
            try {
                fileInputStream.close();
            } catch (Exception unused3) {
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = fileInputStream2;
        }
    }
}
