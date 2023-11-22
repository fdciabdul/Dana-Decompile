package com.alipay.mobile.embedview.mapbiz.api;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterLatLngBounds;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.data.Point;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public class GetRegionAPI extends H5MapAPI {
    @Override // com.alipay.mobile.embedview.mapbiz.api.H5MapAPI
    public void call(H5MapContainer h5MapContainer, JSONObject jSONObject, H5JsCallback h5JsCallback) {
        try {
            AdapterAMap map = h5MapContainer.getMap();
            if (map == null) {
                h5JsCallback.sendError(3, "unknown");
                RVLogger.e(H5MapContainer.TAG, "map is null");
                return;
            }
            AdapterLatLngBounds latLngBounds = map.getProjection().getVisibleRegion().latLngBounds();
            AdapterLatLng southwest = latLngBounds.southwest();
            AdapterLatLng northeast = latLngBounds.northeast();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("southwest", (Object) new Point(southwest.getLatitude(), southwest.getLongitude()));
            jSONObject2.put("northeast", (Object) new Point(northeast.getLatitude(), northeast.getLongitude()));
            h5JsCallback.sendBridgeResult(jSONObject2);
        } catch (Throwable th) {
            h5JsCallback.sendError(3, "unknown");
            RVLogger.e(H5MapContainer.TAG, th);
            h5MapContainer.reportController.reportJsApiError("getRegion", -1, th.getMessage());
        }
    }
}
