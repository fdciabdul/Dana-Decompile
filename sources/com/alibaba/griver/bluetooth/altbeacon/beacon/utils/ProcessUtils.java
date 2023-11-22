package com.alibaba.griver.bluetooth.altbeacon.beacon.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import id.dana.danah5.akulaku.AkuEventParamsKey;

/* loaded from: classes6.dex */
public class ProcessUtils {
    Context mContext;

    public ProcessUtils(Context context) {
        this.mContext = context;
    }

    public String getProcessName() {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) this.mContext.getSystemService(AkuEventParamsKey.KEY_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == getPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public String getPackageName() {
        return this.mContext.getApplicationContext().getPackageName();
    }

    public int getPid() {
        return Process.myPid();
    }

    public boolean isMainProcess() {
        return getPackageName().equals(getProcessName());
    }
}
