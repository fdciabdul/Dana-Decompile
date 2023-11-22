package com.alibaba.ariver.permission.api;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class RVFlag {
    public static boolean hasShowLoading = false;
    public static boolean initUcNormal = true;
    public static boolean isInChane = true;
    public static boolean isUploadLog = true;
    public static long lastTouchTime;
    public static boolean ucReady;
    public static HashMap<String, Boolean> sOpenAuthGrantFlag = new HashMap<>();
    public static Boolean sInjectDebugConsoleJS = Boolean.FALSE;
    public static Map<String, Long> eventTrackerStubMap = new ConcurrentHashMap();
    public static Map<String, Long> eventTrackerCostMap = new ConcurrentHashMap();

    public static boolean getOpenAuthGrantFlag(String str) {
        boolean booleanValue;
        synchronized (RVFlag.class) {
            booleanValue = sOpenAuthGrantFlag.containsKey(str) ? sOpenAuthGrantFlag.get(str).booleanValue() : false;
        }
        return booleanValue;
    }

    public static void setOpenAuthGrantFlag(String str, boolean z) {
        synchronized (RVFlag.class) {
            if (!TextUtils.isEmpty(str)) {
                sOpenAuthGrantFlag.put(str, Boolean.valueOf(z));
            }
        }
    }
}
