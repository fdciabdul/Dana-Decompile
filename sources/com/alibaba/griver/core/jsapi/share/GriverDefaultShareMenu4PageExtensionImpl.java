package com.alibaba.griver.core.jsapi.share;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.api.ui.share.BaseShareItem;
import com.alibaba.griver.api.ui.share.GriverShareMenu4PageExtension;
import com.alibaba.griver.api.ui.share.GriverShareMenuExtension;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverDefaultShareMenu4PageExtensionImpl implements GriverShareMenu4PageExtension {
    @Override // com.alibaba.griver.api.ui.share.GriverShareMenu4PageExtension
    public List<BaseShareItem> getShareItems(Page page) {
        return ((GriverShareMenuExtension) RVProxy.get(GriverShareMenuExtension.class)).getShareItems();
    }
}
