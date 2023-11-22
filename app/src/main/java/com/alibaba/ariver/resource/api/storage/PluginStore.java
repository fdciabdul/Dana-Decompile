package com.alibaba.ariver.resource.api.storage;

import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class PluginStore {
    private final Map<String, PluginModel> mStaticPluginModelMap = new HashMap();
    private final Map<String, PluginModel> mDynamicPluginModelMap = new HashMap();

    public void batchPutStaticPluginModel(AppModel appModel) {
        if (appModel == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getPlugins() == null) {
            return;
        }
        Iterator<PluginModel> it = appModel.getAppInfoModel().getPlugins().iterator();
        while (it.hasNext()) {
            putStaticPluginModel(it.next());
        }
    }

    public void putStaticPluginModel(PluginModel pluginModel) {
        this.mStaticPluginModelMap.put(pluginModel.getAppId(), pluginModel);
    }

    public void putDynamicPluginModel(PluginModel pluginModel) {
        this.mDynamicPluginModelMap.put(pluginModel.getAppId(), pluginModel);
    }

    public Map<String, PluginModel> getAllPlugins() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.mStaticPluginModelMap);
        hashMap.putAll(this.mDynamicPluginModelMap);
        return hashMap;
    }

    public PluginModel getPluginModel(String str) {
        PluginModel pluginModel = this.mStaticPluginModelMap.get(str);
        return pluginModel != null ? pluginModel : this.mDynamicPluginModelMap.get(str);
    }

    public Map<String, PluginModel> getStaticPluginModelMap() {
        return this.mStaticPluginModelMap;
    }

    public Map<String, PluginModel> getDynamicPluginModelMap() {
        return this.mDynamicPluginModelMap;
    }
}
