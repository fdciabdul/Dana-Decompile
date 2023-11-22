package com.alibaba.griver.core.common.monitor;

import com.alibaba.griver.api.common.monitor.GriverMonitorProxy;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverEmptyMonitor implements GriverMonitorProxy {
    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void error(String str, String str2, Map<String, String> map) {
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void event(String str, String str2, Map<String, String> map) {
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void pageDestroy(Object obj) {
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void pageExit(Object obj, String str, String str2, Map<String, String> map) {
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void pageStart(Object obj, String str) {
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void performance(String str, String str2, Map<String, String> map) {
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void upload() {
    }
}
