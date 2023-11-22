package com.alibaba.griver.core.worker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.kernel.api.track.EventTrackStore;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.api.H5CallBack;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.worker.H5Worker;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public class GriverWebWorker extends BaseWorkerImpl {
    private WebWorker b;
    private HandlerThread d;
    private List<PluginModel> f;
    private Set<String> e = new HashSet();

    /* renamed from: a */
    private long f6492a = SystemClock.elapsedRealtime();
    private Handler c = new Handler(Looper.getMainLooper());

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public String getLogTag() {
        return "GriverWebWorker";
    }

    public GriverWebWorker(App app, String str, String str2, CountDownLatch countDownLatch) {
        this.b = new WebWorkerEx(app);
        this.b.setAppId(app.getAppId());
        this.b.setWorkerId(str2);
        this.b.setUserAgent(str);
        this.b.registerWorkerReadyListener(new H5Worker.WorkerReadyListener() { // from class: com.alibaba.griver.core.worker.GriverWebWorker.1
            {
                GriverWebWorker.this = this;
            }

            @Override // com.alibaba.griver.core.worker.H5Worker.WorkerReadyListener
            public void onWorkerReady() {
                GriverWebWorker.this.setWorkerReady();
                StringBuilder sb = new StringBuilder();
                sb.append("WebWorker create->workerReady cost: ");
                sb.append(SystemClock.elapsedRealtime() - GriverWebWorker.this.f6492a);
                GriverLogger.d("GriverWebWorker", sb.toString());
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("WebWorker create->renderReady cost: ");
        sb.append(SystemClock.elapsedRealtime() - this.f6492a);
        GriverLogger.d("GriverWebWorker", sb.toString());
        this.d = prepareWorkerThread();
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void tryToInjectStartupParamsAndPushWorker() {
        WebWorker webWorker = this.b;
        if (webWorker != null) {
            webWorker.tryToInjectStartupParamsAndPushWorker();
        }
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void setRenderReady() {
        super.setRenderReady();
        this.b.setRenderReady();
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void destroy() {
        WebWorker webWorker = this.b;
        if (webWorker != null) {
            webWorker.destroy();
            this.b = null;
        }
        super.destroy();
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void postMessage(String str, SendToWorkerCallback sendToWorkerCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sendMessageToWorker(getAppId(), sb.toString(), str, sendToWorkerCallback);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendJsonToWorker(JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback) {
        if (this.b == null) {
            GriverLogger.w("GriverWebWorker", "sendMessageToWorker but worker destroyed!");
            return;
        }
        GriverLogger.d("GriverWebWorker", "sendJsonToWorker");
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        final String obj = sb.toString();
        this.b.sendJsonToWorker(getAppId(), obj, jSONObject, new H5CallBack() { // from class: com.alibaba.griver.core.worker.GriverWebWorker.2
            {
                GriverWebWorker.this = this;
            }

            @Override // com.alibaba.griver.base.api.H5CallBack
            public void onCallBack(JSONObject jSONObject2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("sendJsonToWorker onCallback: ");
                sb2.append(jSONObject2);
                GriverLogger.d("GriverWebWorker", sb2.toString());
                GriverWebWorker griverWebWorker = GriverWebWorker.this;
                griverWebWorker.sendPushCallBack(jSONObject2, griverWebWorker.getAppId(), obj, sendToWorkerCallback);
            }
        });
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public Handler getWorkerHandler() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendMessageToWorker(String str, final String str2, String str3, final SendToWorkerCallback sendToWorkerCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("sendMessageToWorker ");
        sb.append(str2);
        sb.append(" ");
        sb.append(str3);
        GriverLogger.d("GriverWebWorker", sb.toString());
        WebWorker webWorker = this.b;
        if (webWorker == null) {
            GriverLogger.w("GriverWebWorker", "sendMessageToWorker but worker destroyed!");
        } else {
            webWorker.sendMessageToWorker(str, str2, str3, new H5CallBack() { // from class: com.alibaba.griver.core.worker.GriverWebWorker.3
                {
                    GriverWebWorker.this = this;
                }

                @Override // com.alibaba.griver.base.api.H5CallBack
                public void onCallBack(JSONObject jSONObject) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("sendMessageToWorker onCallback: ");
                    sb2.append(jSONObject);
                    GriverLogger.d("GriverWebWorker", sb2.toString());
                    GriverWebWorker griverWebWorker = GriverWebWorker.this;
                    griverWebWorker.sendPushCallBack(jSONObject, griverWebWorker.getAppId(), str2, sendToWorkerCallback);
                }
            });
        }
    }

    public static HandlerThread prepareWorkerThread() {
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append("jsi-worker-jsapi-");
        sb.append(myPid);
        sb.append("-");
        HandlerThread handlerThread = new HandlerThread(sb.toString());
        handlerThread.start();
        return handlerThread;
    }

    public void setPluginModelList(List<PluginModel> list) {
        this.f = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class WebWorkerEx extends WebWorker {

        /* renamed from: a */
        private final App f6493a;

        WebWorkerEx(App app) {
            GriverWebWorker.this = r1;
            this.f6493a = app;
        }

        @Override // com.alibaba.griver.core.worker.WebWorker
        public H5WorkerControllerProvider generateH5WorkerControllerProvider() {
            return new WebWorkerControllerProvider(this, this.f6493a);
        }

        @Override // com.alibaba.griver.core.worker.H5Worker
        public void onAlipayJSBridgeReady() {
            if (GriverWebWorker.this.b != null && !GriverWebWorker.this.b.isDestroyed()) {
                GriverWebWorker.this.b.setStartupParams(this.f6493a.getStartParams());
            }
            String appxVersionInWorker = GriverWebWorker.this.b == null ? "" : GriverWebWorker.this.b.getAppxVersionInWorker();
            StringBuilder sb = new StringBuilder();
            sb.append("detect appx worker version is: ");
            sb.append(appxVersionInWorker);
            GriverLogger.e("GriverWebWorker", sb.toString());
            EventTrackStore eventTrackStore = (EventTrackStore) this.f6493a.getData(EventTrackStore.class, true);
            if (appxVersionInWorker != null) {
                eventTrackStore.fullLinkAttrMap.put("appxWorkerVersion", appxVersionInWorker);
            } else {
                eventTrackStore.fullLinkAttrMap.put("appxWorkerVersion", "");
            }
            super.onAlipayJSBridgeReady();
        }
    }
}
