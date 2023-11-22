package com.alibaba.griver.beehive.lottie.util;

import android.app.ActivityManager;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.adapter.impl.ApplicationAapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.DeviceUtilsAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import id.dana.danah5.akulaku.AkuEventParamsKey;

/* loaded from: classes6.dex */
public class DeviceUtils {
    public static final int DEVICE_DEFAULT = 1;
    public static final int DEVICE_HIGH = 3;
    public static final int DEVICE_LOW = 1;
    public static final int DEVICE_MIDDLE = 2;
    private static final long LOW_MEM_GB = 3221225472L;
    private static long MIDDLE_MEM_GB = 3221225472L;
    private static final String TAG = "DeviceUtils";
    private static ActivityManager activityManager = null;
    private static long mTotalRam = -100;

    static {
        initDeviceInfo();
    }

    public static int getDeviceLevel() {
        if (mTotalRam == -100) {
            initDeviceInfo();
        }
        long j = mTotalRam;
        if (j == 0 || j == -1 || Build.VERSION.SDK_INT < 23) {
            return 1;
        }
        long j2 = mTotalRam;
        if (j2 >= LOW_MEM_GB) {
            return j2 < MIDDLE_MEM_GB ? 2 : 3;
        }
        return 1;
    }

    private static void initDeviceInfo() {
        mTotalRam = DeviceUtilsAdapter.getTotalMemory(ApplicationAapter.getApplicationContext());
        String configValue = SwitchConfigUtilsAdapter.getConfigValue("Android_lottieplayer_middle_mem_switch");
        if (TextUtils.isEmpty(configValue)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Android_lottieplayer_middle_mem_switch=");
        sb.append(configValue);
        GriverLogger.d("DeviceUtils", sb.toString());
        try {
            MIDDLE_MEM_GB = (long) (Double.parseDouble(configValue) * 1024.0d * 1024.0d * 1024.0d);
        } catch (Exception unused) {
        }
    }

    public static long getTotalRam() {
        if (mTotalRam == -100) {
            initDeviceInfo();
        }
        return mTotalRam;
    }

    public static ActivityManager.MemoryInfo getMemoryInfo() {
        try {
            if (activityManager == null) {
                activityManager = (ActivityManager) ApplicationAapter.getApplicationContext().getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            StringBuilder sb = new StringBuilder();
            sb.append("系统剩余内存:availMem=");
            sb.append(memoryInfo.availMem);
            sb.append(",lowMemory=");
            sb.append(memoryInfo.lowMemory);
            sb.append(",threshold=");
            sb.append(memoryInfo.threshold);
            GriverLogger.d("DeviceUtils", sb.toString());
            return memoryInfo;
        } catch (Exception e) {
            GriverLogger.e("DeviceUtils", "isLowMemory执行异常：", e);
            return null;
        }
    }
}
