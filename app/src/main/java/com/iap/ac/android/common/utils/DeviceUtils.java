package com.iap.ac.android.common.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.iap.ac.android.common.a.a;
import com.iap.ac.android.common.log.ACLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public class DeviceUtils {
    public static final int DEVICEINFO_NO_INIT = -100;
    public static final int DEVICEINFO_UNKNOWN = -1;
    public static final String SHARED_PREFERENCE_DEVICE_ID = "SHARE_PREFERENCE_DEVICE_ID";
    public static final String SHARED_PREFERENCE_DEVICE_ID_UUID = "SHARED_PREFERENCE_DEVICE_ID_UUID";
    public static final String TAG = "DeviceUtils";
    public static String sClientKey;
    public static String sTerminalIdentifier;
    public static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.iap.ac.android.common.utils.DeviceUtils.1
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
    public static int sCoreNum = -100;

    public static String generateClientKey(Context context, String str) {
        if (sClientKey == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                String packageName = context.getPackageName();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(packageName);
                String obj = sb.toString();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.reset();
                    byte[] digest = messageDigest.digest(obj.getBytes());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("%0");
                    sb2.append(digest.length * 2);
                    sb2.append("X");
                    sClientKey = String.format(sb2.toString(), new BigInteger(1, digest));
                } catch (NoSuchAlgorithmException e) {
                    ACLog.e(TAG, "can not generate terminal identifier cause of sha-256 algorithm not found.", e);
                }
            } else {
                ACLog.e(TAG, "can not generate terminal identifier cause of the input deviceId is empty.");
            }
        }
        return sClientKey;
    }

    public static String generateTerminalIdentifier(Context context, String str) {
        if (sTerminalIdentifier == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                StringBuilder a2 = a.a(str);
                a2.append(context.getPackageName());
                String obj = a2.toString();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.reset();
                    byte[] digest = messageDigest.digest(obj.getBytes());
                    StringBuilder sb = new StringBuilder();
                    sb.append("%0");
                    sb.append(digest.length * 2);
                    sb.append("X");
                    sTerminalIdentifier = String.format(sb.toString(), new BigInteger(1, digest));
                } catch (NoSuchAlgorithmException e) {
                    ACLog.e(TAG, "can not generate terminal identifier cause of sha-256 algorithm not found.", e);
                }
            } else {
                ACLog.e(TAG, "can not generate terminal identifier cause of the input deviceId is empty.");
            }
        }
        return sTerminalIdentifier;
    }

    public static int getCoresFromCPUFileList() {
        return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
    }

    public static int getCoresFromFileInfo(String str) {
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

    public static int getCoresFromFileString(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    @Deprecated
    public static String getIMEI(Context context) {
        ACLog.e(TAG, "getIMEI interface is deprecated, please use the other interface instead, it will return null");
        return null;
    }

    public static int getNumberOfCPUCores() {
        int i = sCoreNum;
        if (i == -1) {
            return i;
        }
        if (i == -100) {
            synchronized (DeviceUtils.class) {
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

    public static long getTotalMemory() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String trim = Pattern.compile("[^0-9]").matcher(bufferedReader.readLine()).replaceAll("").trim();
            bufferedReader.close();
            return Long.parseLong(trim);
        } catch (Exception e) {
            ACLog.w(TAG, e);
            return 0L;
        }
    }
}
