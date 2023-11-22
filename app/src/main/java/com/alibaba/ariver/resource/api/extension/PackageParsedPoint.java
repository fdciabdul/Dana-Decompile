package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppModel;

/* loaded from: classes6.dex */
public interface PackageParsedPoint extends Extension {
    void onResourceParsed(AppModel appModel, ResourcePackage resourcePackage);
}
