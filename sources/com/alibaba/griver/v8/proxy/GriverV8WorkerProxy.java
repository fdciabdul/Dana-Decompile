package com.alibaba.griver.v8.proxy;

import android.os.HandlerThread;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.v8worker.V8Worker;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.worker.GriverV8WorkerExtension;
import com.alibaba.griver.v8.JsiV8Worker;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public class GriverV8WorkerProxy implements GriverV8WorkerExtension {
    @Override // com.alibaba.griver.base.common.worker.GriverV8WorkerExtension
    public Worker getV8Worker(App app, String str, String str2, List<PluginModel> list, HandlerThread handlerThread, CountDownLatch countDownLatch) {
        if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_JSI_MSG_WORKER_ENABLE, false)) {
            return new JsiV8Worker(app, str, list, null, countDownLatch);
        }
        return new V8Worker(app, str, list, null, countDownLatch);
    }

    @Override // com.alibaba.griver.base.common.worker.GriverV8WorkerExtension
    public Worker getV8Worker(String str, HandlerThread handlerThread) {
        if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_JSI_MSG_WORKER_ENABLE, false)) {
            return new JsiV8Worker(str, handlerThread);
        }
        return new V8Worker(str, handlerThread);
    }

    @Override // com.alibaba.griver.base.common.worker.GriverV8WorkerExtension
    public Worker reBindJsi(Worker worker, App app, List<PluginModel> list, CountDownLatch countDownLatch, String str) {
        if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_JSI_MSG_WORKER_ENABLE, false)) {
            return JsiV8Worker.reBindJsi((JsiV8Worker) worker, app, list, null, str);
        }
        return V8Worker.reBindJsi((V8Worker) worker, app, list, null, str);
    }

    @Override // com.alibaba.griver.base.common.worker.GriverV8WorkerExtension
    public void clearThread(App app) {
        V8Worker.clearHandlerThread(app);
    }
}
