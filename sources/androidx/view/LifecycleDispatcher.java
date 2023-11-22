package androidx.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
class LifecycleDispatcher {
    private static AtomicBoolean BuiltInFictitiousFunctionClassFactory = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(Context context) {
        if (BuiltInFictitiousFunctionClassFactory.getAndSet(true)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
    }

    /* loaded from: classes6.dex */
    static class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        @Override // androidx.view.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // androidx.view.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        DispatcherActivityCallback() {
        }

        @Override // androidx.view.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ReportFragment.PlaceComponentResult(activity);
        }
    }

    private LifecycleDispatcher() {
    }
}
