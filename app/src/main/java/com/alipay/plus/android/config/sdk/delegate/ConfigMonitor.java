package com.alipay.plus.android.config.sdk.delegate;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.log.MonitorWrapper;
import com.alipay.plus.android.config.sdk.a.e;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class ConfigMonitor {
    public static final String EVENT_BIZ_TYPE = "AMCS-Config";

    /* loaded from: classes7.dex */
    public static class Events {
        public static final String CONFIG_BY_KEYS_UPDATE_FAILURE = "config_by_keys_update_failure";
        public static final String CONFIG_BY_KEYS_UPDATE_START = "config_by_keys_update_start";
        public static final String CONFIG_BY_KEYS_UPDATE_SUCCESS = "config_by_keys_update_success";
        public static final String CONFIG_CDN_UPDATE_FAILURE = "config_cdn_update_failure";
        public static final String CONFIG_CDN_UPDATE_START = "config_cdn_update_start";
        public static final String CONFIG_CDN_UPDATE_SUCCESS = "config_cdn_update_success";
        public static final String CONFIG_FETCH_LITE_APPS_FAILURE = "config_fetch_lite_apps_failure";
        public static final String CONFIG_FETCH_LITE_APPS_START = "config_fetch_lite_apps_start";
        public static final String CONFIG_FETCH_LITE_APPS_SUCCESS = "config_fetch_lite_apps_success";
        public static final String CONFIG_INITIALIZED = "config_initialized";
        public static final String CONFIG_MERGE_RESULT = "config_merge_result";
        public static final String CONFIG_RATE_LIMITED = "config_rate_limited";
        public static final String CONFIG_SYNC_GETDATA = "sync_getdata";
        public static final String CONFIG_TOTAL_UPDATE_START = "config_total_update_start";
        public static final String CONFIG_TOTAL_UPDATE_SUCCESS = "config_total_update_success";
        public static final String CONFIG_UPDATE_FAILURE = "config_update_failure";
        public static final String CONFIG_UPDATE_RETRY = "config_update_retry";
        public static final String CONFIG_UPDATE_START = "config_update_start";
        public static final String CONFIG_UPDATE_SUCCESS = "config_update_success";
    }

    /* loaded from: classes7.dex */
    public static class IAPLogMonitor extends ConfigMonitor {
        @Override // com.alipay.plus.android.config.sdk.delegate.ConfigMonitor
        protected void behavior(String str, String str2, Map<String, String> map) {
            MonitorWrapper.behaviour(str, str2, map);
        }
    }

    /* loaded from: classes7.dex */
    public static class MockMonitor extends ConfigMonitor {

        /* renamed from: a  reason: collision with root package name */
        private static final String f7368a = e.a("MockMonitor");

        @Override // com.alipay.plus.android.config.sdk.delegate.ConfigMonitor
        public void behavior(String str, String str2, Map<String, String> map) {
            LoggerWrapper.d(f7368a, String.format("behavior: event = %s, bizType = %s, extParams = %s", str, str2, String.valueOf(map)));
        }
    }

    protected abstract void behavior(String str, String str2, Map<String, String> map);

    public final void behavior(String str, Map<String, String> map) {
        behavior(str, EVENT_BIZ_TYPE, map);
    }
}
