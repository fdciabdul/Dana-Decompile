package com.alibaba.griver.base.common.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.security.GriverSecurity;
import com.google.common.base.Ascii;
import com.iap.ac.android.common.instance.InstanceInfo;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes6.dex */
public class DeviceUtils {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {94, Ascii.EM, -44, 73, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 108;

    public static String getIMEI(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Throwable unused) {
            }
        }
        return str == null ? "" : str;
    }

    public static String getIMEIEncrypt(Context context) {
        return GriverSecurity.getInstance().encrypt(getIMEI(context));
    }

    public static String getAndroidId(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String getAndroidIdEncrypt(Context context) {
        return GriverSecurity.getInstance().encrypt(getAndroidId(context));
    }

    public static String getMacEncrypt(Context context) {
        return GriverSecurity.getInstance().encrypt(getMac(context));
    }

    public static String getMac(Context context) {
        try {
            String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (macAddress != null) {
                try {
                    if (macAddress.length() != 0 && !"02:00:00:00:00:00".equals(macAddress)) {
                        return macAddress;
                    }
                } catch (Throwable unused) {
                    return macAddress;
                }
            }
            return a();
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static String a() {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            if (list == null) {
                return "02:00:00:00:00:00";
            }
            for (NetworkInterface networkInterface : list) {
                if (networkInterface != null && networkInterface.getName() != null && networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "02:00:00:00:00:00";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(String.format("%02X:", Integer.valueOf(b & 255)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Throwable unused) {
            return "02:00:00:00:00:00";
        }
    }

    public static String getSerialNumber() {
        String str;
        try {
            str = b();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    private static String b() {
        if (Build.VERSION.SDK_INT > 27) {
            return null;
        }
        if (Build.VERSION.SDK_INT == 27) {
            if (GriverEnv.getApplicationContext().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                return Build.getSerial();
            }
            return null;
        }
        return Build.SERIAL;
    }

    public static String getSerialNumberEncrypt() {
        return GriverSecurity.getInstance().encrypt(getSerialNumber());
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002a A[Catch: Exception -> 0x0054, TryCatch #0 {Exception -> 0x0054, blocks: (B:2:0x0000, B:6:0x0024, B:8:0x002a, B:9:0x0048), top: B:14:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048 A[Catch: Exception -> 0x0054, TRY_LEAVE, TryCatch #0 {Exception -> 0x0054, blocks: (B:2:0x0000, B:6:0x0024, B:8:0x002a, B:9:0x0048), top: B:14:0x0000 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x004a -> B:11:0x004d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getUtdid(android.content.Context r12) {
        /*
            java.lang.String r0 = "com.ut.device.UTDevice"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L54
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L54
            r3 = 97
            byte[] r4 = com.alibaba.griver.base.common.utils.DeviceUtils.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L54
            r5 = -1
            r6 = 23
            byte[] r6 = new byte[r6]     // Catch: java.lang.Exception -> L54
            r7 = 22
            r8 = 4
            r3 = r2
            r5 = r4
            if (r4 != 0) goto L1f
            r10 = r6
            r4 = 22
            r6 = -1
            r9 = 4
            goto L4d
        L1f:
            r8 = r6
            r4 = 97
            r6 = -1
            r9 = 4
        L24:
            int r6 = r6 + r1
            byte r10 = (byte) r4     // Catch: java.lang.Exception -> L54
            r8[r6] = r10     // Catch: java.lang.Exception -> L54
            if (r6 != r7) goto L48
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L54
            r5 = 0
            r4.<init>(r8, r5)     // Catch: java.lang.Exception -> L54
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Exception -> L54
            r2[r5] = r4     // Catch: java.lang.Exception -> L54
            java.lang.String r2 = "getUtdid"
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch: java.lang.Exception -> L54
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L54
            r1[r5] = r12     // Catch: java.lang.Exception -> L54
            r12 = 0
            java.lang.Object r12 = r0.invoke(r12, r1)     // Catch: java.lang.Exception -> L54
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Exception -> L54
            goto L5d
        L48:
            r10 = r5[r9]     // Catch: java.lang.Exception -> L54
            r11 = r10
            r10 = r8
            r8 = r11
        L4d:
            int r8 = -r8
            int r4 = r4 + r8
            int r4 = r4 + (-8)
            int r9 = r9 + r1
            r8 = r10
            goto L24
        L54:
            java.lang.String r12 = "TinyDeviceUtils"
            java.lang.String r0 = "[*] UTDID error."
            com.alibaba.griver.base.common.logger.GriverLogger.d(r12, r0)
            java.lang.String r12 = ""
        L5d:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.DeviceUtils.getUtdid(android.content.Context):java.lang.String");
    }

    public static String getInstanceId(Context context) {
        if (InstanceInfo.getInstanceInfoImpl() != null) {
            return InstanceInfo.getInstanceId(context);
        }
        return getUtdid(context);
    }

    public static String getUtdidEncrypt(Context context) {
        return GriverSecurity.getInstance().encrypt(getUtdid(context));
    }
}
