package com.bumptech.glide.util;

import android.os.Build;
import android.os.SystemClock;

/* loaded from: classes3.dex */
public final class LogTime {
    private static final double MyBillsEntityDataFactory;

    static {
        MyBillsEntityDataFactory = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    private LogTime() {
    }

    public static long PlaceComponentResult() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    public static double MyBillsEntityDataFactory(long j) {
        long uptimeMillis;
        if (Build.VERSION.SDK_INT >= 17) {
            uptimeMillis = SystemClock.elapsedRealtimeNanos();
        } else {
            uptimeMillis = SystemClock.uptimeMillis();
        }
        double d = uptimeMillis - j;
        double d2 = MyBillsEntityDataFactory;
        Double.isNaN(d);
        return d * d2;
    }
}
