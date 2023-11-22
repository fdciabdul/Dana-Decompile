package com.alibaba.ariver.resource.api.appinfo;

/* loaded from: classes6.dex */
public interface IAppUpdater {
    void updateApp(UpdateAppParam updateAppParam, UpdateAppCallback updateAppCallback);

    void updatePlugin(UpdatePluginParam updatePluginParam, UpdatePluginCallback updatePluginCallback);
}
