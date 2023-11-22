package com.alipay.plus.android.ab.sdk.monitor;

import com.alipay.iap.android.common.log.MonitorWrapper;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class AbTestingMonitor {
    public static final String EVENT_BIZ_TYPE = "AMCS-AB-TESTING";

    /* loaded from: classes7.dex */
    public static class Events {
        public static final String AB_FETCH_FAILURE = "ab_update_failure";
        public static final String AB_FETCH_START = "ab_update_start";
        public static final String AB_FETCH_SUCCESS = "ab_update_success";
        public static final String AB_INITIALIZED = "ab_initialized";
        public static final String AB_SYNC_GETDATA = "sync_get_ab_data";
    }

    /* loaded from: classes7.dex */
    public static class IAPLogMonitor extends AbTestingMonitor {
        @Override // com.alipay.plus.android.ab.sdk.monitor.AbTestingMonitor
        protected void behavior(String str, String str2, Map<String, String> map) {
            MonitorWrapper.behaviour(str, str2, map);
        }
    }

    protected abstract void behavior(String str, String str2, Map<String, String> map);

    public final void behavior(String str, Map<String, String> map) {
        behavior(str, EVENT_BIZ_TYPE, map);
    }
}
