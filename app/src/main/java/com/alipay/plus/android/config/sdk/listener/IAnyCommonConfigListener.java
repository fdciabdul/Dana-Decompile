package com.alipay.plus.android.config.sdk.listener;

import com.alibaba.fastjson.JSONObject;
import com.alipay.plus.android.config.sdk.listener.sectionconfig.ChangedDetails;

/* loaded from: classes7.dex */
public interface IAnyCommonConfigListener {
    void onConfigChanged(JSONObject jSONObject, ChangedDetails changedDetails);
}
