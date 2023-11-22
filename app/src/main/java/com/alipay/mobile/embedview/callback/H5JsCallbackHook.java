package com.alipay.mobile.embedview.callback;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class H5JsCallbackHook extends H5JsCallback<BridgeCallback> {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f7135a;
    private Page b;

    public H5JsCallbackHook(Page page, BridgeCallback bridgeCallback, Runnable runnable) {
        super(bridgeCallback);
        this.f7135a = runnable;
    }

    private void a() {
        Runnable runnable = this.f7135a;
        if (runnable != null) {
            runnable.run();
            this.f7135a = null;
        }
    }

    @Override // com.alipay.mobile.embedview.callback.H5JsCallback
    public boolean sendToWeb(String str, JSONObject jSONObject) {
        if (this.b == null) {
            return false;
        }
        if (this.mProxy != 0) {
            EngineUtils.sendToRender(this.b.getRender(), str, jSONObject, null);
            a();
            return true;
        }
        return super.sendToWeb(str, jSONObject);
    }

    @Override // com.alipay.mobile.embedview.callback.H5JsCallback
    public boolean sendBridgeResult(JSONObject jSONObject) {
        if (this.mProxy != 0) {
            ((BridgeCallback) this.mProxy).sendJSONResponse(jSONObject);
            a();
            return true;
        }
        return super.sendBridgeResult(jSONObject);
    }

    @Override // com.alipay.mobile.embedview.callback.H5JsCallback
    public boolean sendSuccess() {
        if (this.mProxy != 0) {
            ((BridgeCallback) this.mProxy).sendBridgeResponse(BridgeResponse.SUCCESS);
            a();
            return true;
        }
        return super.sendSuccess();
    }

    @Override // com.alipay.mobile.embedview.callback.H5JsCallback
    public boolean sendError(int i, String str) {
        if (this.mProxy != 0) {
            ((BridgeCallback) this.mProxy).sendBridgeResponse(new BridgeResponse.Error(i, str));
            a();
            return true;
        }
        return super.sendError(i, str);
    }
}
