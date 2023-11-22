package com.alibaba.ariver.resource.api.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.PluginInstallCallback;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.util.List;

/* loaded from: classes2.dex */
public interface RVPluginResourceManager extends Proxiable {
    void clearPluginUpdateTime(String str);

    void downloadPlugins(AppModel appModel, List<PluginModel> list, PluginDownloadCallback pluginDownloadCallback);

    String getInstallPath(AppModel appModel, PluginModel pluginModel);

    String getPluginLastUpdateTime(String str);

    PluginModel getRequiredPlugin(String str, String str2);

    void installPlugins(AppModel appModel, List<PluginModel> list, PluginInstallCallback pluginInstallCallback);

    boolean isAvailable(AppModel appModel, List<PluginModel> list);

    void refreshPluginUpdateTime(String str, String str2);

    void savePluginModelList(List<PluginModel> list);
}
