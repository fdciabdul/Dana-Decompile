package com.iap.ac.android.common.task.threadpool;

import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class ProcessCpuTracker {
    public static int[] SYSTEM_CPU_FORMAT = null;
    public static final String TAG = "ProcessCpuTracker";
    public static final String TOTAL_STAT_FILE = "/proc/stat";
    public static Method readProcFileMethod;
    public long mBaseIdleTime;
    public long mBaseIrqTime;
    public long mBaseSystemTime;
    public long mBaseUserTime;
    public long mRelIdleTime;
    public long mRelIrqTime;
    public long mRelSystemTime;
    public long mRelUserTime;
    public long[] mTotalCpuData = new long[7];

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

    @Deprecated
    public ProcessCpuTracker update() {
        return this;
    }
}
