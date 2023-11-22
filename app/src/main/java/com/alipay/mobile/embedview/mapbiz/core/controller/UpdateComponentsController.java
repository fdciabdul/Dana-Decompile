package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterCameraUpdateFactory;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterLatLngBounds;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.alipay.mobile.embedview.mapbiz.data.IncludePadding;
import com.alipay.mobile.embedview.mapbiz.data.MapData;
import com.alipay.mobile.embedview.mapbiz.data.MapSetting;
import com.alipay.mobile.embedview.mapbiz.data.Marker;
import com.alipay.mobile.embedview.mapbiz.data.Point;
import com.alipay.mobile.embedview.mapbiz.data.Polyline;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class UpdateComponentsController extends H5MapController {
    public UpdateComponentsController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    public void updateComponents(JSONObject jSONObject, H5JsCallback h5JsCallback) {
        AdapterTextureMapView mapView = this.mMapContainer.getMapView();
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateComponents data = ");
            sb.append(jSONObject == null ? "null" : jSONObject.toJSONString());
            sb.append(" mMapView.width=");
            sb.append(mapView.getMeasuredWidth());
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
        RVLogger.d(H5MapContainer.TAG, "updateComponents begin");
        MapData check = MapData.check((MapData) JSON.toJavaObject(jSONObject, MapData.class));
        if (check == null) {
            h5JsCallback.sendError(3, "unknown");
            return;
        }
        AdapterAMap map = mapView.getMap();
        MapData mapData = this.mMapContainer.renderController.getMapData();
        a(check.command);
        if (updateComponentsForSetting(map, check.setting) && check.setting != null && check.setting.markerCluster != null) {
            if (mapData.setting == null) {
                mapData.setting = new MapSetting();
            }
            mapData.setting.markerCluster = check.setting.markerCluster;
            this.mMapContainer.renderController.invalidateMapData();
        }
        if (check.enableSatellite != null) {
            map.setMapType(check.enableSatellite.booleanValue() ? AdapterAMap.MAP_TYPE_SATELLITE(map) : AdapterAMap.MAP_TYPE_NORMAL(map));
            mapData.enableSatellite = check.enableSatellite;
            this.mMapContainer.renderController.invalidateMapData();
        }
        if (check.limitRegion != null && check.limitRegion.size() >= 2) {
            updateComponentsForLimitRegion(map, check.limitRegion);
            mapData.limitRegion = check.limitRegion;
            this.mMapContainer.renderController.invalidateMapData();
        } else if (check.limitRegion != null) {
            map.setMapStatusLimits(null);
            mapData.limitRegion = check.limitRegion;
            this.mMapContainer.renderController.invalidateMapData();
        }
        if (a(check.markers)) {
            mapData.markers = check.markers;
            this.mMapContainer.renderController.invalidateMapData();
        }
        double d = jSONObject.containsKey("latitude") ? check.latitude : Double.NaN;
        double d2 = jSONObject.containsKey("longitude") ? check.longitude : Double.NaN;
        float f = jSONObject.containsKey(H5MapRenderOptimizer.KEY_SCALE) ? check.scale : Float.NaN;
        if (a(map, d, d2)) {
            mapData.latitude = d;
            mapData.longitude = d2;
            this.mMapContainer.renderController.invalidateCamera();
        }
        if (b(map, f)) {
            mapData.scale = f;
            this.mMapContainer.renderController.invalidateCamera();
        }
        float valueOfSkew = MapData.valueOfSkew(check.skew);
        if (a(check.includePoints, check.includePadding, check.includePointsAnimation && check.rotate == -1.0f && valueOfSkew == -1.0f && check.skewAnim == null && Double.isNaN(d) && Double.isNaN(d2) && Float.isNaN(f))) {
            mapData.includePoints = check.includePoints;
            mapData.includePadding = check.includePadding;
            this.mMapContainer.renderController.invalidateMapData();
        }
        if (a(map, check.polyline)) {
            mapData.polyline = check.polyline;
            this.mMapContainer.renderController.invalidateMapData();
        }
        if (!TextUtils.isEmpty(check.customMapStyle)) {
            this.mMapContainer.mapStyleController.setCustomMapStyle(map, check.customMapStyle);
            mapData.customMapStyle = check.customMapStyle;
            if (mapData.setting != null && mapData.setting.customMapStyleSrc != null && (check.setting == null || check.setting.customMapStyleSrc == null)) {
                mapData.setting.customMapStyleSrc = null;
            }
            this.mMapContainer.renderController.invalidateMapData();
        }
        if (check.setting != null && check.setting.customMapStyleSrc != null) {
            this.mMapContainer.mapStyleController.setCustomMapStyleSource(check.setting.customMapStyleSrc);
            if (mapData.setting == null) {
                mapData.setting = new MapSetting();
            }
            mapData.setting.customMapStyleSrc = check.setting.customMapStyleSrc;
            this.mMapContainer.renderController.invalidateMapData();
            if (check.setting.customTextureSrc != null) {
                this.mMapContainer.mapStyleController.setCustomTextureSource(check.setting.customTextureSrc);
                mapData.setting.customTextureSrc = check.setting.customTextureSrc;
                this.mMapContainer.renderController.invalidateMapData();
            }
        }
        if (a(map, check.rotate)) {
            mapData.rotate = check.rotate;
            this.mMapContainer.renderController.invalidateCamera();
        }
        if (this.mMapContainer.skewController.updateComponentsForSkew(valueOfSkew)) {
            mapData.skew = check.skew;
            this.mMapContainer.renderController.invalidateCamera();
        }
        if (check.skewAnim != null && this.mMapContainer.skewController.updateComponentsForSkewAnim(check.skewAnim)) {
            mapData.skew = check.skewAnim.skew;
            this.mMapContainer.renderController.invalidateCamera();
        }
        if (check.panels != null) {
            this.mMapContainer.panelController.setPanels(check.panels);
            mapData.panels = check.panels;
            this.mMapContainer.renderController.invalidateMapData();
        }
        h5JsCallback.sendSuccess();
        this.mMapContainer.renderController.checkMapDataChanged();
    }

    public boolean updateComponentsForLimitRegion(AdapterAMap adapterAMap, List<Point> list) {
        if (adapterAMap == null) {
            return false;
        }
        try {
            if (adapterAMap.is2dMapSdk()) {
                return false;
            }
            if (!this.mMapContainer.configController.isDoRenderLimitRegion()) {
                RVLogger.d(H5MapContainer.TAG, "limit-region is not allow to render by config service");
                return false;
            }
            AdapterLatLngBounds adapterLatLngBounds = new AdapterLatLngBounds(adapterAMap);
            Iterator<Point> it = list.iterator();
            while (it.hasNext()) {
                adapterLatLngBounds.include(it.next().getLatLng(adapterAMap));
            }
            adapterAMap.setMapStatusLimits(adapterLatLngBounds.build());
            return true;
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("UpdateComponentsController#updateComponentsForLimitRegion", th.getMessage());
            return false;
        }
    }

    private boolean a(AdapterAMap adapterAMap, float f) {
        if (f < 0.0f || adapterAMap == null) {
            return false;
        }
        try {
            if (adapterAMap.is2dMapSdk()) {
                return false;
            }
            adapterAMap.moveCamera(AdapterCameraUpdateFactory.changeBearing(adapterAMap, f));
            return true;
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("UpdateComponentsController#updateComponentsForRotate", th.getMessage());
            return false;
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("markerAnim");
            if (jSONArray == null || jSONArray.isEmpty()) {
                return;
            }
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.containsKey("type")) {
                    this.mMapContainer.markerAnimController.playMarkerAnimation(jSONObject2.getString("markerId"), H5MapUtils.getIntValue(jSONObject2, "type"));
                }
            }
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("UpdateComponentsController#updateComponentsForCommand", th.getMessage());
        }
    }

    private boolean a(AdapterAMap adapterAMap, List<Polyline> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        try {
            this.mMapContainer.polylineController.setPolyline(adapterAMap, list);
            return true;
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("UpdateComponentsController#updateComponentsForPolyline", th.getMessage());
            return true;
        }
    }

    private boolean a(List<Point> list, IncludePadding includePadding, boolean z) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        try {
            this.mMapContainer.includePointsController.setIncludePoints(list, includePadding, z);
            return true;
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("UpdateComponentsController#updateComponentsForIncludePointsAndPadding", th.getMessage());
            return true;
        }
    }

    private boolean b(AdapterAMap adapterAMap, float f) {
        if (Float.isNaN(f)) {
            return false;
        }
        try {
            if (this.mMapContainer.renderController.checkScale(f)) {
                StringBuilder sb = new StringBuilder();
                sb.append("scale error: ");
                sb.append(f);
                RVLogger.e(H5MapContainer.TAG, sb.toString());
            }
            adapterAMap.moveCamera(AdapterCameraUpdateFactory.zoomTo(adapterAMap, f));
            return true;
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("UpdateComponentsController#updateComponentsForScale", th.getMessage());
            return true;
        }
    }

    private boolean a(AdapterAMap adapterAMap, double d, double d2) {
        if (Double.isNaN(d) || Double.isNaN(d2)) {
            return false;
        }
        try {
            if (this.mMapContainer.renderController.checkLatLon(d, d2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("lat or lon is error: [");
                sb.append(d);
                sb.append(",");
                sb.append(d2);
                sb.append("]");
                RVLogger.e(H5MapContainer.TAG, sb.toString());
            }
            adapterAMap.moveCamera(AdapterCameraUpdateFactory.changeLatLng(new AdapterLatLng(adapterAMap, d, d2)));
            return true;
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("UpdateComponentsController#updateComponentsForPos", th.getMessage());
            return true;
        }
    }

    public boolean updateComponentsForSetting(AdapterAMap adapterAMap, MapSetting mapSetting) {
        if (mapSetting == null) {
            return false;
        }
        this.mMapContainer.mapSettingController.compareAndSet(mapSetting);
        if (mapSetting.markerCluster == null || adapterAMap == null) {
            return true;
        }
        this.mMapContainer.markerController.onCameraChanged(adapterAMap.getCameraPosition(), false);
        return true;
    }

    private boolean a(List<Marker> list) {
        RVLogger.d(H5MapContainer.TAG, "updateComponentsForMarkers begin");
        this.mMapContainer.markerAnimController.cleanAnimCache();
        if (list == null || list.isEmpty()) {
            return false;
        }
        try {
            this.mMapContainer.markerController.updateComponentsForMarkers(this.mMapContainer.markerController.checkMarkers(list, false));
            return true;
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("UpdateComponentsController#updateComponentsForMarkers", th.getMessage());
            return true;
        }
    }
}
