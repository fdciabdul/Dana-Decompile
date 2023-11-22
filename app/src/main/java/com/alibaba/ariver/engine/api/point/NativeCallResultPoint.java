package com.alibaba.ariver.engine.api.point;

import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface NativeCallResultPoint extends Extension {
    void onSendBack(NativeCallContext nativeCallContext, JSONObject jSONObject);
}
