package com.alipay.mobile.embedview.mapbiz.api;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.zebra.data.ZebraData;

/* loaded from: classes6.dex */
public class GetMapPropertiesAPI extends H5MapAPI {
    @Override // com.alipay.mobile.embedview.mapbiz.api.H5MapAPI
    public void call(H5MapContainer h5MapContainer, JSONObject jSONObject, H5JsCallback h5JsCallback) {
        try {
            AdapterTextureMapView mapView = h5MapContainer.getMapView();
            if (mapView == null) {
                h5JsCallback.sendError(3, "unknown");
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("success", (Object) Boolean.TRUE);
            jSONObject2.put("is3d", (Object) Boolean.valueOf(!mapView.is2dMapSdk()));
            jSONObject2.put("isSupportAnim", (Object) Boolean.valueOf(!mapView.is2dMapSdk()));
            jSONObject2.put(ZebraData.ATTR_WIDTH, (Object) Integer.valueOf(mapView.getWidth()));
            jSONObject2.put(ZebraData.ATTR_HEIGHT, (Object) Integer.valueOf(mapView.getHeight()));
            h5JsCallback.sendBridgeResult(jSONObject2);
        } catch (Throwable th) {
            h5JsCallback.sendError(3, "unknown");
            RVLogger.e(H5MapContainer.TAG, th);
            h5MapContainer.reportController.reportJsApiError("getMapProperties", -1, th.getMessage());
        }
    }
}
