package com.alibaba.ariver.kernel.api.extension.bridge;

import android.app.Activity;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.exthub.lifecycler.ActivityLifecycleExtension;
import com.alibaba.exthub.lifecycler.ProcessLifecycleExtension;

/* loaded from: classes2.dex */
public abstract class SimpleBridgeExtension implements BridgeExtension, ActivityLifecycleExtension, ProcessLifecycleExtension {
    @Override // com.alibaba.exthub.lifecycler.ActivityLifecycleExtension
    public void onActivityDestroy(Activity activity) {
    }

    @Override // com.alibaba.exthub.lifecycler.ActivityLifecycleExtension
    public void onActivityPause(Activity activity) {
    }

    @Override // com.alibaba.exthub.lifecycler.ActivityLifecycleExtension
    public void onActivityResume(Activity activity) {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.exthub.lifecycler.ProcessLifecycleExtension
    public void onProcessPause() {
    }

    @Override // com.alibaba.exthub.lifecycler.ProcessLifecycleExtension
    public void onProcessResume() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
