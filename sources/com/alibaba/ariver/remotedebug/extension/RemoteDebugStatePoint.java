package com.alibaba.ariver.remotedebug.extension;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface RemoteDebugStatePoint extends Extension {
    boolean onDisconnected(App app);
}
