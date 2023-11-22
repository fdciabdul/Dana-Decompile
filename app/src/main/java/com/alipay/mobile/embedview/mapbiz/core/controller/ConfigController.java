package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;

/* loaded from: classes6.dex */
public class ConfigController extends H5MapController {

    /* renamed from: a */
    private volatile int f7149a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    protected int mClusterUseAnimCfg;
    protected int mDoClusterOnMoveMarker;
    protected int mDoDestroyOnDead;
    protected int mDoNotifyRestore;
    protected int mDoPauseOnRenderByNebula;
    protected int mDoRenderLimitRegion;
    protected int mFixCompassOnLoad;
    protected int mFixIncludePointsOnLoad;
    protected int mFixShowMapTextOnLoad;
    protected int mLimitMapMaxSize;
    protected Boolean mMapInfoWindow2DUseNull;
    protected int mMaxMarkerCount;
    protected int mTryRegionChangeEnd;
    private int n;

    /* renamed from: o */
    private int f7150o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;

    public void onDestroy() {
    }

    public ConfigController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.mDoPauseOnRenderByNebula = -1;
        this.mDoRenderLimitRegion = -1;
        this.mFixIncludePointsOnLoad = -1;
        this.mFixShowMapTextOnLoad = -1;
        this.mDoDestroyOnDead = -1;
        this.mDoNotifyRestore = -1;
        this.mLimitMapMaxSize = -1;
        this.mTryRegionChangeEnd = -1;
        this.mDoClusterOnMoveMarker = -1;
        this.mMaxMarkerCount = -1;
        this.mClusterUseAnimCfg = -1;
        this.mFixCompassOnLoad = -1;
        this.f7149a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.f7150o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = -1;
    }

    private String a(String str) {
        return GriverConfig.getConfigWithProcessCache(str, null);
    }

    private JSONObject b(String str) {
        return GriverConfig.getConfigJSONObject(str);
    }

    private JSONArray c(String str) {
        return GriverConfig.getConfigJSONArray(str);
    }

    private boolean a(String str, boolean z) {
        int i;
        JSONObject b = b(str);
        if (b != null) {
            String appId = this.mMapContainer.getAppId();
            i = !TextUtils.isEmpty(appId) ? H5MapUtils.getIntValue(b, appId, -1) : -1;
            if (i == -1) {
                i = H5MapUtils.getIntValue(b, "default", -1);
            }
        } else {
            i = -1;
        }
        return i != -1 ? i == 1 : z;
    }

    public boolean isDoDestroyOnDead() {
        if (this.mDoDestroyOnDead == -1) {
            this.mDoDestroyOnDead = !TextUtils.equals(a("ta_map_do_destroy_on_dead"), "0") ? 1 : 0;
        }
        return this.mDoDestroyOnDead == 1;
    }

    public boolean isFixShowMapTextOnLoad() {
        if (this.mFixShowMapTextOnLoad == -1) {
            this.mFixShowMapTextOnLoad = !TextUtils.equals(a("ta_map_fix_show_text_on_load"), "0") ? 1 : 0;
        }
        return this.mFixShowMapTextOnLoad == 1;
    }

    public boolean isFixIncludePointsOnLoad() {
        if (this.mFixIncludePointsOnLoad == -1) {
            this.mFixIncludePointsOnLoad = !TextUtils.equals(a("ta_map_fix_include_points_on_load"), "0") ? 1 : 0;
        }
        return this.mFixIncludePointsOnLoad == 1;
    }

    public boolean isDoRenderLimitRegion() {
        if (this.mDoRenderLimitRegion == -1) {
            this.mDoRenderLimitRegion = !TextUtils.equals(a("ta_map_render_limit_region"), "0") ? 1 : 0;
        }
        return this.mDoRenderLimitRegion == 1;
    }

    public boolean isLimitMapMaxSize() {
        if (this.mLimitMapMaxSize == -1) {
            this.mLimitMapMaxSize = !TextUtils.equals(a("ta_map_limit_max_size"), "0") ? 1 : 0;
        }
        return this.mLimitMapMaxSize == 1;
    }

    public boolean isDoPauseOnRenderByNebula() {
        if (this.mDoPauseOnRenderByNebula == -1) {
            this.mDoPauseOnRenderByNebula = !TextUtils.equals(a("ta_map_do_pause_by_nebula"), "0") ? 1 : 0;
        }
        return this.mDoPauseOnRenderByNebula == 1;
    }

    public boolean isDoNotifyRestore() {
        if (this.mDoNotifyRestore == -1) {
            this.mDoNotifyRestore = !TextUtils.equals(a("ta_map_notify_restore"), "0") ? 1 : 0;
        }
        return this.mDoNotifyRestore == 1;
    }

    public boolean isMapInfoWindow2DUseNull() {
        if (this.mMapInfoWindow2DUseNull == null) {
            this.mMapInfoWindow2DUseNull = Boolean.valueOf(TextUtils.equals(a("ta_map_info_win_2d_null"), "1"));
        }
        return this.mMapInfoWindow2DUseNull.booleanValue();
    }

    public boolean isTryRegionChangeEnd() {
        if (this.mTryRegionChangeEnd == -1) {
            this.mTryRegionChangeEnd = !TextUtils.equals(a("ta_map_try_region_change_end"), "0") ? 1 : 0;
        }
        return this.mTryRegionChangeEnd == 1;
    }

    public boolean isDoClusterOnMoveMarker() {
        if (this.mDoClusterOnMoveMarker == -1) {
            this.mDoClusterOnMoveMarker = TextUtils.equals(a("ta_map_do_cluster_on_move"), "1") ? 1 : 0;
        }
        return this.mDoClusterOnMoveMarker == 1;
    }

    public int getMaxMarkerCount() {
        JSONObject jSONObject;
        if (this.mMaxMarkerCount == -1) {
            String appId = this.mMapContainer.getAppId();
            if (!TextUtils.isEmpty(appId)) {
                try {
                    JSONObject b = b("amap_marker_limit");
                    if (b != null && (jSONObject = b.getJSONObject(appId)) != null) {
                        int intValue = H5MapUtils.getIntValue(jSONObject, "maxMarker");
                        this.mMaxMarkerCount = intValue;
                        if (intValue > 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(appId);
                            sb.append(" max marker is ");
                            sb.append(this.mMaxMarkerCount);
                            RVLogger.d(H5MapContainer.TAG, sb.toString());
                        }
                    }
                } catch (Exception e) {
                    this.mMaxMarkerCount = 0;
                    RVLogger.e(H5MapContainer.TAG, e);
                    this.mMapContainer.reportController.reportException("ConfigController#getMaxMarkerCount", e.getMessage());
                }
            }
        }
        return this.mMaxMarkerCount;
    }

    public boolean isUseAnimationForClusteredMarkers() {
        if (this.mClusterUseAnimCfg == -1) {
            this.mClusterUseAnimCfg = !TextUtils.equals(a("ta_map_cluster_use_anim"), "0") ? 1 : 0;
        }
        return (this.mMapContainer.is2dMapSdk() || this.mClusterUseAnimCfg == 0) ? false : true;
    }

    public boolean isFixCompassOnLoad() {
        if (this.mFixCompassOnLoad == -1) {
            this.mFixCompassOnLoad = !TextUtils.equals(a("ta_map_fix_compass_on_load"), "0") ? 1 : 0;
        }
        return this.mFixCompassOnLoad == 1;
    }

    public boolean isCustomMapStyleEnabled() {
        if (this.f7149a == -1) {
            this.f7149a = TextUtils.equals(a("ta_map_use_custom_style"), "1") ? 1 : 0;
        }
        return this.f7149a == 1;
    }

    public boolean isRestore2DEnabled() {
        if (this.b == -1) {
            this.b = TextUtils.equals(a("ta_map_restore_2d"), "1") ? 1 : 0;
        }
        return this.b == 1;
    }

    public boolean isGridDistanceCluster() {
        if (this.c == -1) {
            this.c = !TextUtils.equals(a("ta_map_grid_distance_cluster"), "0") ? 1 : 0;
        }
        return this.c == 1;
    }

    public boolean isMapDSLAsync() {
        if (this.d == -1) {
            this.d = !TextUtils.equals(a("ta_map_dsl_async"), "0") ? 1 : 0;
        }
        return this.d == 1;
    }

    public boolean isFixIncludePointsWithLimitRegion() {
        if (this.e == -1) {
            this.e = !TextUtils.equals(a("ta_map_fix_include_points_with_limit_region"), "0") ? 1 : 0;
        }
        return this.e == 1;
    }

    public boolean isMapDSLCacheEnabled() {
        if (this.f == -1) {
            this.f = !TextUtils.equals(a("ta_map_dsl_cache_enable"), "0") ? 1 : 0;
        }
        return this.f == 1;
    }

    public boolean isMapDSLCamelCompat() {
        if (this.g == -1) {
            this.g = TextUtils.equals(a("ta_map_dsl_camel"), "1") ? 1 : 0;
        }
        return this.g == 1;
    }

    public boolean isMapDSLEnabled() {
        if (this.h == -1) {
            this.h = !TextUtils.equals(a("ta_map_dsl_enable"), "0") ? 1 : 0;
        }
        return this.h == 1;
    }

    public boolean isCheckMarkerToken() {
        if (this.i == -1) {
            this.i = !TextUtils.equals(a("ta_map_check_marker_token"), "0") ? 1 : 0;
        }
        return this.i == 1;
    }

    public boolean isMapWebCacheEnabled() {
        if (this.j == -1) {
            this.j = !TextUtils.equals(a("ta_map_web_cache_enable"), "0") ? 1 : 0;
        }
        return this.j == 1;
    }

    public boolean isMapAbroadInBackList() {
        if (this.k == -1) {
            JSONArray c = c("ta_map_abroad_b_list");
            if (c == null) {
                this.k = 0;
            } else {
                String appId = this.mMapContainer.getAppId();
                if (TextUtils.isEmpty(appId)) {
                    this.k = c.contains("all") ? 1 : 0;
                } else {
                    this.k = (c.contains("all") || c.contains(appId)) ? 1 : 0;
                }
            }
        }
        return this.k == 1;
    }

    public boolean isMapAbroadInWhiteList() {
        if (this.l == -1) {
            JSONArray c = c("ta_map_abroad_w_list");
            if (c == null) {
                this.l = 0;
            } else {
                String appId = this.mMapContainer.getAppId();
                if (TextUtils.isEmpty(appId)) {
                    this.l = c.contains("all") ? 1 : 0;
                } else {
                    this.l = (c.contains("all") || c.contains(appId)) ? 1 : 0;
                }
            }
        }
        return this.l == 1;
    }

    public boolean isMapRenderCacheDataObject() {
        if (this.n == -1) {
            this.n = !TextUtils.equals(a("ta_map_render_cache_data_object"), "0") ? 1 : 0;
        }
        return this.n == 1;
    }

    public boolean isCachedMapDataUpdateEnabled() {
        if (this.f7150o == -1) {
            this.f7150o = a("ta_map_enable_cache_data_update", true) ? 1 : 0;
        }
        return this.f7150o == 1;
    }

    public boolean isMapAbroadEnabled() {
        if (this.m == -1) {
            if (this.mMapContainer.configController.isMapAbroadInWhiteList()) {
                this.m = 1;
            } else {
                this.m = !this.mMapContainer.configController.isMapAbroadInBackList();
            }
        }
        return this.m == 1;
    }

    public boolean isNotifyMapLoadingErrorEnabled() {
        if (this.p == -1) {
            JSONArray c = c("ta_map_notify_loading_apps");
            if (c != null) {
                String appId = this.mMapContainer.getAppId();
                if (TextUtils.isEmpty(appId)) {
                    this.p = 0;
                } else {
                    this.p = c.contains(appId) ? 1 : 0;
                }
            } else {
                this.p = 0;
            }
        }
        return this.p == 1;
    }

    public boolean isMapJSAPICallLazyEnabled() {
        if (this.q == -1) {
            this.q = TextUtils.equals(a("ta_map_jsapi_call_lazy"), "1") ? 1 : 0;
        }
        return this.q == 1;
    }

    public boolean isMapDoClusterEnabled() {
        if (this.r == -1) {
            this.r = !TextUtils.equals(a("ta_map_do_cluster"), "0") ? 1 : 0;
        }
        return this.r == 1;
    }

    public boolean isRenderPolylineFast() {
        if (this.s == -1) {
            this.s = a("ta_map_render_polyline_fast", true) ? 1 : 0;
        }
        return this.s == 1;
    }

    public boolean isMapAnimationUseThread() {
        if (this.t == -1) {
            this.t = a("ta_map_anim_use_thread", false) ? 1 : 0;
        }
        return this.t == 1;
    }

    public boolean isMapNotifyEndWhenStop() {
        if (this.u == -1) {
            this.u = a("ta_map_notify_end_when_stop", true) ? 1 : 0;
        }
        return this.u == 1;
    }
}
