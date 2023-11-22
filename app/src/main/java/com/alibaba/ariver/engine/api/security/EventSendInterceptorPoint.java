package com.alibaba.ariver.engine.api.security;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface EventSendInterceptorPoint extends Extension {
    boolean needIntercept(String str, JSONObject jSONObject);
}
