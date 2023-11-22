package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ActivityRecreator {
    protected static final Method BuiltInFictitiousFunctionClassFactory;
    protected static final Method KClassImpl$Data$declaredNonStaticMembers$2;
    protected static final Class<?> MyBillsEntityDataFactory;
    protected static final Method PlaceComponentResult;
    protected static final Field getAuthRequestContext;
    protected static final Field getErrorConfigVersion;
    private static final Handler lookAheadTest = new Handler(Looper.getMainLooper());

    private ActivityRecreator() {
    }

    static {
        Class<?> authRequestContext = getAuthRequestContext();
        MyBillsEntityDataFactory = authRequestContext;
        getAuthRequestContext = MyBillsEntityDataFactory();
        getErrorConfigVersion = PlaceComponentResult();
        PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
        KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory(authRequestContext);
        BuiltInFictitiousFunctionClassFactory = PlaceComponentResult(authRequestContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean MyBillsEntityDataFactory(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (KClassImpl$Data$declaredNonStaticMembers$2() && BuiltInFictitiousFunctionClassFactory == null) {
            return false;
        } else {
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null && PlaceComponentResult == null) {
                return false;
            }
            try {
                final Object obj2 = getErrorConfigVersion.get(activity);
                if (obj2 == null || (obj = getAuthRequestContext.get(activity)) == null) {
                    return false;
                }
                final Application application = activity.getApplication();
                final LifecycleCheckCallbacks lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
                application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                Handler handler = lookAheadTest;
                handler.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LifecycleCheckCallbacks.this.getAuthRequestContext = obj2;
                    }
                });
                try {
                    if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                        BuiltInFictitiousFunctionClassFactory.invoke(obj, obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE);
                    } else {
                        activity.recreate();
                    }
                    handler.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.2
                        @Override // java.lang.Runnable
                        public void run() {
                            application.unregisterActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                        }
                    });
                    return true;
                } catch (Throwable th) {
                    lookAheadTest.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.2
                        @Override // java.lang.Runnable
                        public void run() {
                            application.unregisterActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                        }
                    });
                    throw th;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        private Activity MyBillsEntityDataFactory;
        private final int PlaceComponentResult;
        Object getAuthRequestContext;
        private boolean BuiltInFictitiousFunctionClassFactory = false;
        private boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
        private boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }

        LifecycleCheckCallbacks(Activity activity) {
            this.MyBillsEntityDataFactory = activity;
            this.PlaceComponentResult = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (this.MyBillsEntityDataFactory == activity) {
                this.BuiltInFictitiousFunctionClassFactory = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2 || this.NetworkUserEntityData$$ExternalSyntheticLambda0 || this.BuiltInFictitiousFunctionClassFactory || !ActivityRecreator.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, this.PlaceComponentResult, activity)) {
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            this.getAuthRequestContext = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            if (this.MyBillsEntityDataFactory == activity) {
                this.MyBillsEntityDataFactory = null;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
        }
    }

    protected static boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, int i, Activity activity) {
        try {
            final Object obj2 = getErrorConfigVersion.get(activity);
            if (obj2 == obj && activity.hashCode() == i) {
                final Object obj3 = getAuthRequestContext.get(activity);
                lookAheadTest.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.ActivityRecreator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (ActivityRecreator.PlaceComponentResult != null) {
                                ActivityRecreator.PlaceComponentResult.invoke(obj3, obj2, Boolean.FALSE, "AppCompat recreation");
                            } else {
                                ActivityRecreator.KClassImpl$Data$declaredNonStaticMembers$2.invoke(obj3, obj2, Boolean.FALSE);
                            }
                        } catch (RuntimeException e) {
                            if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                                throw e;
                            }
                        } catch (Throwable th) {
                            InstrumentInjector.log_e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th) {
            InstrumentInjector.log_e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    private static Method KClassImpl$Data$declaredNonStaticMembers$2(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method BuiltInFictitiousFunctionClassFactory(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    private static Method PlaceComponentResult(Class<?> cls) {
        if (!KClassImpl$Data$declaredNonStaticMembers$2() || cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field MyBillsEntityDataFactory() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field PlaceComponentResult() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getAuthRequestContext() {
        try {
            return Class.forName(ProcessUtils.ACTIVITY_THREAD);
        } catch (Throwable unused) {
            return null;
        }
    }
}
