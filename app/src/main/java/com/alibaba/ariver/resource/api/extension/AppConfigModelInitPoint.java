package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface AppConfigModelInitPoint extends Extension {
    void onAppConfigModelInit(App app, AppConfigModel appConfigModel);
}
