package com.alibaba.ariver.kernel.common.bigdata;

import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface IBigDataChannelCallback {
    void onChannelCreated(String str, String str2, String str3);

    void onChannelReleased(String str);

    void onReceiveData(JSONObject jSONObject);
}
