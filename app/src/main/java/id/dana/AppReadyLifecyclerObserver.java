package id.dana;

import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.performancetracker.AppReadyRumTracker;
import id.dana.performancetracker.FirstActionEntryPointClickTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/AppReadyLifecyclerObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "p0", "", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "onDestroy", "onStop", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppReadyLifecyclerObserver implements DefaultLifecycleObserver {
    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.MyBillsEntityDataFactory();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.PlaceComponentResult();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final void onCreate(LifecycleOwner p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DefaultLifecycleObserver.CC.KClassImpl$Data$declaredNonStaticMembers$2();
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(false);
        AppReadyMixpanelTracker.MyBillsEntityDataFactory(false);
    }

    @Override // androidx.view.FullLifecycleObserver
    public final void onStop(LifecycleOwner p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DefaultLifecycleObserver.CC.scheduleImpl();
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(TrackerKey.Property.APP_MINIMIZED, true);
        AppReadyRumTracker appReadyRumTracker = AppReadyRumTracker.INSTANCE;
        AppReadyRumTracker.BuiltInFictitiousFunctionClassFactory();
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(true);
        AppReadyMixpanelTracker.MyBillsEntityDataFactory(true);
        AppReadyMixpanelTracker.MyBillsEntityDataFactory();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final void onDestroy(LifecycleOwner p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DefaultLifecycleObserver.CC.getAuthRequestContext();
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory();
        FirstActionEntryPointClickTracker firstActionEntryPointClickTracker = FirstActionEntryPointClickTracker.INSTANCE;
        FirstActionEntryPointClickTracker.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
