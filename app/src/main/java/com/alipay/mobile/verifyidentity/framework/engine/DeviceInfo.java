package com.alipay.mobile.verifyidentity.framework.engine;

import android.os.Build;

/* loaded from: classes3.dex */
public class DeviceInfo {
    private static final String TAG = "DeviceInfo";

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getMobileBrand() {
        return Build.BRAND;
    }

    public static String getMobileModel() {
        return Build.MODEL;
    }

    public static String getMobileManufacturer() {
        return Build.MANUFACTURER;
    }
}
