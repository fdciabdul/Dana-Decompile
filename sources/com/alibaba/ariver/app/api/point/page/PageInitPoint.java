package com.alibaba.ariver.app.api.point.page;

import android.os.Bundle;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* loaded from: classes2.dex */
public interface PageInitPoint extends Extension {
    @ThreadType(ExecutorType.SYNC)
    void onPageInit(String str, Bundle bundle, Bundle bundle2);
}
