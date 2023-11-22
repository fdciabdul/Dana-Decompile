package com.iap.ac.android.common.log.event;

import com.iap.ac.android.common.a.a;
import java.util.Map;

/* loaded from: classes3.dex */
public class LogEvent extends BaseLogEvent {
    public String eventName;
    public LogEventType eventType = LogEventType.BEHAVIOR_LOG;

    public LogEvent(String str, Map<String, String> map) {
        this.eventName = str;
        this.params = map;
    }

    @Override // com.iap.ac.android.common.log.event.BaseLogEvent
    public String toString() {
        StringBuilder a2 = a.a("LogEvent{eventName='");
        a2.append(this.eventName);
        a2.append('\'');
        a2.append(", params=");
        a2.append(this.params);
        a2.append(", bizCode='");
        a2.append(this.bizCode);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
