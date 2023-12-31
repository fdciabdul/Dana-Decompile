package com.alibaba.ariver.app.api.point.page;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.SimpleSorter;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* loaded from: classes2.dex */
public interface PageExitPoint extends Extension, SimpleSorter {
    @ThreadType(ExecutorType.UI)
    void onPageExit(Page page);
}
