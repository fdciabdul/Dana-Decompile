package com.alipay.iap.android.aplog.log;

import com.alipay.iap.android.aplog.api.Level;

/* loaded from: classes3.dex */
public class TraceLog extends BaseLogInfo {
    private Level level;
    private String msg;
    private String tag;
    private Throwable tr;

    @Override // com.alipay.iap.android.aplog.log.BaseLogInfo
    public String getLogCategory() {
        return "applog";
    }

    public TraceLog(String str, Level level, String str2, Throwable th) {
        this.tag = str;
        this.level = level;
        this.msg = str2;
        this.tr = th;
    }

    public String getTag() {
        return this.tag;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getMsg() {
        return this.msg;
    }

    public Throwable getTr() {
        return this.tr;
    }
}
