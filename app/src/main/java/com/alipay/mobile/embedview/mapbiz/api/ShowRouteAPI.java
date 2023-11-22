package com.alipay.mobile.embedview.mapbiz.api;

import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public class ShowRouteAPI extends H5MapAPI {
    @Override // com.alipay.mobile.embedview.mapbiz.api.H5MapAPI
    public void call(H5MapContainer h5MapContainer, JSONObject jSONObject, H5JsCallback h5JsCallback) {
        h5MapContainer.routeSearchController.showRoute(jSONObject, h5JsCallback);
    }
}
