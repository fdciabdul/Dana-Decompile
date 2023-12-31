package com.alibaba.ariver.engine.api.point;

import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* loaded from: classes2.dex */
public interface JsErrorInterceptPoint extends Extension {
    @ThreadType(ExecutorType.NORMAL)
    void onJsEngineErrorIntercept(String str, String str2);

    @ThreadType(ExecutorType.NORMAL)
    void onWorkerErrorIntercept(String str, String str2);
}
