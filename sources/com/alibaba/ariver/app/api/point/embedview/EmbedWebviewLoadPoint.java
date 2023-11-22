package com.alibaba.ariver.app.api.point.embedview;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import java.util.Map;

/* loaded from: classes2.dex */
public interface EmbedWebviewLoadPoint extends Extension {
    @ThreadType(ExecutorType.SYNC)
    void onPageLoadError(Page page, Map<String, Object> map);

    @ThreadType(ExecutorType.SYNC)
    void onPageLoaded(Page page, Map<String, Object> map);
}
