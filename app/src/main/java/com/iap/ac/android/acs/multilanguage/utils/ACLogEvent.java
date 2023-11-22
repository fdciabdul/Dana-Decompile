package com.iap.ac.android.acs.multilanguage.utils;

import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.common.log.event.LogEventType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ACLogEvent {

    /* renamed from: a  reason: collision with root package name */
    private String f7532a;
    private String b;
    private LogEventType c = LogEventType.BEHAVIOR_LOG;
    private Map<String, String> d;

    private ACLogEvent(String str, String str2) {
        this.b = str2;
        this.f7532a = str;
    }

    public static ACLogEvent newLogger(String str, String str2) {
        return new ACLogEvent(str, str2);
    }

    public ACLogEvent addParams(String str, String str2) {
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.d.put(str, str2);
        return this;
    }

    public void event() {
        LogEvent logEvent = new LogEvent(this.b, this.d);
        logEvent.bizCode = this.f7532a;
        logEvent.eventType = this.c;
        ACMonitor.getInstance("ac_biz").logEvent(logEvent);
    }

    public ACLogEvent setEventType(LogEventType logEventType) {
        this.c = logEventType;
        return this;
    }
}
