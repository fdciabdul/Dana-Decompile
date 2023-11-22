package com.alibaba.ariver.app.api.service;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes2.dex */
public interface TinyAppInnerProxy extends Proxiable {
    boolean isEmbedWebViewInnerAppBlack(Page page);

    boolean isInner(App app);
}
