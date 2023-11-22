package com.akamai.botman;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes3.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    private int BuiltInFictitiousFunctionClassFactory = 0;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        StringBuilder sb = new StringBuilder("Activity Created: ");
        sb.append(activity.getLocalClassName());
        ah.PlaceComponentResult("LifecycleCallbacks", sb.toString(), new Throwable[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        StringBuilder sb = new StringBuilder("Activity Destroyed: ");
        sb.append(activity.getLocalClassName());
        ah.PlaceComponentResult("LifecycleCallbacks", sb.toString(), new Throwable[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        StringBuilder sb = new StringBuilder("Activity Paused: ");
        sb.append(activity.getLocalClassName());
        ah.PlaceComponentResult("LifecycleCallbacks", sb.toString(), new Throwable[0]);
        int i = this.BuiltInFictitiousFunctionClassFactory - 1;
        this.BuiltInFictitiousFunctionClassFactory = i;
        if (i == 0) {
            com.cyberfend.cyfsecurity.CYFMonitor.KClassImpl$Data$declaredNonStaticMembers$2();
            com.cyberfend.cyfsecurity.CYFMonitor.PlaceComponentResult(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        StringBuilder sb = new StringBuilder("Activity Resumed:");
        sb.append(activity.getLocalClassName());
        ah.PlaceComponentResult("LifecycleCallbacks", sb.toString(), new Throwable[0]);
        if (this.BuiltInFictitiousFunctionClassFactory == 0) {
            com.cyberfend.cyfsecurity.CYFMonitor.getAuthRequestContext(activity);
            com.cyberfend.cyfsecurity.CYFMonitor.PlaceComponentResult(true);
        }
        this.BuiltInFictitiousFunctionClassFactory++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        StringBuilder sb = new StringBuilder("Activity Started:");
        sb.append(activity.getLocalClassName());
        ah.PlaceComponentResult("LifecycleCallbacks", sb.toString(), new Throwable[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        StringBuilder sb = new StringBuilder("Activity Stopped:");
        sb.append(activity.getLocalClassName());
        ah.PlaceComponentResult("LifecycleCallbacks", sb.toString(), new Throwable[0]);
    }
}
