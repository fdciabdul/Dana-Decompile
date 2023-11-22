package com.alibaba.ariver.engine.common.bridge.internal;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class DefaultBridgeCallback implements BridgeCallback {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6034a;
    private BridgeResponseHelper b;

    public DefaultBridgeCallback(BridgeResponseHelper bridgeResponseHelper) {
        this(bridgeResponseHelper, false);
    }

    public DefaultBridgeCallback(BridgeResponseHelper bridgeResponseHelper, boolean z) {
        this.f6034a = z;
        this.b = bridgeResponseHelper;
    }

    public boolean isSticky() {
        return this.f6034a;
    }

    public BridgeResponseHelper getResponseHelper() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
    public void sendJSONResponse(JSONObject jSONObject, boolean z) {
        if (z) {
            this.b.sendBridgeResultWithCallbackKept(jSONObject);
        } else {
            this.b.sendBridgeResult(jSONObject);
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
    public void sendJSONResponse(JSONObject jSONObject) {
        if (this.f6034a) {
            this.b.sendBridgeResultWithCallbackKept(jSONObject);
        } else {
            this.b.sendBridgeResult(jSONObject);
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
    public void sendBridgeResponse(BridgeResponse bridgeResponse) {
        if (bridgeResponse == null) {
            bridgeResponse = BridgeResponse.SUCCESS;
        }
        if (bridgeResponse instanceof BridgeResponse.Error) {
            BridgeResponse.Error error = (BridgeResponse.Error) bridgeResponse;
            if (!TextUtils.isEmpty(error.getSignature())) {
                this.b.sendError(error.getErrorCode(), error.getErrorMessage(), error.getSignature());
                return;
            } else {
                this.b.sendError(error.getErrorCode(), error.getErrorMessage());
                return;
            }
        }
        JSONObject jSONObject = bridgeResponse.get();
        if (this.f6034a) {
            this.b.sendBridgeResultWithCallbackKept(jSONObject);
        } else {
            this.b.sendBridgeResult(jSONObject);
        }
    }
}
