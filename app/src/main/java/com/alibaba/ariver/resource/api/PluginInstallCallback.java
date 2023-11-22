package com.alibaba.ariver.resource.api;

import android.util.Pair;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.util.List;

/* loaded from: classes6.dex */
public interface PluginInstallCallback {
    void onFailed(int i, String str);

    void onSingleFailed(PluginModel pluginModel, int i, String str);

    void onSuccess(List<Pair<PluginModel, String>> list);
}
