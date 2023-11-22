package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.embedview.callback.H5JsCallbackHook;
import com.alipay.mobile.embedview.mapbiz.api.CalculateDistanceAPI;
import com.alipay.mobile.embedview.mapbiz.api.ChangeMarkersAPI;
import com.alipay.mobile.embedview.mapbiz.api.ClearRouteAPI;
import com.alipay.mobile.embedview.mapbiz.api.GestureEnableAPI;
import com.alipay.mobile.embedview.mapbiz.api.GetCenterLocationAPI;
import com.alipay.mobile.embedview.mapbiz.api.GetMapPropertiesAPI;
import com.alipay.mobile.embedview.mapbiz.api.GetRegionAPI;
import com.alipay.mobile.embedview.mapbiz.api.H5MapAPI;
import com.alipay.mobile.embedview.mapbiz.api.MoveToLocationAPI;
import com.alipay.mobile.embedview.mapbiz.api.ShowRouteAPI;
import com.alipay.mobile.embedview.mapbiz.api.ShowsCompassAPI;
import com.alipay.mobile.embedview.mapbiz.api.ShowsScaleAPI;
import com.alipay.mobile.embedview.mapbiz.api.SmoothMoveMarkerAPI;
import com.alipay.mobile.embedview.mapbiz.api.SmoothMovePolylineAPI;
import com.alipay.mobile.embedview.mapbiz.api.TiltGesturesEnabledAPI;
import com.alipay.mobile.embedview.mapbiz.api.TranslateMarkerAPI;
import com.alipay.mobile.embedview.mapbiz.api.UpdateComponentsAPI;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class MapAPIController extends H5MapController {

    /* renamed from: a */
    private final HashMap<String, H5MapAPI> f7157a;

    public MapAPIController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7157a = new HashMap<String, H5MapAPI>() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MapAPIController.1
            {
                MapAPIController.this = this;
                put("getCenterLocation", new GetCenterLocationAPI());
                put("moveToLocation", new MoveToLocationAPI());
                put("gestureEnable", new GestureEnableAPI());
                put("showsScale", new ShowsScaleAPI());
                put("showsCompass", new ShowsCompassAPI());
                put("showRoute", new ShowRouteAPI());
                put("clearRoute", new ClearRouteAPI());
                put("tiltGesturesEnabled", new TiltGesturesEnabledAPI());
                put("updateComponents", new UpdateComponentsAPI());
                put("translateMarker", new TranslateMarkerAPI());
                put("calculateDistance", new CalculateDistanceAPI());
                put("smoothMoveMarker", new SmoothMoveMarkerAPI());
                put("smoothMovePolyline", new SmoothMovePolylineAPI());
                put("getMapProperties", new GetMapPropertiesAPI());
                put("getRegion", new GetRegionAPI());
                put("changeMarkers", new ChangeMarkersAPI());
            }
        };
    }

    public void onReceivedMessage(final String str, JSONObject jSONObject, BridgeCallback bridgeCallback, Page page) {
        final long currentTimeMillis = System.currentTimeMillis();
        H5JsCallbackHook h5JsCallbackHook = new H5JsCallbackHook(page, bridgeCallback, new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MapAPIController.2
            {
                MapAPIController.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                MapAPIController.this.mMapContainer.reportController.reportJsApiTime(str, System.currentTimeMillis() - currentTimeMillis);
            }
        });
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append(" actionType = ");
            sb.append(str);
            sb.append(" data = ");
            sb.append(jSONObject == null ? "null" : jSONObject.toJSONString());
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
        try {
            this.mMapContainer.reportController.reportJsApiCall(str);
            H5MapAPI h5MapAPI = this.f7157a.get(str);
            if (h5MapAPI != null) {
                h5MapAPI.call(this.mMapContainer, jSONObject, h5JsCallbackHook);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MapAPI is not found for ");
            sb2.append(str);
            RVLogger.d(H5MapContainer.TAG, sb2.toString());
            h5JsCallbackHook.sendError(100001, "map api is not found");
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportJsApiError(str, -1, th.getMessage());
        }
    }
}
