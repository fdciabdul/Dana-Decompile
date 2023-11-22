package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.common.bridge.internal.DefaultBridgeCallback;

/* loaded from: classes3.dex */
public class CallbackBinder implements Binder<BindingCallback, BridgeCallback> {

    /* renamed from: a  reason: collision with root package name */
    private BridgeResponseHelper f6038a;

    public CallbackBinder(BridgeResponseHelper bridgeResponseHelper) {
        this.f6038a = bridgeResponseHelper;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public BridgeCallback bind(Class<BridgeCallback> cls, BindingCallback bindingCallback) throws BindException {
        return new DefaultBridgeCallback(this.f6038a, bindingCallback.isSticky());
    }
}
