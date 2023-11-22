package com.alibaba.ariver.app.api.point.page;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes3.dex */
public interface PageEnterInterceptPoint extends Extension {
    boolean interceptLoadMainDoc(Page page, LoadParams loadParams);
}
