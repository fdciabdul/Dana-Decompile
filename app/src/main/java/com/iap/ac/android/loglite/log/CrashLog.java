package com.iap.ac.android.loglite.log;

import android.os.Build;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import com.huawei.hms.push.e;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.utils.BizCodeMatchUtils;
import com.iap.ac.android.loglite.utils.LoggingUtil;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class CrashLog extends LogEvent {
    public CrashLog(String str, Map<String, String> map) {
        super(str, map);
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String d() {
        return "crash";
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String f() {
        return "crash";
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String g() {
        StringBuilder sb = new StringBuilder();
        AnalyticsContext analyticsContext = AnalyticsContext.getInstance();
        sb.append(e.PlaceComponentResult);
        LoggingUtil.appendParam(sb, LoggingUtil.getNowTime());
        LoggingUtil.appendParam(sb, analyticsContext.getProductId());
        LoggingUtil.appendParam(sb, analyticsContext.getContextInfo().b);
        LoggingUtil.appendParam(sb, "2");
        analyticsContext.getContextInfo();
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, h());
        LoggingUtil.appendParam(sb, "exception");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "call_write_crash_log_api");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "MonitorPoint_Crash");
        LoggingUtil.appendParam(sb, this.b.get("stackTrace"));
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, this.f7593a);
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, Build.MODEL);
        LoggingUtil.appendParam(sb, Build.VERSION.RELEASE);
        LoggingUtil.appendParam(sb, BizCodeMatchUtils.a(analyticsContext.getApplication()));
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, e());
        LoggingUtil.appendParam(sb, Locale.getDefault().toString());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, this.b.get("threadName"));
        LoggingUtil.appendParam(sb, "java");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendExtParam(sb, analyticsContext.getExtraParamMap());
        LoggingUtil.appendParam(sb, b());
        sb.append(MasLog.Constant.GAP);
        return sb.toString();
    }
}
