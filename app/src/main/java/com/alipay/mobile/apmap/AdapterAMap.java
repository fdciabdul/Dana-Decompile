package com.alipay.mobile.apmap;

import android.graphics.Bitmap;
import android.location.Location;
import android.view.View;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.AdapterLocationSource;
import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.apmap.model.AdapterCircle;
import com.alipay.mobile.apmap.model.AdapterCircleOptions;
import com.alipay.mobile.apmap.model.AdapterGroundOverlay;
import com.alipay.mobile.apmap.model.AdapterGroundOverlayOptions;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterLatLngBounds;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.apmap.model.AdapterMarkerOptions;
import com.alipay.mobile.apmap.model.AdapterMyLocationStyle;
import com.alipay.mobile.apmap.model.AdapterPolygon;
import com.alipay.mobile.apmap.model.AdapterPolygonOptions;
import com.alipay.mobile.apmap.model.AdapterPolyline;
import com.alipay.mobile.apmap.model.AdapterPolylineOptions;
import com.alipay.mobile.apmap.model.AdapterRouteOverlay;
import com.alipay.mobile.apmap.model.AdapterTileOverlay;
import com.alipay.mobile.apmap.model.AdapterTileOverlayOptions;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class AdapterAMap implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private GoogleMap f7092a;
    private boolean b;
    private CameraPosition c;

    /* loaded from: classes6.dex */
    public interface AdapterCancelableCallback {
        void onCancel();

        void onFinish();
    }

    /* loaded from: classes6.dex */
    public interface AdapterInfoWindowAdapter {
        View getInfoContents(AdapterMarker adapterMarker);

        View getInfoWindow(AdapterMarker adapterMarker);
    }

    /* loaded from: classes6.dex */
    public interface OnAdapterCameraChangeListener {
        void onCameraChange(AdapterCameraPosition adapterCameraPosition);

        void onCameraChangeFinish(AdapterCameraPosition adapterCameraPosition);
    }

    /* loaded from: classes6.dex */
    public interface OnAdapterInfoWindowClickListener {
        void onInfoWindowClick(AdapterMarker adapterMarker);
    }

    /* loaded from: classes6.dex */
    public interface OnAdapterMapClickListener {
        void onMapClick(AdapterLatLng adapterLatLng);
    }

    /* loaded from: classes6.dex */
    public interface OnAdapterMapLoadedListener {
        void onMapLoaded();
    }

    /* loaded from: classes6.dex */
    public interface OnAdapterMapScreenShotListener {
        void onMapScreenShot(Bitmap bitmap);
    }

    /* loaded from: classes6.dex */
    public interface OnAdapterMarkerClickListener {
        boolean onMarkerClick(AdapterMarker adapterMarker);
    }

    /* loaded from: classes6.dex */
    public interface OnAdapterMarkerDragListener {
        void onMarkerDrag(AdapterMarker adapterMarker);

        void onMarkerDragEnd(AdapterMarker adapterMarker);

        void onMarkerDragStart(AdapterMarker adapterMarker);
    }

    /* loaded from: classes6.dex */
    public interface OnMyLocationButtonClickListener {
        void onMyLocationButtonClick();
    }

    /* loaded from: classes6.dex */
    public interface OnRouteSearchListener {
        void onWalkRouteSearched(int i, AdapterRouteOverlay adapterRouteOverlay, int i2, float f, int i3);
    }

    public static int MAP_TYPE_NORMAL(DynamicSDKContext dynamicSDKContext) {
        return 1;
    }

    public static int MAP_TYPE_SATELLITE(DynamicSDKContext dynamicSDKContext) {
        return 1;
    }

    public int getMapType() {
        return 1;
    }

    public void setMapType(int i) {
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public AdapterAMap(GoogleMap googleMap) {
        this.f7092a = googleMap;
    }

    public void setTrafficEnabled(boolean z) {
        GoogleMap googleMap;
        StringBuilder sb = new StringBuilder();
        sb.append("setTrafficEnabled var1 = ");
        sb.append(z);
        RVLogger.d("AdapterAMap", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
            return;
        }
        googleMap.setTrafficEnabled(z);
    }

    public void showMapText(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("showMapText enable = ");
        sb.append(z);
        RVLogger.d("AdapterAMap", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterAMap", "showMapText google map sdk not support");
        }
    }

    public final AdapterProjection getProjection() {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "getProjection");
        if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
            return null;
        }
        return new AdapterProjection(googleMap.getProjection());
    }

    public static int getLocationTypeLocate(DynamicSDKContext dynamicSDKContext) {
        if (dynamicSDKContext == null) {
            return 1;
        }
        RVLogger.d("AdapterAMap", "getLocationTypeLocate");
        AdapterUtil.isGoogleMapSdk();
        return 1;
    }

    public void setLocationSource(final AdapterLocationSource adapterLocationSource) {
        RVLogger.d("AdapterAMap", "setLocationSource");
        if (adapterLocationSource == null) {
            RVLogger.d("AdapterAMap", "setLocationSource locationSource == null");
            return;
        }
        try {
            if (AdapterUtil.isGoogleMapSdk()) {
                GoogleMap googleMap = this.f7092a;
                if (googleMap == null) {
                    RVLogger.d("AdapterAMap", "setLocationSource mGoogleMap == null");
                } else {
                    googleMap.setLocationSource(new LocationSource() { // from class: com.alipay.mobile.apmap.AdapterAMap.1
                        @Override // com.google.android.gms.maps.LocationSource
                        public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
                            AdapterAMap.this.a(onLocationChangedListener, adapterLocationSource);
                        }

                        @Override // com.google.android.gms.maps.LocationSource
                        public void deactivate() {
                            AdapterLocationSource adapterLocationSource2 = adapterLocationSource;
                            if (adapterLocationSource2 == null) {
                                return;
                            }
                            adapterLocationSource2.deactivate();
                        }
                    });
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("setLocationSource,th=");
            sb.append(th);
            RVLogger.e("AdapterAMap", sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final LocationSource.OnLocationChangedListener onLocationChangedListener, AdapterLocationSource adapterLocationSource) {
        if (adapterLocationSource == null) {
            return;
        }
        if (onLocationChangedListener == null) {
            adapterLocationSource.activate(null);
        } else {
            adapterLocationSource.activate(new AdapterLocationSource.OnAdapterLocationChangedListener() { // from class: com.alipay.mobile.apmap.AdapterAMap.2
                @Override // com.alipay.mobile.apmap.AdapterLocationSource.OnAdapterLocationChangedListener
                public void onLocationChanged(Location location) {
                    LocationSource.OnLocationChangedListener onLocationChangedListener2 = onLocationChangedListener;
                    if (onLocationChangedListener2 != null) {
                        onLocationChangedListener2.onLocationChanged(location);
                    }
                }
            });
        }
    }

    public void setMyLocationEnabled(boolean z) {
        GoogleMap googleMap;
        StringBuilder sb = new StringBuilder();
        sb.append("setMyLocationEnabled var1 == ");
        sb.append(z);
        RVLogger.d("AdapterAMap", sb.toString());
        try {
            if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
                return;
            }
            googleMap.setMyLocationEnabled(z);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setMyLocationEnabled,th=");
            sb2.append(th);
            RVLogger.e("AdapterAMap", sb2.toString());
        }
    }

    public void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        RVLogger.d("AdapterAMap", "setOnMyLocationButtonClickListener");
        if (onMyLocationButtonClickListener == null) {
            RVLogger.d("AdapterAMap", "setOnMyLocationButtonClickListener listener == null");
            return;
        }
        try {
            if (AdapterUtil.isGoogleMapSdk()) {
                GoogleMap googleMap = this.f7092a;
                if (googleMap == null) {
                    RVLogger.d("AdapterAMap", "setOnMyLocationButtonClickListener mGoogleMap == null");
                } else {
                    googleMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() { // from class: com.alipay.mobile.apmap.AdapterAMap.3
                        @Override // com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener
                        public boolean onMyLocationButtonClick() {
                            OnMyLocationButtonClickListener onMyLocationButtonClickListener2 = onMyLocationButtonClickListener;
                            if (onMyLocationButtonClickListener2 != null) {
                                onMyLocationButtonClickListener2.onMyLocationButtonClick();
                                return false;
                            }
                            return false;
                        }
                    });
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("setOnMyLocationButtonClickListener,th=");
            sb.append(th);
            RVLogger.e("AdapterAMap", sb.toString());
        }
    }

    public AdapterUiSettings getUiSettings() {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "getUiSettings");
        try {
            if (AdapterUtil.isGoogleMapSdk() && (googleMap = this.f7092a) != null && googleMap.getUiSettings() != null) {
                return new AdapterUiSettings(this.f7092a.getUiSettings());
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getUiSettings, th=");
            sb.append(th);
            RVLogger.e("AdapterAMap", sb.toString());
        }
        return null;
    }

    public void setMyLocationStyle(AdapterMyLocationStyle adapterMyLocationStyle) {
        RVLogger.d("AdapterAMap", "setMyLocationStyle");
        if (adapterMyLocationStyle == null) {
            RVLogger.d("AdapterAMap", "setMyLocationStyle style = null");
        } else if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterAMap", "setMyLocationStyle google map sdk not support");
        }
    }

    public void moveCamera(AdapterCameraUpdate adapterCameraUpdate) {
        GoogleMap googleMap;
        if (adapterCameraUpdate == null) {
            RVLogger.d("AdapterAMap", "moveCamera update == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.moveCamera(adapterCameraUpdate.getGoogleMapCameraUpdate());
        }
    }

    public void animateCamera(AdapterCameraUpdate adapterCameraUpdate) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "animateCamera");
        if (adapterCameraUpdate == null) {
            RVLogger.d("AdapterAMap", "moveCamera cameraUpdate == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.animateCamera(adapterCameraUpdate.getGoogleMapCameraUpdate());
        }
    }

    public AdapterPolygon addPolygon(AdapterPolygonOptions adapterPolygonOptions) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "addPolygon");
        if (adapterPolygonOptions == null) {
            RVLogger.d("AdapterAMap", "addPolygon options == null");
            return null;
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
            return null;
        } else {
            return new AdapterPolygon(googleMap.addPolygon(adapterPolygonOptions.getGoogleMapPolygonOptions()));
        }
    }

    public AdapterPolyline addPolyline(AdapterPolylineOptions adapterPolylineOptions) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "addPolyline");
        if (adapterPolylineOptions == null) {
            RVLogger.d("AdapterAMap", "addPolyline polylineOptions == null");
            return null;
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
            return null;
        } else {
            return new AdapterPolyline(googleMap.addPolyline(adapterPolylineOptions.getGoogleMapPolylineOptions()));
        }
    }

    public void setOnMapLoadedListener(final OnAdapterMapLoadedListener onAdapterMapLoadedListener) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "setOnMapLoadedListener");
        if (onAdapterMapLoadedListener == null) {
            RVLogger.d("AdapterAMap", "setOnMapLoadedListener listener == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() { // from class: com.alipay.mobile.apmap.AdapterAMap.4
                @Override // com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback
                public void onMapLoaded() {
                    OnAdapterMapLoadedListener onAdapterMapLoadedListener2 = onAdapterMapLoadedListener;
                    if (onAdapterMapLoadedListener2 != null) {
                        onAdapterMapLoadedListener2.onMapLoaded();
                    }
                }
            });
        }
    }

    public final AdapterMarker addMarker(AdapterMarkerOptions adapterMarkerOptions) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "addMarker");
        if (adapterMarkerOptions == null) {
            RVLogger.d("AdapterAMap", "addMarker options == null");
            return null;
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
            return null;
        } else {
            return new AdapterMarker(googleMap.addMarker(adapterMarkerOptions.getGoogleMapMarkerOptions()));
        }
    }

    public final AdapterGroundOverlay addGroundOverlay(AdapterGroundOverlayOptions adapterGroundOverlayOptions) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "addGroundOverlay");
        if (adapterGroundOverlayOptions == null) {
            RVLogger.d("AdapterAMap", "addGroundOverlay options == null");
            return null;
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
            return null;
        } else {
            return new AdapterGroundOverlay(googleMap.addGroundOverlay(adapterGroundOverlayOptions.getGoogleMapGroundOverlayOptions()));
        }
    }

    public final AdapterTileOverlay addTileOverlay(AdapterTileOverlayOptions adapterTileOverlayOptions) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "addTileOverlay");
        if (adapterTileOverlayOptions == null) {
            RVLogger.d("AdapterAMap", "addTileOverlay options == null");
            return null;
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
            return null;
        } else {
            return new AdapterTileOverlay(googleMap.addTileOverlay(adapterTileOverlayOptions.getGoogleMapTileOverlayOptions()));
        }
    }

    public final AdapterCameraPosition getCameraPosition() {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "getCameraPosition");
        if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null || googleMap.getCameraPosition() == null) {
            return null;
        }
        return new AdapterCameraPosition(this.f7092a.getCameraPosition());
    }

    public void setMyLocationType(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("setMyLocationType type = ");
        sb.append(i);
        RVLogger.d("AdapterAMap", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterAMap", "setMyLocationType google map sdk not support");
        }
    }

    public AdapterCircle addCircle(AdapterCircleOptions adapterCircleOptions) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "addCircle");
        if (adapterCircleOptions == null) {
            RVLogger.d("AdapterAMap", "addCircle circleOptions == null");
            return null;
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
            return null;
        } else {
            return new AdapterCircle(googleMap.addCircle(adapterCircleOptions.getGoogleMapCircleOptions()));
        }
    }

    public List<AdapterMarker> getMapScreenMarkers() {
        RVLogger.d("AdapterAMap", "getMapScreenMarkers");
        ArrayList arrayList = new ArrayList();
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterAMap", "getMapScreenMarkers google map sdk not support");
        }
        return arrayList;
    }

    public void clear() {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "clear");
        if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
            return;
        }
        googleMap.clear();
    }

    public void getMapScreenShot(final OnAdapterMapScreenShotListener onAdapterMapScreenShotListener) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "getMapScreenShot");
        if (onAdapterMapScreenShotListener == null) {
            RVLogger.d("AdapterAMap", "getMapScreenShot listener == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.snapshot(new GoogleMap.SnapshotReadyCallback() { // from class: com.alipay.mobile.apmap.AdapterAMap.5
                @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
                public void onSnapshotReady(Bitmap bitmap) {
                    OnAdapterMapScreenShotListener onAdapterMapScreenShotListener2 = onAdapterMapScreenShotListener;
                    if (onAdapterMapScreenShotListener2 != null) {
                        onAdapterMapScreenShotListener2.onMapScreenShot(bitmap);
                    }
                }
            });
        }
    }

    public void setOnCameraChangeListener(final OnAdapterCameraChangeListener onAdapterCameraChangeListener) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "setOnCameraChangeListener");
        if (onAdapterCameraChangeListener == null) {
            RVLogger.d("AdapterAMap", "setOnCameraChangeListener listener == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() { // from class: com.alipay.mobile.apmap.AdapterAMap.6
                @Override // com.google.android.gms.maps.GoogleMap.OnCameraChangeListener
                public void onCameraChange(CameraPosition cameraPosition) {
                    OnAdapterCameraChangeListener onAdapterCameraChangeListener2 = onAdapterCameraChangeListener;
                    if (onAdapterCameraChangeListener2 == null) {
                        return;
                    }
                    if (cameraPosition != null) {
                        AdapterAMap.this.c = cameraPosition;
                        onAdapterCameraChangeListener.onCameraChange(new AdapterCameraPosition(cameraPosition));
                        return;
                    }
                    onAdapterCameraChangeListener2.onCameraChange(null);
                }
            });
            this.f7092a.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() { // from class: com.alipay.mobile.apmap.AdapterAMap.7
                @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
                public void onCameraMoveStarted(int i) {
                    AdapterAMap.this.c = null;
                }
            });
            this.f7092a.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() { // from class: com.alipay.mobile.apmap.AdapterAMap.8
                @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
                public void onCameraIdle() {
                    if (onAdapterCameraChangeListener == null) {
                        return;
                    }
                    if (AdapterAMap.this.c == null) {
                        onAdapterCameraChangeListener.onCameraChangeFinish(null);
                    } else {
                        onAdapterCameraChangeListener.onCameraChangeFinish(new AdapterCameraPosition(AdapterAMap.this.c));
                    }
                }
            });
        }
    }

    public void setOnMarkerClickListener(final OnAdapterMarkerClickListener onAdapterMarkerClickListener) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "setOnMarkerClickListener");
        if (onAdapterMarkerClickListener == null) {
            RVLogger.d("AdapterAMap", "setOnMarkerClickListener listener == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: com.alipay.mobile.apmap.AdapterAMap.9
                @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
                public boolean onMarkerClick(Marker marker) {
                    OnAdapterMarkerClickListener onAdapterMarkerClickListener2 = onAdapterMarkerClickListener;
                    if (onAdapterMarkerClickListener2 == null) {
                        return false;
                    }
                    if (marker == null) {
                        return onAdapterMarkerClickListener2.onMarkerClick(null);
                    }
                    return onAdapterMarkerClickListener2.onMarkerClick(new AdapterMarker(marker));
                }
            });
        }
    }

    public void setInfoWindowAdapter(final AdapterInfoWindowAdapter adapterInfoWindowAdapter) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "setInfoWindowAdapter");
        if (adapterInfoWindowAdapter == null) {
            RVLogger.d("AdapterAMap", "setInfoWindowAdapter infoWindowAdapter == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() { // from class: com.alipay.mobile.apmap.AdapterAMap.10
                @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                public View getInfoWindow(Marker marker) {
                    AdapterInfoWindowAdapter adapterInfoWindowAdapter2 = adapterInfoWindowAdapter;
                    if (adapterInfoWindowAdapter2 == null) {
                        return null;
                    }
                    if (marker == null) {
                        return adapterInfoWindowAdapter2.getInfoWindow(null);
                    }
                    return adapterInfoWindowAdapter2.getInfoWindow(new AdapterMarker(marker));
                }

                @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                public View getInfoContents(Marker marker) {
                    AdapterInfoWindowAdapter adapterInfoWindowAdapter2 = adapterInfoWindowAdapter;
                    if (adapterInfoWindowAdapter2 == null) {
                        return null;
                    }
                    if (marker == null) {
                        return adapterInfoWindowAdapter2.getInfoContents(null);
                    }
                    return adapterInfoWindowAdapter2.getInfoContents(new AdapterMarker(marker));
                }
            });
        }
    }

    public void setOnInfoWindowClickListener(final OnAdapterInfoWindowClickListener onAdapterInfoWindowClickListener) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "setOnInfoWindowClickListener");
        if (onAdapterInfoWindowClickListener == null) {
            RVLogger.d("AdapterAMap", "setOnInfoWindowClickListener listener == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() { // from class: com.alipay.mobile.apmap.AdapterAMap.11
                @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
                public void onInfoWindowClick(Marker marker) {
                    OnAdapterInfoWindowClickListener onAdapterInfoWindowClickListener2 = onAdapterInfoWindowClickListener;
                    if (onAdapterInfoWindowClickListener2 == null) {
                        return;
                    }
                    if (marker == null) {
                        onAdapterInfoWindowClickListener2.onInfoWindowClick(null);
                    } else {
                        onAdapterInfoWindowClickListener2.onInfoWindowClick(new AdapterMarker(marker));
                    }
                }
            });
        }
    }

    public void setOnMapClickListener(final OnAdapterMapClickListener onAdapterMapClickListener) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "setOnMapClickListener");
        if (onAdapterMapClickListener == null) {
            RVLogger.d("AdapterAMap", "setOnMapClickListener listener == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() { // from class: com.alipay.mobile.apmap.AdapterAMap.12
                @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
                public void onMapClick(LatLng latLng) {
                    OnAdapterMapClickListener onAdapterMapClickListener2 = onAdapterMapClickListener;
                    if (onAdapterMapClickListener2 == null) {
                        return;
                    }
                    if (latLng == null) {
                        onAdapterMapClickListener2.onMapClick(null);
                    } else {
                        onAdapterMapClickListener2.onMapClick(new AdapterLatLng(latLng));
                    }
                }
            });
        }
    }

    public void setOnMarkerDragListener(final OnAdapterMarkerDragListener onAdapterMarkerDragListener) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "setOnMarkerDragListener");
        if (onAdapterMarkerDragListener == null) {
            RVLogger.d("AdapterAMap", "setOnMarkerDragListener listener == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() { // from class: com.alipay.mobile.apmap.AdapterAMap.13
                @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
                public void onMarkerDragStart(Marker marker) {
                    OnAdapterMarkerDragListener onAdapterMarkerDragListener2 = onAdapterMarkerDragListener;
                    if (onAdapterMarkerDragListener2 == null) {
                        return;
                    }
                    if (marker == null) {
                        onAdapterMarkerDragListener2.onMarkerDragStart(null);
                    } else {
                        onAdapterMarkerDragListener2.onMarkerDragStart(new AdapterMarker(marker));
                    }
                }

                @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
                public void onMarkerDrag(Marker marker) {
                    OnAdapterMarkerDragListener onAdapterMarkerDragListener2 = onAdapterMarkerDragListener;
                    if (onAdapterMarkerDragListener2 == null) {
                        return;
                    }
                    if (marker == null) {
                        onAdapterMarkerDragListener2.onMarkerDrag(null);
                    } else {
                        onAdapterMarkerDragListener2.onMarkerDrag(new AdapterMarker(marker));
                    }
                }

                @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
                public void onMarkerDragEnd(Marker marker) {
                    OnAdapterMarkerDragListener onAdapterMarkerDragListener2 = onAdapterMarkerDragListener;
                    if (onAdapterMarkerDragListener2 == null) {
                        return;
                    }
                    if (marker == null) {
                        onAdapterMarkerDragListener2.onMarkerDragEnd(null);
                    } else {
                        onAdapterMarkerDragListener2.onMarkerDragEnd(new AdapterMarker(marker));
                    }
                }
            });
        }
    }

    public void setMapCustomEnable(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setMapCustomEnable enable = ");
        sb.append(z);
        RVLogger.d("AdapterAMap", sb.toString());
        AdapterUtil.isGoogleMapSdk();
    }

    public void setCustomMapStylePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("setCustomMapStylePath stylePath = ");
        sb.append(str);
        RVLogger.d("AdapterAMap", sb.toString());
        AdapterUtil.isGoogleMapSdk();
    }

    public void setMapStatusLimits(AdapterLatLngBounds adapterLatLngBounds) {
        RVLogger.d("AdapterAMap", "setMapStatusLimits");
        if (adapterLatLngBounds == null) {
            RVLogger.d("AdapterAMap", "setMapStatusLimits bounds == null");
        } else {
            AdapterUtil.isGoogleMapSdk();
        }
    }

    public final void animateCamera(AdapterCameraUpdate adapterCameraUpdate, final AdapterCancelableCallback adapterCancelableCallback) {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "animateCamera");
        if (adapterCameraUpdate == null) {
            RVLogger.d("AdapterAMap", "moveCamera cameraUpdate == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.animateCamera(adapterCameraUpdate.getGoogleMapCameraUpdate(), new GoogleMap.CancelableCallback() { // from class: com.alipay.mobile.apmap.AdapterAMap.14
                @Override // com.google.android.gms.maps.GoogleMap.CancelableCallback
                public void onFinish() {
                    AdapterCancelableCallback adapterCancelableCallback2 = adapterCancelableCallback;
                    if (adapterCancelableCallback2 != null) {
                        adapterCancelableCallback2.onFinish();
                    }
                }

                @Override // com.google.android.gms.maps.GoogleMap.CancelableCallback
                public void onCancel() {
                    AdapterCancelableCallback adapterCancelableCallback2 = adapterCancelableCallback;
                    if (adapterCancelableCallback2 != null) {
                        adapterCancelableCallback2.onCancel();
                    }
                }
            });
        }
    }

    public final void animateCamera(AdapterCameraUpdate adapterCameraUpdate, long j, final AdapterCancelableCallback adapterCancelableCallback) {
        GoogleMap googleMap;
        StringBuilder sb = new StringBuilder();
        sb.append("animateCamera duration = ");
        sb.append(j);
        RVLogger.d("AdapterAMap", sb.toString());
        if (adapterCameraUpdate == null) {
            RVLogger.d("AdapterAMap", "moveCamera cameraUpdate == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
        } else {
            googleMap.animateCamera(adapterCameraUpdate.getGoogleMapCameraUpdate(), (int) j, new GoogleMap.CancelableCallback() { // from class: com.alipay.mobile.apmap.AdapterAMap.15
                @Override // com.google.android.gms.maps.GoogleMap.CancelableCallback
                public void onFinish() {
                    AdapterCancelableCallback adapterCancelableCallback2 = adapterCancelableCallback;
                    if (adapterCancelableCallback2 != null) {
                        adapterCancelableCallback2.onFinish();
                    }
                }

                @Override // com.google.android.gms.maps.GoogleMap.CancelableCallback
                public void onCancel() {
                    AdapterCancelableCallback adapterCancelableCallback2 = adapterCancelableCallback;
                    if (adapterCancelableCallback2 != null) {
                        adapterCancelableCallback2.onCancel();
                    }
                }
            });
        }
    }

    public final void stopAnimation() {
        GoogleMap googleMap;
        RVLogger.d("AdapterAMap", "stopAnimation");
        if (!AdapterUtil.isGoogleMapSdk() || (googleMap = this.f7092a) == null) {
            return;
        }
        googleMap.stopAnimation();
    }

    public float getScalePerPixel() {
        RVLogger.d("AdapterAMap", "getScalePerPixel");
        AdapterUtil.isGoogleMapSdk();
        return 0.0f;
    }

    public void setCustomTextureResourcePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("setCustomTextureResourcePath path = ");
        sb.append(str);
        RVLogger.d("AdapterAMap", sb.toString());
        AdapterUtil.isGoogleMapSdk();
    }

    public void setCustomRender(AdapterCustomRender adapterCustomRender) {
        is2dMapSdk();
    }

    public void setRenderMode(int i) {
        is2dMapSdk();
    }
}
