package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.os.SystemClock;

/* loaded from: classes6.dex */
public class DetectionTracker {
    private static final DetectionTracker INSTANCE = new DetectionTracker();
    private long mLastDetectionTime = 0;

    private DetectionTracker() {
    }

    public static DetectionTracker getInstance() {
        return INSTANCE;
    }

    public long getLastDetectionTime() {
        return this.mLastDetectionTime;
    }

    public void recordDetection() {
        this.mLastDetectionTime = SystemClock.elapsedRealtime();
    }
}
