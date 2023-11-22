package com.iap.ac.android.acs.operation.biz.region.utils;

import android.os.Build;

/* loaded from: classes8.dex */
public class AndroidVersionUtils {
    public static final int VERSION_CODES_Q = 29;
    public static final int VERSION_CODES_R = 30;

    public static int getBuildVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean isNAndAbove() {
        return getBuildVersion() >= 24;
    }

    public static boolean isQAndAbove() {
        return getBuildVersion() >= 29;
    }

    public static boolean isRAndAbove() {
        return getBuildVersion() >= 30;
    }
}
