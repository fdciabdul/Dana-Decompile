package com.alibaba.ariver.app.api.point.biz;

import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* loaded from: classes2.dex */
public interface DisclaimerPoint extends Extension {
    @ThreadType(ExecutorType.UI)
    void showDisclaimer(int i);
}
