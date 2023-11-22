package com.alibaba.ariver.engine.common.track;

import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.fastjson.JSONObject;

@DefaultImpl("com.alibaba.ariver.engine.common.track.DefaultJSAPIEventTracker")
/* loaded from: classes6.dex */
public interface JSAPIEventTrackerProxy extends Proxiable {
    void trackKeyJSAPIInvoke(NativeCallContext nativeCallContext);

    void trackKeyJSAPIResult(NativeCallContext nativeCallContext, JSONObject jSONObject);
}
