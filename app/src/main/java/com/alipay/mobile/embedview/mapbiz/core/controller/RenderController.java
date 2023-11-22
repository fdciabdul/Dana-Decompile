package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.embedview.IEmbedPerformanceReporter;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.apmap.OnAdapterMapReadyCallback;
import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.embedview.mapbiz.core.H5MapPreloadManager;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.alipay.mobile.embedview.mapbiz.data.MapData;
import com.alipay.mobile.embedview.mapbiz.data.MarkerCluster;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class RenderController extends H5MapController {

    /* renamed from: a */
    private float f7165a;
    private double b;
    private double c;
    private AdapterTextureMapView d;
    private String e;
    private MapData f;
    private boolean g;
    private AdapterCameraPosition h;
    private CountDownLatch i;
    protected long mCreateMapViewCount;
    protected boolean mEmbedPerformanceReported;
    protected IEmbedPerformanceReporter mEmbedPerformanceReporter;
    protected AtomicBoolean mForceRenderIncludePoints;
    protected volatile boolean mHasMapLoaded;
    protected volatile boolean mHasNotifiedInitComplete;
    protected volatile boolean mHasReceivedRender;
    protected volatile boolean mHasRenderedLimitRegion;
    protected volatile boolean mHasRenderedSatellite;
    protected boolean mLoadMapTimeTracked;
    protected volatile boolean mNeedFixIncludePointsOnLoad;
    protected AtomicLong mPauseCount;
    protected AtomicBoolean mPauseReally;
    protected long mReceiveRenderFirstTime;
    protected boolean mShowing;

    public RenderController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7165a = H5MapContainer.SCALE_DEFAULT;
        this.f = new MapData();
        this.mPauseCount = new AtomicLong();
        this.mPauseReally = new AtomicBoolean(true);
        this.mShowing = true;
        this.mForceRenderIncludePoints = new AtomicBoolean(false);
        this.i = new CountDownLatch(1);
    }

    public void setPerformanceReporter(IEmbedPerformanceReporter iEmbedPerformanceReporter) {
        this.mEmbedPerformanceReporter = iEmbedPerformanceReporter;
    }

    public boolean hasReceivedRender() {
        return this.mHasReceivedRender;
    }

    public AdapterTextureMapView getMapView() {
        return this.d;
    }

    public void create(int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mCreateMapViewCount++;
        Context context = this.mMapContainer.getContext();
        if (context == null) {
            RVLogger.d(H5MapContainer.TAG, "create context is null");
            return;
        }
        final AdapterTextureMapView requestMapView = H5MapPreloadManager.INSTANCE.requestMapView(context, this.mMapContainer.getAppId());
        requestMapView.setCreateMapTracked(true);
        StringBuilder sb = new StringBuilder();
        sb.append("RenderController.create: ");
        sb.append(i);
        sb.append(",");
        sb.append(i2);
        RVLogger.d(H5MapContainer.TAG, sb.toString());
        final AtomicLong atomicLong = new AtomicLong();
        requestMapView.initMap(new OnAdapterMapReadyCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.RenderController.1
            {
                RenderController.this = this;
            }

            @Override // com.alipay.mobile.apmap.OnAdapterMapReadyCallback
            public void onAdapterMapReady(AdapterAMap adapterAMap) {
                adapterAMap.getUiSettings().setZoomControlsEnabled(false);
                adapterAMap.getUiSettings().setScaleControlsEnabled(false);
                adapterAMap.getUiSettings().setCompassEnabled(false);
                adapterAMap.getUiSettings().setGestureScaleByMapCenter(true);
                adapterAMap.getUiSettings().setZoomInByScreenCenter(true);
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                adapterAMap.setOnMapLoadedListener(new AdapterAMap.OnAdapterMapLoadedListener() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.RenderController.1.1
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMapLoadedListener
                    public void onMapLoaded() {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        if (RenderController.this.mEmbedPerformanceReporter != null && !RenderController.this.mEmbedPerformanceReported) {
                            RenderController.this.mEmbedPerformanceReported = true;
                            RenderController.this.mEmbedPerformanceReporter.onRenderFinished(elapsedRealtime2);
                            if (RenderController.this.mMapContainer.debuggable) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("embed performance reported: ");
                                sb2.append(RenderController.this.mMapContainer.getAppId());
                                sb2.append(" -> ");
                                sb2.append(elapsedRealtime2);
                                RVLogger.d(H5MapContainer.TAG, sb2.toString());
                            }
                        }
                        RenderController.this.mMapContainer.performLogController.logMap(requestMapView.is2dMapSdk(), elapsedRealtime, elapsedRealtime2);
                        if (!RenderController.this.mLoadMapTimeTracked) {
                            RenderController.this.mLoadMapTimeTracked = true;
                            RenderController.this.mMapContainer.reportController.reportLoadMap(requestMapView.is2dMapSdk(), System.currentTimeMillis() - atomicLong.get());
                        }
                        RenderController.this.mHasMapLoaded = true;
                        RenderController.this.b();
                        RenderController.this.a();
                        try {
                            RenderController.this.c();
                        } catch (Throwable th) {
                            RVLogger.e(H5MapContainer.TAG, th);
                            RenderController.this.mMapContainer.reportController.reportException("RenderController#onMapLoaded", th.getMessage());
                        }
                    }
                });
                adapterAMap.setOnMapClickListener(RenderController.this.mMapContainer.onTapClickListener);
                adapterAMap.setOnCameraChangeListener(RenderController.this.mMapContainer.onRegionChangeListener);
                adapterAMap.setInfoWindowAdapter(RenderController.this.mMapContainer.infoWindowAdapter);
                adapterAMap.setOnInfoWindowClickListener(RenderController.this.mMapContainer.infoWindowClickListener);
                adapterAMap.setOnMarkerClickListener(RenderController.this.mMapContainer.markerClickListener);
                RenderController.this.i.countDown();
            }
        });
        requestMapView.onCreate(new Bundle());
        requestMapView.onResume();
        this.d = requestMapView;
        this.mHasMapLoaded = false;
        d();
        this.mMapContainer.routeSearchController.onCreate();
        this.mMapContainer.compassController.onCreate();
        long currentTimeMillis2 = System.currentTimeMillis();
        long j = currentTimeMillis2 - currentTimeMillis;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("create cost: ");
        sb2.append(j);
        sb2.append("ms");
        RVLogger.d(H5MapContainer.TAG, sb2.toString());
        this.mMapContainer.reportController.reportCreateMap(requestMapView.is2dMapSdk(), j);
        atomicLong.set(currentTimeMillis2);
    }

    public boolean a() {
        if (this.mCreateMapViewCount > 1 && this.mMapContainer.configController.isDoNotifyRestore()) {
            StringBuilder sb = new StringBuilder();
            sb.append("notifyMapRestoreComplete: ");
            sb.append(this.mCreateMapViewCount);
            RVLogger.d(H5MapContainer.TAG, sb.toString());
            try {
                if (this.mMapContainer.getH5Page() != null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
                    jSONObject.put("data", (Object) jSONObject2);
                    if (this.mMapContainer.getExtraJsCallback() != null) {
                        this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "mapRestoreComplete" : "nbcomponent.map.bindmaprestorecomplete", jSONObject);
                        return true;
                    }
                    return true;
                }
                return true;
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
                this.mMapContainer.reportController.reportException("RenderController#notifyMapRestoreComplete", th.getMessage());
                return false;
            }
        }
        return false;
    }

    public boolean b() {
        if (!this.mHasNotifiedInitComplete && this.mHasMapLoaded && this.mHasReceivedRender) {
            try {
                if (this.mMapContainer.getH5Page() != null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
                    jSONObject.put("data", (Object) jSONObject2);
                    if (this.mMapContainer.getExtraJsCallback() != null) {
                        this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "mapInitComplete" : "nbcomponent.map.bindmapinitcomplete", jSONObject);
                    }
                }
                this.mHasNotifiedInitComplete = true;
                return true;
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
                this.mMapContainer.reportController.reportException("RenderController#notifyMapInitComplete", th.getMessage());
            }
        }
        return false;
    }

    public void c() {
        int queueSize = this.mMapContainer.replayController.getQueueSize();
        if (queueSize <= 0) {
            return;
        }
        this.mMapContainer.replayController.play();
        this.mMapContainer.reportController.reportReplayJSAPI(queueSize);
    }

    private void d() {
        AdapterTextureMapView adapterTextureMapView = this.d;
        if (adapterTextureMapView == null || !adapterTextureMapView.is2dMapSdk()) {
            return;
        }
        View findViewByClassName = H5MapUtils.findViewByClassName(this.d, "com.amap.api.mapcore2d.ce");
        if (findViewByClassName != null) {
            findViewByClassName.setVisibility(8);
        } else {
            RVLogger.e(H5MapContainer.TAG, "zoom controls find error for 2d");
        }
    }

    public View getView(int i, int i2) {
        if (this.d == null) {
            try {
                create(i, i2);
                AdapterTextureMapView adapterTextureMapView = this.d;
                if (adapterTextureMapView != null && !adapterTextureMapView.isCreateMapFailed()) {
                    this.mMapContainer.reportController.reportRenderMap(true);
                } else {
                    this.mMapContainer.reportController.reportRenderMap(false);
                }
                if (this.mMapContainer.getExtraJsCallback() != null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
                    jSONObject2.put("type", (Object) "getView");
                    jSONObject.put("data", (Object) jSONObject2);
                    this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "afterRender" : "nbcomponent.map.afterrender", jSONObject);
                }
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
                this.mMapContainer.reportController.reportRenderMap(false);
                this.mMapContainer.reportController.reportException("RenderController#getView", th.getMessage());
                throw th;
            }
        }
        return this.d;
    }

    public void restoreView(int i, int i2) {
        if (is2dMapSdk() && !this.mMapContainer.configController.isRestore2DEnabled()) {
            RVLogger.d(H5MapContainer.TAG, "restore render is forbidden for 2d");
            return;
        }
        boolean z = true;
        if (!this.mHasReceivedRender || (this.mPauseCount.get() != 1 || this.mPauseReally.get() || !this.mMapContainer.configController.isDoPauseOnRenderByNebula() ? System.currentTimeMillis() - this.mReceiveRenderFirstTime < 500 : System.currentTimeMillis() - this.mReceiveRenderFirstTime < 2000)) {
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RenderController.restore: ");
        sb.append(i);
        sb.append(",");
        sb.append(i2);
        RVLogger.d(H5MapContainer.TAG, sb.toString());
        if (!z && this.mPauseCount.get() == 1 && !this.mPauseReally.get() && this.mMapContainer.configController.isDoPauseOnRenderByNebula()) {
            RVLogger.d(H5MapContainer.TAG, "restore: this is not a really restore, it is paused by nebula!");
        }
        destroy();
        try {
            create(i, i2);
            long currentTimeMillis = this.mMapContainer.debuggable ? System.currentTimeMillis() : 0L;
            onRestoreRender(z);
            if (this.mMapContainer.debuggable) {
                long currentTimeMillis2 = System.currentTimeMillis();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("RenderController#onRestoreRender: ");
                sb2.append(currentTimeMillis2 - currentTimeMillis);
                sb2.append("ms");
                RVLogger.d(H5MapContainer.TAG, sb2.toString());
            }
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("RenderController#restoreView", th.getMessage());
            throw th;
        }
    }

    public void destroy() {
        this.mMapContainer.smoothMoveMarkerController.stopSmoothMoveMarker();
        this.mMapContainer.smoothMovePolylineController.stopSmoothMovePolyline();
        e();
        AdapterTextureMapView adapterTextureMapView = this.d;
        if (adapterTextureMapView != null) {
            AdapterAMap map = adapterTextureMapView.getMap();
            if (map != null) {
                map.setOnMapLoadedListener(null);
                map.setOnMapClickListener(null);
                map.setOnCameraChangeListener(null);
                map.setInfoWindowAdapter(null);
                map.setOnInfoWindowClickListener(null);
                map.setOnMarkerClickListener(null);
            }
            this.d.onDestroy();
            RVLogger.d(H5MapContainer.TAG, "destroy mMapView is null");
            this.d = null;
        }
        this.mMapContainer.mapCtrlController.clear();
        this.mMapContainer.panelController.clear();
        initLastLatLngZoom(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, H5MapContainer.SCALE_DEFAULT);
    }

    public void onRestoreRender(boolean z) {
        MapData mapData = null;
        try {
            if (this.mMapContainer.configController.isMapRenderCacheDataObject()) {
                if (this.mMapContainer.debuggable) {
                    RVLogger.d(H5MapContainer.TAG, "getSpecialRestoreView render by cache data object");
                }
                this.f.reset();
                mapData = MapData.check(this.f);
                this.f = mapData;
            } else {
                if (this.mMapContainer.debuggable) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getSpecialRestoreView mRenderMapDataText =  ");
                    sb.append(this.e);
                    RVLogger.d(H5MapContainer.TAG, sb.toString());
                }
                mapData = MapData.check((MapData) JSON.parseObject(this.e, MapData.class));
                this.f = mapData;
            }
        } catch (Exception e) {
            RVLogger.e(H5MapContainer.TAG, e);
            this.mMapContainer.reportController.reportException("RenderController#onRestoreRender", e.getMessage());
        }
        try {
            a(mapData, z);
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("RenderController#onRestoreRender", th.getMessage());
        }
    }

    public void onResume() {
        this.mShowing = true;
        RVLogger.d(H5MapContainer.TAG, "RenderController onResume");
    }

    public void onPause() {
        this.mShowing = false;
        RVLogger.d(H5MapContainer.TAG, "RenderController onPause");
        if (this.mPauseCount.incrementAndGet() == 1) {
            try {
                this.mPauseReally.set(!isVisible(this.mMapContainer.getH5Page().getPageContext().getContentView()));
                if (this.mPauseReally.get()) {
                    return;
                }
                RVLogger.d(H5MapContainer.TAG, "This is not really pause, it is pause by nebula for uc.");
                return;
            } catch (Throwable th) {
                this.mPauseReally.set(true);
                this.mMapContainer.reportController.reportException("RenderController#onPause", th.getMessage());
                return;
            }
        }
        this.mPauseReally.set(true);
    }

    public void onDestroy() {
        if (this.mMapContainer.configController.isDoDestroyOnDead()) {
            try {
                this.mMapContainer.locationController.deactivate();
            } catch (Exception e) {
                RVLogger.e(H5MapContainer.TAG, e);
                this.mMapContainer.reportController.reportException("RenderController#onDestroy", e.getMessage());
            }
        }
    }

    public boolean isReady() {
        return this.mHasMapLoaded;
    }

    public boolean isShowing() {
        return this.mShowing;
    }

    protected boolean isVisible(View view) {
        return view != null && view.isShown() && view.hasWindowFocus();
    }

    public MapData getMapData() {
        return this.f;
    }

    public void invalidateMapData() {
        this.g = true;
    }

    public void invalidateCamera() {
        this.g = true;
        if (this.mShowing) {
            return;
        }
        this.h = null;
    }

    public void checkMapDataChanged() {
        try {
            if (this.g) {
                if (this.mMapContainer.configController.isMapRenderCacheDataObject()) {
                    if (this.mMapContainer.debuggable) {
                        RVLogger.d(H5MapContainer.TAG, "RenderController#checkMapDataChanged: map data is changed");
                    }
                } else {
                    this.e = JSON.toJSONString(this.f);
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public void onIncludePointsChange() {
        if (this.mShowing) {
            return;
        }
        this.mForceRenderIncludePoints.set(true);
    }

    public void doReceivedRender(final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        ExecutorUtils.execute(ExecutorType.NORMAL, new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.RenderController.2
            {
                RenderController.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (RenderController.this.d.getMap() == null) {
                    try {
                        RenderController.this.i.await(3L, TimeUnit.SECONDS);
                    } catch (InterruptedException unused) {
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                StringBuilder sb = new StringBuilder();
                sb.append("map_lifecycle:map_data_start:");
                sb.append(RenderController.this.is2dMapSdk() ? "2d" : "3d");
                RVLogger.d(H5MapContainer.TAG, sb.toString());
                if (!RenderController.this.mHasReceivedRender) {
                    RenderController.this.mHasReceivedRender = true;
                    RenderController.this.mReceiveRenderFirstTime = System.currentTimeMillis();
                }
                if (!RenderController.this.mHasNotifiedInitComplete) {
                    RenderController.this.b();
                }
                JSONObject wrapData = RenderController.this.mMapContainer.renderOptimizer.wrapData(jSONObject);
                if (wrapData != null) {
                    if (!wrapData.containsKey("longitude") || !wrapData.containsKey("latitude")) {
                        wrapData.put("longitude", (Object) Double.valueOf(RenderController.this.c));
                        wrapData.put("latitude", (Object) Double.valueOf(RenderController.this.b));
                    }
                    if (!wrapData.containsKey(H5MapRenderOptimizer.KEY_SCALE)) {
                        wrapData.put(H5MapRenderOptimizer.KEY_SCALE, (Object) Float.valueOf(RenderController.this.f7165a));
                    }
                    RenderController.this.mMapContainer.setElementId(wrapData.getString(LottieParams.KEY_ELEMENT_ID));
                }
                if (RenderController.this.mMapContainer.debuggable) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onReceivedRender  =  ");
                    sb2.append(wrapData);
                    sb2.append(" mElementId = ");
                    sb2.append(RenderController.this.mMapContainer.getElementId());
                    RVLogger.d(H5MapContainer.TAG, sb2.toString());
                }
                try {
                    final MapData check = MapData.check((MapData) JSON.toJavaObject(wrapData, MapData.class));
                    RenderController.this.f = check;
                    if (RenderController.this.mMapContainer.configController.isMapRenderCacheDataObject()) {
                        if (RenderController.this.mMapContainer.debuggable) {
                            RVLogger.d(H5MapContainer.TAG, "RenderController#doReceivedRender: render by cache data object");
                        }
                        try {
                            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.RenderController.2.1
                                {
                                    AnonymousClass2.this = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    RenderController.this.a(check, false);
                                }
                            });
                        } catch (Throwable th) {
                            RVLogger.e(H5MapContainer.TAG, th);
                            RenderController.this.mMapContainer.reportController.reportException("RenderController#doReceivedRender", th.getMessage());
                        }
                    } else {
                        if (RenderController.this.mMapContainer.debuggable) {
                            RVLogger.d(H5MapContainer.TAG, "RenderController#doReceivedRender: render by json string text");
                        }
                        boolean a2 = check != null ? RenderController.this.a(check.scale, check.latitude, check.longitude) : true;
                        String jSONString = JSON.toJSONString(check);
                        if (!TextUtils.equals(jSONString, RenderController.this.e) || !a2) {
                            RenderController.this.e = jSONString;
                            try {
                                ExecutorUtils.runOnMain(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.RenderController.2.2
                                    {
                                        AnonymousClass2.this = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        RenderController.this.a(check, false);
                                    }
                                });
                            } catch (Throwable th2) {
                                RVLogger.e(H5MapContainer.TAG, th2);
                                RenderController.this.mMapContainer.reportController.reportException("RenderController#doReceivedRender", th2.getMessage());
                            }
                        } else if (RenderController.this.mMapContainer.debuggable) {
                            RVLogger.d(H5MapContainer.TAG, "RenderController#doReceivedRender: render data same!!!");
                        }
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("map_lifecycle:map_data_ready:");
                    sb3.append(RenderController.this.is2dMapSdk() ? "2d" : "3d");
                    RVLogger.d(H5MapContainer.TAG, sb3.toString());
                    RenderController.this.mMapContainer.performLogController.logData(RenderController.this.is2dMapSdk(), elapsedRealtime, SystemClock.elapsedRealtime());
                    RenderController.this.a(bridgeCallback);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    JSONObject jSONObject2 = jSONObject;
                    String str = (jSONObject2 == null || !jSONObject2.containsKey("optimize")) ? ReportController.EVENT_RENDER_MAP : "renderMapOptimize";
                    RenderController.this.mMapContainer.reportController.reportJsApiCall(str);
                    RenderController.this.mMapContainer.reportController.reportJsApiTime(str, currentTimeMillis2 - currentTimeMillis);
                } catch (Throwable th3) {
                    RenderController.this.mMapContainer.reportController.reportException("RenderController#doReceivedRender", th3.getMessage());
                }
            }
        });
    }

    public void a(BridgeCallback bridgeCallback) {
        if (this.mMapContainer.getExtraJsCallback() != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
            jSONObject2.put("type", (Object) "render");
            jSONObject.put("data", (Object) jSONObject2);
            this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "afterRender" : "nbcomponent.map.afterrender", jSONObject);
        }
        if (bridgeCallback != null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }

    private void e() {
        synchronized (this) {
            AdapterTextureMapView adapterTextureMapView = this.d;
            if (adapterTextureMapView != null && adapterTextureMapView.getMap() != null) {
                this.d.getMap().clear();
                this.mMapContainer.locationController.clear();
            }
            this.mMapContainer.polylineController.clear();
            this.mMapContainer.markerController.clear();
            RVLogger.d(H5MapContainer.TAG, "clear");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.alipay.mobile.embedview.mapbiz.data.MapData r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.RenderController.a(com.alipay.mobile.embedview.mapbiz.data.MapData, boolean):void");
    }

    public boolean checkScale(float f) {
        if (f <= 0.0f) {
            this.mMapContainer.reportController.reportParamError(2);
            return true;
        }
        return false;
    }

    public boolean checkLatLon(double d, double d2) {
        if (d < -90.0d || d > 90.0d || d2 < -180.0d || d2 > 180.0d) {
            this.mMapContainer.reportController.reportParamError(3);
            return true;
        }
        return false;
    }

    public boolean a(float f, double d, double d2) {
        return ((((double) Math.abs(this.f7165a - f)) > 1.0E-6d ? 1 : (((double) Math.abs(this.f7165a - f)) == 1.0E-6d ? 0 : -1)) < 0) && ((Math.abs(this.b - d) > 1.0E-6d ? 1 : (Math.abs(this.b - d) == 1.0E-6d ? 0 : -1)) < 0) && ((Math.abs(this.c - d2) > 1.0E-6d ? 1 : (Math.abs(this.c - d2) == 1.0E-6d ? 0 : -1)) < 0);
    }

    public void initLastLatLngZoom(double d, double d2, float f) {
        this.b = d;
        this.c = d2;
        this.f7165a = f;
    }

    public AdapterAMap getMap() {
        AdapterTextureMapView adapterTextureMapView = this.d;
        if (adapterTextureMapView != null) {
            return adapterTextureMapView.getMap();
        }
        return null;
    }

    public boolean is2dMapSdk() {
        AdapterTextureMapView adapterTextureMapView = this.d;
        return adapterTextureMapView == null || adapterTextureMapView.is2dMapSdk();
    }

    public MarkerCluster getMarkerCluster() {
        MapData mapData = this.f;
        if (mapData == null || mapData.setting == null) {
            return null;
        }
        return this.f.setting.markerCluster;
    }

    public void onDetachedFromWebView() {
        try {
            if (this.mMapContainer.onRegionChangeListener.isCameraChangeHappened()) {
                this.h = this.d.getMap().getCameraPosition();
            }
        } catch (Exception e) {
            this.h = null;
            RVLogger.e(H5MapContainer.TAG, e);
            this.mMapContainer.reportController.reportException("RenderController#onDetachedFromWebView", e.getMessage());
        }
    }
}
