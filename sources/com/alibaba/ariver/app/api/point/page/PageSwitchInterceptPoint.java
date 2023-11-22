package com.alibaba.ariver.app.api.point.page;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* loaded from: classes2.dex */
public interface PageSwitchInterceptPoint extends Extension {
    @ThreadType(ExecutorType.SYNC)
    String interceptSwitchPage(App app, String str, Bundle bundle);
}
