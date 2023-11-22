package com.iap.ac.android.acs.plugin.downgrade.amcs;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JSAPICompatibilityConfigManager extends BaseDowngradeConfigManager {
    public static final String INNER_BIZ_KEY_CONFIG_PREVIEW_ENABLED = "config_preview_enabled";
    public static final String INNER_BIZ_KEY_JSAPI_COMPATIBILITY_ENABLED = "jsapi_compatibility_enabled";
    public static final String INNER_BIZ_KEY_ONLY_INTERCEPT_A_PLUS_JSAPI = "only_intercept_a_plus_jsapi";
    public static final String KEY_IN_SECTION_JSAPI_COMPATIBILITY_CONFIG = "jsapi_compatibility_config";
    public static final String SECTION_NAME_JSAPI_DOWNGRADE_CONFIG = "DowngradeConfig";
    public static JSAPICompatibilityConfigManager sInstance;

    public static JSAPICompatibilityConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (JSAPICompatibilityConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new JSAPICompatibilityConfigManager();
                }
            }
        }
        return sInstance;
    }

    private JSONObject getJSAPICompatibilityConfig() {
        return (JSONObject) getKeyOrDefault(KEY_IN_SECTION_JSAPI_COMPATIBILITY_CONFIG, new JSONObject());
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.amcs.BaseDowngradeConfigManager
    public String getSectionName() {
        return SECTION_NAME_JSAPI_DOWNGRADE_CONFIG;
    }

    public boolean isConfigPreviewEnabled() {
        return getJSAPICompatibilityConfig().optBoolean(INNER_BIZ_KEY_CONFIG_PREVIEW_ENABLED, false);
    }

    public boolean isJSAPICompatibilityEnabled() {
        return getJSAPICompatibilityConfig().optBoolean(INNER_BIZ_KEY_JSAPI_COMPATIBILITY_ENABLED, true);
    }

    public boolean isOnlyInterceptAPlusMiniProgramJSAPI() {
        return getJSAPICompatibilityConfig().optBoolean(INNER_BIZ_KEY_ONLY_INTERCEPT_A_PLUS_JSAPI, false);
    }
}
