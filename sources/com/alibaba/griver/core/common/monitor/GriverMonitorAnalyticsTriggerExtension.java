package com.alibaba.griver.core.common.monitor;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint;
import com.alibaba.griver.base.common.monitor.GriverMonitorAnalyticsConfigManager;

/* loaded from: classes6.dex */
public class GriverMonitorAnalyticsTriggerExtension implements AppOnLoadResultPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint
    public void onLoadResult(App app, AppLoadResult appLoadResult) {
        if (app == null || appLoadResult == null || !app.isTinyApp()) {
            return;
        }
        GriverMonitorAnalyticsConfigManager.syncMonitorConfig(app, appLoadResult.appVersion);
    }
}
