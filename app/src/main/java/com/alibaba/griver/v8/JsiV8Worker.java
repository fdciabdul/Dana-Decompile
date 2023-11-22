package com.alibaba.griver.v8;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgePermission;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.v8worker.JSConsoleCallback;
import com.alibaba.ariver.v8worker.JsApiHandler;
import com.alibaba.ariver.v8worker.V8Worker;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.alibaba.griver.v8.dispatch.GriverConcurrentJsHandlerDispatcher;
import com.alibaba.griver.v8.dispatch.GriverJsApiMsgQueue;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public class JsiV8Worker extends V8Worker {
    private static Map<String, List<String>> e = new ConcurrentHashMap();

    /* renamed from: a */
    private JsApiHandler f6774a;
    private JsiPostMessageDispatcher b;
    private GriverJsApiMsgQueue c;
    private GriverConcurrentJsHandlerDispatcher d;
    private JSONArray f;
    private JSONArray g;
    private JSONArray h;
    private boolean i;

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void handleJsApiCacheInitialParams(JSONObject jSONObject) {
    }

    public JsiV8Worker(App app, String str, List<PluginModel> list, HandlerThread handlerThread, CountDownLatch countDownLatch) {
        super(app, str, list, handlerThread, countDownLatch);
        this.i = false;
        initJsiWorker(app);
    }

    public JsiV8Worker(String str, HandlerThread handlerThread) {
        super(str, handlerThread);
        this.i = false;
    }

    public void initWorkerFromPool(App app, String str, String str2, CountDownLatch countDownLatch) {
        super.setAppToWorker(app, str, str2, countDownLatch);
        initJsiWorker(app);
    }

    public void initJsiWorker(App app) {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService.getConfigBoolean("ta_v8worker_postMessage_thread", true)) {
            ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(app, "postMessageInThread", "yes");
            JsiPostMessageDispatcher jsiPostMessageDispatcher = new JsiPostMessageDispatcher(this, app);
            this.b = jsiPostMessageDispatcher;
            jsiPostMessageDispatcher.start();
        }
        JSONObject configJSONObject = rVConfigService.getConfigJSONObject("ta_concurrent_dispatch_message");
        JSONObject jSONObject = JSONUtils.getJSONObject(configJSONObject, app.getAppId(), null);
        if (jSONObject == null) {
            jSONObject = JSONUtils.getJSONObject(configJSONObject, "all", null);
        }
        int i = JSONUtils.getInt(jSONObject, "worker", 0);
        if (i > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("V8Worker dispatch msg in ");
            sb.append(i);
            sb.append(" Concurrent Thread");
            RVLogger.d("JsiV8Worker", sb.toString());
            ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(app, "v8WorkerConcurrentDispatcher", "yes");
            this.c = new GriverJsApiMsgQueue();
            this.d = new GriverConcurrentJsHandlerDispatcher(app, this.c, i, "worker");
        }
        this.f6774a = new JsiJsApiHandler(this, app, this.b, this.c);
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker, com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void destroy() {
        GriverConcurrentJsHandlerDispatcher griverConcurrentJsHandlerDispatcher = this.d;
        if (griverConcurrentJsHandlerDispatcher != null) {
            griverConcurrentJsHandlerDispatcher.quit();
            this.d = null;
        }
        GriverJsApiMsgQueue griverJsApiMsgQueue = this.c;
        if (griverJsApiMsgQueue != null) {
            griverJsApiMsgQueue.clear();
            this.c = null;
        }
        JsiPostMessageDispatcher jsiPostMessageDispatcher = this.b;
        if (jsiPostMessageDispatcher != null) {
            jsiPostMessageDispatcher.quit();
            this.b = null;
        }
        super.destroy();
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public JsApiHandler getJsApiHandler() {
        return this.f6774a;
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void onPageCreate(final Page page) {
        if (isMessageChannelEnabled() && isRenderReady()) {
            page.addJsBridgeReadyListener(new Page.JsBridgeReadyListener() { // from class: com.alibaba.griver.v8.JsiV8Worker.1
                {
                    JsiV8Worker.this = this;
                }

                @Override // com.alibaba.ariver.app.api.Page.JsBridgeReadyListener
                public void onJsBridgeReady() {
                    JsiV8Worker.this.prepareMessageChannel(page);
                }
            });
        }
        super.onPageCreate(page);
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public JSConsoleCallback getJSConsoleCallback() {
        return new JSConsoleCallback() { // from class: com.alibaba.griver.v8.JsiV8Worker.2
            {
                JsiV8Worker.this = this;
            }

            @Override // com.alibaba.ariver.v8worker.JSConsoleCallback
            public void onConsoleMessage(String str) {
                if (JsiV8Worker.this.getApp() == null) {
                    return;
                }
                JsiV8Worker.this.getApp().getActivePage();
            }
        };
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void initJsApiCache() {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        JSONObject configJSONObject = rVConfigService.getConfigJSONObject("ta_worker_preCacheJsApi");
        this.f = JSONUtils.getJSONArray(configJSONObject, "jsapi", new JSONArray());
        this.g = JSONUtils.getJSONArray(configJSONObject, GriverOnPreloadExtension.PARAMS_APP, new JSONArray());
        this.h = rVConfigService.getConfigJSONArray("ta_worker_preCache_blacklist");
        this.i = rVConfigService.getConfigBoolean("ta_worker_precache_ignore_permission", false);
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void packageJsApiCacheStartParams(JSONObject jSONObject) {
        boolean z;
        if (CollectionUtils.isEmpty(this.f) || CollectionUtils.isEmpty(this.g)) {
            return;
        }
        if (this.g.contains(this.mAppId) || this.g.contains("all")) {
            if (CollectionUtils.isEmpty(this.h) || !this.h.contains(this.mAppId)) {
                try {
                    int size = this.f.size();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < size; i++) {
                        String string = this.f.getString(i);
                        JSONObject jsonValue = getApp().getJsonValue(string);
                        if (jsonValue != null) {
                            List<String> list = e.get(string);
                            if (!CollectionUtils.isEmpty(list)) {
                                if (!this.i) {
                                    for (String str : list) {
                                        if (!((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).checkJSApi(new BridgePermission(str, ""), new NativeCallContext.Builder().name(str).build(), null, getApp(), null).isSuccess()) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                                z = true;
                                if (z) {
                                    arrayList.add(string);
                                    jSONObject.put(string, (Object) jsonValue);
                                    EventTracker eventTracker = (EventTracker) RVProxy.get(EventTracker.class);
                                    App app = getApp();
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("WorkerJsApiPreCache_");
                                    sb.append(string);
                                    eventTracker.addAttr(app, sb.toString(), "YES");
                                }
                            }
                        }
                    }
                    if (CollectionUtils.isEmpty(arrayList)) {
                        return;
                    }
                    jSONObject.put("jsApiCacheWhitelist", (Object) TextUtils.join(",", arrayList));
                } catch (Exception e2) {
                    RVLogger.w(getLogTag(), "put jsApiCacheWhitelist failed", e2);
                }
            }
        }
    }
}
