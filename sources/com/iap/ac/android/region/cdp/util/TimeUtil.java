package com.iap.ac.android.region.cdp.util;

import com.iap.ac.android.region.cdp.model.CdpFatigueInfo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class TimeUtil {
    public static long getPeriodStartTime(String str, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(getServerTime());
        long currentTimeMillis = System.currentTimeMillis();
        if (CdpFatigueInfo.PERIOD_MONTH.equalsIgnoreCase(str)) {
            calendar.set(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        } else if ("WEEK".equalsIgnoreCase(str)) {
            calendar.set(7, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        } else if ("DAY".equalsIgnoreCase(str)) {
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        } else if ("HOUR".equalsIgnoreCase(str)) {
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        } else {
            return currentTimeMillis;
        }
    }

    public static long getServerTime() {
        long httpRespTimeMillis = SpProvider.getInstance().getHttpRespTimeMillis();
        if (httpRespTimeMillis <= 0) {
            return System.currentTimeMillis();
        }
        return (System.currentTimeMillis() - SpProvider.getInstance().getHttpRespTimeMillisStart()) + httpRespTimeMillis;
    }

    public static boolean isInCurrentDay(long j, TimeZone timeZone) {
        return isSameDay(j, getServerTime(), timeZone);
    }

    public static boolean isInCurrentHour(long j, TimeZone timeZone) {
        return isSameHour(j, getServerTime(), timeZone);
    }

    public static boolean isInCurrentMonth(long j, TimeZone timeZone) {
        return isSameMonth(j, getServerTime(), timeZone);
    }

    public static boolean isInCurrentPeriod(String str, long j, TimeZone timeZone) {
        if (CdpFatigueInfo.PERIOD_MONTH.equalsIgnoreCase(str)) {
            return isInCurrentMonth(j, timeZone);
        }
        if ("WEEK".equalsIgnoreCase(str)) {
            return isInCurrentWeek(j, timeZone);
        }
        if ("DAY".equalsIgnoreCase(str)) {
            return isInCurrentDay(j, timeZone);
        }
        if ("HOUR".equalsIgnoreCase(str)) {
            return isInCurrentHour(j, timeZone);
        }
        return false;
    }

    public static boolean isInCurrentWeek(long j, TimeZone timeZone) {
        return isSameWeek(j, getServerTime(), timeZone);
    }

    public static boolean isSameDay(long j, long j2, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(Long.valueOf(j2)).equals(simpleDateFormat.format(Long.valueOf(j)));
    }

    public static boolean isSameHour(long j, long j2, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh");
        String format = simpleDateFormat.format(Long.valueOf(j));
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(Long.valueOf(j2)).equals(format);
    }

    public static boolean isSameMonth(long j, long j2, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(Long.valueOf(j2)).equals(simpleDateFormat.format(Long.valueOf(j)));
    }

    public static boolean isSameWeek(long j, long j2, TimeZone timeZone) {
        if ((((Math.abs(j2 - j) / 1000) / 60) / 60) / 24 > 7) {
            return false;
        }
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(j2);
        int i = calendar.get(3);
        calendar.setTimeInMillis(j);
        return i == calendar.get(3);
    }
}
