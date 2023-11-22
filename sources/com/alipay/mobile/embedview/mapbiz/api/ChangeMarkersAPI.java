package com.alipay.mobile.embedview.mapbiz.api;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.data.ChangeMarkers;
import com.alipay.mobile.embedview.mapbiz.data.MapData;
import com.alipay.mobile.embedview.mapbiz.data.Marker;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class ChangeMarkersAPI extends H5MapAPI {
    @Override // com.alipay.mobile.embedview.mapbiz.api.H5MapAPI
    public void call(H5MapContainer h5MapContainer, JSONObject jSONObject, H5JsCallback h5JsCallback) {
        try {
            ChangeMarkers changeMarkers = (ChangeMarkers) JSON.toJavaObject(jSONObject, ChangeMarkers.class);
            a(h5MapContainer, h5MapContainer.getMap(), changeMarkers.add, changeMarkers.remove, changeMarkers.update);
            h5JsCallback.sendSuccess();
        } catch (Throwable th) {
            h5JsCallback.sendError(3, "unknown");
            RVLogger.e(H5MapContainer.TAG, th);
            h5MapContainer.reportController.reportJsApiError("changeMarkers", -1, th.getMessage());
        }
    }

    private void a(H5MapContainer h5MapContainer, AdapterAMap adapterAMap, List<Marker> list, List<Marker> list2, List<Marker> list3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        MapData mapData = h5MapContainer.renderController.getMapData();
        ArrayList arrayList4 = mapData.markers != null ? new ArrayList(mapData.markers) : new ArrayList();
        Map<String, Integer> buildIdMap = Marker.buildIdMap(arrayList4);
        if (list3 != null && !list3.isEmpty()) {
            for (Marker marker : list3) {
                if (marker != null && !TextUtils.isEmpty(marker.f7175id) && buildIdMap.containsKey(marker.f7175id)) {
                    arrayList3.add(marker);
                    h5MapContainer.markerController.updateMarker(marker);
                    arrayList4.set(buildIdMap.get(marker.f7175id).intValue(), marker);
                }
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            for (Marker marker2 : list2) {
                if (marker2 != null && !TextUtils.isEmpty(marker2.f7175id) && buildIdMap.containsKey(marker2.f7175id)) {
                    arrayList2.add(marker2);
                    h5MapContainer.markerController.removeMarker(marker2);
                }
            }
        }
        if (arrayList2.size() != 0) {
            arrayList4.removeAll(arrayList2);
        }
        if (list != null && !list.isEmpty()) {
            for (Marker marker3 : h5MapContainer.markerController.checkMarkers(list, false)) {
                if (marker3 != null && !TextUtils.isEmpty(marker3.f7175id) && !buildIdMap.containsKey(marker3.f7175id)) {
                    arrayList.add(marker3);
                }
            }
        }
        if (arrayList.size() != 0) {
            h5MapContainer.markerController.setMarkers(adapterAMap, arrayList);
            arrayList4.addAll(arrayList);
        }
        if (arrayList3.size() == 0 && arrayList.size() == 0 && arrayList2.size() == 0) {
            return;
        }
        mapData.markers = arrayList4;
        h5MapContainer.renderController.invalidateMapData();
        h5MapContainer.renderController.checkMapDataChanged();
        StringBuilder sb = new StringBuilder();
        sb.append("ChangeMarkersAPI add: ");
        sb.append(arrayList.size());
        sb.append(" remove: ");
        sb.append(arrayList2.size());
        sb.append(" update: ");
        sb.append(arrayList3.size());
        RVLogger.d(H5MapContainer.TAG, sb.toString());
        if (arrayList.size() == 0 && arrayList2.size() == 0) {
            return;
        }
        h5MapContainer.markerController.onMarkersChanged();
        h5MapContainer.markerController.onCameraChanged(adapterAMap.getCameraPosition(), false);
    }
}
