package com.alibaba.griver.base.resource.preset;

import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverRVResourcePresetImpl implements RVResourcePresetProxy {
    @Override // com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy
    public Map<String, AppModel> getPresetAppInfos() {
        Map<String, AppModel> presetAppInfos = GriverResourcePreset.getPresetAppInfos();
        if (presetAppInfos == null || presetAppInfos.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, AppModel> entry : presetAppInfos.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy
    public Map<String, RVResourcePresetProxy.PresetPackage> getPresetPackage() {
        return GriverResourcePreset.getPresetPackage();
    }
}
