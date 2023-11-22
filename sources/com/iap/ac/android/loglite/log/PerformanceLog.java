package com.iap.ac.android.loglite.log;

import android.os.Build;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.utils.BizCodeMatchUtils;
import com.iap.ac.android.loglite.utils.DeviceHWInfo;
import com.iap.ac.android.loglite.utils.DeviceUtil;
import com.iap.ac.android.loglite.utils.LoggingUtil;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class PerformanceLog extends LogEvent {
    public PerformanceLog(String str, Map<String, String> map) {
        super(str, map);
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String d() {
        return "performance";
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String f() {
        return "performance";
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String g() {
        StringBuilder sb = new StringBuilder();
        AnalyticsContext analyticsContext = AnalyticsContext.getInstance();
        sb.append("D-MM");
        LoggingUtil.appendParam(sb, LoggingUtil.getNowTime());
        LoggingUtil.appendParam(sb, analyticsContext.getProductId());
        LoggingUtil.appendParam(sb, analyticsContext.getContextInfo().b);
        LoggingUtil.appendParam(sb, "2");
        analyticsContext.getContextInfo();
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, analyticsContext.getSessionId());
        LoggingUtil.appendParam(sb, h());
        LoggingUtil.appendParam(sb, this.f7593a);
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "1000");
        LoggingUtil.appendParam(sb, j());
        LoggingUtil.appendParam(sb, c());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendExtParam(sb, a());
        LoggingUtil.appendParam(sb, "android");
        LoggingUtil.appendParam(sb, Build.VERSION.RELEASE);
        LoggingUtil.appendParam(sb, BizCodeMatchUtils.a(analyticsContext.getApplication()));
        LoggingUtil.appendParam(sb, Build.MODEL);
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, e());
        LoggingUtil.appendParam(sb, Locale.getDefault().toString());
        LoggingUtil.appendParam(sb, String.valueOf(DeviceHWInfo.a()));
        LoggingUtil.appendParam(sb, String.valueOf(DeviceUtil.a()));
        LoggingUtil.appendParam(sb, String.valueOf(DeviceUtil.a(analyticsContext.getApplication())));
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        Map<String, String> extraParamMap = analyticsContext.getExtraParamMap();
        Map<String, String> map = this.d;
        if (map != null && map.size() > 0) {
            extraParamMap.putAll(this.d);
        }
        LoggingUtil.appendExtParam(sb, extraParamMap);
        LoggingUtil.appendParam(sb, i());
        LoggingUtil.appendParam(sb, LoggingUtil.getResolution());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, b());
        LoggingUtil.appendParam(sb, "2");
        sb.append(MasLog.Constant.GAP);
        return sb.toString();
    }

    public String i() {
        return "-";
    }

    public String j() {
        return "performance";
    }
}
