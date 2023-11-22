package com.iap.ac.config.lite.delegate;

import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.config.lite.common.AmcsConstants;
import com.iap.ac.config.lite.d.e;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class ConfigMonitor {
    public static final String EVENT_BIZ_TYPE = "AMCS-LITE";

    /* renamed from: a  reason: collision with root package name */
    private static final String f7633a = e.b("ConfigMonitor");
    String bizCode;

    /* loaded from: classes3.dex */
    public static class ACLogMonitor extends ConfigMonitor {
        @Override // com.iap.ac.config.lite.delegate.ConfigMonitor
        protected void behavior(String str, String str2, Map<String, String> map) {
            LogEvent logEvent = new LogEvent(str, map);
            logEvent.bizCode = str2;
            ACLog.d(ConfigMonitor.f7633a, String.format("Monitor event [%s] with bizCode [%s]", str, this.bizCode));
            if (TextUtils.isEmpty(this.bizCode)) {
                ACMonitor.getInstance(AmcsConstants.BIZ_CODE_AMCSLITE_FOR_MULTI_INSTANCE).logEvent(logEvent);
            } else {
                ACMonitor.getInstance(this.bizCode).logEvent(logEvent);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class Events {
        public static final String CONFIG_BY_KEYS_UPDATE = "config_by_keys_update";
        public static final String CONFIG_DECRYPT_FAIL = "config_decrypt_fail";
        public static final String CONFIG_DNS_CHECK_FAILED = "config_dns_check_failed";
        public static final String CONFIG_INITIALIZED = "config_initialized";
        public static final String CONFIG_MERGE_RESULT = "config_merge_result";
        public static final String CONFIG_RATE_LIMITED = "config_rate_limited";
        public static final String CONFIG_TOTAL_UPDATE = "config_total_update";
        public static final String CONFIG_UPDATE = "config_update";
        public static final String CONFIG_UPDATE_BY_DNS = "config_update_by_dns";
        public static final String CONFIG_UPDATE_RETRY = "config_update_retry";
    }

    /* loaded from: classes8.dex */
    public static class Keywords {
        public static final String KEY_WORD_IS_RETRY = "isRetry";
        public static final String KEY_WORD_NEED_ENCRYPT = "needEncrypt";
    }

    /* loaded from: classes8.dex */
    public static class MockMonitor extends ConfigMonitor {
        private static final String b = e.b("MockMonitor");

        @Override // com.iap.ac.config.lite.delegate.ConfigMonitor
        public void behavior(String str, String str2, Map<String, String> map) {
            ACLog.d(b, String.format("behavior: event = %s, bizType = %s, extParams = %s", str, str2, String.valueOf(map)));
        }
    }

    protected abstract void behavior(String str, String str2, Map<String, String> map);

    public final void behavior(String str, Map<String, String> map) {
        behavior(str, "AMCS-LITE", map);
    }

    public void setBizCode(String str) {
        this.bizCode = str;
    }
}
