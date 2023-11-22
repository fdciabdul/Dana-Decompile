package com.iap.ac.android.loglite.log;

import com.alipay.iap.android.aplog.api.LogCategory;
import java.util.Map;

/* loaded from: classes8.dex */
public class PageLog extends BehaviorLog {
    public long h;
    public String i;
    public String j;
    public String k;

    public PageLog(String str, Map<String, String> map) {
        super(str, map);
    }

    @Override // com.iap.ac.android.loglite.log.BehaviorLog
    public String j() {
        return LogCategory.LOG_SPM;
    }

    @Override // com.iap.ac.android.loglite.log.BehaviorLog
    public String k() {
        return this.j;
    }

    @Override // com.iap.ac.android.loglite.log.BehaviorLog
    public String l() {
        return String.valueOf(this.h);
    }

    @Override // com.iap.ac.android.loglite.log.BehaviorLog
    public String m() {
        return this.k;
    }

    @Override // com.iap.ac.android.loglite.log.BehaviorLog
    public String n() {
        return this.i;
    }

    @Override // com.iap.ac.android.loglite.log.BehaviorLog
    public String o() {
        return String.valueOf(this.h);
    }
}
