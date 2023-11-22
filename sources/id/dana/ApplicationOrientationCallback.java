package id.dana;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import id.dana.extension.ContextExtKt;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes.dex */
public class ApplicationOrientationCallback implements Application.ActivityLifecycleCallbacks {
    public WeakReference<Activity> BuiltInFictitiousFunctionClassFactory = new WeakReference<>(null);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Inject
    public ApplicationOrientationCallback() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        ContextExtKt.PlaceComponentResult(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.BuiltInFictitiousFunctionClassFactory.get() == activity) {
            this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(null);
        }
    }
}
