package androidx.view;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.view.Lifecycle;

/* loaded from: classes.dex */
public class ReportFragment extends Fragment {
    ActivityInitializationListener PlaceComponentResult;

    /* loaded from: classes.dex */
    interface ActivityInitializationListener {
        void BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public static void PlaceComponentResult(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            LifecycleCallbacks.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    static void MyBillsEntityDataFactory(Activity activity, Lifecycle.Event event) {
        if (activity instanceof LifecycleRegistryOwner) {
            LifecycleRegistry authRequestContext = ((LifecycleRegistryOwner) activity).getAuthRequestContext();
            authRequestContext.PlaceComponentResult("handleLifecycleEvent");
            authRequestContext.getAuthRequestContext(event.getTargetState());
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof LifecycleRegistry) {
                LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) lifecycle;
                lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
                lifecycleRegistry.getAuthRequestContext(event.getTargetState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ReportFragment MyBillsEntityDataFactory(Activity activity) {
        return (ReportFragment) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Lifecycle.Event event = Lifecycle.Event.ON_CREATE;
        if (Build.VERSION.SDK_INT < 29) {
            MyBillsEntityDataFactory(getActivity(), event);
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        ActivityInitializationListener activityInitializationListener = this.PlaceComponentResult;
        if (activityInitializationListener != null) {
            activityInitializationListener.BuiltInFictitiousFunctionClassFactory();
        }
        Lifecycle.Event event = Lifecycle.Event.ON_START;
        if (Build.VERSION.SDK_INT < 29) {
            MyBillsEntityDataFactory(getActivity(), event);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ActivityInitializationListener activityInitializationListener = this.PlaceComponentResult;
        if (activityInitializationListener != null) {
            activityInitializationListener.PlaceComponentResult();
        }
        Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
        if (Build.VERSION.SDK_INT < 29) {
            MyBillsEntityDataFactory(getActivity(), event);
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        Lifecycle.Event event = Lifecycle.Event.ON_PAUSE;
        if (Build.VERSION.SDK_INT < 29) {
            MyBillsEntityDataFactory(getActivity(), event);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        Lifecycle.Event event = Lifecycle.Event.ON_STOP;
        if (Build.VERSION.SDK_INT < 29) {
            MyBillsEntityDataFactory(getActivity(), event);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Lifecycle.Event event = Lifecycle.Event.ON_DESTROY;
        if (Build.VERSION.SDK_INT < 29) {
            MyBillsEntityDataFactory(getActivity(), event);
        }
        this.PlaceComponentResult = null;
    }

    /* loaded from: classes.dex */
    static class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
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
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        LifecycleCallbacks() {
        }

        static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            ReportFragment.MyBillsEntityDataFactory(activity, Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            ReportFragment.MyBillsEntityDataFactory(activity, Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            ReportFragment.MyBillsEntityDataFactory(activity, Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            ReportFragment.MyBillsEntityDataFactory(activity, Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            ReportFragment.MyBillsEntityDataFactory(activity, Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            ReportFragment.MyBillsEntityDataFactory(activity, Lifecycle.Event.ON_DESTROY);
        }
    }
}
