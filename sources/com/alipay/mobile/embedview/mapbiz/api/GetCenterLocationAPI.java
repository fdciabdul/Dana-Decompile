package com.alipay.mobile.embedview.mapbiz.api;

import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public class GetCenterLocationAPI extends H5MapAPI {
    @Override // com.alipay.mobile.embedview.mapbiz.api.H5MapAPI
    public void call(H5MapContainer h5MapContainer, JSONObject jSONObject, H5JsCallback h5JsCallback) {
        AdapterTextureMapView mapView = h5MapContainer.getMapView();
        if (mapView == null || mapView.getMap() == null) {
            h5JsCallback.sendError(3, "unknown");
            return;
        }
        AdapterCameraPosition cameraPosition = mapView.getMap().getCameraPosition();
        if (cameraPosition == null || cameraPosition.target == null) {
            h5JsCallback.sendError(3, "unknown");
            h5MapContainer.reportController.reportJsApiError("getCenterLocation", 3, "unknown");
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("longitude", (Object) Double.valueOf(cameraPosition.target.getLongitude()));
        jSONObject2.put("latitude", (Object) Double.valueOf(cameraPosition.target.getLatitude()));
        jSONObject2.put(H5MapRenderOptimizer.KEY_SCALE, (Object) Float.valueOf(cameraPosition.zoom));
        h5JsCallback.sendBridgeResult(jSONObject2);
    }
}
