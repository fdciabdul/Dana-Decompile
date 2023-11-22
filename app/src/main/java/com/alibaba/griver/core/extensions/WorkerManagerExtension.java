package com.alibaba.griver.core.extensions;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.worker.RemoteDebugWorker;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.webview.GriverWebviewSetting;
import com.alibaba.griver.base.preload.core.PreloadScheduler;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.base.utils.RemoteDebugCompatUtils;
import com.alibaba.griver.core.GriverParam;
import com.alibaba.griver.core.preload.impl.worker.WorkerPreloadResources;
import com.alibaba.griver.core.webview.AndroidWebView;
import com.alibaba.griver.core.worker.GriverWorkerFactory;
import id.dana.sendmoney.summary.SummaryActivity;

/* loaded from: classes6.dex */
public class WorkerManagerExtension implements CreateWorkerPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    private Worker a(Node node, String str, String str2) {
        App app = (App) node.bubbleFindNode(App.class);
        if (app == null) {
            RVLogger.w("Griver:WorkerManagerExtension", "prepareWorker but app == null!");
            return null;
        }
        if (str2 == null) {
            str2 = GriverWebviewSetting.getUserAgent();
        }
        if (RemoteDebugCompatUtils.isDebugModeWithAppx1(app)) {
            RVLogger.d("Griver:WorkerManagerExtension", "create RemoteDebugWorker");
            RemoteDebugWorker remoteDebugWorker = new RemoteDebugWorker(GriverEnv.getApplicationContext(), node, str, str2);
            remoteDebugWorker.setWorkerId(str);
            return remoteDebugWorker;
        }
        if (str == null) {
            String string = BundleUtils.getString(app.getStartParams(), "onlineHost", null);
            if (!TextUtils.isEmpty(string)) {
                str = FileUtils.combinePath(string, "index.worker.js");
            }
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("prepareWorker userAgent ");
            sb.append(str2);
            sb.append(", workerId ");
            sb.append(str);
            sb.append(" !");
            RVLogger.w("Griver:WorkerManagerExtension", sb.toString());
            return null;
        }
        return GriverWorkerFactory.createWorker(GriverWorkerFactory.WorkerType.JSIWorker, app, str2, str);
    }

    @Override // com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint
    public Worker createWorker(Context context, Node node, String str, String str2) {
        Worker a2;
        App app = (App) node.bubbleFindNode(App.class);
        if (app == null) {
            return null;
        }
        GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app));
        WorkerPreloadResources workerPreloadResources = (WorkerPreloadResources) PreloadScheduler.getInstance().getAndRemoveReadyResult(WorkerPreloadResources.class);
        if (workerPreloadResources != null && workerPreloadResources.getWorker(app.getStartToken()) != null) {
            GriverLogger.d(PreloadScheduler.TAG, "WorkerManagerExtension#createWorker, use preload worker.");
            if (stageMonitor != null) {
                stageMonitor.addParam(GriverMonitorConstants.KEY_PRELOAD_WORKER_STATUS, 1);
            }
            a2 = workerPreloadResources.getWorker(app.getStartToken());
        } else {
            GriverLogger.d(PreloadScheduler.TAG, "WorkerManagerExtension#createWorker, use default worker.");
            if (stageMonitor != null) {
                stageMonitor.addParam(GriverMonitorConstants.KEY_PRELOAD_WORKER_STATUS, 0);
            }
            a2 = a(node, str, str2);
        }
        app.getStartParams().putString(GriverParam.IS_V8_WORKER, a2 instanceof AndroidWebView ? "false" : SummaryActivity.CHECKED);
        return a2;
    }
}
