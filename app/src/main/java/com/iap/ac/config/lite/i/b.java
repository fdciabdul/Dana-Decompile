package com.iap.ac.config.lite.i;

import android.content.Context;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.IACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.common.log.event.PageLogEvent;
import com.iap.ac.android.loglite.api.AnalyticsConfig;
import com.iap.ac.android.loglite.api.CommonAnalyticsAgent;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.config.lite.common.AmcsConstants;
import com.iap.ac.config.lite.d.e;
import java.util.Map;

/* loaded from: classes8.dex */
public class b {
    private static final String b = e.b("LogService");
    private static boolean c = false;

    /* renamed from: a  reason: collision with root package name */
    private CommonAnalyticsAgent f7645a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a implements IACMonitor {
        a() {
        }

        @Override // com.iap.ac.android.common.log.IACMonitor
        public void flush() {
            b.this.f7645a.flushLogs();
        }

        @Override // com.iap.ac.android.common.log.IACMonitor
        public void logEvent(LogEvent logEvent) {
            if (logEvent != null) {
                String str = b.b;
                StringBuilder sb = new StringBuilder();
                sb.append("logBehavior to lite log, bizCode:");
                sb.append(logEvent.bizCode);
                ACLog.i(str, sb.toString());
                b.this.f7645a.sendBehaviorLog(logEvent.eventName, logEvent.bizCode, logEvent.params);
                return;
            }
            ACLog.i(b.b, "sendBehavior log error, event is null");
        }

        @Override // com.iap.ac.android.common.log.IACMonitor
        public void logPageEvent(PageLogEvent pageLogEvent) {
        }

        @Override // com.iap.ac.android.common.log.IACMonitor
        public void setGlobalParameters(Map<String, String> map) {
            AnalyticsContext.getInstance().setGlobalExtParam(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.iap.ac.config.lite.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0143b {

        /* renamed from: a  reason: collision with root package name */
        private static final b f7647a = new b();
    }

    protected b() {
    }

    public static b b() {
        return C0143b.f7647a;
    }

    public void a(Context context, String str, String str2) {
        synchronized (this) {
            if (c) {
                return;
            }
            if (e.a("com.iap.ac.android.loglite.api.AnalyticsConfig") && e.a("com.iap.ac.android.loglite.api.AnalyticsHelper")) {
                AnalyticsConfig.init(context, str, str2);
                AnalyticsConfig.addCrashWhiteList("com.iap.ac");
                AnalyticsConfig.registerBizTypeToUploadUrl("AMCS-LITE", str2);
                ACLog.i(b, "Log component initialize finish");
                this.f7645a = new CommonAnalyticsAgent(AmcsConstants.BIZ_CODE_AMCSLITE_FOR_MULTI_INSTANCE);
                ACMonitor.setACMonitorImpl(new a(), AmcsConstants.BIZ_CODE_AMCSLITE_FOR_MULTI_INSTANCE);
                c = true;
                return;
            }
            ACLog.e(b, "lite log init error, without dependent libraries");
        }
    }
}
