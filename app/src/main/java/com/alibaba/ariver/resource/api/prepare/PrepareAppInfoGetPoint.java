package com.alibaba.ariver.resource.api.prepare;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.resource.api.models.AppModel;

/* loaded from: classes2.dex */
public interface PrepareAppInfoGetPoint extends Extension {
    @ThreadType(ExecutorType.SYNC)
    void onAppPrepare(App app, Bundle bundle, Bundle bundle2, AppModel appModel);

    @ThreadType(ExecutorType.SYNC)
    void onAppStart(App app, Bundle bundle, Bundle bundle2);
}
