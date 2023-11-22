package com.alibaba.ariver.app.api.point.app;

import android.os.Bundle;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;

/* loaded from: classes2.dex */
public interface AppLoadPoint extends Extension {

    /* loaded from: classes2.dex */
    public interface LoadResultCallback {
        void onResult(AppLoadResult appLoadResult);
    }

    @ThreadType(transSyncThreadNames = {RVScheduleType.BIZ_SPECIFIC, RVScheduleType.BIZ_SPECIFIC_SCHEDULED, RVScheduleType.URGENT, RVScheduleType.URGENT_DISPLAY}, value = ExecutorType.URGENT_DISPLAY)
    void loadApp(String str, Bundle bundle, Bundle bundle2, LoadResultCallback loadResultCallback);
}
