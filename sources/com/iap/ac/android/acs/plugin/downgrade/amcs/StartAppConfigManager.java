package com.iap.ac.android.acs.plugin.downgrade.amcs;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class StartAppConfigManager extends BaseDowngradeConfigManager {
    public static final String SECTION_KEY_ACS_APP_MAP = "app_map";
    public static final String SECTION_NAME_ACS_START_APP = "acs_start_app";
    public static StartAppConfigManager sInstance;

    public static StartAppConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (StartAppConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new StartAppConfigManager();
                }
            }
        }
        return sInstance;
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.amcs.BaseDowngradeConfigManager
    public String getSectionName() {
        return SECTION_NAME_ACS_START_APP;
    }

    public JSONObject getStartAppMap() {
        return (JSONObject) getKeyOrDefault(SECTION_KEY_ACS_APP_MAP, null);
    }
}
