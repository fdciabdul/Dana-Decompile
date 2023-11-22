package com.splunk.rum;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActivityCallbacks implements Application.ActivityLifecycleCallbacks {
    private final VisibleScreenTracker BuiltInFictitiousFunctionClassFactory;
    private final Tracer MyBillsEntityDataFactory;
    private final AppStartupTimer getAuthRequestContext;
    private final Map<String, ActivityTracer> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
    private final AtomicReference<String> PlaceComponentResult = new AtomicReference<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityCallbacks(Tracer tracer, VisibleScreenTracker visibleScreenTracker, AppStartupTimer appStartupTimer) {
        this.MyBillsEntityDataFactory = tracer;
        this.BuiltInFictitiousFunctionClassFactory = visibleScreenTracker;
        this.getAuthRequestContext = appStartupTimer;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        ActivityTracer BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda2(BuiltInFictitiousFunctionClassFactory));
        Span span = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPreCreated");
        }
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new RumFragmentLifecycleCallbacks(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory), true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.getAuthRequestContext.getAuthRequestContext();
        Span span = BuiltInFictitiousFunctionClassFactory(activity).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent(PerfId.activityCreated);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(Activity activity) {
        ActivityTracer BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity);
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2.size() > 1;
        if (!BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda1(BuiltInFictitiousFunctionClassFactory, z));
        }
        Span span = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPreStarted");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(Activity activity) {
        ActivityTracer BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity);
        if (!BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda0(BuiltInFictitiousFunctionClassFactory, "Resumed"));
        }
        Span span = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPreResumed");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        ActivityTracer BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity);
        Span span = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPostResumed");
        }
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
        if (BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.get() == null) {
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.set(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.PlaceComponentResult();
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.set(activity.getClass().getSimpleName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
        ActivityTracer BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity);
        if (!BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda0(BuiltInFictitiousFunctionClassFactory, "Paused"));
        }
        Span span = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPrePaused");
        }
        VisibleScreenTracker visibleScreenTracker = this.BuiltInFictitiousFunctionClassFactory;
        visibleScreenTracker.MyBillsEntityDataFactory.set(activity.getClass().getSimpleName());
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(visibleScreenTracker.KClassImpl$Data$declaredNonStaticMembers$2, activity.getClass().getSimpleName(), null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(Activity activity) {
        ActivityTracer BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity);
        Span span = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPostPaused");
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.PlaceComponentResult();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
        ActivityTracer BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity);
        if (!BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda0(BuiltInFictitiousFunctionClassFactory, "Stopped"));
        }
        Span span = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPreStopped");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(Activity activity) {
        ActivityTracer BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity);
        Span span = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPostStopped");
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.PlaceComponentResult();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(Activity activity) {
        ActivityTracer BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity);
        if (!BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda0(BuiltInFictitiousFunctionClassFactory, "Destroyed"));
        }
        Span span = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPreDestroyed");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(Activity activity) {
        ActivityTracer BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity);
        Span span = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPostDestroyed");
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.PlaceComponentResult();
    }

    private ActivityTracer BuiltInFictitiousFunctionClassFactory(Activity activity) {
        ActivityTracer activityTracer = this.KClassImpl$Data$declaredNonStaticMembers$2.get(activity.getClass().getName());
        if (activityTracer == null) {
            ActivityTracer activityTracer2 = new ActivityTracer(activity, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
            this.KClassImpl$Data$declaredNonStaticMembers$2.put(activity.getClass().getName(), activityTracer2);
            return activityTracer2;
        }
        return activityTracer;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Span span = BuiltInFictitiousFunctionClassFactory(activity).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityDestroyed");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Span span = BuiltInFictitiousFunctionClassFactory(activity).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPaused");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(Activity activity, Bundle bundle) {
        Span span = BuiltInFictitiousFunctionClassFactory(activity).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPostCreated");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        Span span = BuiltInFictitiousFunctionClassFactory(activity).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPostStarted");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Span span = BuiltInFictitiousFunctionClassFactory(activity).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityResumed");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Span span = BuiltInFictitiousFunctionClassFactory(activity).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityStarted");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Span span = BuiltInFictitiousFunctionClassFactory(activity).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityStopped");
        }
    }
}
