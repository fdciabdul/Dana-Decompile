package com.alibaba.griver.base.resource.plugin.storage;

import java.util.List;

/* loaded from: classes6.dex */
public interface GriverPluginStorageProxy {
    boolean deletePluginInfo(PluginDao pluginDao);

    boolean deletePluginInfoById(String str);

    boolean insertOrUpdateInfo(PluginDao pluginDao);

    boolean insertOrUpdateInfo(List<PluginDao> list);

    List<PluginDao> selectAllPluginInfo(String str);

    List<PluginDao> selectAllPluginInfos();

    PluginDao selectPluginInfo(String str, String str2);

    PluginDao selectPluginInfoWithHighestVersion(String str);

    boolean updateInfo(PluginDao pluginDao);
}
