package com.iap.ac.android.loglite.log;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipay.iap.android.aplog.api.LogCategory;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.utils.BizCodeMatchUtils;
import com.iap.ac.android.loglite.utils.DeviceHWInfo;
import com.iap.ac.android.loglite.utils.DeviceUtil;
import com.iap.ac.android.loglite.utils.LoggingUtil;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes8.dex */
public class BehaviorLog extends LogEvent {
    public Map<String, String> f;
    public String g;

    public BehaviorLog(String str, Map<String, String> map) {
        super(str, map);
        i();
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String d() {
        return "user_behavior";
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String f() {
        return LogCategory.LOG_BEHAVIOUR_MANUAL;
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String g() {
        AnalyticsContext analyticsContext = AnalyticsContext.getInstance();
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = this.b;
        boolean equals = TextUtils.equals(SummaryActivity.CHECKED, map != null ? map.get(GriverMonitorConstants.KEY_AUTO_LOG) : null);
        sb.append(equals ? "D-AM" : "D-VM");
        LoggingUtil.appendParam(sb, LoggingUtil.getNowTime());
        LoggingUtil.appendParam(sb, analyticsContext.getProductId());
        LoggingUtil.appendParam(sb, analyticsContext.getContextInfo().b);
        LoggingUtil.appendParam(sb, "2");
        analyticsContext.getContextInfo();
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, analyticsContext.getSessionId());
        LoggingUtil.appendParam(sb, h());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(equals ? "auto_" : "");
        sb2.append(j());
        LoggingUtil.appendParam(sb, sb2.toString());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, n());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, this.f7593a);
        LoggingUtil.appendParam(sb, "2");
        LoggingUtil.appendParam(sb, c());
        LoggingUtil.appendParam(sb, "c");
        Map<String, String> map2 = this.b;
        LoggingUtil.appendParam(sb, map2 != null ? map2.get("spmtracker_refer_page") : "-");
        LoggingUtil.appendParam(sb, l());
        LoggingUtil.appendParam(sb, m());
        LoggingUtil.appendExtParam(sb, a());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, o());
        LoggingUtil.appendParam(sb, e());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, k());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "1000");
        LoggingUtil.appendParam(sb, Build.MODEL);
        LoggingUtil.appendParam(sb, Build.VERSION.RELEASE);
        LoggingUtil.appendParam(sb, BizCodeMatchUtils.a(analyticsContext.getApplication()));
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, Locale.getDefault().toString());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, String.valueOf(DeviceHWInfo.a()));
        LoggingUtil.appendParam(sb, String.valueOf(DeviceUtil.a()));
        LoggingUtil.appendParam(sb, String.valueOf(DeviceUtil.a(analyticsContext.getApplication())));
        LoggingUtil.appendExtParam(sb, analyticsContext.getExtraParamMap());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, LoggingUtil.getResolution());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, b());
        analyticsContext.getApplication();
        synchronized (DeviceUtil.class) {
        }
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendExtParam(sb, this.f);
        sb.append(MasLog.Constant.GAP);
        return sb.toString();
    }

    public final void i() {
        HashMap hashMap = new HashMap();
        this.f = hashMap;
        hashMap.put(H5GetLogInfoBridge.RESULT_TIMEZONE, TimeZone.getDefault().getID());
        this.f.put("OS", "android");
        this.f.put("TimeStamp", String.valueOf(System.currentTimeMillis()));
    }

    public String j() {
        return TextUtils.isEmpty(this.g) ? "event" : this.g;
    }

    public String k() {
        return "-";
    }

    public String l() {
        return "-";
    }

    public String m() {
        return "-";
    }

    public String n() {
        return "-";
    }

    public String o() {
        return "-";
    }
}
