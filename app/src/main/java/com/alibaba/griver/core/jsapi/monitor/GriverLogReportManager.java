package com.alibaba.griver.core.jsapi.monitor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class GriverLogReportManager {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, GriverLogReport> f6417a;
    private final GriverLogReportConfig b;

    /* loaded from: classes6.dex */
    interface GriverLogReportManagerFactory {
        public static final GriverLogReportManager manager = new GriverLogReportManager();
    }

    public static GriverLogReportManager getInstance() {
        return GriverLogReportManagerFactory.manager;
    }

    private GriverLogReportManager() {
        this.f6417a = new HashMap();
        this.b = new GriverLogReportConfig(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_GRIVER_LOG_REPORT_CONFIG));
    }

    public boolean canReport(String str) {
        return this.b.canReport(str);
    }

    public JSONObject logCache(String str, String str2) {
        GriverLogReport griverLogReport = this.f6417a.get(GriverLogReport.getReportId(str, str2));
        if (griverLogReport != null && griverLogReport.getCacheData() != null) {
            return griverLogReport.getCacheData();
        }
        return new JSONObject();
    }

    public void reportData(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        synchronized (this) {
            String reportId = GriverLogReport.getReportId(str, str2);
            if (!this.f6417a.containsKey(reportId)) {
                this.f6417a.put(reportId, new GriverLogReport(str, str2, this.b.getLogReportCount(), this.b.getLogReportTimeSecond()));
            }
            GriverLogReport griverLogReport = this.f6417a.get(reportId);
            if (griverLogReport != null) {
                griverLogReport.addData(str3, str4, jSONObject);
            }
        }
    }
}
