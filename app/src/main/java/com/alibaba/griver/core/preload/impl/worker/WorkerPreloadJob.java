package com.alibaba.griver.core.preload.impl.worker;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.webview.GriverWebviewSetting;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.alibaba.griver.base.preload.annotation.PreloadThreadType;
import com.alibaba.griver.base.preload.core.IPreloadJob;
import com.alibaba.griver.base.preload.core.PreloadScheduler;
import com.alibaba.griver.core.webview.AndroidWebView;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class WorkerPreloadJob implements IPreloadJob<WorkerPreloadResources> {
    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    public String getJobName() {
        return "WorkerPreloadJob";
    }

    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    @PreloadThreadType(ExecutorType.URGENT)
    public /* bridge */ /* synthetic */ WorkerPreloadResources preLoad(Map map, PreloadScheduler.PointType pointType) {
        return preLoad((Map<String, Object>) map, pointType);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    @PreloadThreadType(ExecutorType.URGENT)
    public WorkerPreloadResources preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        App app;
        if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_TOGGLE_PRELOAD_WORKER, true) && (app = (App) map.get(GriverOnPreloadExtension.PARAMS_APP)) != null && app.isTinyApp()) {
            prepareUserAgent();
            if (TextUtils.isEmpty(PreloadScheduler.UA)) {
                return null;
            }
            GriverLogger.d(PreloadScheduler.TAG, "WorkerPreloadJob#preLoad, start worker package preload.");
            WorkerPreloadResources workerPreloadResources = (WorkerPreloadResources) PreloadScheduler.getInstance().getAndRemoveReadyResult(WorkerPreloadResources.class);
            if (workerPreloadResources != null) {
                workerPreloadResources.destroy();
            }
            WorkerPreloadResources workerPreloadResources2 = new WorkerPreloadResources(app.getStartToken());
            workerPreloadResources2.preloadWorker(app);
            return workerPreloadResources2;
        }
        return null;
    }

    public static void prepareUserAgent() {
        if (PreloadScheduler.UA == null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.preload.impl.worker.WorkerPreloadJob.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        AndroidWebView androidWebView = new AndroidWebView(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
                        StringBuilder sb = new StringBuilder();
                        sb.append(androidWebView.getUserAgentString());
                        sb.append(" ");
                        sb.append(EngineUtils.getUserAgentSuffix());
                        sb.append(" ");
                        sb.append(GriverWebviewSetting.getUserAgent());
                        PreloadScheduler.UA = sb.toString();
                        androidWebView.destroy();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
            try {
                countDownLatch.await(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                StringBuilder sb = new StringBuilder();
                sb.append(e);
                GriverLogger.e("WorkerPreloadJob", sb.toString());
            }
        }
    }

    @Override // com.alibaba.griver.base.preload.core.IPreloadJob
    public Class<WorkerPreloadResources> getResultClazz() {
        return WorkerPreloadResources.class;
    }
}
