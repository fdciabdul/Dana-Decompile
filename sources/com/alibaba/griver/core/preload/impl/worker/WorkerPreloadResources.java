package com.alibaba.griver.core.preload.impl.worker;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.preload.core.PreloadScheduler;
import com.alibaba.griver.core.worker.GriverWorkerFactory;

/* loaded from: classes2.dex */
public class WorkerPreloadResources {

    /* renamed from: a  reason: collision with root package name */
    private final Object f6444a = new Object();
    private Worker b;
    private long c;

    public WorkerPreloadResources(long j) {
        this.c = j;
    }

    public void preloadWorker(final App app) {
        if (app == null) {
            RVLogger.w("WorkerPreloadResources", "prepareWorker but app == null!");
            return;
        }
        RVLogger.d("WorkerPreloadResources", "preloadWorker begin schedule");
        ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.griver.core.preload.impl.worker.WorkerPreloadResources.1
            @Override // java.lang.Runnable
            public void run() {
                RVLogger.d("WorkerPreloadResources", "preloadWorker begin inner");
                synchronized (WorkerPreloadResources.this.f6444a) {
                    WorkerPreloadResources workerPreloadResources = WorkerPreloadResources.this;
                    workerPreloadResources.b = workerPreloadResources.a(app, null, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Worker a(Node node, String str, String str2) {
        App app = (App) node.bubbleFindNode(App.class);
        if (app == null) {
            RVLogger.w("WorkerPreloadResources", "prepareWorker but app == null!");
            return null;
        }
        if (str2 == null) {
            str2 = PreloadScheduler.UA;
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
            RVLogger.w("WorkerPreloadResources", sb.toString());
            return null;
        }
        return GriverWorkerFactory.createWorker(GriverWorkerFactory.WorkerType.JSIWorker, app, str2, str);
    }

    public void destroy() {
        synchronized (this.f6444a) {
            Worker worker = this.b;
            if (worker != null && !worker.isDestroyed()) {
                this.b.destroy();
            }
        }
    }

    public Worker getWorker(long j) {
        synchronized (this.f6444a) {
            if (this.c == j) {
                return this.b;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(RVConstants.EXTRA_START_TOKEN);
            sb.append(this.c);
            sb.append(", startToken");
            sb.append(j);
            GriverLogger.e("WorkerPreloadResources", sb.toString());
            return null;
        }
    }
}
