package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.embedview.mapbiz.core.H5MapMarker;
import com.alipay.mobile.embedview.mapbiz.data.Marker;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.util.Set;

/* loaded from: classes6.dex */
public class MarkerClickListener extends H5MapController implements AdapterAMap.OnAdapterMarkerClickListener {
    public MarkerClickListener(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMarkerClickListener
    public boolean onMarkerClick(AdapterMarker adapterMarker) {
        Set<H5MapMarker> clusterChildren;
        Marker markerData = H5MapMarker.getMarkerData(adapterMarker);
        if (markerData == null) {
            if (!TextUtils.isEmpty(adapterMarker.getTitle()) || !TextUtils.isEmpty(adapterMarker.getSnippet())) {
                adapterMarker.showInfoWindow();
            }
            return true;
        } else if (this.mMapContainer.getH5Page() == null) {
            return true;
        } else {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("onMarkerClick ");
                sb.append(JSON.toJSONString(markerData));
                sb.append(" title = ");
                sb.append(adapterMarker.getTitle());
                sb.append(" snip = ");
                sb.append(adapterMarker.getSnippet());
                RVLogger.d(H5MapContainer.TAG, sb.toString());
            } catch (Exception e) {
                RVLogger.e(H5MapContainer.TAG, e);
                this.mMapContainer.reportController.reportException("MarkerClickListener#onMarkerClick", e.getMessage());
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            AdapterLatLng position = adapterMarker.getPosition();
            if (position != null) {
                jSONObject2.put("latitude", (Object) Double.valueOf(position.getLatitude()));
                jSONObject2.put("longitude", (Object) Double.valueOf(position.getLongitude()));
            }
            jSONObject2.put("markerId", (Object) (markerData.f7175id == null ? "" : markerData.f7175id));
            jSONObject2.put("hasChildren", (Object) Boolean.FALSE);
            H5MapMarker findH5MapMarkerById = this.mMapContainer.markerController.findH5MapMarkerById(markerData.f7175id);
            if (findH5MapMarkerById != null && (clusterChildren = findH5MapMarkerById.getClusterChildren()) != null && clusterChildren.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("hasChildren", (Object) Boolean.TRUE);
                jSONObject2.put("children", (Object) jSONArray);
                for (H5MapMarker h5MapMarker : clusterChildren) {
                    if (h5MapMarker.marker != null && !TextUtils.isEmpty(h5MapMarker.marker.f7175id)) {
                        jSONArray.add(h5MapMarker.marker.f7175id);
                    }
                }
            }
            jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
            jSONObject.put("data", (Object) jSONObject2);
            if (this.mMapContainer.getExtraJsCallback() != null) {
                this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "markerTap" : "nbcomponent.map.bindmarkertap", jSONObject);
            }
            if (markerData.label == null && (markerData.title != null || (markerData.callout != null && markerData.callout.content != null))) {
                adapterMarker.showInfoWindow();
            }
            if (markerData.customCallout != null && markerData.customCallout.canShowOnTap && markerData.customCallout.hasDescription()) {
                adapterMarker.showInfoWindow();
            }
            return true;
        }
    }
}
