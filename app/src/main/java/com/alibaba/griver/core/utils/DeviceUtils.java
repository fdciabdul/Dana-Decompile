package com.alibaba.griver.core.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.alibaba.griver.base.common.env.GriverEnv;
import id.dana.danah5.akulaku.AkuEventParamsKey;

/* loaded from: classes3.dex */
public class DeviceUtils {
    public static final int DEVICE_DEFAULT = 1;
    public static final int DEVICE_HIGH = 3;
    public static final int DEVICE_LOW = 1;
    public static final int DEVICE_MIDDLE = 2;
    public static final int DINFO_NO_INIT = -100;
    public static final int DINFO_UNKNOWN = -1;

    /* renamed from: a  reason: collision with root package name */
    private static long f6477a = 3221225472L;
    private static long b = -100;
    private static long c = 0;
    static long sAliveRamSize = -100;
    static long sRamSize = -100;

    static {
        a();
    }

    public static int getDeviceLevel() {
        if (b == -100) {
            a();
        }
        long j = b;
        if (j == 0 || j == -1 || Build.VERSION.SDK_INT < 23) {
            return 1;
        }
        long j2 = b;
        if (j2 >= 3221225472L) {
            return j2 < f6477a ? 2 : 3;
        }
        return 1;
    }

    private static void a() {
        b = getTotalMemory(GriverEnv.getApplicationContext());
    }

    public static long getTotalMemory(Context context) {
        long j = sRamSize;
        if (j == -1) {
            return j;
        }
        if (j == -100) {
            synchronized (DeviceUtils.class) {
                try {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY)).getMemoryInfo(memoryInfo);
                    sRamSize = memoryInfo.totalMem;
                } catch (Throwable unused) {
                    sRamSize = -1L;
                }
            }
        }
        return sRamSize;
    }

    public static long getAliveMemory(Context context) {
        if (sAliveRamSize == -1 || SystemClock.elapsedRealtime() - c < 60000) {
            return sAliveRamSize;
        }
        synchronized (DeviceUtils.class) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY)).getMemoryInfo(memoryInfo);
                sAliveRamSize = memoryInfo.availMem;
            } catch (Throwable unused) {
                sAliveRamSize = -1L;
            }
            c = SystemClock.elapsedRealtime();
        }
        return sAliveRamSize;
    }
}
