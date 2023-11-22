package com.alibaba.ariver.ariverexthub.api.provider;

import java.util.Map;

/* loaded from: classes3.dex */
public interface RVELogProvider {
    void d(String str, String str2);

    void e(String str, String str2, Throwable th);

    void i(String str, String str2);

    void logEvent(String str, Map<String, String> map);

    void recordApiCallError(Map<String, String> map);

    void recordExthubApiCallError(Map<String, String> map);

    void recordRVEApiCall(Map<String, String> map);
}
