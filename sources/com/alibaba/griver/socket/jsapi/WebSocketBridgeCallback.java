package com.alibaba.griver.socket.jsapi;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.ariver.websocket.core.RVWebSocketCallback;
import com.alibaba.fastjson.JSONObject;
import id.dana.data.here.HereOauthManager;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class WebSocketBridgeCallback implements RVWebSocketCallback {

    /* renamed from: a  reason: collision with root package name */
    private Page f6650a;
    private boolean b;
    private String c;

    public WebSocketBridgeCallback(Page page, String str, boolean z) {
        this.f6650a = page;
        this.b = z;
        this.c = str;
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
    public void onSocketOpen() {
        if (this.f6650a == null) {
            return;
        }
        RVLogger.d("AriverAPI:WebSocketBridgeCallback", "enter onSocketOpen. ");
        if (this.b && !TextUtils.isEmpty(this.c)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("socketTaskID", (Object) this.c);
            jSONObject.put("data", (Object) jSONObject2);
            a("onSocketTaskOpen", jSONObject);
            return;
        }
        a("socketOpen", null);
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
    public void onSocketClose() {
        if (this.f6650a == null) {
            return;
        }
        RVLogger.d("AriverAPI:WebSocketBridgeCallback", "enter onSocketClose. ");
        if (this.b && !TextUtils.isEmpty(this.c)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("socketTaskID", (Object) this.c);
            jSONObject.put("data", (Object) jSONObject2);
            a("onSocketTaskClose", jSONObject);
            return;
        }
        a("socketClose", null);
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
    public void onSocketMessage(byte[] bArr) {
        if (this.f6650a == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", (Object) new String(Base64.encode(bArr, 2), HereOauthManager.ENC));
            jSONObject.put("isBuffer", (Object) Boolean.TRUE);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            if (this.b && !TextUtils.isEmpty(this.c)) {
                jSONObject.put("socketTaskID", (Object) this.c);
                a("onSocketTaskMessage", jSONObject2);
                return;
            }
            a(RDConstant.SOCKET_MESSAGE, jSONObject2);
        } catch (UnsupportedEncodingException e) {
            RVLogger.e("AriverAPI:WebSocketBridgeCallback", String.format("create string by buffer error. exception : %s", e.toString()));
        }
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
    public void onSocketMessage(String str) {
        if (this.f6650a == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", (Object) str);
        jSONObject.put("isBuffer", (Object) Boolean.FALSE);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        if (this.b && !TextUtils.isEmpty(this.c)) {
            jSONObject.put("socketTaskID", (Object) this.c);
            a("onSocketTaskMessage", jSONObject2);
            return;
        }
        a(RDConstant.SOCKET_MESSAGE, jSONObject2);
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketCallback
    public void onSocketError(int i, String str) {
        if (this.f6650a == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("enter onSocketError. ");
        sb.append(str);
        RVLogger.d("AriverAPI:WebSocketBridgeCallback", sb.toString());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", Integer.valueOf(i));
        JSONObject jSONObject2 = new JSONObject();
        if (this.b && !TextUtils.isEmpty(this.c)) {
            jSONObject2.put("socketTaskID", (Object) this.c);
            jSONObject.put("data", (Object) jSONObject2);
            a("onSocketTaskError", jSONObject);
            return;
        }
        a("socketError", jSONObject);
    }

    private void a(String str, JSONObject jSONObject) {
        Page page = this.f6650a;
        if (page == null) {
            return;
        }
        EngineUtils.sendToRender(page.getRender(), str, jSONObject, null);
    }

    public void setPage(Page page) {
        this.f6650a = page;
    }
}
