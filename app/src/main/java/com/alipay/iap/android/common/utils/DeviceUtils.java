package com.alipay.iap.android.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.google.common.base.Ascii;
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
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class DeviceUtils {
    public static final int DEVICEINFO_NO_INIT = -100;
    public static final int DEVICEINFO_UNKNOWN = -1;
    private static final String SHARED_PREFERENCE_DEVICE_ID = "SHARE_PREFERENCE_DEVICE_ID";
    private static final String SHARED_PREFERENCE_DEVICE_ID_UUID = "SHARED_PREFERENCE_DEVICE_ID_UUID";
    private static final String TAG = "DeviceUtils";
    private static String sClientKey = null;
    static int sCoreNum = -100;
    private static String sDeviceId;
    private static String sIMEI;
    private static String sTerminalIdentifier;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {105, Ascii.NAK, -43, 101, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 16;
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.alipay.iap.android.common.utils.DeviceUtils.1
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

    private DeviceUtils() {
    }

    @Deprecated
    public static String getIMEI(Context context) {
        LoggerWrapper.e(TAG, "getIMEI interface is deprecated, please use the other interface instead, it will return null");
        return sIMEI;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054 A[Catch: Exception -> 0x0083, all -> 0x00b8, TryCatch #1 {Exception -> 0x0083, blocks: (B:9:0x0027, B:11:0x002f, B:15:0x004c, B:17:0x0054, B:19:0x0067, B:20:0x0075), top: B:39:0x0027, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075 A[Catch: Exception -> 0x0083, all -> 0x00b8, TRY_LEAVE, TryCatch #1 {Exception -> 0x0083, blocks: (B:9:0x0027, B:11:0x002f, B:15:0x004c, B:17:0x0054, B:19:0x0067, B:20:0x0075), top: B:39:0x0027, outer: #0 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0077 -> B:22:0x007b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDeviceId(android.content.Context r15) {
        /*
            java.lang.Class<com.alipay.iap.android.common.utils.DeviceUtils> r0 = com.alipay.iap.android.common.utils.DeviceUtils.class
            monitor-enter(r0)
            java.lang.String r1 = com.alipay.iap.android.common.utils.DeviceUtils.sDeviceId     // Catch: java.lang.Throwable -> Lb8
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb8
            if (r1 != 0) goto L27
            java.lang.String r15 = com.alipay.iap.android.common.utils.DeviceUtils.TAG     // Catch: java.lang.Throwable -> Lb8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb8
            r1.<init>()     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r2 = "Get device id from memory, device id: "
            r1.append(r2)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r2 = com.alipay.iap.android.common.utils.DeviceUtils.sDeviceId     // Catch: java.lang.Throwable -> Lb8
            r1.append(r2)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb8
            com.alipay.iap.android.common.log.LoggerWrapper.d(r15, r1)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r15 = com.alipay.iap.android.common.utils.DeviceUtils.sDeviceId     // Catch: java.lang.Throwable -> Lb8
            monitor-exit(r0)
            return r15
        L27:
            java.lang.String r1 = "com.ut.device.UTDevice"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            if (r1 == 0) goto L8d
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            byte[] r4 = com.alipay.iap.android.common.utils.DeviceUtils.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            r5 = 97
            r6 = 23
            byte[] r7 = new byte[r6]     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            r8 = 3
            r9 = 0
            r5 = r4
            if (r4 != 0) goto L46
            r10 = r7
            r7 = 23
            r11 = 3
            r12 = 0
            r4 = r3
            goto L7b
        L46:
            r8 = r7
            r7 = 97
            r10 = 3
            r11 = 0
            r4 = r3
        L4c:
            int r12 = r11 + 1
            byte r13 = (byte) r7     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            int r10 = r10 + r2
            r8[r11] = r13     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            if (r12 != r6) goto L75
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            r5.<init>(r8, r9)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            r3[r9] = r5     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            java.lang.String r3 = "getUtdid"
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r4)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            if (r1 == 0) goto L8d
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            r2[r9] = r15     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            r3 = 0
            java.lang.Object r1 = r1.invoke(r3, r2)     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            com.alipay.iap.android.common.utils.DeviceUtils.sDeviceId = r1     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            goto L8d
        L75:
            r11 = r5[r10]     // Catch: java.lang.Exception -> L83 java.lang.Throwable -> Lb8
            r14 = r10
            r10 = r8
            r8 = r11
            r11 = r14
        L7b:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-8)
            r8 = r10
            r10 = r11
            r11 = r12
            goto L4c
        L83:
            r1 = move-exception
            java.lang.String r2 = com.alipay.iap.android.common.utils.DeviceUtils.TAG     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb8
            com.alipay.iap.android.common.log.LoggerWrapper.e(r2, r1)     // Catch: java.lang.Throwable -> Lb8
        L8d:
            java.lang.String r1 = com.alipay.iap.android.common.utils.DeviceUtils.sDeviceId     // Catch: java.lang.Throwable -> Lb8
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb8
            if (r1 != 0) goto Lb1
            java.lang.String r15 = com.alipay.iap.android.common.utils.DeviceUtils.TAG     // Catch: java.lang.Throwable -> Lb8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb8
            r1.<init>()     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r2 = "Get device id from utdid, device id: "
            r1.append(r2)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r2 = com.alipay.iap.android.common.utils.DeviceUtils.sDeviceId     // Catch: java.lang.Throwable -> Lb8
            r1.append(r2)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb8
            com.alipay.iap.android.common.log.LoggerWrapper.d(r15, r1)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r15 = com.alipay.iap.android.common.utils.DeviceUtils.sDeviceId     // Catch: java.lang.Throwable -> Lb8
            monitor-exit(r0)
            return r15
        Lb1:
            getDeviceIdFromSharedPreference(r15)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r15 = com.alipay.iap.android.common.utils.DeviceUtils.sDeviceId     // Catch: java.lang.Throwable -> Lb8
            monitor-exit(r0)
            return r15
        Lb8:
            r15 = move-exception
            monitor-exit(r0)
            goto Lbc
        Lbb:
            throw r15
        Lbc:
            goto Lbb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.common.utils.DeviceUtils.getDeviceId(android.content.Context):java.lang.String");
    }

    private static void getDeviceIdFromSharedPreference(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SHARE_PREFERENCE_DEVICE_ID", 0);
        String string = sharedPreferences.getString("SHARED_PREFERENCE_DEVICE_ID_UUID", "");
        if (TextUtils.isEmpty(string)) {
            sDeviceId = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("SHARED_PREFERENCE_DEVICE_ID_UUID", sDeviceId);
            edit.apply();
        } else {
            sDeviceId = string;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Get device id from uuid, device id: ");
        sb.append(sDeviceId);
        LoggerWrapper.d(str, sb.toString());
    }

    public static void setDeviceId(String str) {
        synchronized (DeviceUtils.class) {
            sDeviceId = str;
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Set device id , device id: ");
            sb.append(sDeviceId);
            LoggerWrapper.d(str2, sb.toString());
        }
    }

    public static String generateTerminalIdentifier(Context context, String str) {
        if (sTerminalIdentifier == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(context.getPackageName());
                String obj = sb.toString();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.reset();
                    byte[] digest = messageDigest.digest(obj.getBytes());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("%0");
                    sb2.append(digest.length * 2);
                    sb2.append("X");
                    sTerminalIdentifier = String.format(sb2.toString(), new BigInteger(1, digest));
                } catch (NoSuchAlgorithmException e) {
                    LoggerWrapper.e(TAG, "can not generate terminal identifier cause of sha-256 algorithm not found.", e);
                }
            } else {
                LoggerWrapper.e(TAG, "can not generate terminal identifier cause of the input deviceId is empty.");
            }
        }
        return sTerminalIdentifier;
    }

    public static String generateClientKey(Context context, String str) {
        String obj;
        if (sClientKey == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                String packageName = context.getPackageName();
                if (PermissionUtils.hasPermission(context, "android.permission.READ_PHONE_STATE")) {
                    String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(deviceId);
                    sb.append(packageName);
                    obj = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(packageName);
                    obj = sb2.toString();
                }
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.reset();
                    byte[] digest = messageDigest.digest(obj.getBytes());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("%0");
                    sb3.append(digest.length * 2);
                    sb3.append("X");
                    sClientKey = String.format(sb3.toString(), new BigInteger(1, digest));
                } catch (NoSuchAlgorithmException e) {
                    LoggerWrapper.e(TAG, "can not generate terminal identifier cause of sha-256 algorithm not found.", e);
                }
            } else {
                LoggerWrapper.e(TAG, "can not generate terminal identifier cause of the input deviceId is empty.");
            }
        }
        return sClientKey;
    }

    public static long getTotalMemory() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String trim = Pattern.compile("[^0-9]").matcher(bufferedReader.readLine()).replaceAll("").trim();
            bufferedReader.close();
            return Long.parseLong(trim);
        } catch (Exception e) {
            LoggerWrapper.w(TAG, e);
            return 0L;
        }
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
}
