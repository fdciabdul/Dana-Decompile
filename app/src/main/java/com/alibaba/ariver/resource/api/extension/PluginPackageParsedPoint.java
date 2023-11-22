package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;

/* loaded from: classes6.dex */
public interface PluginPackageParsedPoint extends Extension {
    void onPluginParsed(AppModel appModel, PluginModel pluginModel, ResourcePackage resourcePackage);
}
