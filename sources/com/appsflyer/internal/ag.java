package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ag {
    public static b AFInAppEventParameterName = null;
    public static long valueOf = 500;

    /* loaded from: classes.dex */
    public interface b {
        void AFKeystoreWrapper(Activity activity);

        void values(Context context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.appsflyer.internal.ag$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ b AFInAppEventParameterName;
        private /* synthetic */ Executor AFInAppEventType;
        boolean valueOf = true;
        boolean values;

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

        AnonymousClass3(Executor executor, b bVar) {
            this.AFInAppEventType = executor;
            this.AFInAppEventParameterName = bVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(final Activity activity) {
            this.AFInAppEventType.execute(new Runnable() { // from class: com.appsflyer.internal.ag.3.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (!AnonymousClass3.this.values) {
                        try {
                            AnonymousClass3.this.AFInAppEventParameterName.AFKeystoreWrapper(activity);
                        } catch (Exception e) {
                            AFLogger.AFInAppEventParameterName("Listener thrown an exception: ", e);
                        }
                    }
                    AnonymousClass3.this.valueOf = false;
                    AnonymousClass3.this.values = true;
                }
            });
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(final Activity activity) {
            this.AFInAppEventType.execute(new Runnable() { // from class: com.appsflyer.internal.ag.3.4
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass3.this.valueOf = true;
                    final Context applicationContext = activity.getApplicationContext();
                    try {
                        new Timer().schedule(new TimerTask() { // from class: com.appsflyer.internal.ag.3.4.4
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public final void run() {
                                if (AnonymousClass3.this.values && AnonymousClass3.this.valueOf) {
                                    AnonymousClass3.this.values = false;
                                    try {
                                        AnonymousClass3.this.AFInAppEventParameterName.values(applicationContext);
                                    } catch (Exception e) {
                                        AFLogger.AFInAppEventType("Listener threw exception! ", e);
                                    }
                                }
                            }
                        }, ag.valueOf);
                    } catch (Throwable th) {
                        AFLogger.AFInAppEventType("Background task failed with a throwable: ", th);
                    }
                }
            });
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(final Activity activity, Bundle bundle) {
            this.AFInAppEventType.execute(new Runnable() { // from class: com.appsflyer.internal.ag.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    j.AFInAppEventType();
                    Intent intent = activity.getIntent();
                    if (j.AFInAppEventType(intent) == null || intent == j.values) {
                        return;
                    }
                    j.values = intent;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void valueOf(Context context, b bVar, Executor executor) {
        AFInAppEventParameterName = bVar;
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(executor, bVar);
        if (context instanceof Activity) {
            anonymousClass3.onActivityResumed((Activity) context);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(anonymousClass3);
    }
}
