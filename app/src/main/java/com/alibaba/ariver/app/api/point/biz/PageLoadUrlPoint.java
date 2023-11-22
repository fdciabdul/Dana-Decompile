package com.alibaba.ariver.app.api.point.biz;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface PageLoadUrlPoint extends Extension {
    String loadUrlDirectly(JSONObject jSONObject, String str, int i);
}
