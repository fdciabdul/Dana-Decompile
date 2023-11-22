package com.iap.ac.android.loglite.log;

import android.text.TextUtils;
import com.iap.ac.android.common.account.ACUserInfoManager;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.loglite.config.LogStrategyInfo;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.utils.LoggingUtil;
import com.iap.ac.android.loglite.utils.TraceIdUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class LogEvent {

    /* renamed from: a  reason: collision with root package name */
    public String f7593a;
    public Map<String, String> b;
    public String c;
    public Map<String, String> d = new ConcurrentHashMap();
    public String e;

    public LogEvent(String str, Map<String, String> map) {
        this.f7593a = str;
        this.b = map;
    }

    public Map<String, String> a() {
        Map<String, String> globalExtParam = AnalyticsContext.getInstance().getGlobalExtParam();
        if (globalExtParam != null && globalExtParam.size() > 0) {
            for (Map.Entry<String, String> entry : globalExtParam.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key)) {
                    if (value == null) {
                        value = "";
                    }
                    this.b.put(key, value);
                }
            }
        }
        return this.b;
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        sb.append("20000000");
        sb.append(LoggingUtil.getServerTime());
        if (TraceIdUtil.f7605a == 10000) {
            TraceIdUtil.f7605a = 1;
        }
        Locale locale = Locale.getDefault();
        int i = TraceIdUtil.f7605a;
        TraceIdUtil.f7605a = i + 1;
        sb.append(String.format(locale, "%04d", Integer.valueOf(i)));
        return sb.toString();
    }

    public String c() {
        return TextUtils.isEmpty(this.c) ? d() : this.c;
    }

    public abstract String d();

    public String e() {
        LogStrategyInfo a2 = AnalyticsContext.getInstance().getConfigurationManager().a(this.e);
        if (a2 != null && a2.instanceId) {
            String instanceId = InstanceInfo.getInstanceId(AnalyticsContext.getInstance().getApplication());
            return !TextUtils.isEmpty(instanceId) ? instanceId : "-";
        }
        return "-";
    }

    public abstract String f();

    public abstract String g();

    public String h() {
        LogStrategyInfo a2 = AnalyticsContext.getInstance().getConfigurationManager().a(this.e);
        if (a2 != null && a2.openId) {
            String openId = ACUserInfoManager.getInstance(this.e).getOpenId();
            return !TextUtils.isEmpty(openId) ? openId : "-";
        }
        return "-";
    }
}
