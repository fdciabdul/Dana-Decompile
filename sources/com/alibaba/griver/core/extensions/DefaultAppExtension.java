package com.alibaba.griver.core.extensions;

import android.os.Handler;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppExitPoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.griver.api.common.page.GriverAppEvent;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.ui.GriverAppExtension;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.worker.GriverV8WorkerExtension;
import com.alibaba.griver.base.performance.PerformanceMonitorFactory;
import com.alibaba.griver.base.resource.predownload.AppPreDownloadManager;
import com.alibaba.griver.base.stagemonitor.GriverPVConfig;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.core.prefetch.PrefetchManager;
import com.alibaba.griver.core.prefetch.PrefetchUtils;
import com.alibaba.griver.core.worker.QJSUtils;

/* loaded from: classes6.dex */
public class DefaultAppExtension implements AppExitPoint, AppStartPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(final App app) {
        PerformanceMonitorFactory.register(app.getAppId());
        ((GriverAppExtension) RVProxy.get(GriverAppExtension.class)).onAppStart(app);
        ((GriverAppEvent) ExtensionPoint.as(GriverAppEvent.class).node(app).create()).onAppStart(app);
        ExecutorUtils.execute(ExecutorType.NORMAL, new Runnable() { // from class: com.alibaba.griver.core.extensions.DefaultAppExtension.1
            @Override // java.lang.Runnable
            public void run() {
                if (PrefetchUtils.isPrefetchAllowed(app.getAppId()) && app.isTinyApp()) {
                    PrefetchUtils.setApp(app);
                    PrefetchManager.getInstance().prefetchData(app.getAppId(), (String) app.getStartParams().get("page"), app.getAppVersion());
                }
            }
        });
        if (app.isTinyApp() && GriverPVConfig.canMonit(app)) {
            GriverStageMonitorManager.getInstance().createPVStageMonitor(app.getAppId(), String.valueOf(app.getStartToken()));
        }
        AppPreDownloadManager.updateTopApp(app);
        GriverAllRecordsExtension griverAllRecordsExtension = (GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class);
        if (griverAllRecordsExtension == null || !griverAllRecordsExtension.canUseRecords(app)) {
            return;
        }
        griverAllRecordsExtension.createRecordReport(app);
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppExitPoint
    public void onAppExit(App app) {
        GriverV8WorkerExtension griverV8WorkerExtension;
        ((GriverAppExtension) RVProxy.get(GriverAppExtension.class)).onAppExit(app);
        ((GriverAppEvent) ExtensionPoint.as(GriverAppEvent.class).node(app).create()).onAppExit(app);
        PerformanceMonitorFactory.upload(app);
        final String appId = app.getAppId();
        new Handler().postDelayed(new Runnable() { // from class: com.alibaba.griver.core.extensions.DefaultAppExtension.2
            @Override // java.lang.Runnable
            public void run() {
                GriverMonitor.upload();
                PerformanceMonitorFactory.unRegister(appId);
            }
        }, 1000L);
        GriverAllRecordsExtension griverAllRecordsExtension = (GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class);
        if (griverAllRecordsExtension != null && griverAllRecordsExtension.canUseRecords(app)) {
            griverAllRecordsExtension.updateRecordReport(app, PerformanceMonitorFactory.getPerformance(appId));
        }
        PrefetchManager.getInstance().removePrefetchInfo(app.getAppId());
        if (!QJSUtils.isAllowedQJS(app.getAppId()) || (griverV8WorkerExtension = (GriverV8WorkerExtension) RVProxy.get(GriverV8WorkerExtension.class, true)) == null) {
            return;
        }
        griverV8WorkerExtension.clearThread(app);
    }
}
