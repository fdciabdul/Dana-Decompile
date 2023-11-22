package com.alipay.zoloz.zface.services;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class TimeRecord {
    private HashMap<String, Long> mTimes = new HashMap<>();

    /* loaded from: classes7.dex */
    static abstract class TimeRecordHolder {
        public static final TimeRecord S_INSTANCE = new TimeRecord();

        private TimeRecordHolder() {
        }
    }

    public static TimeRecord getInstance() {
        return TimeRecordHolder.S_INSTANCE;
    }

    public void recordTime(String str) {
        this.mTimes.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public long getTimeInterval(String str) {
        if (this.mTimes.get(str) == null) {
            return -1L;
        }
        return System.currentTimeMillis() - this.mTimes.get(str).longValue();
    }
}
