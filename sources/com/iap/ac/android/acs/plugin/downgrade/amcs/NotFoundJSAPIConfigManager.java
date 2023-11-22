package com.iap.ac.android.acs.plugin.downgrade.amcs;

import org.json.JSONObject;

/* loaded from: classes8.dex */
public class NotFoundJSAPIConfigManager extends BaseDowngradeConfigManager {
    public static final String SECTION_KEY_ACS_JSAPI_ACTION_MAP = "jsapi_downgrade_map";
    public static final String SECTION_NAME_ACS_NOT_FOUND_JSAPI = "acs_not_found_jsapi_downgrade_config";
    public static NotFoundJSAPIConfigManager sInstance;

    public static NotFoundJSAPIConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (NotFoundJSAPIConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new NotFoundJSAPIConfigManager();
                }
            }
        }
        return sInstance;
    }

    public JSONObject getNotFoundJSAPIConfig() {
        return (JSONObject) getKeyOrDefault(SECTION_KEY_ACS_JSAPI_ACTION_MAP, null);
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.amcs.BaseDowngradeConfigManager
    public String getSectionName() {
        return SECTION_NAME_ACS_NOT_FOUND_JSAPI;
    }
}
