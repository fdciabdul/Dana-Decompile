package com.splunk.rum;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import androidx.view.fragment.NavHostFragment;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import j$.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
class RumFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {
    private final Map<String, FragmentTracer> BuiltInFictitiousFunctionClassFactory = new HashMap();
    private final VisibleScreenTracker MyBillsEntityDataFactory;
    private final Tracer getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RumFragmentLifecycleCallbacks(Tracer tracer, VisibleScreenTracker visibleScreenTracker) {
        this.getAuthRequestContext = tracer;
        this.MyBillsEntityDataFactory = visibleScreenTracker;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentPreAttached(fragmentManager, fragment, context);
        final FragmentTracer authRequestContext = getAuthRequestContext(fragment);
        authRequestContext.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new Supplier() { // from class: com.splunk.rum.FragmentTracer$$ExternalSyntheticLambda0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return FragmentTracer.this.KClassImpl$Data$declaredNonStaticMembers$2("Created");
            }
        });
        Span span = authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("fragmentPreAttached");
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentAttached(fragmentManager, fragment, context);
        KClassImpl$Data$declaredNonStaticMembers$2(fragment, "fragmentAttached");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentPreCreated(fragmentManager, fragment, bundle);
        KClassImpl$Data$declaredNonStaticMembers$2(fragment, "fragmentPreCreated");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentCreated(fragmentManager, fragment, bundle);
        KClassImpl$Data$declaredNonStaticMembers$2(fragment, PerfId.fragmentCreated);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
        FragmentTracer authRequestContext = getAuthRequestContext(fragment);
        if (!authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2()) {
            authRequestContext.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new FragmentTracer$$ExternalSyntheticLambda1(authRequestContext, "Restored"));
        }
        Span span = authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("fragmentViewCreated");
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStarted(fragmentManager, fragment);
        KClassImpl$Data$declaredNonStaticMembers$2(fragment, "fragmentStarted");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        FragmentTracer authRequestContext = getAuthRequestContext(fragment);
        if (!authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2()) {
            authRequestContext.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new FragmentTracer$$ExternalSyntheticLambda1(authRequestContext, "Resumed"));
        }
        Span span = authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("fragmentResumed");
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
        authRequestContext.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        VisibleScreenTracker visibleScreenTracker = this.MyBillsEntityDataFactory;
        if (fragment instanceof NavHostFragment) {
            return;
        }
        if (fragment instanceof DialogFragment) {
            visibleScreenTracker.getAuthRequestContext.set(visibleScreenTracker.PlaceComponentResult.get());
        }
        visibleScreenTracker.PlaceComponentResult.set(fragment.getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
        VisibleScreenTracker visibleScreenTracker = this.MyBillsEntityDataFactory;
        if (!(fragment instanceof NavHostFragment)) {
            if (fragment instanceof DialogFragment) {
                visibleScreenTracker.PlaceComponentResult.set(visibleScreenTracker.getAuthRequestContext.get());
            } else {
                LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(visibleScreenTracker.PlaceComponentResult, fragment.getClass().getSimpleName(), null);
            }
            visibleScreenTracker.getAuthRequestContext.set(fragment.getClass().getSimpleName());
        }
        FragmentTracer authRequestContext = getAuthRequestContext(fragment);
        if (!authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2()) {
            authRequestContext.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new FragmentTracer$$ExternalSyntheticLambda1(authRequestContext, "Paused"));
        }
        Span span = authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("fragmentPaused");
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStopped(fragmentManager, fragment);
        FragmentTracer authRequestContext = getAuthRequestContext(fragment);
        Span span = authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("fragmentStopped");
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentSaveInstanceState(fragmentManager, fragment, bundle);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentViewDestroyed(fragmentManager, fragment);
        FragmentTracer authRequestContext = getAuthRequestContext(fragment);
        if (!authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2()) {
            authRequestContext.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new FragmentTracer$$ExternalSyntheticLambda1(authRequestContext, "ViewDestroyed"));
        }
        Span span = authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("fragmentViewDestroyed");
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDestroyed(fragmentManager, fragment);
        FragmentTracer authRequestContext = getAuthRequestContext(fragment);
        if (!authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2()) {
            authRequestContext.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new FragmentTracer$$ExternalSyntheticLambda1(authRequestContext, "Destroyed"));
        }
        Span span = authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("fragmentDestroyed");
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDetached(fragmentManager, fragment);
        FragmentTracer authRequestContext = getAuthRequestContext(fragment);
        if (!authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2()) {
            authRequestContext.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new FragmentTracer$$ExternalSyntheticLambda1(authRequestContext, "Detached"));
        }
        Span span = authRequestContext.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.addEvent("fragmentDetached");
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Fragment fragment, String str) {
        Span span;
        FragmentTracer fragmentTracer = this.BuiltInFictitiousFunctionClassFactory.get(fragment.getClass().getName());
        if (fragmentTracer == null || (span = fragmentTracer.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        span.addEvent(str);
    }

    private FragmentTracer getAuthRequestContext(Fragment fragment) {
        FragmentTracer fragmentTracer = this.BuiltInFictitiousFunctionClassFactory.get(fragment.getClass().getName());
        if (fragmentTracer == null) {
            FragmentTracer fragmentTracer2 = new FragmentTracer(fragment, this.getAuthRequestContext, this.MyBillsEntityDataFactory);
            this.BuiltInFictitiousFunctionClassFactory.put(fragment.getClass().getName(), fragmentTracer2);
            return fragmentTracer2;
        }
        return fragmentTracer;
    }
}
