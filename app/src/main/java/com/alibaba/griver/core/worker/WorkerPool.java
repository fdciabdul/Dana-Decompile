package com.alibaba.griver.core.worker;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.base.common.webview.GriverWebviewSetting;
import com.alibaba.griver.base.common.worker.GriverV8WorkerExtension;
import com.alibaba.griver.core.worker.GriverWorkerFactory;

/* loaded from: classes3.dex */
public class WorkerPool {

    /* renamed from: a  reason: collision with root package name */
    private Worker f6498a;
    private volatile boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SingleTonHolder {

        /* renamed from: a  reason: collision with root package name */
        private static WorkerPool f6499a = new WorkerPool();

        private SingleTonHolder() {
        }
    }

    public static WorkerPool getInstance() {
        return SingleTonHolder.f6499a;
    }

    public void asyncCreateWorkerInPool() {
        if (this.f6498a == null && !this.b) {
            GriverV8WorkerExtension griverV8WorkerExtension = (GriverV8WorkerExtension) RVProxy.get(GriverV8WorkerExtension.class, true);
            if (!QJSUtils.isAllowedWorkerPool() || griverV8WorkerExtension == null) {
                return;
            }
            this.b = true;
            try {
                this.f6498a = GriverWorkerFactory.createPoolWorker(GriverWorkerFactory.WorkerType.JSIWorker, GriverWebviewSetting.getUserAgent(), null);
                this.b = false;
            } catch (Exception unused) {
                this.f6498a = null;
                this.b = false;
            }
        }
    }

    public Worker getPreWorker(App app) {
        return this.f6498a;
    }

    public void resetPreCreateWorker() {
        this.f6498a = null;
    }
}
