package com.alibaba.ariver.app.api.point.app;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.SimpleSorter;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* loaded from: classes2.dex */
public interface AppLeaveHintPoint extends Extension, SimpleSorter {
    @ThreadType(ExecutorType.IO)
    void onAppLeaveHint(App app);
}
