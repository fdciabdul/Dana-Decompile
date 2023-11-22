package com.alibaba.ariver.app.api.point.error;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface JsErrorPoint extends Extension {
    void onJsErrorMessage(String str, Page page);
}
