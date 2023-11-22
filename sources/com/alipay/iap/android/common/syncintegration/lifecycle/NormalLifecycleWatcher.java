package com.alipay.iap.android.common.syncintegration.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.alipay.iap.android.common.log.LoggerWrapper;

@Deprecated
/* loaded from: classes3.dex */
public class NormalLifecycleWatcher extends LifecycleWatcher {
    private static final String TAG = "NormalLifecycleWatcher";
    private int mForegroundCount = 0;
    private final Application.ActivityLifecycleCallbacks mLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.alipay.iap.android.common.syncintegration.lifecycle.NormalLifecycleWatcher.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            NormalLifecycleWatcher.access$004(NormalLifecycleWatcher.this);
            if (NormalLifecycleWatcher.this.mForegroundCount == 1) {
                LoggerWrapper.d(NormalLifecycleWatcher.TAG, "onEnterForeground");
                NormalLifecycleWatcher.this.notifyAppToForeground();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            NormalLifecycleWatcher.access$006(NormalLifecycleWatcher.this);
            if (NormalLifecycleWatcher.this.mForegroundCount <= 0) {
                NormalLifecycleWatcher.this.mForegroundCount = 0;
                LoggerWrapper.d(NormalLifecycleWatcher.TAG, "onEnterBackground");
                NormalLifecycleWatcher.this.notifyAppToBackground();
            }
        }
    };

    static /* synthetic */ int access$004(NormalLifecycleWatcher normalLifecycleWatcher) {
        int i = normalLifecycleWatcher.mForegroundCount + 1;
        normalLifecycleWatcher.mForegroundCount = i;
        return i;
    }

    static /* synthetic */ int access$006(NormalLifecycleWatcher normalLifecycleWatcher) {
        int i = normalLifecycleWatcher.mForegroundCount - 1;
        normalLifecycleWatcher.mForegroundCount = i;
        return i;
    }

    @Override // com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher
    public boolean isAppForeground() {
        return this.mForegroundCount > 0;
    }

    @Override // com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher
    public void startWatcher(Context context) {
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
    }

    @Override // com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher
    public void stopWatcher(Context context) {
        ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
    }
}
