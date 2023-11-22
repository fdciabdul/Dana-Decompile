package com.ta.audid.a;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.fingerprint.FingerprintManager;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.ta.audid.g.i;
import com.ta.audid.g.m;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class c {
    /* renamed from: a  reason: collision with other method in class */
    public static String m237a(Context context) {
        Exception e;
        String str;
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = telephonyManager != null ? telephonyManager.getDeviceId() : "";
            try {
                return !com.ta.utdid2.a.a.e.isBlank(str) ? str : "";
            } catch (Exception e2) {
                e = e2;
                m.i("", e.toString());
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
        }
    }

    public static String b(Context context) {
        Exception e;
        String str;
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = telephonyManager != null ? telephonyManager.getSubscriberId() : "";
            try {
                return !com.ta.utdid2.a.a.e.isBlank(str) ? str : "";
            } catch (Exception e2) {
                e = e2;
                m.i("", e.toString());
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
        }
    }

    public static String c(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return c();
        }
        return d(context);
    }

    private static String c() {
        try {
            byte[] hardwareAddress = NetworkInterface.getByName("wlan0").getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < hardwareAddress.length) {
                Object[] objArr = new Object[2];
                objArr[0] = Byte.valueOf(hardwareAddress[i]);
                objArr[1] = i < hardwareAddress.length - 1 ? ":" : "";
                sb.append(String.format("%02X%s", objArr));
                i++;
            }
            return sb.toString();
        } catch (Exception e) {
            m.i("", e);
            return "";
        }
    }

    private static String d(Context context) {
        if (context != null) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    String macAddress = connectionInfo.getMacAddress();
                    if (!TextUtils.isEmpty(macAddress)) {
                        return macAddress;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String d() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                String address = defaultAdapter.getAddress();
                if (!com.ta.utdid2.a.a.e.isBlank(address)) {
                    return address;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String e(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String e() {
        return i.get("ro.serialno", "");
    }

    public static String f(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception unused) {
            str = "";
        }
        return com.ta.utdid2.a.a.e.isBlank(str) ? "" : str;
    }

    public static String f() {
        return com.ta.audid.g.c.g("/sys/block/mmcblk0/device/cid");
    }

    public static String g() {
        InputStreamReader inputStreamReader;
        String str = "";
        try {
            try {
                inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo | grep Serial").getInputStream());
                try {
                    LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
                    for (int i = 0; i < 100; i = i + 1 + 1) {
                        try {
                            String readLine = lineNumberReader.readLine();
                            if (readLine != null && readLine.indexOf("Serial") >= 0) {
                                str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Exception unused2) {
                    }
                    lineNumberReader.close();
                } catch (Throwable unused3) {
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    return str;
                }
            } catch (Throwable unused4) {
                inputStreamReader = null;
            }
        } catch (Exception unused5) {
        }
        return str;
    }

    public static String g(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getLine1Number();
                }
            } catch (Exception unused) {
            }
        }
        return com.ta.utdid2.a.a.e.isBlank(str) ? "" : str;
    }

    public static String h() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.ta.audid.a.c.1
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length);
        } catch (Exception unused) {
            return "1";
        }
    }

    public static String i() {
        return com.ta.audid.g.c.g("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
    }

    public static String j() {
        String g = com.ta.audid.g.c.g("/proc/meminfo");
        return g != null ? g.split("\\s+")[1] : "";
    }

    public static String h(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.availMem >> 10);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String i(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return String.valueOf(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String j(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getResources().getDisplayMetrics().densityDpi);
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String k(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(displayMetrics.widthPixels));
            sb.append("*");
            sb.append(Integer.toString(displayMetrics.heightPixels));
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m238a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return m239b(context);
            }
            return m240c(context);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private static boolean m239b(Context context) {
        List<StorageVolume> storageVolumes = ((StorageManager) context.getSystemService("storage")).getStorageVolumes();
        if (storageVolumes != null) {
            for (StorageVolume storageVolume : storageVolumes) {
                if (storageVolume.isRemovable() && storageVolume.getState().equals("mounted")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    private static boolean m240c(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Method method = StorageManager.class.getMethod("getVolumeList", new Class[0]);
            method.setAccessible(true);
            Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
            if (objArr != null) {
                for (Object obj : objArr) {
                    if (((Boolean) obj.getClass().getMethod("isRemovable", new Class[0]).invoke(obj, new Object[0])).booleanValue() && ((String) obj.getClass().getMethod("getState", new Class[0]).invoke(obj, new Object[0])).equals("mounted")) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean a(Context context, int i) {
        List<Sensor> sensorList = ((SensorManager) context.getSystemService("sensor")).getSensorList(i);
        return sensorList != null && sensorList.size() > 0;
    }

    /* renamed from: d  reason: collision with other method in class */
    public static boolean m241d(Context context) {
        List<String> allProviders;
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager == null || (allProviders = locationManager.getAllProviders()) == null) {
            return false;
        }
        return allProviders.contains("gps");
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m242e(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((FingerprintManager) context.getSystemService("fingerprint")).isHardwareDetected()) {
                    return true;
                }
            } catch (Throwable th) {
                m.d("", th);
            }
        }
        return false;
    }

    public static String l(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            int a2 = a(context);
            if (a2 > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(a2);
                return sb.toString();
            }
            return k();
        }
        return k();
    }

    private static int a(Context context) {
        try {
            return ((BatteryManager) context.getSystemService("batterymanager")).getIntProperty(4);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static String k() {
        InputStreamReader inputStreamReader;
        String readLine;
        String str = "";
        try {
            try {
                inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/power_supply/battery/uevent").getInputStream());
                try {
                    LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
                    for (int i = 0; i < 100; i = i + 1 + 1) {
                        try {
                            readLine = lineNumberReader.readLine();
                        } catch (Throwable unused) {
                        }
                        if (readLine != null) {
                            if (readLine.contains("POWER_SUPPLY_CAPACITY")) {
                                str = readLine.substring(readLine.indexOf("=") + 1, readLine.length()).trim();
                            } else {
                                continue;
                            }
                        }
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Exception unused2) {
                    }
                    lineNumberReader.close();
                } catch (Throwable unused3) {
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    return str;
                }
            } catch (Throwable unused4) {
                inputStreamReader = null;
            }
        } catch (Exception unused5) {
        }
        return str;
    }
}
