package androidx.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.view.Lifecycle;
import androidx.view.ReportFragment;

/* loaded from: classes.dex */
public class ProcessLifecycleOwner implements LifecycleOwner {
    private static final ProcessLifecycleOwner getErrorConfigVersion = new ProcessLifecycleOwner();
    Handler MyBillsEntityDataFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    int moveToNextValue = 0;
    boolean BuiltInFictitiousFunctionClassFactory = true;
    private boolean scheduleImpl = true;
    final LifecycleRegistry KClassImpl$Data$declaredNonStaticMembers$2 = new LifecycleRegistry(this);
    Runnable PlaceComponentResult = new Runnable() { // from class: androidx.lifecycle.ProcessLifecycleOwner.1
        @Override // java.lang.Runnable
        public void run() {
            ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.this;
            if (processLifecycleOwner.moveToNextValue == 0) {
                processLifecycleOwner.BuiltInFictitiousFunctionClassFactory = true;
                LifecycleRegistry lifecycleRegistry = processLifecycleOwner.KClassImpl$Data$declaredNonStaticMembers$2;
                Lifecycle.Event event = Lifecycle.Event.ON_PAUSE;
                lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
                lifecycleRegistry.getAuthRequestContext(event.getTargetState());
            }
            ProcessLifecycleOwner.this.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    };
    ReportFragment.ActivityInitializationListener getAuthRequestContext = new ReportFragment.ActivityInitializationListener() { // from class: androidx.lifecycle.ProcessLifecycleOwner.2
        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public final void BuiltInFictitiousFunctionClassFactory() {
            ProcessLifecycleOwner.this.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public final void PlaceComponentResult() {
            ProcessLifecycleOwner.this.getAuthRequestContext();
        }
    };

    public static LifecycleOwner PlaceComponentResult() {
        return getErrorConfigVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(Context context) {
        ProcessLifecycleOwner processLifecycleOwner = getErrorConfigVersion;
        processLifecycleOwner.MyBillsEntityDataFactory = new Handler();
        LifecycleRegistry lifecycleRegistry = processLifecycleOwner.KClassImpl$Data$declaredNonStaticMembers$2;
        Lifecycle.Event event = Lifecycle.Event.ON_CREATE;
        lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
        lifecycleRegistry.getAuthRequestContext(event.getTargetState());
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner.3
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPreCreated(Activity activity, Bundle bundle) {
                Api29Impl.getAuthRequestContext(activity, new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner.3.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostStarted(Activity activity2) {
                        ProcessLifecycleOwner.this.BuiltInFictitiousFunctionClassFactory();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostResumed(Activity activity2) {
                        ProcessLifecycleOwner.this.getAuthRequestContext();
                    }
                });
            }

            @Override // androidx.view.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (Build.VERSION.SDK_INT < 29) {
                    ReportFragment.MyBillsEntityDataFactory(activity).PlaceComponentResult = ProcessLifecycleOwner.this.getAuthRequestContext;
                }
            }

            @Override // androidx.view.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ProcessLifecycleOwner processLifecycleOwner2 = ProcessLifecycleOwner.this;
                int i = processLifecycleOwner2.moveToNextValue - 1;
                processLifecycleOwner2.moveToNextValue = i;
                if (i == 0) {
                    processLifecycleOwner2.MyBillsEntityDataFactory.postDelayed(processLifecycleOwner2.PlaceComponentResult, 700L);
                }
            }

            @Override // androidx.view.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                r2.NetworkUserEntityData$$ExternalSyntheticLambda0--;
                ProcessLifecycleOwner.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    final void BuiltInFictitiousFunctionClassFactory() {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        if (i == 1 && this.scheduleImpl) {
            LifecycleRegistry lifecycleRegistry = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Lifecycle.Event event = Lifecycle.Event.ON_START;
            lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
            lifecycleRegistry.getAuthRequestContext(event.getTargetState());
            this.scheduleImpl = false;
        }
    }

    final void getAuthRequestContext() {
        int i = this.moveToNextValue + 1;
        this.moveToNextValue = i;
        if (i == 1) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                LifecycleRegistry lifecycleRegistry = this.KClassImpl$Data$declaredNonStaticMembers$2;
                Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
                lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
                lifecycleRegistry.getAuthRequestContext(event.getTargetState());
                this.BuiltInFictitiousFunctionClassFactory = false;
                return;
            }
            this.MyBillsEntityDataFactory.removeCallbacks(this.PlaceComponentResult);
        }
    }

    final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0 && this.BuiltInFictitiousFunctionClassFactory) {
            LifecycleRegistry lifecycleRegistry = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Lifecycle.Event event = Lifecycle.Event.ON_STOP;
            lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
            lifecycleRegistry.getAuthRequestContext(event.getTargetState());
            this.scheduleImpl = true;
        }
    }

    private ProcessLifecycleOwner() {
    }

    @Override // androidx.view.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static void getAuthRequestContext(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }
}
