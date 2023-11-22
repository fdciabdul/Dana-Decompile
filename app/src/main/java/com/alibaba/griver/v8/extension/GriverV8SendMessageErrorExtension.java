package com.alibaba.griver.v8.extension;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class GriverV8SendMessageErrorExtension implements NodeAware<App>, V8SendMessageErrorPoint {
    WeakReference<App> appWeakReference;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint
    public void onSendMessageException(Throwable th) {
        WeakReference<App> weakReference = this.appWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        App app = this.appWeakReference.get();
        GriverMonitor.error(GriverMonitorConstants.ERROR_JS_EXECUTE_EXCEPTION, "GriverAppContainer", new MonitorMap.Builder().appId(app.getAppId()).version((AppModel) app.getData(AppModel.class)).needAsynAppType(true).workerType(GriverMonitorConstants.WORKER_TYPE_V8).exception(th).message(GriverMonitorConstants.MESSAGE_WORKER_SEND_MESSAGE_EXCEPTION).build());
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.appWeakReference = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }
}
