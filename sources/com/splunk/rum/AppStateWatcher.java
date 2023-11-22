package com.splunk.rum;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class AppStateWatcher implements Application.ActivityLifecycleCallbacks {
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private final List<AppStateListener> getAuthRequestContext;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppStateWatcher(List<AppStateListener> list) {
        this.getAuthRequestContext = list;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
            Iterator<AppStateListener> it = this.getAuthRequestContext.iterator();
            while (it.hasNext()) {
                it.next().KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2 - 1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        if (i == 0) {
            Iterator<AppStateListener> it = this.getAuthRequestContext.iterator();
            while (it.hasNext()) {
                it.next().getAuthRequestContext();
            }
        }
    }
}
