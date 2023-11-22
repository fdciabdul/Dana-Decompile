package com.alibaba.griver.core.common.monitor;

import com.alibaba.griver.api.common.monitor.GriverMonitorProxy;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.common.log.event.PageLogEvent;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverACCommonMonitor implements GriverMonitorProxy {
    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void performance(String str, String str2, Map<String, String> map) {
        LogEvent logEvent = new LogEvent(str, map);
        logEvent.eventType = LogEventType.PERFORMANCE_LOG;
        logEvent.bizCode = str2;
        ACMonitor.logEvent(logEvent);
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void event(String str, String str2, Map<String, String> map) {
        LogEvent logEvent = new LogEvent(str, map);
        logEvent.bizCode = str2;
        ACMonitor.logEvent(logEvent);
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void error(String str, String str2, Map<String, String> map) {
        LogEvent logEvent = new LogEvent(str, map);
        logEvent.eventType = LogEventType.CRUCIAL_LOG;
        logEvent.bizCode = str2;
        ACMonitor.logEvent(logEvent);
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void pageStart(Object obj, String str) {
        ACMonitor.logPageEvent(new PageLogEvent(str, PageLogEvent.PageEvent.START, obj, null));
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void pageExit(Object obj, String str, String str2, Map<String, String> map) {
        PageLogEvent pageLogEvent = new PageLogEvent(str, PageLogEvent.PageEvent.END, obj, map);
        pageLogEvent.bizCode = str2;
        ACMonitor.logPageEvent(pageLogEvent);
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void pageDestroy(Object obj) {
        ACMonitor.logPageEvent(new PageLogEvent(null, PageLogEvent.PageEvent.DESTORY, obj, null));
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void upload() {
        ACMonitor.flush();
    }
}
