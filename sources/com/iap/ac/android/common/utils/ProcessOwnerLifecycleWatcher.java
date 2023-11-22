package com.iap.ac.android.common.utils;

import android.content.Context;
import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.OnLifecycleEvent;
import androidx.view.ProcessLifecycleOwner;
import com.iap.ac.android.common.a.a;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public enum ProcessOwnerLifecycleWatcher {
    INSTANCE;

    public static final String TAG = "ProcessOwnerLifecycleWatcher";
    public List<LifecycleCallback> callbackList = new ArrayList();
    public final LifecycleObserver mLifecycleObserver = new LifecycleObserver() { // from class: com.iap.ac.android.common.utils.ProcessOwnerLifecycleWatcher.1
        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onEnterBackground() {
            ProcessOwnerLifecycleWatcher.this.notifyAppToBackground();
            ACLog.d(ProcessOwnerLifecycleWatcher.TAG, "onEnterBackground");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onEnterForeground() {
            ACLog.d(ProcessOwnerLifecycleWatcher.TAG, "onEnterForeground");
            ProcessOwnerLifecycleWatcher.this.notifyAppToForeground();
        }
    };

    /* loaded from: classes3.dex */
    public interface LifecycleCallback {
        void onAppToBackground();

        void onAppToForeground();
    }

    ProcessOwnerLifecycleWatcher() {
    }

    private boolean isProcessLifecycleOwnerValid() {
        try {
            return Class.forName("androidx.lifecycle.ProcessLifecycleOwnerInitializer") != null;
        } catch (ClassNotFoundException e) {
            StringBuilder a2 = a.a("Take it easy. ProcessLifecycleOwnerInitializer not exists! ");
            a2.append(e.getMessage());
            ACLog.d(TAG, a2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAppToBackground() {
        Iterator<LifecycleCallback> it = this.callbackList.iterator();
        while (it.hasNext()) {
            it.next().onAppToBackground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAppToForeground() {
        Iterator<LifecycleCallback> it = this.callbackList.iterator();
        while (it.hasNext()) {
            it.next().onAppToForeground();
        }
    }

    private void onProcessLifecycleNotValid() {
        ACLog.e(TAG, "ProcessLifecycleOwner is not imported into your project. If you want use this feature please import androidx.lifecycle:lifecycle-process first.");
    }

    public final void addLifecycleCallback(LifecycleCallback lifecycleCallback) {
        this.callbackList.add(lifecycleCallback);
    }

    public final void clearLifecycleCallback() {
        this.callbackList.clear();
    }

    public final boolean isAppForeground() {
        if (isProcessLifecycleOwnerValid()) {
            StringBuilder a2 = a.a("Current state is: ");
            a2.append(ProcessLifecycleOwner.PlaceComponentResult().getLifecycle().PlaceComponentResult().name());
            ACLog.d(TAG, a2.toString());
            return ProcessLifecycleOwner.PlaceComponentResult().getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.STARTED);
        }
        onProcessLifecycleNotValid();
        return false;
    }

    public final void removeLifecycleCallback(LifecycleCallback lifecycleCallback) {
        this.callbackList.remove(lifecycleCallback);
    }

    public final void startWatcher(Context context) {
        if (isProcessLifecycleOwnerValid()) {
            try {
                ProcessLifecycleOwner.PlaceComponentResult().getLifecycle().BuiltInFictitiousFunctionClassFactory(this.mLifecycleObserver);
                return;
            } catch (Throwable th) {
                StringBuilder a2 = a.a("ProcessLifecycleOwner start failed ");
                a2.append(th.getMessage());
                ACLog.e(TAG, a2.toString());
                return;
            }
        }
        onProcessLifecycleNotValid();
    }

    public final void stopWatcher(Context context) {
        if (isProcessLifecycleOwnerValid()) {
            ProcessLifecycleOwner.PlaceComponentResult().getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(this.mLifecycleObserver);
        } else {
            onProcessLifecycleNotValid();
        }
    }
}
