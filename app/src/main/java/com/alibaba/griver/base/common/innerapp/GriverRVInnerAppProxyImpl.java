package com.alibaba.griver.base.common.innerapp;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class GriverRVInnerAppProxyImpl implements TinyAppInnerProxy {
    @Override // com.alibaba.ariver.app.api.service.TinyAppInnerProxy
    public boolean isEmbedWebViewInnerAppBlack(Page page) {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.service.TinyAppInnerProxy
    public boolean isInner(App app) {
        if (app == null) {
            GriverLogger.w("GriverRVInnerAppProxyImpl", "app is null, return false directly", null);
            return false;
        }
        return GriverInnerAppUtil.isInnerApp(app);
    }
}
