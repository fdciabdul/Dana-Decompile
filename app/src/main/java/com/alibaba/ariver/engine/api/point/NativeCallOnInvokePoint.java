package com.alibaba.ariver.engine.api.point;

import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* loaded from: classes2.dex */
public interface NativeCallOnInvokePoint extends Extension {
    @ThreadType(ExecutorType.IDLE)
    void onInvoke(NativeCallContext nativeCallContext);
}
