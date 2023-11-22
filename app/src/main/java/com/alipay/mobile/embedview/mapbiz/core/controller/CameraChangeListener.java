package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class CameraChangeListener extends H5MapController implements AdapterAMap.OnAdapterCameraChangeListener {
    boolean mCameraChangeHappened;
    long mCameraChangingTime;
    boolean mChanging;
    RegionChangeState mRegionChangeState;
    Runnable mTryRegionChangeEndRunnable;
    boolean mTryRegionChangeEndRunning;

    public CameraChangeListener(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.mChanging = false;
        this.mCameraChangeHappened = false;
        this.mCameraChangingTime = -1L;
        this.mRegionChangeState = new RegionChangeState();
    }

    public void fixRegionChangeOnLoad() {
        if (this.mMapContainer.configController.isTryRegionChangeEnd()) {
            if (this.mTryRegionChangeEndRunnable == null) {
                this.mTryRegionChangeEndRunnable = new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.CameraChangeListener.1
                    {
                        CameraChangeListener.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        CameraChangeListener.this.mTryRegionChangeEndRunning = false;
                        if (!CameraChangeListener.this.mChanging || System.currentTimeMillis() - CameraChangeListener.this.mCameraChangingTime <= 500) {
                            return;
                        }
                        try {
                            AdapterAMap map = CameraChangeListener.this.mMapContainer.getMap();
                            if (map != null) {
                                CameraChangeListener.this.a(map.getCameraPosition());
                            }
                        } catch (Throwable th) {
                            RVLogger.e(H5MapContainer.TAG, th);
                            CameraChangeListener.this.mMapContainer.reportController.reportException("CameraChangeListener#run", th.getMessage());
                        }
                    }
                };
            } else {
                this.mMapContainer.mainHandler.removeCallbacks(this.mTryRegionChangeEndRunnable);
            }
            this.mMapContainer.mainHandler.postDelayed(this.mTryRegionChangeEndRunnable, 1000L);
            this.mTryRegionChangeEndRunning = true;
        }
    }

    public void a(AdapterCameraPosition adapterCameraPosition) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("regionChangedType", (Object) "end");
        jSONObject2.put("latitude", (Object) Double.valueOf(adapterCameraPosition.target.getLatitude()));
        jSONObject2.put("longitude", (Object) Double.valueOf(adapterCameraPosition.target.getLongitude()));
        jSONObject2.put(H5MapRenderOptimizer.KEY_SCALE, (Object) Float.valueOf(adapterCameraPosition.zoom));
        jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
        jSONObject.put("data", (Object) jSONObject2);
        if (this.mMapContainer.getExtraJsCallback() != null) {
            this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "regionChange" : "nbcomponent.map.bindregionchange", jSONObject);
        }
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("nbcomponent.map.bindregionchange: ");
            sb.append(jSONObject);
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterCameraChangeListener
    public void onCameraChange(AdapterCameraPosition adapterCameraPosition) {
        this.mCameraChangeHappened = true;
        this.mMapContainer.renderController.initLastLatLngZoom(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, adapterCameraPosition.zoom);
        this.mMapContainer.markerController.onCameraChanging(adapterCameraPosition);
        this.mMapContainer.polygonController.onCameraChanging(adapterCameraPosition);
        if (this.mMapContainer.getH5Page() == null) {
            this.mChanging = true;
            return;
        }
        if (!this.mChanging) {
            double latitude = adapterCameraPosition.target.getLatitude();
            double longitude = adapterCameraPosition.target.getLongitude();
            float f = adapterCameraPosition.zoom;
            if (!this.mRegionChangeState.equals(1, latitude, longitude, f)) {
                this.mRegionChangeState.update(1, latitude, longitude, f);
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("regionChangedType", (Object) "begin");
                jSONObject2.put("latitude", (Object) Double.valueOf(adapterCameraPosition.target.getLatitude()));
                jSONObject2.put("longitude", (Object) Double.valueOf(adapterCameraPosition.target.getLongitude()));
                jSONObject2.put(H5MapRenderOptimizer.KEY_SCALE, (Object) Float.valueOf(adapterCameraPosition.zoom));
                jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
                jSONObject.put("data", (Object) jSONObject2);
                if (this.mMapContainer.getExtraJsCallback() != null) {
                    this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "regionChange" : "nbcomponent.map.bindregionchange", jSONObject);
                }
                if (this.mMapContainer.debuggable) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("nbcomponent.map.bindregionchange: ");
                    sb.append(jSONObject);
                    RVLogger.d(H5MapContainer.TAG, sb.toString());
                }
            } else if (this.mMapContainer.debuggable) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("nbcomponent.map.bindregionchange: state is same [");
                sb2.append(1);
                sb2.append(",");
                sb2.append(latitude);
                sb2.append(",");
                sb2.append(longitude);
                sb2.append(",");
                sb2.append(f);
                sb2.append("]");
                RVLogger.d(H5MapContainer.TAG, sb2.toString());
            }
        }
        this.mChanging = true;
        this.mCameraChangingTime = System.currentTimeMillis();
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterCameraChangeListener
    public void onCameraChangeFinish(AdapterCameraPosition adapterCameraPosition) {
        this.mCameraChangeHappened = true;
        this.mChanging = false;
        this.mMapContainer.markerController.onCameraChanged(adapterCameraPosition, true);
        this.mMapContainer.polygonController.onCameraChanged(adapterCameraPosition, true);
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", Double.valueOf(adapterCameraPosition.target.getLatitude()));
        hashMap.put("longitude", Double.valueOf(adapterCameraPosition.target.getLongitude()));
        hashMap.put(H5MapRenderOptimizer.KEY_SCALE, Float.valueOf(adapterCameraPosition.zoom));
        this.mMapContainer.renderOptimizer.putAll(hashMap);
        if (this.mMapContainer.getH5Page() == null) {
            return;
        }
        double latitude = adapterCameraPosition.target.getLatitude();
        double longitude = adapterCameraPosition.target.getLongitude();
        float f = adapterCameraPosition.zoom;
        if (!this.mRegionChangeState.equals(2, latitude, longitude, f)) {
            this.mRegionChangeState.update(2, latitude, longitude, f);
            a(adapterCameraPosition);
        } else if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("nbcomponent.map.bindregionchange: state is same [");
            sb.append(2);
            sb.append(",");
            sb.append(latitude);
            sb.append(",");
            sb.append(longitude);
            sb.append(",");
            sb.append(f);
            sb.append("]");
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
        this.mMapContainer.globalMapsController.onCameraChangeFinish(adapterCameraPosition);
        this.mMapContainer.renderController.initLastLatLngZoom(adapterCameraPosition.target.getLatitude(), adapterCameraPosition.target.getLongitude(), adapterCameraPosition.zoom);
    }

    public boolean isCameraChangeHappened() {
        return this.mCameraChangeHappened;
    }

    /* loaded from: classes6.dex */
    public static class RegionChangeState {
        public static final int TYPE_CHANGE_BEGIN = 1;
        public static final int TYPE_CHANGE_END = 2;
        public static final int TYPE_CHANGE_UNKNOWN = 0;
        public double lat = -1.0d;
        public double lon = -1.0d;
        public float scale = -1.0f;
        public int type = 0;

        public boolean equals(int i, double d, double d2, float f) {
            return this.type == i && this.lat == d && this.lon == d2 && this.scale == f;
        }

        public void update(int i, double d, double d2, float f) {
            this.type = i;
            this.lat = d;
            this.lon = d2;
            this.scale = f;
        }
    }
}
