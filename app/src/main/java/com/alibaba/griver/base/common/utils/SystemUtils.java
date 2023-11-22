package com.alibaba.griver.base.common.utils;

import android.os.SystemClock;

/* loaded from: classes2.dex */
public class SystemUtils {
    public static long convert2ElapseTime(long j) {
        return SystemClock.elapsedRealtime() + (j - System.currentTimeMillis());
    }
}
