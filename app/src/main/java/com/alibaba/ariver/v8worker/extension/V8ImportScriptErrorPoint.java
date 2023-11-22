package com.alibaba.ariver.v8worker.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface V8ImportScriptErrorPoint extends Extension {
    void onLoadScriptError(Throwable th);
}
