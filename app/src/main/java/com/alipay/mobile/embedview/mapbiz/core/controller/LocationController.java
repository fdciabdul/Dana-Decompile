package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.location.Location;
import android.os.Looper;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterLocationSource;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.embedview.mapbiz.core.controller.LocationUtils;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.remoteconfig.RemoteConfigComponent;

/* loaded from: classes6.dex */
public class LocationController extends H5MapController implements AdapterAMap.OnMyLocationButtonClickListener, AdapterLocationSource {

    /* renamed from: a */
    private Location f7154a;
    private boolean b;
    private LocationHelper c;
    private long d;
    private FusedLocationProviderClient e;
    private LocationCallback f;

    public LocationController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    @Override // com.alipay.mobile.apmap.AdapterLocationSource
    public void activate(final AdapterLocationSource.OnAdapterLocationChangedListener onAdapterLocationChangedListener) {
        RVLogger.d("LocationController", RemoteConfigComponent.ACTIVATE_FILE_NAME);
        if (this.e == null) {
            this.e = LocationServices.getFusedLocationProviderClient(this.mMapContainer.getContext());
            this.f = new LocationCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LocationController.1
                {
                    LocationController.this = this;
                }

                @Override // com.google.android.gms.location.LocationCallback
                public void onLocationResult(LocationResult locationResult) {
                    super.onLocationResult(locationResult);
                    if (locationResult != null && locationResult.getLastLocation() != null) {
                        LocationController.this.f7154a = locationResult.getLastLocation();
                        onAdapterLocationChangedListener.onLocationChanged(LocationController.this.f7154a);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("location success[");
                    sb.append(locationResult.getLastLocation().getLatitude());
                    sb.append(",");
                    sb.append(locationResult.getLastLocation().getLongitude());
                    sb.append("]");
                    RVLogger.d("LocationController", sb.toString());
                }
            };
            a();
        }
    }

    private void a() {
        LocationRequest create = LocationRequest.create();
        create.setInterval(10000L);
        create.setFastestInterval(RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
        create.setPriority(102);
        this.e.requestLocationUpdates(create, this.f, Looper.getMainLooper());
    }

    private void b() {
        this.e.removeLocationUpdates(this.f);
    }

    @Override // com.alipay.mobile.apmap.AdapterLocationSource
    public void deactivate() {
        RVLogger.d("LocationController", "deactivate");
        this.f = null;
        this.e = null;
        this.f7154a = null;
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnMyLocationButtonClickListener
    public void onMyLocationButtonClick() {
        RVLogger.d("LocationController", "onMyLocationButtonClick...");
        LocationUtils.checkPermission(this.mMapContainer, new LocationUtils.OnPermissionRequestCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LocationController.2
            {
                LocationController.this = this;
            }

            @Override // com.alipay.mobile.embedview.mapbiz.core.controller.LocationUtils.OnPermissionRequestCallback
            public void onPermissionGranted() {
                LocationController.this.c();
            }
        });
    }

    public void c() {
        RVLogger.d("LocationController", "moveToLocation");
        AdapterTextureMapView mapView = this.mMapContainer.getMapView();
        if (!this.b || mapView == null || mapView.getMap() == null) {
            return;
        }
        if (this.f7154a == null) {
            final AdapterAMap map = mapView.getMap();
            LocationServices.getFusedLocationProviderClient(this.mMapContainer.getContext()).getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LocationController.3
                {
                    LocationController.this = this;
                }

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(Location location) {
                    if (location == null) {
                        return;
                    }
                    if (LocationController.this.c == null) {
                        LocationController.this.c = new LocationHelper();
                    }
                    LocationController.this.c.moveToLocation(LocationController.this.mMapContainer.getContext(), map, location);
                }
            });
            return;
        }
        if (this.c == null) {
            this.c = new LocationHelper();
        }
        this.c.moveToLocation(this.mMapContainer.getContext(), mapView.getMap(), this.f7154a);
    }

    public void clear() {
        this.c = null;
    }

    private void d() {
        RVLogger.d("LocationController", "openLocation");
        AdapterAMap map = this.mMapContainer.getMap();
        if (map == null) {
            return;
        }
        this.d = System.currentTimeMillis();
        RVLogger.d(H5MapContainer.TAG, "openLocation");
        map.setLocationSource(this);
        map.setMyLocationEnabled(true);
        map.setMyLocationType(AdapterAMap.getLocationTypeLocate(map));
        activate(null);
        map.setOnMyLocationButtonClickListener(this);
    }

    public void onWebViewResume() {
        if (!this.b || this.e == null) {
            return;
        }
        RVLogger.d(H5MapContainer.TAG, "onWebViewResume startLocation");
        a();
    }

    public void onWebViewPause() {
        if (this.e != null) {
            RVLogger.d(H5MapContainer.TAG, "onWebViewPause stopLocation");
            b();
        }
    }

    public void setShowLocation(boolean z) {
        this.b = z;
        this.mMapContainer.getMap();
    }

    public boolean isShowLocation() {
        return this.b;
    }

    public void onRender() {
        if (this.b) {
            if (this.e == null || this.f7154a == null) {
                d();
                return;
            } else {
                c();
                return;
            }
        }
        RVLogger.d(H5MapContainer.TAG, "closeLocation");
        deactivate();
    }
}
