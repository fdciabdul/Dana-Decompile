package com.alibaba.ariver.permission.api.proxy;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface JsapiInterceptorProxy extends Proxiable {
    boolean asyncInterceptor(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, Page page);

    boolean syncInterceptor(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, Page page);
}
