package com.alipay.iap.android.aplog.api;

import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorItemConstants;
import com.google.firebase.perf.FirebasePerformance;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class Level implements Serializable {
    public static final int ALL_INT = Integer.MIN_VALUE;
    public static final int DEBUG_INT = 10000;
    public static final int ERROR_INT = 40000;
    public static final int INFO_INT = 20000;
    public static final int OFF_INT = 5000;
    public static final int VERBOSE_INT = 5000;
    public static final int WARN_INT = 30000;
    private static final long serialVersionUID = -814092767334282137L;
    public int levelInt;
    public String levelStr;
    public int loggerLevel;
    public static final Level ERROR = new Level(40000, "E");
    public static final Level WARN = new Level(30000, "W");
    public static final Level INFO = new Level(20000, "I");
    public static final Level DEBUG = new Level(10000, SummaryActivity.DAYS);
    public static final Level VERBOSE = new Level(5000, "V");
    public static final Level OFF = new Level(5000, "OFF");
    public static final Level ALL = new Level(Integer.MIN_VALUE, PayMethod.ALL);
    public static final Level LOGGER_HIGH = new Level(1);
    public static final Level LOGGER_MEDIUM = new Level(2);
    public static final Level LOGGER_LOW = new Level(3);

    public Level(int i) {
        this.loggerLevel = i;
    }

    private Level(int i, String str) {
        this.loggerLevel = -1;
        this.levelInt = i;
        this.levelStr = str;
    }

    public String toString() {
        return this.levelStr;
    }

    public int toInt() {
        return this.levelInt;
    }

    public boolean isGreaterOrEqual(Level level) {
        return this.levelInt >= level.levelInt;
    }

    public static Level toLevel(String str) {
        return toLevel(str, DEBUG);
    }

    public static Level valueOf(String str) {
        return toLevel(str, DEBUG);
    }

    public static Level toLevel(int i) {
        return toLevel(i, DEBUG);
    }

    public static Level toLevel(int i, Level level) {
        if (i != 5000) {
            if (i != 10000) {
                if (i != 20000) {
                    if (i != 30000) {
                        return i != 40000 ? level : ERROR;
                    }
                    return WARN;
                }
                return INFO;
            }
            return DEBUG;
        }
        return VERBOSE;
    }

    public static Level toLevel(String str, Level level) {
        if (str == null) {
            return level;
        }
        if (str.equalsIgnoreCase(PayMethod.ALL)) {
            return ALL;
        }
        if (str.equalsIgnoreCase(FirebasePerformance.HttpMethod.TRACE)) {
            return VERBOSE;
        }
        if (str.equalsIgnoreCase("DEBUG")) {
            return DEBUG;
        }
        if (str.equalsIgnoreCase(MonitorItemConstants.LEVEL_INFO)) {
            return INFO;
        }
        if (str.equalsIgnoreCase("WARN")) {
            return WARN;
        }
        if (str.equalsIgnoreCase("ERROR")) {
            return ERROR;
        }
        return str.equalsIgnoreCase("OFF") ? OFF : level;
    }
}
