package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.text.TextUtils;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.data.Marker;
import com.alipay.mobile.embedview.mapbiz.data.TranslateMarker;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class MarkerAnimController extends H5MapController {

    /* renamed from: a */
    private final Map<String, AdapterLatLng> f7159a;
    private final Set<String> b;

    public void playMarkerAnimation(String str, int i) {
    }

    public MarkerAnimController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7159a = new HashMap();
        this.b = new HashSet();
    }

    public AdapterMarker findScreenMarkerById(String str) {
        for (AdapterMarker adapterMarker : this.mMapContainer.getMap().getMapScreenMarkers()) {
            if (adapterMarker != null && (adapterMarker.getObject() instanceof Marker) && TextUtils.equals(((Marker) adapterMarker.getObject()).f7175id, str)) {
                return adapterMarker;
            }
        }
        return null;
    }

    public void translateMarker(TranslateMarker translateMarker, H5JsCallback h5JsCallback) {
        h5JsCallback.sendError(3, "not implemented");
    }

    public void cleanAnimCache() {
        this.f7159a.clear();
        this.b.clear();
    }

    public AdapterLatLng getPositionFromAnimCache(String str) {
        return this.f7159a.get(str);
    }
}
