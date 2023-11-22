package com.iap.ac.android.acs.plugin.downgrade.amcs;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NavigateSceneConfigManager extends BaseDowngradeConfigManager {
    public static final String SECTION_ACS_NAVIGATE_SCENE = "acs_navigate_scene";
    public static final String SECTION_KEY_BEFORE_ACTION = "before_actions";
    public static final String SECTION_KEY_FAILURE_ACTION = "failure_actions";
    public static final String SECTION_KEY_SCENE_SCHEME_MAP = "scene_scheme_map";
    public static NavigateSceneConfigManager sInstance;

    public static NavigateSceneConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (StartAppConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new NavigateSceneConfigManager();
                }
            }
        }
        return sInstance;
    }

    public JSONObject getBeforeAction() {
        return (JSONObject) getKeyOrDefault(SECTION_KEY_BEFORE_ACTION, null);
    }

    public JSONObject getFailureAction() {
        return (JSONObject) getKeyOrDefault(SECTION_KEY_FAILURE_ACTION, null);
    }

    public JSONObject getSceneSchemeMap() {
        return (JSONObject) getKeyOrDefault(SECTION_KEY_SCENE_SCHEME_MAP, null);
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.amcs.BaseDowngradeConfigManager
    public String getSectionName() {
        return SECTION_ACS_NAVIGATE_SCENE;
    }
}
