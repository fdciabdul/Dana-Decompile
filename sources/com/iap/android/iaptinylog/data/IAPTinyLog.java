package com.iap.android.iaptinylog.data;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class IAPTinyLog implements Serializable {
    public static final String IAP_TINY_LOG_PARAMETER_DIAGNOSE_LEVEL = "diagnoseLevel";
    public static final String IAP_TINY_LOG_PARAMETER_DIAGNOSE_MESSAGE = "diagnoseMessage";
    public String name;
    public Map<String, String> parameters;
    public String tag;
    public IAPTinyLogType type;

    public static IAPTinyLog diagnoseLog(String str, String str2, IAPTinyLogDiagnoseLevel iAPTinyLogDiagnoseLevel) {
        IAPTinyLog iAPTinyLog = new IAPTinyLog();
        iAPTinyLog.name = str;
        iAPTinyLog.type = IAPTinyLogType.LOG_TYPE_DIAGNOSE;
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(IAP_TINY_LOG_PARAMETER_DIAGNOSE_MESSAGE, str2);
        }
        if (iAPTinyLogDiagnoseLevel != null) {
            hashMap.put(IAP_TINY_LOG_PARAMETER_DIAGNOSE_LEVEL, iAPTinyLogDiagnoseLevel.name());
        }
        iAPTinyLog.parameters = hashMap;
        return iAPTinyLog;
    }
}
