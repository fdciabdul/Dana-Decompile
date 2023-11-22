package com.akamai.botman;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Pair;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class c implements Application.ActivityLifecycleCallbacks {
    ArrayList<Pair<String, Long>> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.size() < 10) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(new Pair<>("2", Long.valueOf(System.currentTimeMillis())));
        }
        StringBuilder sb = new StringBuilder("Activity paused: ");
        sb.append(activity.getLocalClassName());
        ah.PlaceComponentResult("BackgroundEventManager", sb.toString(), new Throwable[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.size() < 10) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(new Pair<>("3", Long.valueOf(System.currentTimeMillis())));
        }
        StringBuilder sb = new StringBuilder("Activity resumed: ");
        sb.append(activity.getLocalClassName());
        ah.PlaceComponentResult("BackgroundEventManager", sb.toString(), new Throwable[0]);
    }
}
