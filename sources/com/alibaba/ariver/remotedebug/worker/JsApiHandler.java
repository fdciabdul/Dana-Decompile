package com.alibaba.ariver.remotedebug.worker;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alipay.mobile.security.zim.msgchannel.ZimMessageChannel;
import com.iap.ac.android.container.js.ACJSBridge;
import id.dana.data.constant.UrlParam;

/* loaded from: classes6.dex */
public class JsApiHandler {

    /* renamed from: a */
    private EngineRouter f6195a;
    private RemoteDebugWorker b;

    public JsApiHandler(RemoteDebugWorker remoteDebugWorker, EngineRouter engineRouter) {
        this.b = remoteDebugWorker;
        this.f6195a = engineRouter;
    }

    public boolean handleMsgFromWorker(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleMsgFromWorker msg = ");
        sb.append(str);
        RVLogger.d("AriverRemoteDebug:JsApiHandler", sb.toString());
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("https://alipay.kylinBridge")) {
            return b(str);
        }
        return a(str);
    }

    private boolean a(String str) {
        JSONObject parseObject;
        StringBuilder sb = new StringBuilder();
        sb.append("handleJSMsgFromWorker msg = ");
        sb.append(str);
        RVLogger.d("AriverRemoteDebug:JsApiHandler", sb.toString());
        String str2 = ACJSBridge.JSAPI_PREFIX;
        if (!str.startsWith(ACJSBridge.JSAPI_PREFIX)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("jserror:");
            sb2.append(ACJSBridge.JSAPI_PREFIX);
            if (str.startsWith(sb2.toString())) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("jserror:");
                sb3.append(ACJSBridge.JSAPI_PREFIX);
                str2 = sb3.toString();
            } else {
                str2 = null;
            }
        }
        if (TextUtils.isEmpty(str2) || (parseObject = JSONUtils.parseObject(str.replaceFirst(str2, ""))) == null || parseObject.isEmpty()) {
            return false;
        }
        if (JSONUtils.getJSONObject(parseObject, "data", null) == null) {
            RVLogger.e("AriverRemoteDebug:JsApiHandler", "invalid param, handleMsgFromWorker data = null");
        }
        if (NXEmbedWebView.POST_MESSAGE_ACTION_TYPE.equals(parseObject.getString("handlerName"))) {
            a(parseObject);
            return true;
        }
        final String string = parseObject.getString("callbackId");
        if (TextUtils.isEmpty(string)) {
            RVLogger.e("AriverRemoteDebug:JsApiHandler", "invalid callbackId");
            return false;
        }
        a(parseObject.getString("handlerName"), parseObject, new SendToWorkerCallback() { // from class: com.alibaba.ariver.remotedebug.worker.JsApiHandler.1
            {
                JsApiHandler.this = this;
            }

            @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
            public void onCallBack(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("responseId", (Object) string);
                jSONObject2.put(ZimMessageChannel.K_RPC_RES, (Object) jSONObject);
                JsApiHandler.this.b.sendMessageToWorker(null, null, jSONObject2.toJSONString());
            }
        });
        return true;
    }

    private boolean b(String str) {
        Uri parse = Uri.parse(str);
        RVLogger.d("AriverRemoteDebug:JsApiHandler", parse.toString());
        String scheme = parse.getScheme();
        String host = parse.getHost();
        StringBuilder sb = new StringBuilder();
        sb.append(scheme);
        sb.append("://");
        sb.append(host);
        if ("https://alipay.kylinBridge".equalsIgnoreCase(sb.toString())) {
            String queryParameter = parse.getQueryParameter("data");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("handleSyncJsApiCall data ");
            sb2.append(queryParameter);
            RVLogger.d("AriverRemoteDebug:JsApiHandler", sb2.toString());
            JSONObject parseObject = JSONObject.parseObject(queryParameter);
            if (parseObject == null || parseObject.isEmpty()) {
                return false;
            }
            final String string = JSONUtils.getString(parseObject, "action");
            final int i = JSONUtils.getInt(parseObject, UrlParam.REQUEST_ID);
            final String string2 = JSONUtils.getString(parseObject, "callback");
            if (TextUtils.isEmpty(string2)) {
                return false;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("sync hasPermission ");
            sb3.append(true);
            RVLogger.d("AriverRemoteDebug:JsApiHandler", sb3.toString());
            try {
                a(string, parseObject, new SendToWorkerCallback() { // from class: com.alibaba.ariver.remotedebug.worker.JsApiHandler.2
                    final long time = System.currentTimeMillis();

                    {
                        JsApiHandler.this = this;
                    }

                    @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                    public void onCallBack(JSONObject jSONObject) {
                        long currentTimeMillis = System.currentTimeMillis();
                        long j = this.time;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("tinyAppTimeCostLog:");
                        sb4.append(string);
                        sb4.append(" onReceiveJsapiResult cost ");
                        sb4.append(currentTimeMillis - j);
                        RVLogger.d("AriverRemoteDebug:JsApiHandler", sb4.toString());
                        if (jSONObject != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("type", (Object) "sync");
                            jSONObject2.put("responseId", (Object) Integer.valueOf(i));
                            jSONObject2.put(ZimMessageChannel.K_RPC_RES, (Object) jSONObject);
                            jSONObject2.put("callback", (Object) string2);
                            JsApiHandler.this.b.sendMessageToWorker(null, null, jSONObject2.toJSONString());
                            RVLogger.d("AriverRemoteDebug:JsApiHandler", "sync onReceiveJsapiResult action ");
                        }
                    }
                });
            } catch (Exception e) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("handleSyncJsApiCall...e=");
                sb4.append(e);
                RVLogger.e("AriverRemoteDebug:JsApiHandler", sb4.toString());
            }
            return true;
        }
        return false;
    }

    private void a(final String str, JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleMsgFromJs: ");
        sb.append(str);
        sb.append(", param ");
        sb.append(jSONObject);
        RVLogger.d("AriverRemoteDebug:JsApiHandler", sb.toString());
        try {
            JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
            String string = JSONUtils.getString(jSONObject2, "viewId", null);
            Render renderById = this.f6195a.getRenderById(string);
            if (renderById == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("handleMsgFromJs: ");
                sb2.append(str);
                sb2.append(", but cannot find viewId for ");
                sb2.append(string);
                RVLogger.w("AriverRemoteDebug:JsApiHandler", sb2.toString());
                return;
            }
            NativeCallContext.Builder render = new NativeCallContext.Builder().name(str).params(jSONObject2).node(renderById.getPage()).render(renderById);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(System.currentTimeMillis());
            renderById.getEngine().getBridge().sendToNative(render.id(sb3.toString()).build(), new SendToNativeCallback() { // from class: com.alibaba.ariver.remotedebug.worker.JsApiHandler.3
                {
                    JsApiHandler.this = this;
                }

                @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                public void onCallback(JSONObject jSONObject3, boolean z) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("handleMsgFromJs: ");
                    sb4.append(str);
                    sb4.append(", return ");
                    sb4.append(jSONObject3);
                    RVLogger.d("AriverRemoteDebug:JsApiHandler", sb4.toString());
                    SendToWorkerCallback sendToWorkerCallback2 = sendToWorkerCallback;
                    if (sendToWorkerCallback2 != null) {
                        sendToWorkerCallback2.onCallBack(jSONObject3);
                    }
                }
            });
        } catch (Throwable th) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("handleMsgFromJs: ");
            sb4.append(str);
            sb4.append(" exception!");
            RVLogger.e("AriverRemoteDebug:JsApiHandler", sb4.toString(), th);
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(BridgeResponse.INVALID_PARAM.get());
            }
        }
    }

    private boolean a(JSONObject jSONObject) {
        return handleMessage(jSONObject, "message");
    }

    public boolean handleMessageToTopRender(JSONObject jSONObject, String str) {
        Render renderById = this.f6195a.getRenderById(null);
        if (renderById == null) {
            RVLogger.e("AriverRemoteDebug:JsApiHandler", "handleMessageToTopRender error! can't find target render");
            return false;
        }
        EngineUtils.sendToRender(renderById, this.b, str, jSONObject, null);
        return true;
    }

    public boolean handleMessage(JSONObject jSONObject, String str) {
        Render renderById = this.f6195a.getRenderById(JSONUtils.getString(JSONUtils.getJSONObject(jSONObject, "data", null), "viewId", null));
        if (renderById == null) {
            RVLogger.e("AriverRemoteDebug:JsApiHandler", "handleMessage error! can't find target render");
            return false;
        }
        renderById.getRenderBridge().sendToRender(RenderCallContext.newBuilder(renderById).action(str).type("call").param(jSONObject).build(), null);
        return true;
    }
}
