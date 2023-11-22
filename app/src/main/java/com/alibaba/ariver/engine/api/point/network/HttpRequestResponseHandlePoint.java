package com.alibaba.ariver.engine.api.point.network;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface HttpRequestResponseHandlePoint extends Extension {
    void onHandleResponse(String str, String str2, JSONObject jSONObject);
}
