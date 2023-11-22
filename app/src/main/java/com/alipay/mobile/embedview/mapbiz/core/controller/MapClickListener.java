package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public class MapClickListener extends H5MapController implements AdapterAMap.OnAdapterMapClickListener {
    public MapClickListener(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMapClickListener
    public void onMapClick(AdapterLatLng adapterLatLng) {
        if (this.mMapContainer.getH5Page() == null) {
            return;
        }
        RVLogger.d(H5MapContainer.TAG, "onTapClick");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (adapterLatLng != null) {
            jSONObject2.put("latitude", (Object) Double.valueOf(adapterLatLng.getLatitude()));
            jSONObject2.put("longitude", (Object) Double.valueOf(adapterLatLng.getLongitude()));
        }
        jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
        jSONObject.put("data", (Object) jSONObject2);
        if (this.mMapContainer.getExtraJsCallback() != null) {
            this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "tap" : "nbcomponent.map.bindtap", jSONObject);
        }
        this.mMapContainer.markerController.hideAllInfoWindow();
    }
}
