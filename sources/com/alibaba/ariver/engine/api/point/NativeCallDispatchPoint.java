package com.alibaba.ariver.engine.api.point;

import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface NativeCallDispatchPoint extends Extension {
    void onCallDispatch(NativeCallContext nativeCallContext);
}
