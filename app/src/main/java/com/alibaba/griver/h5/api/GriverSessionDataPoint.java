package com.alibaba.griver.h5.api;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface GriverSessionDataPoint extends Extension {
    JSONObject getData(JSONArray jSONArray);

    void setData(JSONObject jSONObject);
}
