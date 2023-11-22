package com.alibaba.ariver.app.api.point.error;

import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* loaded from: classes2.dex */
public interface WebviewExceptionPoint extends Extension {
    @ThreadType(ExecutorType.SYNC)
    String populateErrorPage(String str, int i, String str2);
}
