package com.alibaba.ariver.app.api.point.app;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface AppOnLoadResultPoint extends Extension {
    void onLoadResult(App app, AppLoadResult appLoadResult);
}
