package com.alipay.mobile.embedview.mapbiz.api;

import android.location.Location;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.core.controller.LocationHelper;
import com.alipay.mobile.embedview.mapbiz.core.controller.LocationUtils;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

/* loaded from: classes6.dex */
public class MoveToLocationAPI extends H5MapAPI {

    /* renamed from: a  reason: collision with root package name */
    private LocationHelper f7136a;

    @Override // com.alipay.mobile.embedview.mapbiz.api.H5MapAPI
    public void call(final H5MapContainer h5MapContainer, JSONObject jSONObject, H5JsCallback h5JsCallback) {
        LocationUtils.checkPermission(h5MapContainer, new LocationUtils.OnPermissionRequestCallback() { // from class: com.alipay.mobile.embedview.mapbiz.api.MoveToLocationAPI.1
            @Override // com.alipay.mobile.embedview.mapbiz.core.controller.LocationUtils.OnPermissionRequestCallback
            public void onPermissionGranted() {
                MoveToLocationAPI.this.a(h5MapContainer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final H5MapContainer h5MapContainer) {
        if (h5MapContainer == null || h5MapContainer.getContext() == null || h5MapContainer.getMap() == null) {
            return;
        }
        final AdapterAMap map = h5MapContainer.getMap();
        LocationServices.getFusedLocationProviderClient(h5MapContainer.getContext()).getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() { // from class: com.alipay.mobile.embedview.mapbiz.api.MoveToLocationAPI.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Location location) {
                if (location == null) {
                    return;
                }
                if (MoveToLocationAPI.this.f7136a == null) {
                    MoveToLocationAPI.this.f7136a = new LocationHelper();
                }
                MoveToLocationAPI.this.f7136a.moveToLocation(h5MapContainer.getContext(), map, location);
            }
        });
    }
}
