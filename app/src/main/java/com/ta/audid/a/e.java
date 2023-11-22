package com.ta.audid.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alibaba.griver.ui.popmenu.TinyAppActionState;
import com.ta.audid.g.m;

/* loaded from: classes.dex */
public class e {
    public static String m(Context context) {
        String bssid;
        try {
            bssid = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } catch (Throwable unused) {
        }
        return com.ta.utdid2.a.a.e.isBlank(bssid) ? "" : bssid;
    }

    public static String n(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String o(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getSimOperatorName() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String p(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getSimOperator();
            }
            return null;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean f(Context context) {
        int rssi;
        if (context == null) {
            return false;
        }
        try {
            rssi = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getRssi();
        } catch (Exception e) {
            m.d("", e);
        }
        return rssi <= 0 && rssi >= -70;
    }

    public static boolean g(Context context) {
        if (context != null && Build.VERSION.SDK_INT >= 18) {
            try {
                BluetoothAdapter adapter = ((BluetoothManager) context.getSystemService(TinyAppActionState.ACTION_BLUE_TOOTH)).getAdapter();
                if (adapter != null) {
                    if (adapter.isEnabled()) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
