package com.alibaba.griver.base.api;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface EventPoint extends Extension {
    boolean sendEvent(String str, JSONObject jSONObject);
}
