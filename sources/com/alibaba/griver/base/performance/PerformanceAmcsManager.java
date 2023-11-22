package com.alibaba.griver.base.performance;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.performance.jsapi.PerformanceJsApiTimeOutConfig;
import com.alibaba.griver.base.performance.network.PerformanceNetworkTimeConfig;
import com.iap.ac.android.common.json.JsonUtils;
import java.util.List;

/* loaded from: classes6.dex */
public class PerformanceAmcsManager {

    /* renamed from: a  reason: collision with root package name */
    private static PerformanceAmcsManager f6326a = new PerformanceAmcsManager();
    private PerformanceJsApiTimeOutConfig b;
    private PerformanceNetworkTimeConfig c;
    private JSONObject d;
    private List e;

    private PerformanceAmcsManager() {
    }

    public static PerformanceAmcsManager getInstance() {
        return f6326a;
    }

    public PerformanceJsApiTimeOutConfig getPerformanceJsApiTimeOutConfig() {
        if (this.b == null) {
            String config = GriverInnerConfig.getConfig("griver_mini_program_performance_jsapi_timeout_config", "{\n\t\"timeThreshold\": 500\n}");
            if (!TextUtils.isEmpty(config)) {
                this.b = (PerformanceJsApiTimeOutConfig) JsonUtils.fromJson(config, PerformanceJsApiTimeOutConfig.class);
            }
        }
        return this.b;
    }

    public PerformanceNetworkTimeConfig getPerformanceNetworkTimeOutConfig() {
        if (this.c == null) {
            String config = GriverInnerConfig.getConfig("griver_mini_program_performance_network_config", "");
            if (!TextUtils.isEmpty(config)) {
                this.c = new PerformanceNetworkTimeConfig(config);
            }
        }
        return this.c;
    }

    public boolean canMonitorNetwork() {
        if (this.d == null) {
            String config = GriverInnerConfig.getConfig("griver_mini_program_performance_switch", "{\nenable_jsapi:false,\nenable_network:false,\nenable_setdata:false,\nenable_network_7:false\n}");
            if (!TextUtils.isEmpty(config)) {
                this.d = JSONObject.parseObject(config);
            }
        }
        JSONObject jSONObject = this.d;
        if (jSONObject == null || !jSONObject.containsKey("enable_network")) {
            return false;
        }
        return this.d.getBoolean("enable_network").booleanValue();
    }

    public boolean canMonitorJSAPI() {
        if (this.d == null) {
            String config = GriverInnerConfig.getConfig("griver_mini_program_performance_switch", "{\nenable_jsapi:false,\nenable_network:false,\nenable_setdata:false,\nenable_network_7:false\n}");
            if (!TextUtils.isEmpty(config)) {
                this.d = JSONObject.parseObject(config);
            }
        }
        JSONObject jSONObject = this.d;
        if (jSONObject == null || !jSONObject.containsKey("enable_jsapi")) {
            return false;
        }
        return this.d.getBoolean("enable_jsapi").booleanValue();
    }

    public boolean canMonitorSetData() {
        if (this.d == null) {
            String config = GriverInnerConfig.getConfig("griver_mini_program_performance_switch", "{\nenable_jsapi:false,\nenable_network:false,\nenable_setdata:false,\nenable_network_7:false\n}");
            if (!TextUtils.isEmpty(config)) {
                this.d = JSONObject.parseObject(config);
            }
        }
        JSONObject jSONObject = this.d;
        if (jSONObject == null || !jSONObject.containsKey("enable_setdata")) {
            return false;
        }
        return this.d.getBoolean("enable_setdata").booleanValue();
    }

    public boolean canMonitorNetWorker7() {
        if (this.d == null) {
            String config = GriverInnerConfig.getConfig("griver_mini_program_performance_switch", "{\nenable_jsapi:false,\nenable_network:false,\nenable_setdata:false,\nenable_network_7:false\n}");
            if (!TextUtils.isEmpty(config)) {
                this.d = JSONObject.parseObject(config);
            }
        }
        JSONObject jSONObject = this.d;
        if (jSONObject == null || !jSONObject.containsKey("enable_network_7")) {
            return false;
        }
        return this.d.getBoolean("enable_network_7").booleanValue();
    }

    public List<String> getApiBlackList() {
        if (this.e == null) {
            String config = GriverInnerConfig.getConfig("griver_mini_program_performance_jsapi_blacklist_config");
            if (!TextUtils.isEmpty(config)) {
                this.e = (List) JsonUtils.fromJson(config, List.class);
            }
        }
        return this.e;
    }
}
