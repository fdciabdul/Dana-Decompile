package com.alibaba.griver.beehive.lottie.player;

/* loaded from: classes6.dex */
public class TimeUtils {
    public static final String DAY_TAG = "{{dd}}";
    public static final long DAY_TO_HOUR = 24;
    public static final long DAY_TO_MILLISECOND = 86400000;
    public static final long DAY_TO_MIN = 1440;
    public static final long DAY_TO_SECOND = 86400;
    public static final String HOUR_TAG = "{{HH}}";
    public static final long HOUR_TO_MILLISECOND = 3600000;
    public static final long HOUR_TO_MIN = 60;
    public static final long HOUR_TO_SECOND = 3600;
    public static final String MINUTE_TAG = "{{mm}}";
    public static final long MINUTE_TO_MILLISECOND = 60000;
    public static final long MINUTE_TO_SECOND = 60;
    public static final String SECOND_TAG = "{{ss}}";
    public static final long SECOND_TO_MILLISECOND = 1000;

    public static long getServerTime() {
        return System.currentTimeMillis();
    }

    public static int[] getDHMS(long j) {
        int i;
        int i2;
        int i3;
        if (j < 0) {
            j = 0;
        }
        int i4 = (int) j;
        if (i4 >= 60) {
            i = i4 / 60;
            i4 %= 60;
        } else {
            i = 0;
        }
        if (i >= 60) {
            i2 = i / 60;
            i %= 60;
        } else {
            i2 = 0;
        }
        if (i2 >= 24) {
            i3 = i2 / 24;
            i2 %= 24;
        } else {
            i3 = 0;
        }
        return new int[]{i3, i2, i, i4};
    }
}
