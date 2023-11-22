package com.alibaba.griver.core.worker;

import android.os.HandlerThread;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.v8worker.V8Worker;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.worker.GriverV8WorkerExtension;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.base.utils.RemoteDebugCompatUtils;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public class GriverWorkerFactory {

    /* loaded from: classes3.dex */
    public enum WorkerType {
        JSIWorker,
        WebWorker
    }

    public static Worker createWorker(WorkerType workerType, App app, String str, String str2) {
        String str3;
        boolean z = QJSUtils.isAllowedQJS(app.getAppId()) && workerType == WorkerType.JSIWorker;
        GriverV8WorkerExtension griverV8WorkerExtension = (GriverV8WorkerExtension) RVProxy.get(GriverV8WorkerExtension.class, true);
        String str4 = "";
        String str5 = "worker";
        Worker worker = null;
        if (z && griverV8WorkerExtension != null && !RemoteDebugCompatUtils.isInDebugMode(app)) {
            try {
                AppModel appModel = (AppModel) app.getData(AppModel.class);
                List<PluginModel> plugins = (appModel == null || appModel.getAppInfoModel() == null) ? null : appModel.getAppInfoModel().getPlugins();
                V8Worker v8Worker = (V8Worker) WorkerPool.getInstance().getPreWorker(app);
                if (v8Worker != null) {
                    worker = griverV8WorkerExtension.reBindJsi(v8Worker, app, plugins, null, str);
                    worker.setWorkerId(str2);
                    str4 = "poolWorker";
                } else {
                    worker = griverV8WorkerExtension.getV8Worker(app, str, str2, plugins, null, null);
                    worker.setWorkerId(str2);
                    str4 = "worker";
                }
            } catch (Throwable th) {
                GriverLogger.e("GriverWorkerFactory", "prepareWorker exception!", th);
            }
            str3 = "jsiWorker";
        } else {
            GriverLogger.e("GriverWorkerFactory", "prepareWorker forceWebWorker by config!");
            str3 = "";
        }
        if (worker == null) {
            GriverLogger.w("GriverWorkerFactory", "degrade to web worker!");
            try {
                worker = new GriverWebWorker(app, str, str2, new CountDownLatch(1));
                worker.setWorkerId(str2);
                GriverLogger.w("GriverWorkerFactory", "degrade to web worker success, clear exception!");
                str3 = GriverMonitorConstants.WORKER_TYPE_WEB;
            } catch (Throwable th2) {
                GriverLogger.w("GriverWorkerFactory", "degrade to web worker success, clear exception!");
                throw th2;
            }
        } else {
            str5 = str4;
        }
        a(str3, str5, app);
        StringBuilder sb = new StringBuilder();
        sb.append("worker source");
        sb.append(str5);
        sb.append("   worker type:");
        sb.append(str3);
        GriverLogger.d("GriverWorkerFactory", sb.toString());
        return worker;
    }

    private static void a(String str, String str2, App app) {
        GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app));
        if (stageMonitor != null) {
            stageMonitor.addParam(GriverMonitorConstants.KEY_WORKER_TYPE, str);
            stageMonitor.addParam("workerSource", str2);
            boolean z = false;
            if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_JSI_MSG_WORKER_ENABLE, false) && "jsiWorker".equals(str)) {
                z = true;
            }
            stageMonitor.addParam("android_render2worker_msgqueue", Boolean.valueOf(z));
        }
    }

    public static Worker createPoolWorker(WorkerType workerType, String str, HandlerThread handlerThread) {
        GriverV8WorkerExtension griverV8WorkerExtension;
        if (workerType != WorkerType.JSIWorker || (griverV8WorkerExtension = (GriverV8WorkerExtension) RVProxy.get(GriverV8WorkerExtension.class, true)) == null) {
            return null;
        }
        return griverV8WorkerExtension.getV8Worker(str, handlerThread);
    }
}
