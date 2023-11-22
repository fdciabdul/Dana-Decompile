package com.alipay.alipaysecuritysdk.common.collector;

import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.alipay.alipaysecuritysdk.common.e.e;
import id.dana.oauth.OauthConstant;
import id.dana.utils.permission.ManifestPermission;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f6870a = new b();
    private static long b = 0;

    private b() {
    }

    public static String a(Context context) {
        String str = "";
        if (com.alipay.alipaysecuritysdk.common.e.d.a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getDeviceId();
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return e.e(str);
    }

    public static String b(Context context) {
        String str = "";
        if (com.alipay.alipaysecuritysdk.common.e.d.a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getSubscriberId();
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return e.e(str);
    }

    public static String c(Context context) {
        int i = 0;
        try {
            i = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return i == 1 ? "1" : "0";
    }

    public static String a() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            j = 0;
        }
        return String.valueOf(j);
    }

    public static String b() {
        File externalStorageDirectory;
        long j = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                j = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return String.valueOf(j);
    }

    public static String d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService(H5ResourceHandlerUtil.AUDIO);
            if (audioManager != null) {
                int i = audioManager.getRingerMode() == 0 ? 1 : 0;
                int streamVolume = audioManager.getStreamVolume(0);
                int streamVolume2 = audioManager.getStreamVolume(1);
                int streamVolume3 = audioManager.getStreamVolume(2);
                int streamVolume4 = audioManager.getStreamVolume(3);
                int streamVolume5 = audioManager.getStreamVolume(4);
                jSONObject.put("ringermode", String.valueOf(i));
                jSONObject.put("call", String.valueOf(streamVolume));
                jSONObject.put("system", String.valueOf(streamVolume2));
                jSONObject.put("ring", String.valueOf(streamVolume3));
                jSONObject.put("music", String.valueOf(streamVolume4));
                jSONObject.put("alarm", String.valueOf(streamVolume5));
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return jSONObject.toString();
    }

    public static String e(Context context) {
        String str = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getSimOperatorName();
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return e.e(str);
    }

    public static String f(Context context) {
        String str = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return (str == null || "null".equals(str)) ? "" : str;
    }

    public static String g(Context context) {
        List<Sensor> sensorList;
        String str = null;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (Sensor sensor : sensorList) {
                    sb.append(sensor.getName());
                    sb.append(sensor.getVersion());
                    sb.append(sensor.getVendor());
                }
                str = com.alipay.alipaysecuritysdk.common.b.b.a(sb.toString());
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return e.e(str);
    }

    public static String h(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                for (Sensor sensor : sensorList) {
                    if (sensor != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", sensor.getName());
                        jSONObject.put("version", sensor.getVersion());
                        jSONObject.put("vendor", sensor.getVendor());
                        jSONArray.put(jSONObject);
                    }
                }
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return jSONArray.toString();
    }

    public static String i(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(displayMetrics.widthPixels));
            sb.append("*");
            sb.append(Integer.toString(displayMetrics.heightPixels));
            return sb.toString();
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return "";
        }
    }

    public static String j(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.widthPixels);
            return sb.toString();
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return "";
        }
    }

    public static String k(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.heightPixels);
            return sb.toString();
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String l(android.content.Context r4) {
        /*
            java.lang.String r0 = "02:00:00:00:00:00"
            java.lang.String r1 = "android.permission.ACCESS_WIFI_STATE"
            boolean r1 = com.alipay.alipaysecuritysdk.common.e.d.a(r4, r1)
            java.lang.String r2 = ""
            if (r1 == 0) goto Ld
            return r2
        Ld:
            java.lang.String r1 = "wifi"
            java.lang.Object r4 = r4.getSystemService(r1)     // Catch: java.lang.Throwable -> L48
            android.net.wifi.WifiManager r4 = (android.net.wifi.WifiManager) r4     // Catch: java.lang.Throwable -> L48
            if (r4 == 0) goto L46
            android.net.wifi.WifiInfo r4 = r4.getConnectionInfo()     // Catch: java.lang.Throwable -> L48
            java.lang.String r4 = r4.getMacAddress()     // Catch: java.lang.Throwable -> L48
            boolean r1 = com.alipay.alipaysecuritysdk.common.e.e.c(r4)     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = "wlan0"
            if (r1 != 0) goto L2f
            boolean r1 = r0.equals(r4)     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L33
        L2f:
            java.lang.String r4 = a(r3)     // Catch: java.lang.Throwable -> L44
        L33:
            boolean r1 = com.alipay.alipaysecuritysdk.common.e.e.c(r4)     // Catch: java.lang.Throwable -> L44
            if (r1 != 0) goto L3f
            boolean r1 = r0.equals(r4)     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L50
        L3f:
            java.lang.String r4 = b(r3)     // Catch: java.lang.Throwable -> L44
            goto L50
        L44:
            r1 = move-exception
            goto L4b
        L46:
            r4 = r2
            goto L50
        L48:
            r4 = move-exception
            r1 = r4
            r4 = r2
        L4b:
            java.lang.String r3 = "SEC_SDK-tool"
            com.alipay.alipaysecuritysdk.common.c.b.a(r3, r1)
        L50:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L57
            goto L58
        L57:
            r2 = r4
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.common.collector.b.l(android.content.Context):java.lang.String");
    }

    private static String a(String str) {
        String str2 = "";
        try {
            while (true) {
                String str3 = "";
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    try {
                        if (networkInterface != null && networkInterface.getName() != null && str.equalsIgnoreCase(networkInterface.getName())) {
                            byte[] hardwareAddress = networkInterface.getHardwareAddress();
                            if (hardwareAddress != null) {
                                StringBuilder sb = new StringBuilder();
                                for (byte b2 : hardwareAddress) {
                                    sb.append(String.format("%02X:", Integer.valueOf(b2 & 255)));
                                }
                                if (sb.length() > 0) {
                                    sb.deleteCharAt(sb.length() - 1);
                                }
                                str3 = sb.toString();
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        str2 = str3;
                        com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
                        return str2;
                    }
                }
                return str3;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private static String b(String str) {
        Exception e;
        String str2;
        File file;
        try {
            StringBuilder sb = new StringBuilder("/sys/class/net/");
            sb.append(str);
            file = new File(sb.toString(), "address");
        } catch (Exception e2) {
            e = e2;
            str2 = "";
        }
        if (file.exists() && file.isFile() && file.canRead()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            fileInputStream.read(bArr, 0, available);
            str2 = new String(bArr);
            try {
                str2 = str2.substring(0, 17).toUpperCase();
                if (!Pattern.matches("[0-9a-fA-F]{2}(:[0-9a-fA-F]{2}){5}", str2)) {
                    if (!Pattern.matches("[0-9a-fA-F]{2}(-[0-9a-fA-F]{2}){5}", str2)) {
                        return "";
                    }
                }
            } catch (Exception e3) {
                e = e3;
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
                return str2;
            }
            return str2;
        }
        return "";
    }

    public static String m(Context context) {
        Throwable th;
        String str = "";
        if (com.alipay.alipaysecuritysdk.common.e.d.a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String simSerialNumber = telephonyManager.getSimSerialNumber();
                try {
                    return e.c(simSerialNumber) ? "" : simSerialNumber;
                } catch (Throwable th2) {
                    th = th2;
                    str = simSerialNumber;
                    com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
                    return str;
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String n(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            str = "";
        }
        return e.e(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
    
        if (r2 == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c() {
        /*
            java.lang.String r0 = "0000000000000000"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L53
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L53
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L53
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4e
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4e
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L49
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L49
            r1 = 1
            r5 = 1
        L1b:
            r6 = 100
            if (r5 >= r6) goto L42
            java.lang.String r6 = r4.readLine()     // Catch: java.lang.Throwable -> L40
            if (r6 == 0) goto L42
            java.lang.String r7 = "Serial"
            boolean r7 = r6.contains(r7)     // Catch: java.lang.Throwable -> L40
            if (r7 == 0) goto L3d
            java.lang.String r5 = ":"
            int r5 = r6.indexOf(r5)     // Catch: java.lang.Throwable -> L40
            int r5 = r5 + r1
            java.lang.String r1 = r6.substring(r5)     // Catch: java.lang.Throwable -> L40
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L40
            goto L42
        L3d:
            int r5 = r5 + 1
            goto L1b
        L40:
            r1 = move-exception
            goto L58
        L42:
            r4.close()     // Catch: java.lang.Throwable -> L45
        L45:
            r3.close()     // Catch: java.lang.Throwable -> L6d
            goto L6d
        L49:
            r4 = move-exception
            r8 = r4
            r4 = r1
            r1 = r8
            goto L58
        L4e:
            r3 = move-exception
            r4 = r1
            r1 = r3
            r3 = r4
            goto L58
        L53:
            r2 = move-exception
            r3 = r1
            r4 = r3
            r1 = r2
            r2 = r4
        L58:
            java.lang.String r5 = "SEC_SDK-tool"
            com.alipay.alipaysecuritysdk.common.c.b.a(r5, r1)     // Catch: java.lang.Throwable -> L75
            if (r4 == 0) goto L64
            r4.close()     // Catch: java.lang.Throwable -> L63
            goto L64
        L63:
        L64:
            if (r3 == 0) goto L6b
            r3.close()     // Catch: java.lang.Throwable -> L6a
            goto L6b
        L6a:
        L6b:
            if (r2 == 0) goto L70
        L6d:
            r2.close()     // Catch: java.lang.Throwable -> L70
        L70:
            java.lang.String r0 = com.alipay.alipaysecuritysdk.common.e.e.e(r0)
            return r0
        L75:
            r0 = move-exception
            if (r4 == 0) goto L7d
            r4.close()     // Catch: java.lang.Throwable -> L7c
            goto L7d
        L7c:
        L7d:
            if (r3 == 0) goto L84
            r3.close()     // Catch: java.lang.Throwable -> L83
            goto L84
        L83:
        L84:
            if (r2 == 0) goto L89
            r2.close()     // Catch: java.lang.Throwable -> L89
        L89:
            goto L8b
        L8a:
            throw r0
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.common.collector.b.c():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
    
        if (r2 == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d() {
        /*
            java.lang.String r0 = "-1"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L57
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L57
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L57
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L57
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L52
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L52
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L4d
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L4d
            r1 = 1
            r5 = 1
        L1b:
            r6 = 100
            if (r5 >= r6) goto L46
            java.lang.String r6 = r4.readLine()     // Catch: java.lang.Throwable -> L44
            if (r6 == 0) goto L46
            java.lang.String r7 = "Hardware"
            boolean r7 = r6.contains(r7)     // Catch: java.lang.Throwable -> L44
            if (r7 == 0) goto L41
            java.lang.String r5 = ":"
            int r5 = r6.indexOf(r5)     // Catch: java.lang.Throwable -> L44
            int r5 = r5 + r1
            int r1 = r6.length()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = r6.substring(r5, r1)     // Catch: java.lang.Throwable -> L44
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L44
            goto L46
        L41:
            int r5 = r5 + 1
            goto L1b
        L44:
            r1 = move-exception
            goto L5c
        L46:
            r4.close()     // Catch: java.lang.Throwable -> L49
        L49:
            r3.close()     // Catch: java.lang.Throwable -> L71
            goto L71
        L4d:
            r4 = move-exception
            r8 = r4
            r4 = r1
            r1 = r8
            goto L5c
        L52:
            r3 = move-exception
            r4 = r1
            r1 = r3
            r3 = r4
            goto L5c
        L57:
            r2 = move-exception
            r3 = r1
            r4 = r3
            r1 = r2
            r2 = r4
        L5c:
            java.lang.String r5 = "SEC_SDK-tool"
            com.alipay.alipaysecuritysdk.common.c.b.a(r5, r1)     // Catch: java.lang.Throwable -> L75
            if (r4 == 0) goto L68
            r4.close()     // Catch: java.lang.Throwable -> L67
            goto L68
        L67:
        L68:
            if (r3 == 0) goto L6f
            r3.close()     // Catch: java.lang.Throwable -> L6e
            goto L6f
        L6e:
        L6f:
            if (r2 == 0) goto L74
        L71:
            r2.close()     // Catch: java.lang.Throwable -> L74
        L74:
            return r0
        L75:
            r0 = move-exception
            if (r4 == 0) goto L7d
            r4.close()     // Catch: java.lang.Throwable -> L7c
            goto L7d
        L7c:
        L7d:
            if (r3 == 0) goto L84
            r3.close()     // Catch: java.lang.Throwable -> L83
            goto L84
        L83:
        L84:
            if (r2 == 0) goto L89
            r2.close()     // Catch: java.lang.Throwable -> L89
        L89:
            goto L8b
        L8a:
            throw r0
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.common.collector.b.d():java.lang.String");
    }

    /* loaded from: classes3.dex */
    final class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Pattern.matches("cpu[0-9]+", file.getName());
        }
    }

    public static String e() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new a()).length);
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return "1";
        }
    }

    public static String f() {
        String v = v();
        return !e.c(v) ? v : w();
    }

    private static String v() {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String readLine;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
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
            readLine = bufferedReader.readLine();
        } catch (Throwable th4) {
            th = th4;
            try {
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                if (fileReader == null) {
                    return "";
                }
                try {
                    fileReader.close();
                    return "";
                } catch (Throwable unused2) {
                    return "";
                }
            } finally {
            }
        }
        if (e.c(readLine)) {
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
            fileReader.close();
            return "";
        }
        String trim = readLine.trim();
        try {
            bufferedReader.close();
        } catch (Throwable unused4) {
        }
        try {
            fileReader.close();
        } catch (Throwable unused5) {
        }
        return trim;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r0 = r1[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        if (r3 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String w() {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = "/proc/cpuinfo"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L43
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3e
            r4 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L3e
        L11:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L38
            boolean r4 = com.alipay.alipaysecuritysdk.common.e.e.c(r1)     // Catch: java.lang.Throwable -> L3c
            if (r4 != 0) goto L11
            java.lang.String r4 = ":"
            java.lang.String[] r1 = r1.split(r4)     // Catch: java.lang.Throwable -> L3c
            int r4 = r1.length     // Catch: java.lang.Throwable -> L3c
            r5 = 1
            if (r4 <= r5) goto L11
            r4 = 0
            r4 = r1[r4]     // Catch: java.lang.Throwable -> L3c
            java.lang.String r6 = "BogoMIPS"
            boolean r4 = r4.contains(r6)     // Catch: java.lang.Throwable -> L3c
            if (r4 == 0) goto L11
            r1 = r1[r5]     // Catch: java.lang.Throwable -> L3c
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L3c
        L38:
            r2.close()     // Catch: java.lang.Throwable -> L55
            goto L55
        L3c:
            r1 = move-exception
            goto L47
        L3e:
            r3 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L47
        L43:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        L47:
            java.lang.String r4 = "SEC_SDK-tool"
            com.alipay.alipaysecuritysdk.common.c.b.a(r4, r1)     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L53
            r2.close()     // Catch: java.lang.Throwable -> L52
            goto L53
        L52:
        L53:
            if (r3 == 0) goto L58
        L55:
            r3.close()     // Catch: java.lang.Throwable -> L58
        L58:
            return r0
        L59:
            r0 = move-exception
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.lang.Throwable -> L60
            goto L61
        L60:
        L61:
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.lang.Throwable -> L66
        L66:
            goto L68
        L67:
            throw r0
        L68:
            goto L67
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.common.collector.b.w():java.lang.String");
    }

    public static String g() {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String[] split;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
            try {
                split = bufferedReader.readLine().split(":\\s+", 2);
            } catch (Throwable th3) {
                th = th3;
                try {
                    com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused) {
                        }
                    }
                    if (bufferedReader == null) {
                        return "";
                    }
                    try {
                        bufferedReader.close();
                        return "";
                    } catch (Throwable unused2) {
                        return "";
                    }
                } finally {
                }
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            fileReader = null;
        }
        if (split.length <= 1) {
            try {
                fileReader.close();
            } catch (Throwable unused3) {
            }
            bufferedReader.close();
            return "";
        }
        String str = split[1];
        try {
            fileReader.close();
        } catch (Throwable unused4) {
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused5) {
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r4 != null) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String h() {
        /*
            r0 = 0
            r1 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L31
            java.lang.String r4 = "/proc/meminfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L31
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2c
            r5 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = r4.readLine()     // Catch: java.lang.Throwable -> L2a
            if (r0 == 0) goto L26
            java.lang.String r5 = "\\s+"
            java.lang.String[] r0 = r0.split(r5)     // Catch: java.lang.Throwable -> L2a
            r5 = 1
            r0 = r0[r5]     // Catch: java.lang.Throwable -> L2a
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L2a
            long r0 = (long) r0
            r1 = r0
        L26:
            r3.close()     // Catch: java.lang.Throwable -> L44
            goto L44
        L2a:
            r0 = move-exception
            goto L35
        L2c:
            r4 = move-exception
            r6 = r4
            r4 = r0
            r0 = r6
            goto L35
        L31:
            r3 = move-exception
            r4 = r0
            r0 = r3
            r3 = r4
        L35:
            java.lang.String r5 = "SEC_SDK-tool"
            com.alipay.alipaysecuritysdk.common.c.b.a(r5, r0)     // Catch: java.lang.Throwable -> L4c
            if (r3 == 0) goto L41
            r3.close()     // Catch: java.lang.Throwable -> L40
            goto L41
        L40:
        L41:
            if (r4 != 0) goto L44
            goto L47
        L44:
            r4.close()     // Catch: java.lang.Throwable -> L47
        L47:
            java.lang.String r0 = java.lang.String.valueOf(r1)
            return r0
        L4c:
            r0 = move-exception
            if (r3 == 0) goto L54
            r3.close()     // Catch: java.lang.Throwable -> L53
            goto L54
        L53:
        L54:
            if (r4 == 0) goto L59
            r4.close()     // Catch: java.lang.Throwable -> L59
        L59:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.common.collector.b.h():java.lang.String");
    }

    public static String i() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            j = 0;
        }
        return String.valueOf(j);
    }

    public static String j() {
        long j = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j = statFs.getBlockCount() * statFs.getBlockSize();
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return String.valueOf(j);
    }

    private static String x() {
        BluetoothAdapter bluetoothAdapter;
        String str = "";
        try {
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (bluetoothAdapter != null) {
                try {
                    if (!bluetoothAdapter.isEnabled()) {
                        return "";
                    }
                    str = bluetoothAdapter.getAddress();
                } catch (Throwable th) {
                    th = th;
                    com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
                    if (str != null) {
                    }
                    try {
                        str = a(bluetoothAdapter);
                    } catch (Throwable th2) {
                        com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th2);
                    }
                    return e.e(str);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bluetoothAdapter = null;
        }
        if (str != null || str.endsWith("00:00:00:00:00")) {
            str = a(bluetoothAdapter);
        }
        return e.e(str);
    }

    public static String o(Context context) {
        if (com.alipay.alipaysecuritysdk.common.e.d.a(context, "android.permission.BLUETOOTH")) {
            return "";
        }
        String x = x();
        try {
            if (e.c(x) || "02:00:00:00:00:00".equals(x)) {
                x = Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
            }
            if (x == null) {
                return "";
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return x;
    }

    private static String a(BluetoothAdapter bluetoothAdapter) {
        Object obj;
        try {
            Field declaredField = BluetoothAdapter.class.getDeclaredField("mService");
            declaredField.setAccessible(true);
            obj = declaredField.get(bluetoothAdapter);
        } catch (Throwable th) {
            th.getMessage();
        }
        if (obj == null) {
            return null;
        }
        Method declaredMethod = obj.getClass().getDeclaredMethod("getAddress", new Class[0]);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(obj, new Object[0]);
        if (invoke instanceof String) {
            return (String) invoke;
        }
        return null;
    }

    public static String p(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return "";
        }
    }

    public static String k() {
        String str;
        try {
            str = a("gsm.version.baseband", "no message");
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            str = "";
        }
        return e.e(str);
    }

    public static String q(Context context) {
        String str = "";
        if (com.alipay.alipaysecuritysdk.common.e.d.b(context, "android.permission.ACCESS_FINE_LOCATION") || (com.alipay.alipaysecuritysdk.common.e.d.b(context, ManifestPermission.ACCESS_COARSE_LOCATION) && Build.VERSION.SDK_INT > 27)) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null && wifiManager.isWifiEnabled()) {
                    str = wifiManager.getConnectionInfo().getBSSID();
                }
            } catch (Throwable th) {
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            }
            return e.e(str);
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003e A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #4 {all -> 0x0057, blocks: (B:15:0x0034, B:17:0x003e), top: B:37:0x0034 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String l() {
        /*
            java.lang.String r0 = "SEC_SDK-tool"
            java.lang.String r1 = ""
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L68
            java.lang.String r4 = "/proc/version"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L68
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L28
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L28
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L28
            r6 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L28
        L1c:
            java.lang.String r5 = r4.readLine()     // Catch: java.lang.Throwable -> L26
            if (r5 == 0) goto L2e
            r2.append(r5)     // Catch: java.lang.Throwable -> L26
            goto L1c
        L26:
            r5 = move-exception
            goto L2b
        L28:
            r4 = move-exception
            r5 = r4
            r4 = 0
        L2b:
            com.alipay.alipaysecuritysdk.common.c.b.a(r0, r5)     // Catch: java.lang.Throwable -> L60
        L2e:
            r4.close()     // Catch: java.lang.Throwable -> L34
            r3.close()     // Catch: java.lang.Throwable -> L34
        L34:
            java.lang.String r3 = r2.toString()     // Catch: java.lang.Throwable -> L57
            boolean r3 = com.alipay.alipaysecuritysdk.common.e.e.d(r3)     // Catch: java.lang.Throwable -> L57
            if (r3 == 0) goto L5b
            java.lang.String r3 = "version "
            int r3 = r2.indexOf(r3)     // Catch: java.lang.Throwable -> L57
            int r3 = r3 + 8
            java.lang.String r2 = r2.substring(r3)     // Catch: java.lang.Throwable -> L57
            java.lang.String r3 = " "
            int r3 = r2.indexOf(r3)     // Catch: java.lang.Throwable -> L57
            r4 = 0
            java.lang.String r1 = r2.substring(r4, r3)     // Catch: java.lang.Throwable -> L57
            goto L5b
        L57:
            r2 = move-exception
            com.alipay.alipaysecuritysdk.common.c.b.a(r0, r2)
        L5b:
            java.lang.String r0 = com.alipay.alipaysecuritysdk.common.e.e.e(r1)
            return r0
        L60:
            r0 = move-exception
            r4.close()     // Catch: java.lang.Throwable -> L67
            r3.close()     // Catch: java.lang.Throwable -> L67
        L67:
            throw r0
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.common.collector.b.l():java.lang.String");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x001e -> B:14:0x0023). Please submit an issue!!! */
    public static String r(Context context) {
        String str;
        try {
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        if (Build.VERSION.SDK_INT < 29) {
            if (Build.VERSION.SDK_INT >= 28) {
                if (com.alipay.alipaysecuritysdk.common.e.d.b(context, "android.permission.READ_PHONE_STATE")) {
                    str = Build.getSerial();
                }
            } else {
                str = Build.SERIAL;
            }
            return e.e(str);
        }
        str = "";
        return e.e(str);
    }

    public static String m() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String n() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            str = "";
        }
        return e.e(str);
    }

    public static String s(Context context) {
        try {
            String v = v(context);
            String y = y();
            if (e.d(v) && e.d(y)) {
                StringBuilder sb = new StringBuilder();
                sb.append(v);
                sb.append(":");
                sb.append(y());
                return sb.toString();
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
        }
        return "";
    }

    private static String v(Context context) {
        if (com.alipay.alipaysecuritysdk.common.e.d.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                return (subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7 || subtype == 11) ? "2G" : (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : RVScheduleType.UNKNOW;
            }
            return "";
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return "";
        }
    }

    private static String y() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return "";
        }
    }

    public static String t(Context context) {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (keyguardManager != null && keyguardManager.isKeyguardSecure()) {
                long j = 0;
                String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
                for (int i = 0; i < 5; i++) {
                    long j2 = -1;
                    try {
                        j2 = new File(strArr[i]).lastModified();
                    } catch (Throwable th) {
                        com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
                    }
                    j = Math.max(j2, j);
                }
                StringBuilder sb = new StringBuilder("1:");
                sb.append(j);
                return sb.toString();
            }
            return "0:0";
        } catch (Throwable th2) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th2);
            return "";
        }
    }

    public static String u(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return "";
            }
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("status", -1);
            boolean z = intExtra2 == 2 || intExtra2 == 5;
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "1" : "0");
            sb.append(":");
            sb.append(intExtra);
            return sb.toString();
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return "";
        }
    }

    public static String o() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            return sb.toString();
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return "";
        }
    }

    public static String p() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb.append("00");
            sb.append(":");
            for (int i = 0; i < 7; i++) {
                if (new File(strArr[i]).exists()) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", th);
            return "";
        }
    }

    public static String q() {
        String[] strArr = {"dalvik.system.Taint"};
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(":");
        for (int i = 0; i <= 0; i++) {
            try {
                Class.forName(strArr[0]);
                sb.append("1");
            } catch (Throwable unused) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    public static String r() {
        LineNumberReader lineNumberReader;
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        sb.append("00");
        sb.append(":");
        for (String str : linkedHashMap.keySet()) {
            char c = '0';
            try {
                lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String readLine = lineNumberReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                            c = '1';
                            break;
                        }
                    } catch (Throwable unused) {
                        sb.append('0');
                        if (lineNumberReader == null) {
                        }
                        lineNumberReader.close();
                    }
                }
                sb.append(c);
            } catch (Throwable unused2) {
                lineNumberReader = null;
            }
            try {
                lineNumberReader.close();
            } catch (Throwable unused3) {
            }
        }
        return sb.toString();
    }

    public static String s() {
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(":");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", OauthConstant.OauthType.SDK_TYPE);
        linkedHashMap.put("MODEL", OauthConstant.OauthType.SDK_TYPE);
        for (String str : linkedHashMap.keySet()) {
            char c = '0';
            try {
                String str2 = (String) Build.class.getField(str).get(null);
                String str3 = (String) linkedHashMap.get(str);
                String lowerCase = str2 != null ? str2.toLowerCase() : null;
                if (lowerCase != null && lowerCase.contains(str3)) {
                    c = '1';
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return sb.toString();
    }

    public static String t() {
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(":");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", OauthConstant.OauthType.SDK_TYPE);
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", OauthConstant.OauthType.SDK_TYPE);
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            String str2 = (String) linkedHashMap.get(str);
            String a2 = a(str, "");
            char c = '0';
            if (a2 != null && a2.contains(str2)) {
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static long u() {
        try {
            if (b == 0) {
                b = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            }
        } catch (Throwable unused) {
        }
        return b;
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
