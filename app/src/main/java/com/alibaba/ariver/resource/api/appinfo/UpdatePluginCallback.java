package com.alibaba.ariver.resource.api.appinfo;

import com.alibaba.ariver.resource.api.models.PluginModel;

/* loaded from: classes6.dex */
public interface UpdatePluginCallback {
    void onError(UpdateAppException updateAppException);

    void onSuccess(PluginModel pluginModel);
}
