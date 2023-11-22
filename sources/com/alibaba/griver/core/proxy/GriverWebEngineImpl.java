package com.alibaba.griver.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.BaseEngineImpl;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.EngineInitCallback;
import com.alibaba.ariver.engine.api.bridge.model.EngineSetupCallback;
import com.alibaba.ariver.engine.api.bridge.model.InitParams;
import com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppTypeUtils;
import com.alibaba.griver.base.common.utils.PWAUtils;
import com.alibaba.griver.base.preload.core.PreloadScheduler;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.base.utils.RemoteDebugCompatUtils;
import com.alibaba.griver.core.bridge.GriverNativeBridge;
import com.alibaba.griver.core.preload.PreloadInitializer;
import com.alibaba.griver.core.preload.impl.render.RenderPreloadNgResources;
import com.alibaba.griver.core.preload.impl.render.RenderPreloadResources;
import com.alibaba.griver.core.render.GriverWebRenderImpl;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public class GriverWebEngineImpl extends BaseEngineImpl {
    public static final String TAG = "GriverEngine:WebViewEngineProxy";

    /* renamed from: a  reason: collision with root package name */
    private CountDownLatch f6445a;
    private CountDownLatch b;
    private Worker c;

    @Override // com.alibaba.ariver.engine.BaseEngineImpl, com.alibaba.ariver.engine.api.RVEngine
    public String getEngineType() {
        return AppTypeUtils.TYPE_TINY;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public boolean isReady() {
        return false;
    }

    public GriverWebEngineImpl(String str, Node node) {
        super(str, node);
        this.f6445a = new CountDownLatch(1);
        this.b = new CountDownLatch(1);
        this.c = null;
        StringBuilder sb = new StringBuilder();
        sb.append("webview engineProxy constructed,appId=");
        sb.append(str);
        RVLogger.d(TAG, sb.toString());
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public void setup(Bundle bundle, Bundle bundle2, final EngineSetupCallback engineSetupCallback) {
        new EngineSetupCallback() { // from class: com.alibaba.griver.core.proxy.GriverWebEngineImpl.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.EngineSetupCallback
            public void setupResult(boolean z, String str) {
                GriverWebEngineImpl.this.f6445a.countDown();
                engineSetupCallback.setupResult(z, str);
            }
        }.setupResult(true, null);
    }

    @Override // com.alibaba.ariver.engine.BaseEngineImpl, com.alibaba.ariver.engine.api.RVEngine
    public void init(InitParams initParams, final EngineInitCallback engineInitCallback) {
        super.init(initParams, engineInitCallback);
        if (this.f6445a.getCount() == 0) {
            this.b.countDown();
            engineInitCallback.initResult(true, null);
            return;
        }
        ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.griver.core.proxy.GriverWebEngineImpl.2
            @Override // java.lang.Runnable
            public void run() {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    GriverWebEngineImpl.this.f6445a.await();
                } catch (InterruptedException unused) {
                }
                GriverWebEngineImpl.this.b.countDown();
                StringBuilder sb = new StringBuilder();
                sb.append("await setupLock for ");
                sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                RVLogger.d(GriverWebEngineImpl.TAG, sb.toString());
                engineInitCallback.initResult(true, null);
            }
        });
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Render createRender(Activity activity, Node node, CreateParams createParams) {
        RVLogger.d(TAG, "start create render");
        App app = ((Page) node).getApp();
        RenderPreloadResources renderPreloadResources = null;
        r2 = null;
        r2 = null;
        RenderPreloadNgResources renderPreloadNgResources = null;
        renderPreloadResources = null;
        renderPreloadResources = null;
        if (app == null) {
            return null;
        }
        if (createParams != null && createParams.startParams != null && !TextUtils.isEmpty(createParams.startParams.getString("MINI-PROGRAM-WEB-VIEW-TAG"))) {
            return new GriverWebRenderImpl(this, activity, node, createParams, null, null);
        }
        GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app));
        if (GriverAppxNgRuntimeChecker.isUseAppxNg(app.getStartParams())) {
            if (app.isTinyApp() && !PWAUtils.isPwaAppAndLoadNewWay(app) && PreloadInitializer.canPrerender(app)) {
                renderPreloadNgResources = (RenderPreloadNgResources) PreloadScheduler.getInstance().getAndRemoveReadyResult(RenderPreloadNgResources.class);
            }
            if (renderPreloadNgResources != null && !RemoteDebugCompatUtils.isInDebugMode(app)) {
                if (stageMonitor != null) {
                    stageMonitor.addParamUnique("prerender_2_0", 1);
                    GriverLogger.d(TAG, "use prerender 2.0");
                }
                return new GriverWebRenderImpl(this, activity, node, createParams, renderPreloadNgResources.getWebView(), renderPreloadNgResources.getIndexJs(app));
            }
            if (stageMonitor != null) {
                stageMonitor.addParamUnique("prerender_2_0", 0);
            }
            return new GriverWebRenderImpl(this, activity, node, createParams, null, null);
        }
        if (app.isTinyApp() && !PWAUtils.isPwaAppAndLoadNewWay(app) && PreloadInitializer.canPrerender(app)) {
            renderPreloadResources = (RenderPreloadResources) PreloadScheduler.getInstance().getAndRemoveReadyResult(RenderPreloadResources.class);
        }
        if (renderPreloadResources != null && !RemoteDebugCompatUtils.isInDebugMode(app)) {
            if (stageMonitor != null) {
                stageMonitor.addParamUnique("prerender_2_0", 1);
                GriverLogger.d(TAG, "use prerender 1.0");
            }
            return new GriverWebRenderImpl(this, activity, node, createParams, renderPreloadResources.getWebView(), renderPreloadResources.getIndexJs(app));
        }
        if (stageMonitor != null) {
            stageMonitor.addParamUnique("prerender_2_0", 0);
        }
        return new GriverWebRenderImpl(this, activity, node, createParams, null, null);
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Worker createWorker(Context context, Node node, String str, String str2) throws Throwable {
        RVLogger.d(TAG, "start create worker");
        Worker createWorker = ((CreateWorkerPoint) ExtensionPoint.as(CreateWorkerPoint.class).node(node).create()).createWorker(context, node, str, str2);
        this.c = createWorker;
        if (createWorker != null) {
            createWorker.setRenderReady();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("end create worker == ");
        sb.append(this.c);
        RVLogger.d(TAG, sb.toString());
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.BaseEngineImpl
    public NativeBridge createNativeBridge() {
        return new GriverNativeBridge();
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public String getInstanceId() {
        Worker worker = this.c;
        if (worker == null) {
            return null;
        }
        return worker.getWorkerId();
    }
}
