package com.alibaba.griver.base.resource.extensions;

import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.content.PluginResourcePackage;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverConfig;

/* loaded from: classes6.dex */
public class GriverPluginResourcePackage extends PluginResourcePackage {
    public GriverPluginResourcePackage(AppModel appModel, PluginModel pluginModel, ResourceContext resourceContext) {
        super(appModel, pluginModel, resourceContext);
    }

    @Override // com.alibaba.ariver.resource.content.PluginResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        super.beforeParsePackage(parseContext);
        parseContext.onlineHost = this.mOnlineHost;
        if ("yes".equalsIgnoreCase(GriverConfig.getConfig(GriverConfigConstants.KEY_SHOULD_VERIFY_APP, "YES"))) {
            parseContext.needVerify = true;
        } else {
            parseContext.needVerify = false;
        }
    }
}
