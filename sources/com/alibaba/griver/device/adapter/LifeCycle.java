package com.alibaba.griver.device.adapter;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface LifeCycle {
    void onCreate(Context context, JSONObject jSONObject);

    void onDestroy();
}
