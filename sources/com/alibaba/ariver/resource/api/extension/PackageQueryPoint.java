package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.util.Set;

/* loaded from: classes6.dex */
public interface PackageQueryPoint extends Extension {
    ResourcePackage createPluginPackage(AppModel appModel, PluginModel pluginModel, ResourceContext resourceContext);

    ResourcePackage getMainPackage(ResourceContext resourceContext);

    Set<ResourcePackage> getResourcePackages(ResourceContext resourceContext);
}
