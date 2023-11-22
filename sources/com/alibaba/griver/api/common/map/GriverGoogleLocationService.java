package com.alibaba.griver.api.common.map;

import android.content.Context;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public interface GriverGoogleLocationService extends Proxiable {
    void getLocation(Context context, JSONObject jSONObject, GriverGoogleLocationCallBack griverGoogleLocationCallBack);
}
