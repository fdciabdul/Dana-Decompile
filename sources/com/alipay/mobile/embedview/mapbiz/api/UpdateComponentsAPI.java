package com.alipay.mobile.embedview.mapbiz.api;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public class UpdateComponentsAPI extends H5MapAPI {
    @Override // com.alipay.mobile.embedview.mapbiz.api.H5MapAPI
    public void call(H5MapContainer h5MapContainer, JSONObject jSONObject, H5JsCallback h5JsCallback) {
        try {
            h5MapContainer.updateComponentsController.updateComponents(jSONObject, h5JsCallback);
        } catch (Throwable th) {
            h5JsCallback.sendError(3, "unknown");
            RVLogger.e(H5MapContainer.TAG, th);
            h5MapContainer.reportController.reportJsApiError("updateComponents", -1, th.getMessage());
        }
    }
}
