package com.alipay.iap.android.aplog.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public class DeviceHWInfo {
    public static final int DEVICEINFO_NO_INIT = -100;
    public static final int DEVICEINFO_UNKNOWN = -1;
    public static final String TAG = "DeviceHWInfo";
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.alipay.iap.android.aplog.util.DeviceHWInfo.1
        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i = 3; i < name.length(); i++) {
                    if (!Character.isDigit(name.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };
    static int sFrequency = -100;
    static long sRamSize = -100;
    static int sCoreNum = -100;
    static String sCpuName = "-100";

    public static int getNumberOfCPUCores() {
        int i = sCoreNum;
        if (i == -1) {
            return i;
        }
        if (i == -100) {
            synchronized (DeviceHWInfo.class) {
                if (Build.VERSION.SDK_INT <= 10) {
                    sCoreNum = 1;
                    return 1;
                }
                try {
                    int coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
                    sCoreNum = coresFromFileInfo;
                    if (coresFromFileInfo == -1) {
                        sCoreNum = getCoresFromFileInfo("/sys/devices/system/cpu/present");
                    }
                    if (sCoreNum == -1) {
                        sCoreNum = getCoresFromCPUFileList();
                    }
                } catch (Throwable unused) {
                    sCoreNum = -1;
                }
            }
        }
        return sCoreNum;
    }

    private static int getCoresFromFileInfo(String str) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                int coresFromFileString = getCoresFromFileString(new BufferedReader(new InputStreamReader(fileInputStream2)).readLine());
                try {
                    fileInputStream2.close();
                } catch (Throwable unused) {
                }
                return coresFromFileString;
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return -1;
                    } catch (Throwable unused3) {
                        return -1;
                    }
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int getCoresFromFileString(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    private static int getCoresFromCPUFileList() {
        return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
    }

    public static int getCPUMaxFreqKHz() {
        int i = sFrequency;
        if (i == -1) {
            return i;
        }
        if (i == -100) {
            synchronized (DeviceHWInfo.class) {
                for (int i2 = 0; i2 < getNumberOfCPUCores(); i2++) {
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
                                if (valueOf.intValue() > sFrequency) {
                                    sFrequency = valueOf.intValue();
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
                        sFrequency = -1;
                    }
                }
                if (sFrequency == -100) {
                    FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
                    try {
                        int parseFileForValue = parseFileForValue("cpu MHz", fileInputStream2) * 1000;
                        if (parseFileForValue > sFrequency) {
                            sFrequency = parseFileForValue;
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
        return sFrequency;
    }

    public static long getTotalMemory(Context context) {
        long j;
        FileInputStream fileInputStream;
        long j2 = sRamSize;
        if (j2 == -1) {
            return j2;
        }
        if (j2 == -100) {
            synchronized (DeviceHWInfo.class) {
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        ((ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY)).getMemoryInfo(memoryInfo);
                        sRamSize = memoryInfo.totalMem;
                    } else {
                        try {
                            fileInputStream = new FileInputStream("/proc/meminfo");
                        } catch (IOException unused) {
                            j = -1;
                        }
                        try {
                            j = parseFileForValue("MemTotal", fileInputStream) * ConvertUtils.KB;
                            sRamSize = j;
                        } finally {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    sRamSize = -1L;
                }
            }
        }
        return sRamSize;
    }

    public static String getCpuName() {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String readLine;
        if (TextUtils.equals(sCpuName, "-1")) {
            return sCpuName;
        }
        if (TextUtils.equals(sCpuName, "-100")) {
            synchronized (DeviceHWInfo.class) {
                try {
                    fileReader = new FileReader("/proc/cpuinfo");
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                    } catch (Throwable th2) {
                        bufferedReader = null;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                    fileReader = null;
                }
                try {
                    String str = bufferedReader.readLine().split(":\\s+", 2)[1];
                    sCpuName = str;
                    if ("0".equals(str) && (readLine = bufferedReader.readLine()) != null) {
                        String[] split = readLine.split(":\\s+", 2);
                        if (split.length > 1) {
                            sCpuName = split[1];
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (Throwable th4) {
                        InstrumentInjector.log_w(TAG, th4);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        InstrumentInjector.log_w(TAG, th);
                        sCpuName = "-1";
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable th6) {
                                InstrumentInjector.log_w(TAG, th6);
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return sCpuName;
                    } finally {
                    }
                }
                try {
                    bufferedReader.close();
                } catch (Throwable th7) {
                    InstrumentInjector.log_w(TAG, th7);
                }
            }
        }
        return sCpuName;
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

    public static String getBrandName() {
        String str;
        try {
            str = Build.BRAND.toLowerCase();
        } catch (Throwable unused) {
            str = "";
        }
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }
}
