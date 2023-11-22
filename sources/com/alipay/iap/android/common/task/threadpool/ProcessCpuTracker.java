package com.alipay.iap.android.common.task.threadpool;

import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class ProcessCpuTracker {
    private static int[] SYSTEM_CPU_FORMAT = null;
    private static final String TAG = "ProcessCpuTracker";
    private static final String TOTAL_STAT_FILE = "/proc/stat";
    private static Method readProcFileMethod;
    private long mBaseIdleTime;
    private long mBaseIrqTime;
    private long mBaseSystemTime;
    private long mBaseUserTime;
    private long mRelIdleTime;
    private long mRelIrqTime;
    private long mRelSystemTime;
    private long mRelUserTime;
    private long[] mTotalCpuData = new long[7];

    @Deprecated
    public ProcessCpuTracker update() {
        return this;
    }

    @Deprecated
    public float getCpuIdlePercent() {
        long j = this.mRelUserTime;
        long j2 = this.mRelSystemTime;
        long j3 = this.mRelIrqTime;
        long j4 = this.mRelIdleTime;
        long j5 = j + j2 + j3 + j4;
        if (j5 > 0) {
            return (((float) j4) * 100.0f) / ((float) j5);
        }
        return -1.0f;
    }
}
