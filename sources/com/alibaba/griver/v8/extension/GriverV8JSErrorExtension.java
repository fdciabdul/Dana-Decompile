package com.alibaba.griver.v8.extension;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.v8worker.extension.V8JSErrorPoint;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class GriverV8JSErrorExtension implements NodeAware<App>, V8JSErrorPoint {
    WeakReference<App> weakReference;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.v8worker.extension.V8JSErrorPoint
    public void onException(String str) {
        WeakReference<App> weakReference = this.weakReference;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        App app = this.weakReference.get();
        GriverMonitor.error(GriverMonitorConstants.ERROR_JS_EXECUTE_EXCEPTION, "GriverAppContainer", new MonitorMap.Builder().appId(app.getAppId()).version((AppModel) app.getData(AppModel.class)).needAsynAppType(true).append(GriverMonitorConstants.KEY_EXCEPTION_MESSAGE, str).workerType(GriverMonitorConstants.WORKER_TYPE_V8).message(GriverMonitorConstants.MESSAGE_WORKER_JS_EXCEPTION).build());
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
