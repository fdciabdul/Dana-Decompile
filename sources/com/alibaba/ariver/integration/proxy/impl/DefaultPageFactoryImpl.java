package com.alibaba.ariver.integration.proxy.impl;

import android.os.Bundle;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.proxy.RVPageFactory;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;

/* loaded from: classes6.dex */
public class DefaultPageFactoryImpl implements RVPageFactory {
    @Override // com.alibaba.ariver.app.proxy.RVPageFactory
    public PageNode createPage(App app, String str, Bundle bundle, Bundle bundle2) {
        return new PageNode(app, str, BundleUtils.clone(bundle), BundleUtils.clone(bundle2));
    }
}
