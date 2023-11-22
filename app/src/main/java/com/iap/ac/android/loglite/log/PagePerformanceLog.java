package com.iap.ac.android.loglite.log;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes8.dex */
public class PagePerformanceLog extends PerformanceLog {
    public String f;

    public PagePerformanceLog(String str, String str2, Map<String, String> map) {
        super(str2, map);
        this.f = str;
    }

    @Override // com.iap.ac.android.loglite.log.PerformanceLog
    public String i() {
        return TextUtils.isEmpty(this.f) ? "-" : this.f;
    }
}
