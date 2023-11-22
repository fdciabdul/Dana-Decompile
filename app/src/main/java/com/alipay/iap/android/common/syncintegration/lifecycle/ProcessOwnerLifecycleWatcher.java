package com.alipay.iap.android.common.syncintegration.lifecycle;

import android.content.Context;
import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.OnLifecycleEvent;
import androidx.view.ProcessLifecycleOwner;
import com.alipay.iap.android.common.log.LoggerWrapper;

/* loaded from: classes2.dex */
public class ProcessOwnerLifecycleWatcher extends LifecycleWatcher {
    private static final String TAG = "ProcessOwnerLifecycleWatcher";
    private boolean mIsAppForeground = false;
    private final LifecycleObserver mLifecycleObserver = new LifecycleObserver() { // from class: com.alipay.iap.android.common.syncintegration.lifecycle.ProcessOwnerLifecycleWatcher.1
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onEnterForeground() {
            ProcessOwnerLifecycleWatcher.this.mIsAppForeground = true;
            LoggerWrapper.d("ProcessOwnerLifecycleWatcher", "onEnterForeground");
            ProcessOwnerLifecycleWatcher.this.notifyAppToForeground();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onEnterBackground() {
            ProcessOwnerLifecycleWatcher.this.mIsAppForeground = false;
            LoggerWrapper.d("ProcessOwnerLifecycleWatcher", "onEnterBackground");
            ProcessOwnerLifecycleWatcher.this.notifyAppToBackground();
        }
    };

    public static boolean processOwnerValid() {
        try {
            return Class.forName("androidx.lifecycle.ProcessLifecycleOwnerInitializer") != null;
        } catch (ClassNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Take it easy. ProcessLifecycleOwnerInitializer not exists! ");
            sb.append(e.getMessage());
            LoggerWrapper.d("ProcessOwnerLifecycleWatcher", sb.toString());
            return false;
        }
    }

    @Override // com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher
    public boolean isAppForeground() {
        return this.mIsAppForeground;
    }

    @Override // com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher
    public void startWatcher(Context context) {
        ProcessLifecycleOwner.PlaceComponentResult().getLifecycle().BuiltInFictitiousFunctionClassFactory(this.mLifecycleObserver);
    }

    @Override // com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher
    public void stopWatcher(Context context) {
        ProcessLifecycleOwner.PlaceComponentResult().getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(this.mLifecycleObserver);
    }
}
