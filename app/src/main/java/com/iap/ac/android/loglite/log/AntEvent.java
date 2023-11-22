package com.iap.ac.android.loglite.log;

import android.os.Build;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.utils.BizCodeMatchUtils;
import com.iap.ac.android.loglite.utils.DeviceHWInfo;
import com.iap.ac.android.loglite.utils.DeviceUtil;
import com.iap.ac.android.loglite.utils.LoggingUtil;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class AntEvent extends LogEvent {
    public Map<String, String> f;
    public Map<String, String> g;

    public AntEvent(String str, Map<String, String> map) {
        super(str, map);
        i();
        j();
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String d() {
        return "antEvent";
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String f() {
        Map<String, String> map = this.b;
        if (map != null && map.containsKey("antLogCategory")) {
            return this.b.get("antLogCategory");
        }
        return c();
    }

    @Override // com.iap.ac.android.loglite.log.LogEvent
    public String g() {
        AnalyticsContext analyticsContext = AnalyticsContext.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("D-AE");
        LoggingUtil.appendParam(sb, LoggingUtil.getNowTime());
        LoggingUtil.appendParam(sb, analyticsContext.getProductId());
        LoggingUtil.appendParam(sb, analyticsContext.getContextInfo().b);
        LoggingUtil.appendParam(sb, "2");
        analyticsContext.getContextInfo();
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, h());
        LoggingUtil.appendParam(sb, "1000");
        LoggingUtil.appendParam(sb, this.f7593a);
        LoggingUtil.appendParam(sb, c());
        LoggingUtil.appendParam(sb, "2");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "android");
        LoggingUtil.appendParam(sb, Build.VERSION.RELEASE);
        LoggingUtil.appendParam(sb, BizCodeMatchUtils.a(analyticsContext.getApplication()));
        LoggingUtil.appendParam(sb, Build.MODEL);
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, e());
        LoggingUtil.appendParam(sb, Locale.getDefault().toString());
        LoggingUtil.appendParam(sb, Build.MANUFACTURER);
        LoggingUtil.appendParam(sb, LoggingUtil.getResolution());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendExtParam(sb, this.f);
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, b());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendExtParam(sb, a());
        LoggingUtil.appendExtParam(sb, this.g);
        LoggingUtil.appendParam(sb, "-");
        sb.append(MasLog.Constant.GAP);
        return sb.toString();
    }

    public final void i() {
        this.f = new HashMap();
        AnalyticsContext analyticsContext = AnalyticsContext.getInstance();
        this.f.put("NumCoresOfCPU", String.valueOf(DeviceHWInfo.a()));
        this.f.put("CPUMaxFreq", String.valueOf(DeviceUtil.a()));
        this.f.put("TotalMem", String.valueOf(DeviceUtil.a(analyticsContext.getApplication())));
        Map<String, String> map = this.f;
        analyticsContext.getApplication();
        synchronized (DeviceUtil.class) {
        }
        map.put("ANDROID_ID", "-");
    }

    public final void j() {
        HashMap hashMap = new HashMap();
        this.g = hashMap;
        hashMap.put(H5GetLogInfoBridge.RESULT_TIMEZONE, TimeZone.getDefault().getID());
        this.g.put("OS", "android");
        this.g.put("TimeStamp", String.valueOf(System.currentTimeMillis()));
    }
}
