package com.alibaba.griver.base.resource.plugin.cache;

import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.griver.base.resource.offline.GriverOfflinePkgManager;
import com.alibaba.griver.base.resource.plugin.storage.GriverPluginInfoStorage;
import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class GriverPluginCacheManager {
    public static volatile GriverPluginCacheManager INSTANCE;

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, GriverPluginCache> f6368a = new ConcurrentHashMap<>();

    public static GriverPluginCacheManager getInstance() {
        if (INSTANCE == null) {
            synchronized (GriverPluginCacheManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GriverPluginCacheManager();
                }
            }
        }
        return INSTANCE;
    }

    public PluginModel selectPluginModel(String str, String str2) {
        GriverPluginCache griverPluginCache = f6368a.get(str);
        if ("*".equals(str2)) {
            PluginModel highestPlugin = getHighestPlugin(str);
            return highestPlugin == null ? GriverPluginInfoStorage.queryHighestPluginInfo(str) : highestPlugin;
        } else if (griverPluginCache != null) {
            return griverPluginCache.getPluginModelByVersion(str2);
        } else {
            if (System.currentTimeMillis() - GriverPluginInfoStorage.queryLastRefreshTimestamp(str, str2) > GriverOfflinePkgManager.getInstance().getCleanTime()) {
                return null;
            }
            return GriverPluginInfoStorage.queryPluginInfo(str, str2);
        }
    }

    public void savePluginModel(String str, String str2, PluginModel pluginModel) {
        GriverPluginCache griverPluginCache = f6368a.get(str);
        if (griverPluginCache == null) {
            griverPluginCache = new GriverPluginCache();
        }
        griverPluginCache.savePluginModel(str2, pluginModel);
        f6368a.put(str, griverPluginCache);
        GriverPluginInfoStorage.savePluginInfo(pluginModel);
    }

    public PluginModel getHighestPlugin(String str) {
        GriverPluginCache griverPluginCache = f6368a.get(str);
        if (griverPluginCache == null) {
            return null;
        }
        return griverPluginCache.getHighestVersionPlugin();
    }
}
