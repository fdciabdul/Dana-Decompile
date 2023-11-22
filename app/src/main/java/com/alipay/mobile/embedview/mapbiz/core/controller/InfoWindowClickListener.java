package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.embedview.mapbiz.core.H5MapMarker;
import com.alipay.mobile.embedview.mapbiz.data.Marker;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public class InfoWindowClickListener extends H5MapController implements AdapterAMap.OnAdapterInfoWindowClickListener {
    public InfoWindowClickListener(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterInfoWindowClickListener
    public void onInfoWindowClick(AdapterMarker adapterMarker) {
        Marker markerData = H5MapMarker.getMarkerData(adapterMarker);
        if (markerData == null || this.mMapContainer.getH5Page() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        AdapterLatLng position = adapterMarker.getPosition();
        if (position != null) {
            jSONObject2.put("latitude", (Object) Double.valueOf(position.getLatitude()));
            jSONObject2.put("longitude", (Object) Double.valueOf(position.getLongitude()));
        }
        jSONObject2.put("markerId", (Object) (markerData.f7175id == null ? "" : markerData.f7175id));
        jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
        jSONObject.put("data", (Object) jSONObject2);
        if (this.mMapContainer.getExtraJsCallback() != null) {
            this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "calloutTap" : "nbcomponent.map.bindcallouttap", jSONObject);
        }
    }
}
