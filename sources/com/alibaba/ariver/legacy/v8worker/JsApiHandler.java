package com.alibaba.ariver.legacy.v8worker;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.proxy.RVJSApiHandlerProxy;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alipay.mobile.security.zim.msgchannel.ZimMessageChannel;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class JsApiHandler {
    private String TAG;
    private App mApp;
    private V8Worker mWorker;
    private final String VIEW_ID = "viewId";
    private final int RETRY_DELAY_MS = 30;
    private boolean mIsFirstJsApi = true;

    protected void onApiCall(long j, NativeCallContext nativeCallContext) {
    }

    protected void onApiCallback(long j, NativeCallContext nativeCallContext, JSONObject jSONObject) {
    }

    public JsApiHandler(App app, V8Worker v8Worker) {
        this.mWorker = v8Worker;
        this.mApp = app;
        StringBuilder sb = new StringBuilder();
        sb.append(v8Worker.getLogTag());
        sb.append("_JsApiHandler");
        this.TAG = sb.toString();
    }

    public void handleSyncJsapiRequest(String str) throws UnsupportedEncodingException {
        Uri parse = Uri.parse(str);
        if (this.mIsFirstJsApi) {
            this.mIsFirstJsApi = false;
        }
        String queryParameter = parse.getQueryParameter("data");
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("handleSyncJsapiRequest data ");
        sb.append(queryParameter);
        RVLogger.d(str2, sb.toString());
        JSONObject parseObject = JSONUtils.parseObject(queryParameter);
        if (parseObject == null || parseObject.isEmpty()) {
            return;
        }
        final String string = JSONUtils.getString(parseObject, "action");
        String string2 = JSONUtils.getString(parseObject, "applicationId");
        String string3 = JSONUtils.getString(parseObject, "callback");
        if (!TextUtils.isEmpty(string3)) {
            String str3 = this.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sync hasPermission ");
            sb2.append(true);
            sb2.append(", render ready ");
            sb2.append(this.mWorker.isRenderReady());
            RVLogger.d(str3, sb2.toString());
            int i = this.mWorker.isRenderReady() ? 2000 : 8000;
            int syncTimeout = ((RVJSApiHandlerProxy) RVProxy.get(RVJSApiHandlerProxy.class)).getSyncTimeout(string, this.mWorker.getStartupParams(), parseObject);
            if (syncTimeout > 0) {
                String str4 = this.TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("H5TinyAppProvider.getTyroBlockTime result: ");
                sb3.append(syncTimeout);
                RVLogger.d(str4, sb3.toString());
                i = syncTimeout;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(string3);
            sb4.append("(");
            handleMsgFromJs(string, parseObject, new SendToWorkerCallback() { // from class: com.alibaba.ariver.legacy.v8worker.JsApiHandler.1
                final long time = System.currentTimeMillis();

                @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                public void onCallBack(JSONObject jSONObject) {
                    String str5;
                    try {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            long j = this.time;
                            String str6 = JsApiHandler.this.TAG;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("tinyAppTimeCostLog:");
                            sb5.append(string);
                            sb5.append(" onReceiveJsapiResult cost ");
                            sb5.append(currentTimeMillis - j);
                            RVLogger.d(str6, sb5.toString());
                            if (jSONObject != null) {
                                String jSONString = jSONObject.toJSONString();
                                String str7 = JsApiHandler.this.TAG;
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("sync action ");
                                sb6.append(string);
                                sb6.append(" sendMsg ");
                                if (jSONString.length() > 200) {
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append(jSONString.substring(0, 200));
                                    sb7.append("..");
                                    str5 = sb7.toString();
                                } else {
                                    str5 = jSONString;
                                }
                                sb6.append(str5);
                                RVLogger.d(str7, sb6.toString());
                                sb4.append(jSONString);
                            }
                        } catch (Exception e) {
                            RVLogger.e(JsApiHandler.this.TAG, "sync failed to get byte array", e);
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }, string2, i / 30);
            try {
                countDownLatch.await(i, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                RVLogger.e(this.TAG, "sync lock await error!");
            }
            sb4.append(")");
            this.mWorker.executeScript(sb4.toString());
            return;
        }
        RVLogger.d(this.TAG, "caution!!! shouldn't be here!!!!");
    }

    public void handleAsyncJsapiRequest(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            RVLogger.e(this.TAG, "invalid param, handleAsyncJsapiRequest");
            return;
        }
        String string = jSONObject.getString("handlerName");
        if (TextUtils.isEmpty(string)) {
            RVLogger.e(this.TAG, "invalid param, handleAsyncJsapiRequest action = null");
            return;
        }
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("handleAsyncJsapiRequest ");
        sb.append(string);
        RVLogger.d(str, sb.toString());
        if (JSONUtils.getJSONObject(jSONObject, "data", null) == null) {
            RVLogger.e(this.TAG, "invalid param, handleAsyncJsapiRequest data = null");
        }
        if (NXEmbedWebView.POST_MESSAGE_ACTION_TYPE.equals(string)) {
            handlePostMessage(jSONObject);
            return;
        }
        final String string2 = jSONObject.getString("callbackId");
        if (TextUtils.isEmpty(string2)) {
            RVLogger.e(this.TAG, "invalid callbackId");
        } else {
            handleMsgFromJs(string, jSONObject, new SendToWorkerCallback() { // from class: com.alibaba.ariver.legacy.v8worker.JsApiHandler.2
                @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                public void onCallBack(JSONObject jSONObject2) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("responseId", (Object) string2);
                    jSONObject3.put(ZimMessageChannel.K_RPC_RES, (Object) jSONObject2);
                    JsApiHandler.this.mWorker.sendMessageToWorker(null, null, jSONObject3.toJSONString());
                }
            }, this.mWorker.getWorkerId(), 266);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePostMessage(final JSONObject jSONObject) {
        if (!this.mWorker.isRenderReady()) {
            this.mWorker.registerRenderReadyListener(new BaseWorkerImpl.RenderReadyListener() { // from class: com.alibaba.ariver.legacy.v8worker.JsApiHandler.3
                @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl.RenderReadyListener
                public void onRenderReady() {
                    JsApiHandler.this.handlePostMessage(jSONObject);
                }
            });
            return;
        }
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("postMessage: ");
        sb.append(jSONObject);
        RVLogger.d(str, sb.toString());
        String string = JSONUtils.getString(JSONUtils.getJSONObject(jSONObject, "data", null), "viewId", null);
        Render renderById = this.mApp.getEngineProxy().getEngineRouter().getRenderById(string);
        if (renderById != null) {
            renderById.getRenderBridge().sendToRender(RenderCallContext.newBuilder(renderById).action("message").type("call").param(jSONObject).build(), null);
            return;
        }
        String str2 = this.TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("postMessage but cannot find viewId: ");
        sb2.append(string);
        RVLogger.w(str2, sb2.toString());
    }

    protected void handleMsgFromJs(final String str, JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback, String str2, int i) {
        try {
            String str3 = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("handleMsgFromJs: ");
            sb.append(str);
            sb.append(", param ");
            sb.append(jSONObject);
            RVLogger.d(str3, sb.toString());
        } catch (Throwable unused) {
        }
        try {
            JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
            String string = JSONUtils.getString(jSONObject2, "viewId", null);
            App app = this.mApp;
            if (app != null && app.getEngineProxy() != null && this.mApp.getEngineProxy().getEngineRouter() != null) {
                Render renderById = this.mApp.getEngineProxy().getEngineRouter().getRenderById(string);
                if (renderById == null) {
                    String str4 = this.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("handleMsgFromJs: ");
                    sb2.append(str);
                    sb2.append(", but cannot find viewId for ");
                    sb2.append(string);
                    RVLogger.w(str4, sb2.toString());
                    return;
                }
                final long currentTimeMillis = System.currentTimeMillis();
                final NativeCallContext build = new NativeCallContext.Builder().name(str).params(jSONObject2).node(renderById.getPage()).source(NativeCallContext.FROM_WORKER).render(renderById).build();
                onApiCall(currentTimeMillis, build);
                renderById.getEngine().getBridge().sendToNative(build, new SendToNativeCallback() { // from class: com.alibaba.ariver.legacy.v8worker.JsApiHandler.4
                    @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                    public void onCallback(JSONObject jSONObject3, boolean z) {
                        String str5 = JsApiHandler.this.TAG;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("handleMsgFromJs: ");
                        sb3.append(str);
                        sb3.append(", return ");
                        sb3.append(jSONObject3);
                        RVLogger.d(str5, sb3.toString());
                        SendToWorkerCallback sendToWorkerCallback2 = sendToWorkerCallback;
                        if (sendToWorkerCallback2 != null) {
                            sendToWorkerCallback2.onCallBack(jSONObject3);
                        }
                        JsApiHandler.this.onApiCallback(currentTimeMillis, build, jSONObject3);
                    }
                });
                return;
            }
            String str5 = this.TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("handleMsgFromJs: ");
            sb3.append(str);
            sb3.append(", but cannot find viewId for ");
            sb3.append(string);
            RVLogger.w(str5, sb3.toString());
        } catch (Throwable th) {
            String str6 = this.TAG;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("handleMsgFromJs: ");
            sb4.append(str);
            sb4.append(" exception!");
            RVLogger.e(str6, sb4.toString(), th);
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(BridgeResponse.INVALID_PARAM.get());
            }
        }
    }
}
