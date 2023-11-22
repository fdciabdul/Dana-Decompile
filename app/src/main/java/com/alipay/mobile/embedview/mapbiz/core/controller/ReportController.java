package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.map.log.MapLoggerFactory;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class ReportController extends H5MapController {
    public static final int CODE_CONTROLS = 4;
    public static final int CODE_FAILURE = 2;
    public static final int CODE_LAT_LON = 3;
    public static final int CODE_MARKER = 1;
    public static final int CODE_POLYLINE = 6;
    public static final int CODE_SCALE = 2;
    public static final int CODE_SUCCESS = 1;
    public static final int CODE_TILE_OVERLAY = 5;
    public static final int DSL_SOURCE_CALL_OUT = 2;
    public static final int DSL_SOURCE_MARKER = 1;
    public static final int DSL_SOURCE_PANEL = 3;
    public static final int DSL_TYPE_LOAD = 3;
    public static final int DSL_TYPE_PARSE = 1;
    public static final int DSL_TYPE_RENDER = 2;
    public static final String EVENT_CATCH_ERROR = "catchErr";
    public static final String EVENT_CLUSTER = "clusterMarker";
    public static final String EVENT_JS_API_CALL = "jsApiCall";
    public static final String EVENT_LOAD_MAP = "loadMap";
    public static final String EVENT_LOAD_MAP_ERROR = "loadMapErr";
    public static final String EVENT_LOCATION = "location";
    public static final String EVENT_MAP_STYLE = "mapStyle";
    public static final String EVENT_RENDER_DSL = "renderDSL";
    public static final String EVENT_RENDER_MAP = "renderMap";
    public static final String EVENT_REPLAY_JS_API = "replayJSAPI";
    public static final String EVENT_ZEBRA_RENDER = "zebra";
    public static final String PARAM_ALL_COUNT = "allCount";
    public static final String PARAM_DELAY = "delay";
    public static final String PARAM_ERROR_MESSAGE = "mapErrMsg";
    public static final String PARAM_HTTP_CODE = "httpCode";
    public static final String PARAM_MAP_2D = "map2d";
    public static final String PARAM_MAP_CODE = "mapCode";
    public static final String PARAM_MAP_JS_API = "mapJSAPI";
    public static final String PARAM_ROOT_COUNT = "rootCount";
    public static final String PARAM_SOURCE = "source";
    public static final String PARAM_TINY = "tiny";
    public static final String PARAM_TYPE = "type";

    public ReportController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    public void reportRenderDSL(boolean z, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_MAP_CODE, String.valueOf(z ? 1 : 2));
        hashMap.put("source", String.valueOf(i));
        MapLoggerFactory.getBusinessLogger().logEvent(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), EVENT_RENDER_DSL, hashMap);
    }

    public void reportParamError(int i) {
        MapLoggerFactory.getBusinessLogger().logParamError(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), i);
    }

    public void reportLocation(boolean z) {
        MapLoggerFactory.getBusinessLogger().logEvent(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), "location", z ? 1 : 2);
    }

    public void reportMapStyle(boolean z) {
        MapLoggerFactory.getBusinessLogger().logEvent(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), EVENT_MAP_STYLE, z ? 1 : 2);
    }

    public void reportCreateMap(boolean z, long j) {
        MapLoggerFactory.getPerformanceLogger().logCreateMapTime(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), z, j);
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportController#reportCreateMap: ");
            sb.append(j);
            sb.append("ms");
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }

    public void reportLoadMap(boolean z, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_MAP_2D, z ? "1" : "0");
        MapLoggerFactory.getPerformanceLogger().logEventTime(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), EVENT_LOAD_MAP, j, hashMap);
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportController#reportLoadMap: ");
            sb.append(j);
            sb.append("ms");
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }

    public void reportRenderMap(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_TINY, "1");
        hashMap.put(PARAM_MAP_CODE, String.valueOf(z ? 1 : 2));
        MapLoggerFactory.getBusinessLogger().logEvent(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), EVENT_RENDER_MAP, hashMap);
    }

    public void reportJsApiError(String str, int i, String str2) {
        MapLoggerFactory.getBusinessLogger().logJsApiError(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), str, i, str2);
    }

    public void reportJsApiCall(String str) {
        MapLoggerFactory.getBusinessLogger().logJsApiCall(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), str);
    }

    public void reportJsApiCall(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_MAP_JS_API, str);
        hashMap.put(PARAM_MAP_CODE, String.valueOf(i));
        MapLoggerFactory.getBusinessLogger().logEvent(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), EVENT_JS_API_CALL, hashMap);
    }

    public void reportLocationTime(long j) {
        MapLoggerFactory.getPerformanceLogger().logDoLocationTime(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), j);
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportController#reportLocationTime: ");
            sb.append(j);
            sb.append("ms");
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }

    public void reportJsApiTime(String str, long j) {
        MapLoggerFactory.getPerformanceLogger().logJsApiExecutionTime(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), str, j);
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportController#reportJsApiTime: ");
            sb.append(str);
            sb.append(" -> ");
            sb.append(j);
            sb.append("ms");
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }

    public void reportMarkerLimit(int i) {
        MapLoggerFactory.getPerformanceLogger().logMarkerLimit(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), i);
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportController#reportMarkerLimit: ");
            sb.append(i);
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }

    public void reportDelayRate(String str, double d) {
        if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("delay", String.valueOf(d));
        MapLoggerFactory.getPerformanceLogger().logEventTime(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), str, hashMap);
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportController#reportDelayRate: ");
            sb.append(d * 100.0d);
            sb.append("%");
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }

    public void reportDSLTime(int i, long j) {
        if (j < 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        MapLoggerFactory.getPerformanceLogger().logEventTime(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), EVENT_ZEBRA_RENDER, j, hashMap);
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportController#reportDSLTime: [");
            sb.append(i);
            sb.append("] ");
            sb.append(j);
            sb.append("ms");
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }

    public void reportClusterTime(long j, int i, int i2) {
        if (j < 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_ALL_COUNT, String.valueOf(i));
        hashMap.put(PARAM_ROOT_COUNT, String.valueOf(i2));
        MapLoggerFactory.getPerformanceLogger().logEventTime(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), EVENT_CLUSTER, j, hashMap);
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportController#reportClusterTime: [");
            sb.append(i);
            sb.append("->");
            sb.append(i2);
            sb.append("] ");
            sb.append(j);
            sb.append("ms");
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }

    public void reportException(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", str);
        hashMap.put(PARAM_ERROR_MESSAGE, str2);
        MapLoggerFactory.getBusinessLogger().logEvent(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), EVENT_CATCH_ERROR, hashMap);
    }

    public void reportReplayJSAPI(int i) {
        if (i <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_ALL_COUNT, String.valueOf(i));
        MapLoggerFactory.getPerformanceLogger().logEventTime(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), EVENT_REPLAY_JS_API, hashMap);
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportController#reportReplayJSAPI: ");
            sb.append(i);
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }

    public void reportLoadMapError(int i, int i2) {
        if (i == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_MAP_CODE, String.valueOf(i));
        hashMap.put(PARAM_HTTP_CODE, String.valueOf(i2));
        MapLoggerFactory.getBusinessLogger().logEvent(this.mMapContainer.getContext(), this.mMapContainer.getAppId(), EVENT_LOAD_MAP_ERROR, hashMap);
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportController#reportLoadMapError: ");
            sb.append(i);
            sb.append(" -> HTTP: ");
            sb.append(i2);
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
    }
}
