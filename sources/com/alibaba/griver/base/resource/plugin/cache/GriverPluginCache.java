package com.alibaba.griver.base.resource.plugin.cache;

import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.PluginModel;
import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class GriverPluginCache {

    /* renamed from: a  reason: collision with root package name */
    private static long f6367a = 86400000;
    private ConcurrentHashMap<String, PluginModel> b = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> c = new ConcurrentHashMap<>();

    public PluginModel getPluginModelByVersion(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Long l = this.c.get(str);
        if (l != null && currentTimeMillis - l.longValue() < f6367a) {
            return this.b.get(str);
        }
        return null;
    }

    public void savePluginModel(String str, PluginModel pluginModel) {
        this.b.put(str, pluginModel);
        this.c.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public PluginModel getHighestVersionPlugin() {
        if (this.b.isEmpty()) {
            return null;
        }
        String str = "0";
        for (String str2 : this.b.keySet()) {
            if (RVResourceUtils.compareVersion(str2, str) == 1) {
                str = str2;
            }
        }
        return this.b.get(str);
    }
}
