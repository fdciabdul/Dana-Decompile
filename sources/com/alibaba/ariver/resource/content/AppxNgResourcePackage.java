package com.alibaba.ariver.resource.content;

import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.runtime.ContentProviderImpl;

/* loaded from: classes6.dex */
public class AppxNgResourcePackage extends NormalResourcePackage {
    public static final String APPX_NG_RENDER_JS_URL = "https://appx-ng/af-appx.min.js";
    public static final String APPX_NG_WORKER_JS_URL = "https://appx-ng/af-appx.worker.min.js";

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean needWaitForSetup() {
        return true;
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    protected boolean needWaitSetupWhenGet() {
        return true;
    }

    public AppxNgResourcePackage(ResourceContext resourceContext) {
        super("68687209", resourceContext);
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(ResourceQuery resourceQuery) {
        Resource resource = super.get(resourceQuery);
        if (resourceQuery.pureUrl.startsWith(ContentProviderImpl.APPX_NG_TINY_RES_HOST) && resource != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("appx-ng get url\t");
            sb.append(resourceQuery.pureUrl);
            sb.append("\t ");
            sb.append(version());
            RVLogger.d("AppxNgResourcePackage", sb.toString());
        }
        return resource;
    }

    @Override // com.alibaba.ariver.resource.content.NormalResourcePackage, com.alibaba.ariver.resource.content.BaseResourcePackage
    protected boolean canHotUpdate(String str) {
        if (count() == 0 || this.mSetupLock.getCount() == 1) {
            RVLogger.d(getLogTag(), "canHotUpdate true because no content || mSetupLock.count() == 1");
            return true;
        }
        return false;
    }
}
