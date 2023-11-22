package com.alibaba.ariver.engine.api.point;

import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes2.dex */
public interface PageBackInterceptPoint extends Extension {
    boolean interceptBackEvent(GoBackCallback goBackCallback);
}
