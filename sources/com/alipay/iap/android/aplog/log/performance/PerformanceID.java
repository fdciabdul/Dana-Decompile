package com.alipay.iap.android.aplog.log.performance;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum PerformanceID {
    MONITORPOINT_PERFORMANCE("performance"),
    MONITORPOINT_FOOTPRINT("footprint"),
    MONITORPOINT_KEYBIZTRACE("keybiztrace");

    private static final Map<String, PerformanceID> sStringToEnum = new HashMap();
    private String desc;

    static {
        for (PerformanceID performanceID : values()) {
            sStringToEnum.put(performanceID.desc, performanceID);
        }
    }

    PerformanceID(String str) {
        this.desc = str;
    }

    public static PerformanceID fromString(String str) {
        return sStringToEnum.get(str);
    }

    public final String getDes() {
        return this.desc;
    }
}
