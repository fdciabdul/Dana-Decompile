package com.alipay.alipaysecuritysdk.common.collector;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.alipay.alipaysecuritysdk.common.e.e;
import id.dana.oauth.OauthConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f6871a = new c();

    public static String a() {
        return "android";
    }

    private c() {
    }

    public static boolean b() {
        String[] strArr = {"/system/bin/su", "/system/xbin/su", "/system/sbin/su", "/su/bin/su", "/su/xbin/su", "/sbin/su", "/usr/bin/su", "/vendor/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (int i = 0; i < 14; i++) {
            try {
            } catch (Exception e) {
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
            }
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context) {
        TelephonyManager telephonyManager;
        boolean z;
        int length;
        try {
            if (!Build.HARDWARE.contains("goldfish") && !Build.PRODUCT.contains(OauthConstant.OauthType.SDK_TYPE) && !Build.FINGERPRINT.contains("generic")) {
                if (com.alipay.alipaysecuritysdk.common.e.d.b(context, "android.permission.READ_PHONE_STATE") && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    if (deviceId != null && (length = deviceId.length()) != 0) {
                        for (int i = 0; i < length; i++) {
                            if (!Character.isWhitespace(deviceId.charAt(i)) && deviceId.charAt(i) != '0') {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        return true;
                    }
                }
                return e.c(Settings.Secure.getString(context.getContentResolver(), "android_id"));
            }
            return true;
        } catch (Exception e) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
            return false;
        }
    }

    public static String c() {
        return Build.BOARD;
    }

    public static String d() {
        return Build.BRAND;
    }

    public static String e() {
        return Build.DEVICE;
    }

    public static String f() {
        return Build.DISPLAY;
    }

    public static String g() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String h() {
        return Build.MANUFACTURER;
    }

    public static String i() {
        return Build.MODEL;
    }

    public static String j() {
        return Build.PRODUCT;
    }

    public static String k() {
        return Build.VERSION.RELEASE;
    }

    public static String l() {
        return Build.VERSION.SDK;
    }

    public static String m() {
        return Build.TAGS;
    }

    public static String n() {
        return a("ro.kernel.qemu", "0");
    }

    public static String o() {
        return a("gsm.sim.state", "");
    }

    public static String p() {
        return a("gsm.sim.state.2", "");
    }

    public static String q() {
        return a("wifi.interface", "");
    }

    public static String r() {
        return a("sys.usb.state", "");
    }

    public static String b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "";
            }
            String typeName = connectivityManager.getActiveNetworkInfo().getTypeName();
            return typeName == null ? false : typeName.equalsIgnoreCase("WIFI") ? "WIFI" : connectivityManager.getActiveNetworkInfo().getExtraInfo();
        } catch (Exception e) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
            return "";
        }
    }

    public static String s() {
        String str;
        str = "";
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] split = bufferedReader.readLine().split(":\\s+", 2);
            str = split.length > 1 ? split[1] : "";
            fileReader.close();
            bufferedReader.close();
            return str;
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return str;
        }
    }

    private static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
            return str2;
        }
    }
}
