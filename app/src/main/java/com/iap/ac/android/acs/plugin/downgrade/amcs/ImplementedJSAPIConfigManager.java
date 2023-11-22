package com.iap.ac.android.acs.plugin.downgrade.amcs;

import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ImplementedJSAPIConfigManager extends BaseDowngradeConfigManager {
    public static final String SECTION_KEY_ACS_JSAPI_ACTION_MAP = "jsapi_intercept_map";
    public static final String SECTION_NAME_ACS_IMPLEMENTED_JSAPI = "acs_implemented_jsapi_intercept_config";
    public static ImplementedJSAPIConfigManager sInstance;

    public static ImplementedJSAPIConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (ImplementedJSAPIConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new ImplementedJSAPIConfigManager();
                }
            }
        }
        return sInstance;
    }

    public JSONObject getImplementedJSAPIConfig() {
        return (JSONObject) getKeyOrDefault(SECTION_KEY_ACS_JSAPI_ACTION_MAP, null);
    }

    public JSONObject getImplementedJSAPIPreviewConfig(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("jsapi_intercept_map-");
        sb.append(str);
        return (JSONObject) getKeyOrDefault(sb.toString(), null);
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.amcs.BaseDowngradeConfigManager
    public String getSectionName() {
        return SECTION_NAME_ACS_IMPLEMENTED_JSAPI;
    }
}
