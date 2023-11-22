package com.alibaba.griver.v8;

import android.net.Uri;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.point.NativeCallSyncErrorBackPoint;
import com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.track.EventTrackStore;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.prerun.AppxPrerunChecker;
import com.alibaba.ariver.v8worker.JsApiHandler;
import com.alibaba.ariver.v8worker.V8Proxy;
import com.alibaba.ariver.v8worker.V8Worker;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alibaba.griver.v8.dispatch.GriverJsApiMsgQueue;
import com.alipay.mobile.security.zim.msgchannel.ZimMessageChannel;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class JsiJsApiHandler extends JsApiHandler {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6771a;
    private final String b;
    private final String c;
    private V8Worker d;
    private App e;
    private Handler f;
    private long g;
    private long h;
    private boolean i;
    private boolean j;
    private boolean k;
    private Handler l;
    private List<JSONObject> m;
    private JsiPostMessageDispatcher n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f6772o;
    private boolean p;
    private GriverJsApiMsgQueue q;
    private V8Proxy r;
    private RVJsStatTrackService s;
    private boolean t;

    public JsiJsApiHandler(V8Worker v8Worker, App app, JsiPostMessageDispatcher jsiPostMessageDispatcher, GriverJsApiMsgQueue griverJsApiMsgQueue) {
        super(app, v8Worker);
        this.b = "viewId";
        this.c = "nxPriority";
        this.i = true;
        this.j = true;
        this.k = true;
        this.d = v8Worker;
        this.e = app;
        this.m = new LinkedList();
        this.n = jsiPostMessageDispatcher;
        this.f6772o = AppxPrerunChecker.isPrerunWorkerApp(this.e.getAppId(), app.getStartParams());
        this.q = griverJsApiMsgQueue;
        this.r = (V8Proxy) RVProxy.get(V8Proxy.class);
        this.s = (RVJsStatTrackService) RVProxy.get(RVJsStatTrackService.class);
        this.t = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ta_workerJsApiCallback_intercept", true);
    }

    @Override // com.alibaba.ariver.v8worker.JsApiHandler
    public void handleSyncJsapiRequest(String str) throws UnsupportedEncodingException {
        String str2;
        Uri parse = Uri.parse(str);
        if (this.i) {
            this.i = false;
        }
        String queryParameter = parse.getQueryParameter("data");
        StringBuilder sb = new StringBuilder();
        sb.append("handleSyncJsapiRequest data ");
        sb.append(queryParameter);
        RVLogger.d("JsiJsApiHandler", sb.toString());
        JSONObject parseObject = JSONUtils.parseObject(queryParameter);
        if (parseObject == null || parseObject.isEmpty()) {
            parseObject = new JSONObject();
        }
        JSONObject jSONObject = parseObject;
        final String string = JSONUtils.getString(jSONObject, "action");
        final String string2 = JSONUtils.getString(jSONObject, "callback");
        if (!TextUtils.isEmpty(string2)) {
            V8Proxy v8Proxy = this.r;
            boolean z = v8Proxy == null || v8Proxy.hasSyncApiPermission(string);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sync hasPermission ");
            sb2.append(z);
            sb2.append(", render ready ");
            sb2.append(this.d.isRenderReady());
            RVLogger.d("JsiJsApiHandler", sb2.toString());
            if (z) {
                final JSONObject jSONObject2 = new JSONObject();
                int i = this.d.isRenderReady() ? 2000 : 8000;
                final ConditionVariable conditionVariable = new ConditionVariable();
                int i2 = i;
                handleMsgFromJs(string, jSONObject, new SendToWorkerCallback() { // from class: com.alibaba.griver.v8.JsiJsApiHandler.1
                    final long time = System.currentTimeMillis();

                    @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                    public void onCallBack(JSONObject jSONObject3) {
                        try {
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                long j = this.time;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("tinyAppTimeCostLog: ");
                                sb3.append(string);
                                sb3.append(" onReceiveJsapiResult cost ");
                                sb3.append(currentTimeMillis - j);
                                RVLogger.d("JsiJsApiHandler", sb3.toString());
                                if (jSONObject3 != null) {
                                    jSONObject2.put("result", (Object) jSONObject3);
                                    String jSONString = jSONObject3.toJSONString();
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("sync action ");
                                    sb4.append(string);
                                    sb4.append(", callback: ");
                                    sb4.append(string2);
                                    sb4.append(" result ");
                                    if (jSONString.length() > 1500) {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append(jSONString.substring(0, 1500));
                                        sb5.append(".. len:");
                                        sb5.append(jSONString.length());
                                        jSONString = sb5.toString();
                                    }
                                    sb4.append(jSONString);
                                    RVLogger.d("JsiJsApiHandler", sb4.toString());
                                } else {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("error", (Object) 999);
                                    jSONObject4.put("errorMessage", (Object) "System Error: Empty Response");
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("sync action ");
                                    sb6.append(string);
                                    sb6.append(", callback: ");
                                    sb6.append(string2);
                                    sb6.append(" result is null");
                                    RVLogger.d("JsiJsApiHandler", sb6.toString());
                                    jSONObject2.put("result", (Object) jSONObject4);
                                }
                            } catch (Exception e) {
                                RVLogger.e("JsiJsApiHandler", "sync failed to get byte array", e);
                            }
                        } finally {
                            conditionVariable.open();
                        }
                    }
                }, queryParameter, true);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append("(");
                if (jSONObject2.containsKey("result")) {
                    sb3.append(jSONObject2.getJSONObject("result").toJSONString());
                    str2 = ")";
                } else {
                    str2 = ")";
                    boolean z2 = !conditionVariable.block(i2);
                    if (!z2 && jSONObject2.containsKey("result")) {
                        sb3.append(jSONObject2.getJSONObject("result").toJSONString());
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("sync action ");
                        sb4.append(string);
                        sb4.append(", callback: ");
                        sb4.append(string2);
                        sb4.append(" Operation Timeout, timeout is ");
                        sb4.append(z2);
                        RVLogger.d("JsiJsApiHandler", sb4.toString());
                        jSONObject2.put("error", (Object) 999);
                        jSONObject2.put("errorMessage", "System Error: Operation Timeout");
                        sb3.append(jSONObject2.toJSONString());
                        a(queryParameter, jSONObject, string, jSONObject2);
                    }
                }
                sb3.append(str2);
                String obj = sb3.toString();
                V8Worker v8Worker = this.d;
                v8Worker.executeScript(obj, null, v8Worker.getAppxJSContext());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[DONE] sync action ");
                sb5.append(string);
                sb5.append(", callback: ");
                sb5.append(string2);
                RVLogger.d("JsiJsApiHandler", sb5.toString());
                return;
            }
            if (a()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("error", (Object) 4);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(string);
                sb6.append(" not allow sync invoke ! ");
                jSONObject3.put("errorMessage", (Object) sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append(string2);
                sb7.append("(");
                sb7.append(jSONObject3.toJSONString());
                sb7.append(")");
                String obj2 = sb7.toString();
                a(queryParameter, jSONObject, string, jSONObject3);
                V8Worker v8Worker2 = this.d;
                v8Worker2.executeScript(obj2, null, v8Worker2.getAppxJSContext());
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append(string);
            sb8.append(" not allow sync invoke ! ");
            RVLogger.d("JsiJsApiHandler", sb8.toString());
            return;
        }
        RVLogger.d("JsiJsApiHandler", "caution!!! shouldn't be here!!!!");
    }

    private void a(String str, JSONObject jSONObject, String str2, JSONObject jSONObject2) {
        try {
            App app = this.e;
            ((NativeCallSyncErrorBackPoint) ExtensionPoint.as(NativeCallSyncErrorBackPoint.class).node(this.e).create()).onSyncErrorBack(a(app != null ? app.getActivePage() : null, str2, jSONObject, null, str, true), jSONObject2);
        } catch (Throwable th) {
            RVLogger.e("JsiJsApiHandler", "ignore sync error back point exception ", th);
        }
    }

    private boolean a() {
        return !TextUtils.equals("no", ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_sync_invoke_forbidden_need_resp", null));
    }

    @Override // com.alibaba.ariver.v8worker.JsApiHandler
    public void handleAsyncJsapiRequest(JSONObject jSONObject) {
        String str;
        SendToWorkerCallback sendToWorkerCallback;
        SendToWorkerCallback sendToWorkerCallback2;
        JsiPostMessageDispatcher jsiPostMessageDispatcher;
        try {
            str = jSONObject.toString();
        } catch (Throwable th) {
            th = th;
            str = "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("handleAsyncJsapiRequest ");
            sb.append(str);
            RVLogger.d("JsiJsApiHandler", sb.toString());
        } catch (Throwable th2) {
            th = th2;
            if (RVKernelUtils.isDebug()) {
                RVLogger.e("JsiJsApiHandler", "handleAsyncJsapiRequest", th);
            }
            String str2 = str;
            if (jSONObject != null) {
                return;
            }
            return;
        }
        String str22 = str;
        if (jSONObject != null || jSONObject.isEmpty()) {
            return;
        }
        final String string = jSONObject.getString("handlerName");
        if (NXEmbedWebView.POST_MESSAGE_ACTION_TYPE.equals(string)) {
            if (this.j) {
                this.j = false;
                this.d.markWorkerPostMsg();
                RVLogger.d("JsiJsApiHandler", "v8Worker get first postMessage");
            }
            if (f6771a && (jsiPostMessageDispatcher = this.n) != null) {
                jsiPostMessageDispatcher.dispatch(jSONObject);
                return;
            } else if (AppxPrerunChecker.isRenderMessageQueue(this.e.getAppId())) {
                b(jSONObject);
                return;
            } else {
                a(jSONObject);
                return;
            }
        }
        if (this.k) {
            this.k = false;
            RVLogger.d("JsiJsApiHandler", "v8Worker get first sendToNative message");
        }
        final String string2 = jSONObject.getString("callbackId");
        if (TextUtils.isEmpty(string2)) {
            RVLogger.e("JsiJsApiHandler", "invalid callbackId");
        } else if (JSONUtils.getJSONObject(jSONObject, "data", null) == null) {
        } else {
            String string3 = jSONObject.getString("needCallback");
            if (this.t) {
                if (!"no".equalsIgnoreCase(string3)) {
                    sendToWorkerCallback = new SendToWorkerCallback() { // from class: com.alibaba.griver.v8.JsiJsApiHandler.2
                        @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                        public void onCallBack(JSONObject jSONObject2) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("responseId", (Object) string2);
                            jSONObject3.put(ZimMessageChannel.K_RPC_RES, (Object) jSONObject2);
                            JsiJsApiHandler.this.d.sendJsonToWorker(jSONObject3, null);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("[DONE] async action: ");
                            sb2.append(string);
                            sb2.append(", callbackId: ");
                            sb2.append(string2);
                            RVLogger.d("JsiJsApiHandler", sb2.toString());
                        }
                    };
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[DONE] ignore: ");
                    sb2.append(string);
                    sb2.append(", callbackId: ");
                    sb2.append(string2);
                    RVLogger.d("JsiJsApiHandler", sb2.toString());
                    sendToWorkerCallback2 = null;
                    handleMsgFromJs(string, jSONObject, sendToWorkerCallback2, str22, false);
                }
            } else {
                sendToWorkerCallback = new SendToWorkerCallback() { // from class: com.alibaba.griver.v8.JsiJsApiHandler.3
                    @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                    public void onCallBack(JSONObject jSONObject2) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("responseId", (Object) string2);
                        jSONObject3.put(ZimMessageChannel.K_RPC_RES, (Object) jSONObject2);
                        JsiJsApiHandler.this.d.sendJsonToWorker(jSONObject3, null);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("[DONE] async action: ");
                        sb3.append(string);
                        sb3.append(", callbackId: ");
                        sb3.append(string2);
                        RVLogger.d("JsiJsApiHandler", sb3.toString());
                    }
                };
            }
            sendToWorkerCallback2 = sendToWorkerCallback;
            handleMsgFromJs(string, jSONObject, sendToWorkerCallback2, str22, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final JSONObject jSONObject) {
        if (!this.d.isRenderReady()) {
            this.d.registerRenderReadyListener(new BaseWorkerImpl.RenderReadyListener() { // from class: com.alibaba.griver.v8.JsiJsApiHandler.4
                @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl.RenderReadyListener
                public void onRenderReady() {
                    JsiJsApiHandler.this.a(jSONObject);
                }
            });
            return;
        }
        String string = JSONUtils.getString(JSONUtils.getJSONObject(jSONObject, "data", null), "viewId", null);
        if (b() == null) {
            return;
        }
        Render renderById = b().getRenderById(string);
        if (renderById != null) {
            renderById.getRenderBridge().sendToRender(RenderCallContext.newBuilder(renderById).action("message").type("call").param(jSONObject).build(), null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("postMessage but cannot find viewId: ");
        sb.append(string);
        RVLogger.w("JsiJsApiHandler", sb.toString());
    }

    private EngineRouter b() {
        if (this.e.getEngineProxy() == null) {
            RVLogger.d("JsiJsApiHandler", "getEngineRouter is null");
            return null;
        }
        return this.e.getEngineProxy().getEngineRouter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Render render, JSONObject jSONObject) {
        a(jSONObject);
    }

    private void b(JSONObject jSONObject) {
        if (this.d.isRenderReady()) {
            a(jSONObject);
            return;
        }
        String string = JSONUtils.getString(JSONUtils.getJSONObject(jSONObject, "data", null), "viewId", null);
        if (b() == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("handlePostQueueMessage getEngineRouter() == null ");
            sb.append(jSONObject);
            RVLogger.d("JsiJsApiHandler", sb.toString());
            return;
        }
        if (this.l == null) {
            this.l = new Handler();
        }
        Render renderById = b().getRenderById(string);
        if (renderById != null) {
            if (!this.m.isEmpty()) {
                Iterator<JSONObject> it = this.m.iterator();
                while (it.hasNext()) {
                    a(renderById, it.next());
                }
                this.m.clear();
            }
            a(renderById, jSONObject);
            return;
        }
        this.m.add(jSONObject);
        b().registerRenderInitListener(string, new EngineRouter.RenderInitListener() { // from class: com.alibaba.griver.v8.JsiJsApiHandler.5
            @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter.RenderInitListener
            public void onRenderInit(final Render render) {
                JsiJsApiHandler.this.l.post(new Runnable() { // from class: com.alibaba.griver.v8.JsiJsApiHandler.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RVLogger.d("JsiJsApiHandler", "RenderInitListener init success");
                        if (JsiJsApiHandler.this.m.isEmpty()) {
                            return;
                        }
                        Iterator it2 = JsiJsApiHandler.this.m.iterator();
                        while (it2.hasNext()) {
                            JsiJsApiHandler.this.a(render, (JSONObject) it2.next());
                        }
                        JsiJsApiHandler.this.m.clear();
                    }
                });
            }
        });
    }

    protected boolean needPrerunWorkerAction(String str, JSONObject jSONObject, Bundle bundle) {
        if (this.f6772o) {
            if ("internalAPI".equalsIgnoreCase(str)) {
                try {
                    str = jSONObject.getJSONObject("data").getString("method");
                } catch (Exception unused) {
                    RVLogger.d("JsiJsApiHandler", "internalAPI but not have method");
                }
            }
            if (AppxPrerunChecker.isPrerunAction(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("prerun action is\t");
                sb.append(str);
                RVLogger.d("JsiJsApiHandler", sb.toString());
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.alibaba.ariver.v8worker.JsApiHandler
    public void handleMsgFromJs(final String str, final JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback, final String str2, final boolean z) {
        if (this.g == 0) {
            this.g = SystemClock.elapsedRealtime();
        }
        Page activePage = this.e.getActivePage();
        if (activePage == null) {
            RVLogger.d("JsiJsApiHandler", "handleMsgFromJs but page == null! add to pageReady listener.");
            if (needPrerunWorkerAction(str, jSONObject, this.e.getStartParams())) {
                if (!this.p) {
                    this.p = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.e.getAppId());
                    sb.append(" support prerun action");
                    RVLogger.d("JsiJsApiHandler", sb.toString());
                    ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.e, "actualPrerunWorker", "yes");
                }
                c(null, str, jSONObject, sendToWorkerCallback, str2, z);
                return;
            }
            this.e.addPageReadyListener(new App.PageReadyListener() { // from class: com.alibaba.griver.v8.JsiJsApiHandler.6
                @Override // com.alibaba.ariver.app.api.App.PageReadyListener
                public void onPageReady(Page page) {
                    if (JsiJsApiHandler.this.h == 0) {
                        JsiJsApiHandler.this.h = SystemClock.elapsedRealtime();
                        JsiJsApiHandler.this.c();
                    }
                    if (JsiJsApiHandler.this.q != null) {
                        JsiJsApiHandler.this.b(page, str, jSONObject, sendToWorkerCallback, str2, z);
                    } else {
                        JsiJsApiHandler.this.c(page, str, jSONObject, sendToWorkerCallback, str2, z);
                    }
                }
            });
            return;
        }
        if (this.h == 0) {
            this.h = SystemClock.elapsedRealtime();
            c();
        }
        if (this.q != null) {
            b(activePage, str, jSONObject, sendToWorkerCallback, str2, z);
        } else {
            c(activePage, str, jSONObject, sendToWorkerCallback, str2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            Map<String, String> perfLogData = this.d.getPerfLogData();
            if (perfLogData != null) {
                perfLogData.put("v8_page_wait", String.valueOf(this.h - this.g));
                Page activePage = this.e.getActivePage();
                ((EventTrackStore) (activePage != null ? activePage.getData(EventTrackStore.class, true) : this.e.getData(EventTrackStore.class, true))).fullLinkAttrMap.putAll(perfLogData);
            }
        } catch (Throwable th) {
            RVLogger.e("JsiJsApiHandler", "trackPerfEvent exception", th);
        }
    }

    protected Handler getHandler(String str) {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    this.f = new Handler(Looper.getMainLooper());
                }
            }
        }
        return this.f;
    }

    private NativeCallContext a(Page page, String str, JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback, String str2, boolean z) {
        if (this.e.isDestroyed()) {
            return null;
        }
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
        String string = JSONUtils.getString(jSONObject2, "viewId", null);
        RVEngine engineProxy = this.e.getEngineProxy();
        if (engineProxy == null || engineProxy.isDestroyed()) {
            RVLogger.e("JsiJsApiHandler", "serialHandleMsgFromJs engine is null or is destroyed");
            return null;
        } else if (str.equals("internalAPI")) {
            RVLogger.d("JsiJsApiHandler", "serialHandleMsgFromJs, ta_interceptInternalAPI is opened");
            return a(jSONObject2, page, string, sendToWorkerCallback, str2, jSONObject, z);
        } else {
            EngineRouter b = b();
            if (b == null) {
                RVLogger.e("JsiJsApiHandler", "serialHandleMsgFromJs engineRouter is null");
                return null;
            }
            NativeCallContext.Builder node = new NativeCallContext.Builder().name(str).params(jSONObject2).node(page == null ? this.e : page);
            StringBuilder sb = new StringBuilder();
            sb.append("worker_");
            sb.append(NativeCallContext.generateUniqueId());
            return node.id(sb.toString()).render(b.getRenderById(string)).source(NativeCallContext.FROM_WORKER).originalData(str2).originalJsonData(jSONObject).callMode(z ? "sync" : "async").build();
        }
    }

    private boolean a(String str) {
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_force_serial_message");
        return (configJSONArray == null || configJSONArray.isEmpty() || TextUtils.isEmpty(str) || !configJSONArray.contains(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Page page, String str, JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback, String str2, boolean z) {
        String str3;
        int i;
        final NativeCallContext a2;
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long currentTimeMillis = System.currentTimeMillis();
        if (a(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" is force send to serialHandleMsg while in concurrent dispatch");
            RVLogger.d("JsiJsApiHandler", sb.toString());
            c(page, str, jSONObject, sendToWorkerCallback, str2, z);
            return;
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        try {
            i = JSONUtils.getInt(JSONUtils.getJSONObject(jSONObject, "data", null), "nxPriority", 0);
            a2 = a(page, str, jSONObject, sendToWorkerCallback, str2, z);
        } catch (Throwable th) {
            th = th;
            str3 = "JsiJsApiHandler";
        }
        try {
            this.q.add2Queue(new GriverJsApiMsgQueue.JsApiCallItem(a2, new SendToNativeCallback() { // from class: com.alibaba.griver.v8.JsiJsApiHandler.7
                @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                public void onCallback(JSONObject jSONObject2, boolean z2) {
                    if (sendToWorkerCallback != null) {
                        JsiJsApiHandler.this.a(jSONObject2, currentTimeMillis, elapsedRealtime, a2);
                        sendToWorkerCallback.onCallBack(jSONObject2);
                    }
                }
            }, !"internalAPI".equals(str)), i);
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("JSAPI_Dispatch_");
            sb2.append(str);
            sb2.append(", cost=");
            sb2.append(elapsedRealtime3 - elapsedRealtime2);
            RVLogger.d("JsiJsApiHandler", sb2.toString());
        } catch (Throwable th2) {
            th = th2;
            str3 = "JsiJsApiHandler";
            long elapsedRealtime4 = SystemClock.elapsedRealtime();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("JSAPI_Dispatch_");
            sb3.append(str);
            sb3.append(", cost=");
            sb3.append(elapsedRealtime4 - elapsedRealtime2);
            RVLogger.d(str3, sb3.toString());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Page page, final String str, JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback, String str2, boolean z) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long currentTimeMillis = System.currentTimeMillis();
        final NativeCallContext a2 = a(page, str, jSONObject, sendToWorkerCallback, str2, z);
        if (a2 == null) {
            RVLogger.d("JsiJsApiHandler", "serialHandleMsgFromJs, but nativeCallContext is null");
            return;
        }
        String name = a2.getName();
        if ("internalAPI".equals(name)) {
            name = JSONUtils.getString(a2.getParams(), "method", "");
        }
        Handler handler = getHandler(name);
        RVJsStatTrackService rVJsStatTrackService = this.s;
        if (rVJsStatTrackService != null) {
            rVJsStatTrackService.onBeginDispatch(a2);
        }
        handler.post(new Runnable() { // from class: com.alibaba.griver.v8.JsiJsApiHandler.8
            @Override // java.lang.Runnable
            public void run() {
                long elapsedRealtime2;
                StringBuilder sb;
                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                try {
                    try {
                        NativeBridge nativeBridge = null;
                        if (JsiJsApiHandler.this.e != null && JsiJsApiHandler.this.e.getEngineProxy() != null) {
                            nativeBridge = JsiJsApiHandler.this.e.getEngineProxy().getBridge();
                        }
                        if (nativeBridge == null) {
                            RVLogger.d("JsiJsApiHandler", "serialHandleMsgFromJs, but nativeBridge is null");
                            elapsedRealtime2 = SystemClock.elapsedRealtime();
                            sb = new StringBuilder();
                        } else {
                            if (JsiJsApiHandler.this.s != null) {
                                JsiJsApiHandler.this.s.onDispatchOnMain(a2);
                            }
                            nativeBridge.sendToNative(a2, new SendToNativeCallback() { // from class: com.alibaba.griver.v8.JsiJsApiHandler.8.1
                                @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                                public void onCallback(JSONObject jSONObject2, boolean z2) {
                                    if (sendToWorkerCallback != null) {
                                        JsiJsApiHandler.this.a(jSONObject2, currentTimeMillis, elapsedRealtime, a2);
                                        sendToWorkerCallback.onCallBack(jSONObject2);
                                    }
                                }
                            }, !"internalAPI".equals(str));
                            elapsedRealtime2 = SystemClock.elapsedRealtime();
                            sb = new StringBuilder();
                        }
                    } catch (Exception e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("serialHandleMsgFromJs dispatch ");
                        sb2.append(str);
                        sb2.append(" failed");
                        RVLogger.w("JsiJsApiHandler", sb2.toString(), e);
                        elapsedRealtime2 = SystemClock.elapsedRealtime();
                        sb = new StringBuilder();
                    }
                    sb.append("JSAPI_Dispatch_");
                    sb.append(str);
                    sb.append(", cost=");
                    sb.append(elapsedRealtime2 - elapsedRealtime3);
                    RVLogger.d("JsiJsApiHandler", sb.toString());
                } catch (Throwable th) {
                    long elapsedRealtime4 = SystemClock.elapsedRealtime();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("JSAPI_Dispatch_");
                    sb3.append(str);
                    sb3.append(", cost=");
                    sb3.append(elapsedRealtime4 - elapsedRealtime3);
                    RVLogger.d("JsiJsApiHandler", sb3.toString());
                    throw th;
                }
            }
        });
    }

    private NativeCallContext a(JSONObject jSONObject, Page page, String str, SendToWorkerCallback sendToWorkerCallback, String str2, JSONObject jSONObject2, boolean z) {
        String string = JSONUtils.getString(jSONObject, "method", "");
        JSONObject jSONObject3 = JSONUtils.getJSONObject(jSONObject, "param", null);
        if (TextUtils.isEmpty(string) || b() == null) {
            return null;
        }
        NativeCallContext.Builder params = new NativeCallContext.Builder().name(string).params(jSONObject3);
        Node node = page;
        if (page == null) {
            node = this.e;
        }
        NativeCallContext.Builder node2 = params.node(node);
        StringBuilder sb = new StringBuilder();
        sb.append("InternalAPI_worker_");
        sb.append(NativeCallContext.generateUniqueId());
        return node2.id(sb.toString()).render(b().getRenderById(str)).originalData(str2).originalJsonData(jSONObject2).callMode(z ? "sync" : "async").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, long j, long j2, NativeCallContext nativeCallContext) {
        JSONObject generateCallStat;
        if (jSONObject != null) {
            try {
                if (!CallStatUtils.enableCallStatResponse() || (generateCallStat = CallStatUtils.generateCallStat(j, j2, nativeCallContext)) == null) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("append call stat =");
                sb.append(generateCallStat);
                RVLogger.d("JsiJsApiHandler", sb.toString());
                jSONObject.put(CallStatUtils.KEY_CALLSTATDATA, (Object) generateCallStat);
            } catch (Throwable th) {
                RVLogger.e("JsiJsApiHandler", "appendCallStat exception ", th);
            }
        }
    }
}
