package com.alibaba.ariver.resource.api;

import com.alibaba.ariver.resource.api.models.PluginModel;

/* loaded from: classes6.dex */
public interface PluginDownloadCallback {
    void onFailed(int i, String str);

    void onSingleFailed(PluginModel pluginModel, int i, String str);

    void onSuccess();
}
