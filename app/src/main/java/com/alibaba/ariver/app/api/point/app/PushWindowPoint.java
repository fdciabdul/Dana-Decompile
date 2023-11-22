package com.alibaba.ariver.app.api.point.app;

import android.os.Bundle;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes2.dex */
public interface PushWindowPoint extends Extension {
    boolean handlePushWindow(Page page, String str, Bundle bundle, Bundle bundle2);
}
