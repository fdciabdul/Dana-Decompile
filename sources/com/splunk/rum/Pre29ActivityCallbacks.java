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
public class Pre29ActivityCallbacks implements Application.ActivityLifecycleCallbacks {
    private final VisibleScreenTracker BuiltInFictitiousFunctionClassFactory;
    private final Tracer PlaceComponentResult;
    private final AppStartupTimer getAuthRequestContext;
    private final Map<String, ActivityTracer> MyBillsEntityDataFactory = new HashMap();
    private final AtomicReference<String> KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicReference<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pre29ActivityCallbacks(Tracer tracer, VisibleScreenTracker visibleScreenTracker, AppStartupTimer appStartupTimer) {
        this.PlaceComponentResult = tracer;
        this.BuiltInFictitiousFunctionClassFactory = visibleScreenTracker;
        this.getAuthRequestContext = appStartupTimer;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.getAuthRequestContext.getAuthRequestContext();
        ActivityTracer KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(activity);
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda2(KClassImpl$Data$declaredNonStaticMembers$2));
        Span span = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent(PerfId.activityCreated);
        }
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new RumFragmentLifecycleCallbacks(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory), true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        ActivityTracer KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(activity);
        boolean z = this.MyBillsEntityDataFactory.size() > 1;
        if (!KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda1(KClassImpl$Data$declaredNonStaticMembers$2, z));
        }
        Span span = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityStarted");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        ActivityTracer KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(activity);
        if (!KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda0(KClassImpl$Data$declaredNonStaticMembers$2, "Resumed"));
        }
        Span span = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityResumed");
        }
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
        if (KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.get() == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.set(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
        }
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.PlaceComponentResult();
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.set(activity.getClass().getSimpleName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ActivityTracer KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(activity);
        if (!KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda0(KClassImpl$Data$declaredNonStaticMembers$2, "Paused"));
        }
        Span span = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityPaused");
        }
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.PlaceComponentResult();
        VisibleScreenTracker visibleScreenTracker = this.BuiltInFictitiousFunctionClassFactory;
        visibleScreenTracker.MyBillsEntityDataFactory.set(activity.getClass().getSimpleName());
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(visibleScreenTracker.KClassImpl$Data$declaredNonStaticMembers$2, activity.getClass().getSimpleName(), null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        ActivityTracer KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(activity);
        if (!KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda0(KClassImpl$Data$declaredNonStaticMembers$2, "Stopped"));
        }
        Span span = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityStopped");
        }
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.PlaceComponentResult();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        ActivityTracer KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(activity);
        if (!KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.getAuthRequestContext(new ActivityTracer$$ExternalSyntheticLambda0(KClassImpl$Data$declaredNonStaticMembers$2, "Destroyed"));
        }
        Span span = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("activityDestroyed");
        }
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.PlaceComponentResult();
    }

    private ActivityTracer KClassImpl$Data$declaredNonStaticMembers$2(Activity activity) {
        ActivityTracer activityTracer = this.MyBillsEntityDataFactory.get(activity.getClass().getName());
        if (activityTracer == null) {
            ActivityTracer activityTracer2 = new ActivityTracer(activity, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
            this.MyBillsEntityDataFactory.put(activity.getClass().getName(), activityTracer2);
            return activityTracer2;
        }
        return activityTracer;
    }
}
