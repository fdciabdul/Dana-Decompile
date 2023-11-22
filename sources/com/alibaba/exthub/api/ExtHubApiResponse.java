package com.alibaba.exthub.api;

import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface ExtHubApiResponse {
    void fail(JSONObject jSONObject);

    void success(JSONObject jSONObject);
}
