package com.alibaba.ariver.ariverexthub.api;

import com.alibaba.ariver.ariverexthub.api.utils.ExtHubLogger;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class RVEApiAnalysis {
    public static void recordRVEApiCall(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("host", str);
        hashMap.put("appId", str2);
        hashMap.put(RecordError.KEY_JSAPI_NAME, str3);
        ExtHubLogger.recordRVEApiCall(hashMap);
    }

    public static void recordExthubApiCallError(String str, String str2, String str3, int i, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("host", str);
        hashMap.put("appId", str2);
        hashMap.put(RecordError.KEY_JSAPI_NAME, str3);
        hashMap.put("errorCode", String.valueOf(i));
        hashMap.put("errorMessage", str4);
        ExtHubLogger.recordExthubApiCallError(hashMap);
    }

    public static void recordApiCallError(String str, String str2, String str3, int i, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("host", str);
        hashMap.put("appId", str2);
        hashMap.put(RecordError.KEY_JSAPI_NAME, str3);
        hashMap.put("errorCode", String.valueOf(i));
        hashMap.put("errorMessage", str4);
        ExtHubLogger.recordApiCallError(hashMap);
    }
}
