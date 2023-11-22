package com.alibaba.ariver.app.api.point.page;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* loaded from: classes2.dex */
public interface PageEnterPoint extends Extension {
    @ThreadType(ExecutorType.UI)
    void onPageEnter(Page page);
}
