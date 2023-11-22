package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.resource.api.models.AppModel;

/* loaded from: classes6.dex */
public interface AppModelInitPoint extends Extension {
    void onGetAppInfo(AppModel appModel);
}
