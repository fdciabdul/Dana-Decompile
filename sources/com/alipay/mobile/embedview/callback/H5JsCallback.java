package com.alipay.mobile.embedview.callback;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public abstract class H5JsCallback<T> {
    protected T mProxy;

    public H5JsCallback() {
    }

    public H5JsCallback(T t) {
        this.mProxy = t;
    }

    public H5JsCallback setProxy(T t) {
        this.mProxy = t;
        return this;
    }

    public boolean sendToWeb(String str, JSONObject jSONObject) {
        RVLogger.w("H5JsCallback", "sendToWeb do nothing");
        return false;
    }

    public boolean sendBridgeResult(JSONObject jSONObject) {
        RVLogger.w("H5JsCallback", "sendBridgeResult do nothing");
        return false;
    }

    public boolean sendSuccess() {
        RVLogger.w("H5JsCallback", "sendSuccess do nothing");
        return false;
    }

    public boolean sendError(int i, String str) {
        RVLogger.w("H5JsCallback", "sendError do nothing");
        return false;
    }
}
