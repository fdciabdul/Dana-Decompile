package com.alipay.mobile.embedview.mapbiz.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.callback.H5PageCallback;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.alipay.mobile.embedview.mapbiz.core.H5ReplayEvent;
import com.alipay.mobile.embedview.mapbiz.core.H5ResourceLoader;
import com.alipay.mobile.embedview.mapbiz.core.controller.CacheController;
import com.alipay.mobile.embedview.mapbiz.core.controller.CameraChangeListener;
import com.alipay.mobile.embedview.mapbiz.core.controller.CircleController;
import com.alipay.mobile.embedview.mapbiz.core.controller.CompassController;
import com.alipay.mobile.embedview.mapbiz.core.controller.ConfigController;
import com.alipay.mobile.embedview.mapbiz.core.controller.GlobalMapsController;
import com.alipay.mobile.embedview.mapbiz.core.controller.GroundOverlayController;
import com.alipay.mobile.embedview.mapbiz.core.controller.IncludePointsController;
import com.alipay.mobile.embedview.mapbiz.core.controller.InfoWindowAdapter;
import com.alipay.mobile.embedview.mapbiz.core.controller.InfoWindowClickListener;
import com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController;
import com.alipay.mobile.embedview.mapbiz.core.controller.LocationController;
import com.alipay.mobile.embedview.mapbiz.core.controller.MapAPIController;
import com.alipay.mobile.embedview.mapbiz.core.controller.MapClickListener;
import com.alipay.mobile.embedview.mapbiz.core.controller.MapCtrlController;
import com.alipay.mobile.embedview.mapbiz.core.controller.MapSettingController;
import com.alipay.mobile.embedview.mapbiz.core.controller.MapStyleController;
import com.alipay.mobile.embedview.mapbiz.core.controller.MarkerAnimController;
import com.alipay.mobile.embedview.mapbiz.core.controller.MarkerClickListener;
import com.alipay.mobile.embedview.mapbiz.core.controller.MarkerClusterController;
import com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController;
import com.alipay.mobile.embedview.mapbiz.core.controller.MetricsController;
import com.alipay.mobile.embedview.mapbiz.core.controller.PanelController;
import com.alipay.mobile.embedview.mapbiz.core.controller.PerformLogController;
import com.alipay.mobile.embedview.mapbiz.core.controller.PolygonController;
import com.alipay.mobile.embedview.mapbiz.core.controller.PolylineController;
import com.alipay.mobile.embedview.mapbiz.core.controller.RenderController;
import com.alipay.mobile.embedview.mapbiz.core.controller.ReplayController;
import com.alipay.mobile.embedview.mapbiz.core.controller.ReportController;
import com.alipay.mobile.embedview.mapbiz.core.controller.RouteSearchController;
import com.alipay.mobile.embedview.mapbiz.core.controller.SkewController;
import com.alipay.mobile.embedview.mapbiz.core.controller.SmoothMoveMarkerController;
import com.alipay.mobile.embedview.mapbiz.core.controller.SmoothMovePolylineController;
import com.alipay.mobile.embedview.mapbiz.core.controller.SnapshotController;
import com.alipay.mobile.embedview.mapbiz.core.controller.TileOverlayController;
import com.alipay.mobile.embedview.mapbiz.core.controller.UpdateComponentsController;
import com.alipay.mobile.embedview.mapbiz.utils.RuntimeConstants;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes2.dex */
public class H5MapContainer {
    public static float SCALE_DEFAULT = 16.0f;
    public static final String TAG = "H5EmbedMapView";
    protected H5JsCallback mCallbackExtra;
    protected WeakReference<Context> mContext;
    protected String mElementId;
    protected WeakReference<Page> mPage;
    protected String mAppId = "";
    protected Environment mEnv = Environment.DEFAULT;
    public final Handler mainHandler = new Handler(Looper.getMainLooper());
    public final boolean debuggable = RuntimeConstants.INSTANCE.isDebug();
    public final SnapshotController snapShotController = new SnapshotController(this);
    public final SmoothMoveMarkerController smoothMoveMarkerController = new SmoothMoveMarkerController(this);
    public final SmoothMovePolylineController smoothMovePolylineController = new SmoothMovePolylineController(this);
    public final MapClickListener onTapClickListener = new MapClickListener(this);
    public final InfoWindowAdapter infoWindowAdapter = new InfoWindowAdapter(this);
    public final CameraChangeListener onRegionChangeListener = new CameraChangeListener(this);
    public final H5MapRenderOptimizer renderOptimizer = new H5MapRenderOptimizer();
    public final LocationController locationController = new LocationController(this);
    public final MarkerController markerController = new MarkerController(this);
    public final RouteSearchController routeSearchController = new RouteSearchController(this);
    public final MapCtrlController mapCtrlController = new MapCtrlController(this);
    public final MetricsController metricsController = new MetricsController(this);
    public final CompassController compassController = new CompassController(this);
    public final MapStyleController mapStyleController = new MapStyleController(this);
    public final RenderController renderController = new RenderController(this);
    public final CircleController circleController = new CircleController(this);
    public final TileOverlayController tileOverlayController = new TileOverlayController(this);
    public final GroundOverlayController groundOverlayController = new GroundOverlayController(this);
    public final PolygonController polygonController = new PolygonController(this);
    public final PolylineController polylineController = new PolylineController(this);
    public final ConfigController configController = new ConfigController(this);
    public final IncludePointsController includePointsController = new IncludePointsController(this);
    public final SkewController skewController = new SkewController(this);
    public final MapSettingController mapSettingController = new MapSettingController(this);
    public final MarkerAnimController markerAnimController = new MarkerAnimController(this);
    public final PerformLogController performLogController = new PerformLogController(this);
    public final UpdateComponentsController updateComponentsController = new UpdateComponentsController(this);
    public final LayoutController layoutController = new LayoutController(this);
    public final PanelController panelController = new PanelController(this);
    public final MapAPIController mapAPIController = new MapAPIController(this);
    public final MarkerClickListener markerClickListener = new MarkerClickListener(this);
    public final InfoWindowClickListener infoWindowClickListener = new InfoWindowClickListener(this);
    public final MarkerClusterController markerClusterController = new MarkerClusterController(this);
    public final H5ResourceLoader resourceLoader = new H5ResourceLoader(this);
    public final ReportController reportController = new ReportController(this);
    public final CacheController cacheController = new CacheController(this);
    public final GlobalMapsController globalMapsController = new GlobalMapsController(this);
    public final ReplayController replayController = new ReplayController(this);

    /* loaded from: classes6.dex */
    public enum Environment {
        DEFAULT,
        CUBE
    }

    public Environment getEnvironment() {
        return this.mEnv;
    }

    public void setEnvironment(Environment environment) {
        this.mEnv = environment;
    }

    public boolean isDefaultContainer() {
        return this.mEnv == Environment.DEFAULT;
    }

    public boolean isCubeContainer() {
        return this.mEnv == Environment.CUBE;
    }

    public void setExtraJsCallback(H5JsCallback h5JsCallback) {
        this.mCallbackExtra = h5JsCallback;
    }

    public H5JsCallback getExtraJsCallback() {
        return this.mCallbackExtra;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public void setAppId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAppId = str;
    }

    public Page getH5Page() {
        WeakReference<Page> weakReference = this.mPage;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public AdapterTextureMapView getMapView() {
        return this.renderController.getMapView();
    }

    public AdapterAMap getMap() {
        return this.renderController.getMap();
    }

    public boolean is2dMapSdk() {
        return this.renderController.is2dMapSdk();
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getElementId() {
        return this.mElementId;
    }

    public void setElementId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mElementId = str;
    }

    public void onCreate(Context context, Page page) {
        this.mContext = new WeakReference<>(context);
        this.mPage = new WeakReference<>(page);
        if (isDefaultContainer()) {
            this.mAppId = BundleUtils.getString(page != null ? page.getStartParams() : null, "appId");
        }
        if (isDefaultContainer() && this.mCallbackExtra == null) {
            this.mCallbackExtra = new H5PageCallback(page);
        }
        this.markerController.onCreate();
        this.layoutController.onCreate();
        this.replayController.setPage(this.mPage.get());
        setExtraJsCallback(new H5PageCallback(this.mPage.get()));
    }

    public void onResume() {
        this.renderController.onResume();
        this.locationController.onWebViewResume();
    }

    public void onPause() {
        this.renderController.onPause();
        this.locationController.onWebViewPause();
        this.smoothMoveMarkerController.stopSmoothMoveMarker();
        this.smoothMovePolylineController.stopSmoothMovePolyline();
        this.markerClusterController.onPause();
    }

    public void onDestroy() {
        this.renderController.onDestroy();
        this.configController.onDestroy();
        this.replayController.onDestroy();
    }

    public View getView(int i, int i2, Map<String, String> map) {
        if (TextUtils.isEmpty(this.mElementId) && map != null) {
            this.mElementId = map.get("id");
        }
        return this.renderController.getView(i, i2);
    }

    public View restoreView(int i, int i2, Map<String, String> map) {
        this.renderController.restoreView(i, i2);
        return this.renderController.getMapView();
    }

    public void onAttached() {
        this.globalMapsController.onAttached();
    }

    public void onDetached() {
        this.renderController.onDetachedFromWebView();
        this.globalMapsController.onDetached();
    }

    public Bitmap getPreSnapshot(int i, int i2, Map<String, String> map) {
        return this.snapShotController.getPreSnapshot();
    }

    public void triggerPreSnapshot() {
        this.snapShotController.triggerPreSnapshot();
    }

    public void onReceivedRender(JSONObject jSONObject, BridgeCallback bridgeCallback) {
        if (this.configController.isMapJSAPICallLazyEnabled()) {
            this.replayController.handleEvent(new H5ReplayEvent.Builder().type(1).data(jSONObject).callback(bridgeCallback).build());
        } else {
            this.renderController.doReceivedRender(jSONObject, bridgeCallback);
        }
    }

    public void onReceivedMessage(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        if (this.configController.isMapJSAPICallLazyEnabled()) {
            this.replayController.handleEvent(new H5ReplayEvent.Builder().type(2).action(str).data(jSONObject).callback(bridgeCallback).build());
        } else {
            this.mapAPIController.onReceivedMessage(str, jSONObject, bridgeCallback, this.mPage.get());
        }
    }
}
