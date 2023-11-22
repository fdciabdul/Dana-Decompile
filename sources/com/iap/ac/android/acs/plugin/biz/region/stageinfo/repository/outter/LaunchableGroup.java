package com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class LaunchableGroup {
    public String code;
    public String displayName;
    public List<LaunchableGroup> launchableGroups;
    public List<LaunchableItem> launchableItems;
    public Map<String, Object> layoutConfig;

    public Map<String, Object> getLayoutConfig() {
        return this.layoutConfig;
    }

    public void setLayoutConfig(Map<String, Object> map) {
        this.layoutConfig = map;
    }
}
