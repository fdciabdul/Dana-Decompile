package com.alibaba.griver.beehive.lottie.adapter.impl;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes6.dex */
public class DeviceUtilsAdapter {
    public static final int DINFO_NO_INIT = -100;
    public static final int DINFO_UNKNOWN = -1;
    public static final String TAG = "DeviceUtilsAdapter";
    static int sCoreNum = -100;
    static String sCpuName = "-1";
    static int sFrequency = -100;
    static long sRamSize = -100;

    public static long getTotalMemory(Context context) {
        long j;
        long j2 = sRamSize;
        if (j2 == -1) {
            return j2;
        }
        if (j2 == -100) {
            synchronized (DeviceUtilsAdapter.class) {
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        ((ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY)).getMemoryInfo(memoryInfo);
                        sRamSize = memoryInfo.totalMem;
                    } else {
                        try {
                            FileInputStream fileInputStream = new FileInputStream("/proc/meminfo");
                            try {
                                j = parseFileForValue("MemTotal", fileInputStream) * ConvertUtils.KB;
                                try {
                                } catch (IOException e) {
                                    e = e;
                                    GriverLogger.e(TAG, "getTotalMemory", e);
                                    sRamSize = j;
                                    return sRamSize;
                                }
                            } finally {
                                fileInputStream.close();
                            }
                        } catch (IOException e2) {
                            e = e2;
                            j = -1;
                        }
                        sRamSize = j;
                    }
                } catch (Throwable unused) {
                    sRamSize = -1L;
                }
            }
        }
        return sRamSize;
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                byte b = bArr[i];
                if (b == 10 || i == 0) {
                    if (b == 10) {
                        i++;
                    }
                    for (int i2 = i; i2 < read; i2++) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return extractValue(bArr, i2);
                        }
                    }
                }
                i++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    private static int extractValue(byte[] bArr, int i) {
        byte b;
        while (i < bArr.length && (b = bArr[i]) != 10) {
            if (Character.isDigit(b)) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }
}
