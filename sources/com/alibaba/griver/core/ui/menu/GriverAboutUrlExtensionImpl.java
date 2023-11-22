package com.alibaba.griver.core.ui.menu;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.open.GriverAboutUrlExtension;
import com.alibaba.griver.base.common.config.GriverInnerConfig;

/* loaded from: classes6.dex */
public class GriverAboutUrlExtensionImpl implements GriverAboutUrlExtension {
    @Override // com.alibaba.griver.api.open.GriverAboutUrlExtension
    public String getAboutUrl(Page page) {
        return GriverInnerConfig.getConfig(GriverConfigConstants.KEY_ABOUT_PAGE_URL);
    }
}
