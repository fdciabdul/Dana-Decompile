package com.iap.ac.android.loglite.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DeviceUtil {
    public static int a() {
        int i = DeviceHWInfo.b;
        if (i != -1) {
            if (i == -100) {
                synchronized (DeviceHWInfo.class) {
                    for (int i2 = 0; i2 < DeviceHWInfo.a(); i2++) {
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append("/sys/devices/system/cpu/cpu");
                            sb.append(i2);
                            sb.append("/cpufreq/cpuinfo_max_freq");
                            File file = new File(sb.toString());
                            if (file.exists()) {
                                byte[] bArr = new byte[128];
                                FileInputStream fileInputStream = new FileInputStream(file);
                                try {
                                    fileInputStream.read(bArr);
                                    int i3 = 0;
                                    while (Character.isDigit(bArr[i3]) && i3 < 128) {
                                        i3++;
                                    }
                                    Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                                    if (valueOf.intValue() > DeviceHWInfo.b) {
                                        DeviceHWInfo.b = valueOf.intValue();
                                    }
                                } catch (NumberFormatException unused) {
                                } catch (Throwable th) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused2) {
                                    }
                                    throw th;
                                }
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        } catch (IOException unused4) {
                            DeviceHWInfo.b = -1;
                        }
                    }
                    if (DeviceHWInfo.b == -100) {
                        FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
                        try {
                            int a2 = DeviceHWInfo.a("cpu MHz", fileInputStream2) * 1000;
                            if (a2 > DeviceHWInfo.b) {
                                DeviceHWInfo.b = a2;
                            }
                        } finally {
                            try {
                                fileInputStream2.close();
                            } catch (Throwable unused5) {
                            }
                        }
                    }
                }
            }
            i = DeviceHWInfo.b;
        }
        if (i <= 0) {
            return -1;
        }
        return i / 1000;
    }

    public static long a(Context context) {
        long j;
        FileInputStream fileInputStream;
        long j2 = DeviceHWInfo.c;
        if (j2 != -1) {
            if (j2 == -100) {
                synchronized (DeviceHWInfo.class) {
                    try {
                        if (Build.VERSION.SDK_INT >= 16) {
                            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                            ((ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY)).getMemoryInfo(memoryInfo);
                            DeviceHWInfo.c = memoryInfo.totalMem;
                        } else {
                            try {
                                fileInputStream = new FileInputStream("/proc/meminfo");
                            } catch (IOException e) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(e);
                                LoggerWrapper.e(com.alipay.iap.android.aplog.util.DeviceHWInfo.TAG, sb.toString());
                                j = -1;
                            }
                            try {
                                j = DeviceHWInfo.a("MemTotal", fileInputStream) * ConvertUtils.KB;
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused) {
                                }
                                DeviceHWInfo.c = j;
                            } finally {
                            }
                        }
                    } catch (Throwable unused2) {
                        DeviceHWInfo.c = -1L;
                    }
                }
            }
            j2 = DeviceHWInfo.c;
        }
        if (j2 <= 0) {
            return -1L;
        }
        return j2 / ConvertUtils.MB;
    }
}
