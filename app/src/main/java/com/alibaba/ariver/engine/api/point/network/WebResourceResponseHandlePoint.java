package com.alibaba.ariver.engine.api.point.network;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface WebResourceResponseHandlePoint extends Extension {
    void onHandleResponse(String str, boolean z, boolean z2, byte[] bArr, String str2, JSONObject jSONObject);
}
