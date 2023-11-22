package com.alibaba.ariver.v8worker;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.jsapi.internalapi.InternalApiBridgeExtension;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.track.EventTrackStore;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.prerun.AppxPrerunChecker;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class JsApiHandler {
    private String TAG;
    private boolean mActualPreRun;
    private App mApp;
    private List<String> mInternalAPIList;
    private boolean mSupportPreRun;
    private V8Proxy mV8Proxy;
    private V8Worker mWorker;
    private boolean mShouldInterceptInternalApi = false;
    private final String VIEW_ID = "viewId";
    private final String InternalAPI = "internalAPI";

    public JsApiHandler(App app, V8Worker v8Worker) {
        this.mWorker = v8Worker;
        this.mApp = app;
        StringBuilder sb = new StringBuilder();
        sb.append(v8Worker.getLogTag());
        sb.append("_JsApiHandler");
        this.TAG = sb.toString();
        initConfig();
    }

    private void initConfig() {
        this.mV8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        this.mSupportPreRun = AppxPrerunChecker.isPrerunWorkerApp(this.mApp.getAppId(), this.mApp.getStartParams());
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService != null) {
            try {
                String config = rVConfigService.getConfig("ta_interceptInternalAPI", "");
                this.mShouldInterceptInternalApi = config != null && "1".equals(config.trim());
                this.mInternalAPIList = JSONUtils.toStringArray(rVConfigService.getConfigJSONArray("ta_internalAPIList"));
            } catch (Exception e) {
                RVLogger.e(this.TAG, e);
            }
        }
    }

    protected boolean needPreRunWorkerAction(String str, JSONObject jSONObject) {
        if (this.mSupportPreRun) {
            if ("internalAPI".equalsIgnoreCase(str)) {
                try {
                    str = jSONObject.getJSONObject("data").getString("method");
                } catch (Exception unused) {
                    RVLogger.d(this.TAG, "internalAPI but not have method");
                }
            }
            if (AppxPrerunChecker.isPrerunAction(str)) {
                String str2 = this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("prerun action is\t");
                sb.append(str);
                RVLogger.d(str2, sb.toString());
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a8, code lost:
    
        if (r1 <= 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleSyncJsapiRequest(java.lang.String r16) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.v8worker.JsApiHandler.handleSyncJsapiRequest(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleAsyncJsapiRequest(com.alibaba.fastjson.JSONObject r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L8c
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto L8c
            java.lang.String r0 = "handlerName"
            java.lang.String r2 = r8.getString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L1c
            java.lang.String r8 = r7.TAG
            java.lang.String r0 = "invalid param, handleAsyncJsapiRequest action = null"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r8, r0)
            return
        L1c:
            java.lang.String r0 = r8.toString()     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = r7.TAG     // Catch: java.lang.Throwable -> L37
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L37
            r3.<init>()     // Catch: java.lang.Throwable -> L37
            java.lang.String r4 = "handleAsyncJsapiRequest: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L37
            r3.append(r0)     // Catch: java.lang.Throwable -> L37
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L37
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r3)     // Catch: java.lang.Throwable -> L37
            goto L49
        L37:
            r1 = move-exception
            goto L3c
        L39:
            r1 = move-exception
            java.lang.String r0 = ""
        L3c:
            boolean r3 = com.alibaba.ariver.kernel.common.utils.RVKernelUtils.isDebug()
            if (r3 == 0) goto L49
            java.lang.String r3 = r7.TAG
            java.lang.String r4 = "handleAsyncJsapiRequest"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r3, r4, r1)
        L49:
            r5 = r0
            r0 = 0
            java.lang.String r1 = "data"
            com.alibaba.fastjson.JSONObject r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.getJSONObject(r8, r1, r0)
            if (r0 != 0) goto L5b
            java.lang.String r8 = r7.TAG
            java.lang.String r0 = "invalid param, handleAsyncJsapiRequest data = null"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r8, r0)
            return
        L5b:
            java.lang.String r0 = "postMessage"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L6c
            com.alibaba.ariver.v8worker.V8Worker r0 = r7.mWorker
            r0.markWorkerPostMsg()
            r7.handlePostMessage(r8)
            return
        L6c:
            java.lang.String r0 = "callbackId"
            java.lang.String r0 = r8.getString(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L80
            java.lang.String r8 = r7.TAG
            java.lang.String r0 = "invalid callbackId"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r8, r0)
            return
        L80:
            com.alibaba.ariver.v8worker.JsApiHandler$2 r4 = new com.alibaba.ariver.v8worker.JsApiHandler$2
            r4.<init>()
            r6 = 0
            r1 = r7
            r3 = r8
            r1.handleMsgFromJs(r2, r3, r4, r5, r6)
            return
        L8c:
            java.lang.String r8 = r7.TAG
            java.lang.String r0 = "invalid param, handleAsyncJsapiRequest"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.v8worker.JsApiHandler.handleAsyncJsapiRequest(com.alibaba.fastjson.JSONObject):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePostMessage(final JSONObject jSONObject) {
        if (!this.mWorker.isRenderReady()) {
            this.mWorker.registerRenderReadyListener(new BaseWorkerImpl.RenderReadyListener() { // from class: com.alibaba.ariver.v8worker.JsApiHandler.3
                @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl.RenderReadyListener
                public void onRenderReady() {
                    JsApiHandler.this.handlePostMessage(jSONObject);
                }
            });
            return;
        }
        String string = JSONUtils.getString(JSONUtils.getJSONObject(jSONObject, "data", null), "viewId", null);
        App app = this.mApp;
        if (app == null || app.getEngineProxy() == null || this.mApp.getEngineProxy().getEngineRouter() == null) {
            RVLogger.e(this.TAG, "handleMsgFromJs: getEngineProxy() is null");
            return;
        }
        Render renderById = this.mApp.getEngineProxy().getEngineRouter().getRenderById(string);
        if (renderById != null) {
            renderById.getRenderBridge().sendToRender(RenderCallContext.newBuilder(renderById).action("message").type("call").param(jSONObject).build(), null);
            return;
        }
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("postMessage but cannot find viewId: ");
        sb.append(string);
        RVLogger.w(str, sb.toString());
    }

    protected void handleMsgFromJs(final String str, final JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback, final String str2, final boolean z) {
        if (this.mApp == null || this.mWorker.isDestroyed()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.mWorker.mBeginWaitH5Page == 0) {
            this.mWorker.mBeginWaitH5Page = elapsedRealtime;
        }
        Page activePage = this.mApp.getActivePage();
        if (activePage == null) {
            if (needPreRunWorkerAction(str, jSONObject)) {
                if (!this.mActualPreRun) {
                    this.mActualPreRun = true;
                    String str3 = this.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.mApp.getAppId());
                    sb.append(" support PreRun action");
                    RVLogger.d(str3, sb.toString());
                    ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.mApp, "actualPreRunWorker", "yes");
                }
                String str4 = this.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mApp.getAppId());
                sb2.append(" handleMsgFromJsWhenPageReady PreRunWorkerAction");
                RVLogger.d(str4, sb2.toString());
                handleMsgFromJsWhenPageReady(null, str, jSONObject, sendToWorkerCallback, str2, z);
                return;
            }
            this.mApp.addPageReadyListener(new App.PageReadyListener() { // from class: com.alibaba.ariver.v8worker.JsApiHandler.4
                @Override // com.alibaba.ariver.app.api.App.PageReadyListener
                public void onPageReady(Page page) {
                    if (JsApiHandler.this.mWorker.mEndWaitH5Page == 0) {
                        JsApiHandler.this.mWorker.mEndWaitH5Page = SystemClock.elapsedRealtime();
                        JsApiHandler.this.trackPerfEvent();
                    }
                    JsApiHandler.this.handleMsgFromJsWhenPageReady(page, str, jSONObject, sendToWorkerCallback, str2, z);
                }
            });
            return;
        }
        if (this.mWorker.mEndWaitH5Page == 0) {
            this.mWorker.mEndWaitH5Page = elapsedRealtime;
            trackPerfEvent();
        }
        handleMsgFromJsWhenPageReady(activePage, str, jSONObject, sendToWorkerCallback, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMsgFromJsWhenPageReady(final Page page, final String str, final JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback, final String str2, final boolean z) {
        Runnable runnable = new Runnable() { // from class: com.alibaba.ariver.v8worker.JsApiHandler.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
                    if (JsApiHandler.this.mApp == null) {
                        RVLogger.e(JsApiHandler.this.TAG, "handleMsgFromJsWhenPageReady: getEngineProxy() is null");
                        return;
                    }
                    RVEngine engineProxy = JsApiHandler.this.mApp.getEngineProxy();
                    if (engineProxy != null && !engineProxy.isDestroyed()) {
                        if (engineProxy.getEngineRouter() == null) {
                            String str3 = JsApiHandler.this.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("handleMsgFromJsWhenPageReady engineRouter is null, action: ");
                            sb.append(str);
                            sb.append(" params: ");
                            sb.append(jSONObject2);
                            RVLogger.e(str3, sb.toString());
                            return;
                        }
                        engineProxy.getBridge().sendToNative(JsApiHandler.this.buildCallContext(page, str, jSONObject, sendToWorkerCallback, str2, z), new SendToNativeCallback() { // from class: com.alibaba.ariver.v8worker.JsApiHandler.5.1
                            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                            public void onCallback(JSONObject jSONObject3, boolean z2) {
                                if (sendToWorkerCallback != null) {
                                    sendToWorkerCallback.onCallBack(jSONObject3);
                                }
                            }
                        }, !("internalAPI".equals(str) && JsApiHandler.this.mShouldInterceptInternalApi));
                        return;
                    }
                    String str4 = JsApiHandler.this.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("handleMsgFromJsWhenPageReady engine is null or is destroyed, action: ");
                    sb2.append(str);
                    sb2.append(" params: ");
                    sb2.append(jSONObject2);
                    RVLogger.e(str4, sb2.toString());
                } catch (Throwable th) {
                    String str5 = JsApiHandler.this.TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("handleMsgFromJsWhenPageReady: ");
                    sb3.append(str);
                    sb3.append(" exception!");
                    RVLogger.e(str5, sb3.toString(), th);
                    SendToWorkerCallback sendToWorkerCallback2 = sendToWorkerCallback;
                    if (sendToWorkerCallback2 != null) {
                        sendToWorkerCallback2.onCallBack(BridgeResponse.INVALID_PARAM.get());
                    }
                }
            }
        };
        Handler dispatchHandler = this.mV8Proxy.getDispatchHandler(str);
        if (dispatchHandler == null) {
            runnable.run();
        } else {
            dispatchHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NativeCallContext buildCallContext(Page page, String str, JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback, String str2, boolean z) {
        if (this.mApp.isDestroyed()) {
            return null;
        }
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
        String string = JSONUtils.getString(jSONObject2, "viewId", null);
        RVEngine engineProxy = this.mApp.getEngineProxy();
        if (engineProxy == null || engineProxy.isDestroyed()) {
            RVLogger.e(this.TAG, "serialHandleMsgFromJs engine is null or is destroyed");
            return null;
        }
        EngineRouter engineRouter = engineProxy.getEngineRouter();
        if (engineRouter == null) {
            RVLogger.e(this.TAG, "serialHandleMsgFromJs engineRouter is null");
            return null;
        } else if (str.equals("internalAPI") && this.mShouldInterceptInternalApi) {
            return buildInternalCallContext(engineRouter, jSONObject2, page, string, sendToWorkerCallback, str2, z);
        } else {
            NativeCallContext.Builder node = new NativeCallContext.Builder().name(str).params(jSONObject2).node(page == null ? this.mApp : page);
            StringBuilder sb = new StringBuilder();
            sb.append("worker_");
            sb.append(NativeCallContext.generateUniqueId());
            return node.id(sb.toString()).render(engineRouter.getRenderById(string)).source(NativeCallContext.FROM_WORKER).originalData(str2).originalJsonData(jSONObject).callMode(z ? "sync" : "async").build();
        }
    }

    private NativeCallContext buildInternalCallContext(EngineRouter engineRouter, JSONObject jSONObject, Page page, String str, SendToWorkerCallback sendToWorkerCallback, String str2, boolean z) {
        List<String> list;
        String string = JSONUtils.getString(jSONObject, "method", "");
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "param", null);
        if (TextUtils.isEmpty(string) || engineRouter == null) {
            return null;
        }
        if (!InternalApiBridgeExtension.API_INIT_LIST.contains(string) && ((list = this.mInternalAPIList) == null || !list.contains(string))) {
            if (sendToWorkerCallback != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("internalAPI has no permission: ");
                sb.append(string);
                sendToWorkerCallback.onCallBack(new BridgeResponse.Error(4, sb.toString()).get());
            }
            RVLogger.d(this.TAG, "handleInternalAPI...realMethod is not allowed");
            return null;
        }
        NativeCallContext.Builder params = new NativeCallContext.Builder().name(string).params(jSONObject2);
        Node node = page;
        if (page == null) {
            node = this.mApp;
        }
        NativeCallContext.Builder node2 = params.node(node);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("InternalAPI_worker_");
        sb2.append(NativeCallContext.generateUniqueId());
        return node2.id(sb2.toString()).render(engineRouter.getRenderById(str)).originalData(str2).originalJsonData(jSONObject).callMode(z ? "sync" : "async").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackPerfEvent() {
        EventTrackStore eventTrackStore;
        try {
            Map<String, String> perfLogData = this.mWorker.getPerfLogData();
            if (perfLogData != null) {
                Page activePage = this.mApp.getActivePage();
                if (activePage != null) {
                    eventTrackStore = (EventTrackStore) activePage.getData(EventTrackStore.class, true);
                } else {
                    eventTrackStore = (EventTrackStore) this.mApp.getData(EventTrackStore.class, true);
                }
                eventTrackStore.fullLinkAttrMap.putAll(perfLogData);
            }
        } catch (Throwable th) {
            RVLogger.e(this.TAG, "trackPerfEvent exception", th);
        }
    }
}
