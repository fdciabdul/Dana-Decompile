package com.iap.ac.android.loglite.log;

import com.alipay.iap.android.aplog.api.LogCategory;
import java.util.Map;

/* loaded from: classes8.dex */
public class KeyBizExceptionLog extends PerformanceLog {
    public KeyBizExceptionLog(String str, Map<String, String> map) {
        super(str, map);
    }

    @Override // com.iap.ac.android.loglite.log.PerformanceLog, com.iap.ac.android.loglite.log.LogEvent
    public String f() {
        return LogCategory.LOG_CATEGORY_HIGHAVAIL;
    }

    @Override // com.iap.ac.android.loglite.log.PerformanceLog
    public String j() {
        return "keybiztrace";
    }
}
