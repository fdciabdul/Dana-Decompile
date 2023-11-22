package com.iap.ac.android.acs.plugin.downgrade.router.amcs;

import com.iap.ac.android.acs.plugin.downgrade.amcs.BaseDowngradeConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.amcs.StartAppConfigManager;

/* loaded from: classes3.dex */
public class APDisableJSAPIConfigManager extends BaseDowngradeConfigManager {
    public static final String AP_DISABLED_JSAPI_STATUS = "ap_disabled_jsapi_status";
    public static final String SECTION_AC_CONFIG = "ACConfig";
    public static APDisableJSAPIConfigManager sInstance;

    public static APDisableJSAPIConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (StartAppConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new APDisableJSAPIConfigManager();
                }
            }
        }
        return sInstance;
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.amcs.BaseDowngradeConfigManager
    public String getSectionName() {
        return "ACConfig";
    }

    public boolean toggleAPIDisableJSAPI() {
        return ((Boolean) getKeyOrDefault("ap_disabled_jsapi_status", Boolean.TRUE)).booleanValue();
    }
}
