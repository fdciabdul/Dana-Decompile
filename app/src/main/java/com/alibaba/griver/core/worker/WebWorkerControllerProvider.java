package com.alibaba.griver.core.worker;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.api.H5ServiceWorkerHook4Bridge;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.nebula.H5EventDispatchHandler;
import com.alibaba.griver.base.nebula.WorkerApiConfig;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alibaba.griver.core.worker.H5Worker;
import com.alipay.mobile.security.zim.msgchannel.ZimMessageChannel;
import com.iap.ac.android.container.js.ACJSBridge;

/* loaded from: classes6.dex */
public class WebWorkerControllerProvider extends H5WorkerControllerProvider {

    /* renamed from: a  reason: collision with root package name */
    private final App f6497a;
    private final String b;
    private EngineRouter c;
    private H5Worker d;
    private Handler e;

    public WebWorkerControllerProvider(H5Worker h5Worker, App app) {
        super(h5Worker, app);
        this.b = "viewId";
        this.f6497a = app;
        this.d = h5Worker;
    }

    @Override // com.alibaba.griver.core.worker.H5WorkerControllerProvider
    protected void handleMsgFromJs(final String str, final JSONObject jSONObject, final H5ServiceWorkerHook4Bridge h5ServiceWorkerHook4Bridge, String str2, int i) {
        Page activePage = this.f6497a.getActivePage();
        if (activePage == null) {
            GriverLogger.d("Griver:WebWorkerControllerProvider", "handleMsgFromJs but page == null! add to pageReady listener.");
            this.f6497a.addPageReadyListener(new App.PageReadyListener() { // from class: com.alibaba.griver.core.worker.WebWorkerControllerProvider.1
                @Override // com.alibaba.ariver.app.api.App.PageReadyListener
                public void onPageReady(Page page) {
                    WebWorkerControllerProvider.this.a(page, str, jSONObject, h5ServiceWorkerHook4Bridge);
                }
            });
            return;
        }
        a(activePage, str, jSONObject, h5ServiceWorkerHook4Bridge);
    }

    @Override // com.alibaba.griver.core.worker.H5WorkerControllerProvider
    public boolean handleMsgFromWorker(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("JSBridgeReady".equals(str)) {
            this.d.onAlipayJSBridgeReady();
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleMsgFromWorker msg = ");
        sb.append(str);
        GriverLogger.d("Griver:WebWorkerControllerProvider", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((WebWorker) this.d).getBridgeToken());
        sb2.append(ACJSBridge.JSAPI_PREFIX);
        String obj = sb2.toString();
        if (!str.startsWith(obj)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("jserror:");
            sb3.append(obj);
            if (str.startsWith(sb3.toString())) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("jserror:");
                sb4.append(obj);
                obj = sb4.toString();
            } else {
                obj = null;
            }
        }
        if (TextUtils.isEmpty(obj)) {
            return false;
        }
        String replaceFirst = str.replaceFirst(obj, "");
        if (TextUtils.isEmpty(replaceFirst)) {
            int indexOf = str.indexOf(ACJSBridge.JSAPI_PREFIX);
            if (indexOf >= 0 && str.length() > indexOf) {
                String substring = str.substring(0, indexOf);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleMsgFromJS token invalid! prefixStr = ");
                sb5.append(substring);
                GriverLogger.d("Griver:WebWorkerControllerProvider", sb5.toString());
            }
            return false;
        }
        JSONObject parseObject = JSONUtils.parseObject(replaceFirst);
        if (parseObject == null || parseObject.isEmpty()) {
            return false;
        }
        if (JSONUtils.getJSONObject(parseObject, "data", null) == null) {
            GriverLogger.e("Griver:WebWorkerControllerProvider", "invalid param, handleMsgFromWorker data = null");
        }
        if (NXEmbedWebView.POST_MESSAGE_ACTION_TYPE.equals(parseObject.getString("handlerName"))) {
            a(parseObject);
        } else {
            final String string = parseObject.getString("callbackId");
            if (TextUtils.isEmpty(string)) {
                GriverLogger.e("Griver:WebWorkerControllerProvider", "invalid callbackId");
                return false;
            }
            handleMsgFromJs(parseObject.getString("handlerName"), parseObject, new H5ServiceWorkerHook4Bridge() { // from class: com.alibaba.griver.core.worker.WebWorkerControllerProvider.2
                @Override // com.alibaba.griver.base.api.H5ServiceWorkerHook4Bridge
                public void onReceiveJsapiResult(JSONObject jSONObject) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("responseId", (Object) string);
                    jSONObject2.put(ZimMessageChannel.K_RPC_RES, (Object) jSONObject);
                    WebWorkerControllerProvider.this.d.sendJsonToWorker(null, null, jSONObject2);
                }
            }, this.d.getWorkerId(), 80);
        }
        return true;
    }

    @Override // com.alibaba.griver.core.worker.H5WorkerControllerProvider
    protected Handler getHandler(String str) {
        if (WorkerApiConfig.getDefaultAsyncJsApiList().contains(str)) {
            return H5EventDispatchHandler.getAsyncHandler();
        }
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.e = new Handler(Looper.getMainLooper());
                }
            }
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Page page, final String str, final JSONObject jSONObject, final H5ServiceWorkerHook4Bridge h5ServiceWorkerHook4Bridge) {
        getHandler(str).post(new Runnable() { // from class: com.alibaba.griver.core.worker.WebWorkerControllerProvider.3
            @Override // java.lang.Runnable
            public void run() {
                NativeBridge bridge;
                if (WebWorkerControllerProvider.this.f6497a == null || WebWorkerControllerProvider.this.f6497a.isDestroyed()) {
                    return;
                }
                JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
                String string = JSONUtils.getString(jSONObject2, "viewId", null);
                NativeCallContext.Builder node = new NativeCallContext.Builder().name(str).params(jSONObject2).node(page);
                StringBuilder sb = new StringBuilder();
                sb.append("worker_");
                sb.append(NativeCallContext.generateUniqueId());
                NativeCallContext build = node.id(sb.toString()).render(WebWorkerControllerProvider.this.a().getRenderById(string)).source(NativeCallContext.FROM_WORKER).build();
                RVEngine engineProxy = WebWorkerControllerProvider.this.f6497a.getEngineProxy();
                if (engineProxy == null || engineProxy.isDestroyed() || (bridge = engineProxy.getBridge()) == null || build.getRender() == null) {
                    return;
                }
                bridge.sendToNative(build, new SendToNativeCallback() { // from class: com.alibaba.griver.core.worker.WebWorkerControllerProvider.3.1
                    @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                    public void onCallback(JSONObject jSONObject3, boolean z) {
                        if (h5ServiceWorkerHook4Bridge != null) {
                            h5ServiceWorkerHook4Bridge.onReceiveJsapiResult(jSONObject3);
                        }
                    }
                });
            }
        });
    }

    @Override // com.alibaba.griver.core.worker.H5WorkerControllerProvider
    public void destroy() {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final JSONObject jSONObject) {
        if (!this.d.isRenderReady()) {
            this.d.registerRenderReadyListener(new H5Worker.RenderReadyListener() { // from class: com.alibaba.griver.core.worker.WebWorkerControllerProvider.4
                @Override // com.alibaba.griver.core.worker.H5Worker.RenderReadyListener
                public void onRenderReady() {
                    WebWorkerControllerProvider.this.a(jSONObject);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("joMessage is ");
        sb.append(jSONObject);
        GriverLogger.d("Griver:WebWorkerControllerProvider", sb.toString());
        String string = JSONUtils.getString(JSONUtils.getJSONObject(jSONObject, "data", null), "viewId", null);
        Render renderById = a().getRenderById(string);
        if (renderById != null) {
            renderById.getRenderBridge().sendToRender(RenderCallContext.newBuilder(renderById).action("message").type("call").param(jSONObject).build(), null);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("postMessage but cannot find viewId: ");
        sb2.append(string);
        GriverLogger.w("Griver:WebWorkerControllerProvider", sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EngineRouter a() {
        App app;
        if (this.c == null && (app = this.f6497a) != null && app.getEngineProxy() != null) {
            this.c = this.f6497a.getEngineProxy().getEngineRouter();
        }
        return this.c;
    }
}
