package com.alibaba.griver.core.extensions;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.webview.PageFinishedPoint;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.core.webview.AndroidWebViewDelegateView;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class TrackerExtension implements AppStartPoint, NodeAware<App>, PageFinishedPoint {
    WeakReference<App> weakReference;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(App app) {
        if (app != null && BundleUtils.getBoolean(app.getStartParams(), RVParams.isH5App, false)) {
            GriverMonitor.event(GriverMonitorConstants.EVENT_START_APP, "GriverAppContainer", new MonitorMap.Builder().appId(app.getAppId()).version(app).url(BundleUtils.getString(app.getStartParams(), "url")).needAsynAppType(true).build());
        }
    }

    @Override // com.alibaba.griver.api.webview.PageFinishedPoint
    public void onPageFinished(String str) {
        WeakReference<App> weakReference = this.weakReference;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        App app = this.weakReference.get();
        boolean z = BundleUtils.getBoolean(app.getStartParams(), RVParams.isH5App, false);
        boolean isEmbeddedApp = AppInfoUtils.isEmbeddedApp(app.getActivePage());
        if (z || isEmbeddedApp) {
            if ((!(app.getActivePage() != null) || !(app.getActivePage().getRender() != null)) || !(app.getActivePage().getRender().getView() instanceof AndroidWebViewDelegateView)) {
                return;
            }
            ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(app, str, "firstScreen");
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.weakReference = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }
}
