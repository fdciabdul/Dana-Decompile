package com.alibaba.ariver.ariverexthub.api.utils;

import com.alibaba.ariver.ariverexthub.api.instance.RVEProxyCenter;
import com.alibaba.ariver.ariverexthub.api.provider.RVELogProvider;
import java.util.Map;

/* loaded from: classes3.dex */
public class ExtHubLogger {
    public static void i(String str, String str2) {
        RVELogProvider logProvider = RVEProxyCenter.getInstance().getLogProvider();
        if (logProvider != null) {
            logProvider.i(str, str2);
        }
    }

    public static void recordRVEApiCall(Map<String, String> map) {
        RVELogProvider logProvider = RVEProxyCenter.getInstance().getLogProvider();
        if (logProvider != null) {
            logProvider.recordRVEApiCall(map);
        }
    }

    public static void recordExthubApiCallError(Map<String, String> map) {
        RVELogProvider logProvider = RVEProxyCenter.getInstance().getLogProvider();
        if (logProvider != null) {
            logProvider.recordExthubApiCallError(map);
        }
    }

    public static void recordApiCallError(Map<String, String> map) {
        RVELogProvider logProvider = RVEProxyCenter.getInstance().getLogProvider();
        if (logProvider != null) {
            logProvider.recordApiCallError(map);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        RVELogProvider logProvider = RVEProxyCenter.getInstance().getLogProvider();
        if (logProvider != null) {
            logProvider.e(str, str2, th);
        }
    }

    public static void d(String str, String str2) {
        RVELogProvider logProvider = RVEProxyCenter.getInstance().getLogProvider();
        if (logProvider != null) {
            logProvider.d(str, str2);
        }
    }

    public static void logEvent(String str, Map<String, String> map) {
        RVELogProvider logProvider = RVEProxyCenter.getInstance().getLogProvider();
        if (logProvider != null) {
            logProvider.logEvent(str, map);
        }
    }
}
