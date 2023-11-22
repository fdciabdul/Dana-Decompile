package com.alipay.iap.android.common.syncintegration.lifecycle;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class LifecycleWatcher {
    private static final String TAG = "LifecycleWatcher";
    protected List<Callback> mCallbacks = new ArrayList();

    /* loaded from: classes3.dex */
    public interface Callback {
        void onAppToBackground();

        void onAppToForeground();
    }

    public abstract boolean isAppForeground();

    public abstract void startWatcher(Context context);

    public abstract void stopWatcher(Context context);

    public void addCallback(Callback callback) {
        this.mCallbacks.add(callback);
    }

    public void removeCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyAppToForeground() {
        StringBuilder sb = new StringBuilder();
        sb.append("notifyAppToForeground. callbacks count: ");
        sb.append(this.mCallbacks.size());
        LoggerWrapper.d(TAG, sb.toString());
        Iterator<Callback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onAppToForeground();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyAppToBackground() {
        StringBuilder sb = new StringBuilder();
        sb.append("notifyAppToBackground. callbacks count: ");
        sb.append(this.mCallbacks.size());
        LoggerWrapper.d(TAG, sb.toString());
        Iterator<Callback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onAppToBackground();
        }
    }

    public static LifecycleWatcher newValidWatcher() {
        if (ProcessOwnerLifecycleWatcher.processOwnerValid()) {
            LoggerWrapper.d(TAG, "Will create ProcessOwnerLifecycleWatcher");
            return new ProcessOwnerLifecycleWatcher();
        }
        LoggerWrapper.d(TAG, "Will create NormalLifecycleWatcher");
        return new NormalLifecycleWatcher();
    }
}
