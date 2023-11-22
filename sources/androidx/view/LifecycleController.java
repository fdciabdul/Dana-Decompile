package androidx.view;

import androidx.view.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e"}, d2 = {"Landroidx/lifecycle/LifecycleController;", "", "Landroidx/lifecycle/DispatchQueue;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/lifecycle/DispatchQueue;", "PlaceComponentResult", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle;", "getAuthRequestContext", "Landroidx/lifecycle/Lifecycle$State;", "MyBillsEntityDataFactory", "Landroidx/lifecycle/Lifecycle$State;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "p0", "p1", "p2", "Lkotlinx/coroutines/Job;", "p3", "<init>", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LifecycleController {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final DispatchQueue PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final LifecycleEventObserver BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lifecycle.State KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Lifecycle getAuthRequestContext;

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State state, DispatchQueue dispatchQueue, final Job job) {
        Intrinsics.checkNotNullParameter(lifecycle, "");
        Intrinsics.checkNotNullParameter(state, "");
        Intrinsics.checkNotNullParameter(dispatchQueue, "");
        Intrinsics.checkNotNullParameter(job, "");
        this.getAuthRequestContext = lifecycle;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = state;
        this.PlaceComponentResult = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.LifecycleController$$ExternalSyntheticLambda0
            @Override // androidx.view.LifecycleEventObserver
            public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                LifecycleController.getAuthRequestContext(LifecycleController.this, job, lifecycleOwner, event);
            }
        };
        this.BuiltInFictitiousFunctionClassFactory = lifecycleEventObserver;
        if (lifecycle.PlaceComponentResult() != Lifecycle.State.DESTROYED) {
            lifecycle.BuiltInFictitiousFunctionClassFactory(lifecycleEventObserver);
            return;
        }
        Job.DefaultImpls.cancel$default(job, null, 1, null);
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory);
        DispatchQueue dispatchQueue2 = this.PlaceComponentResult;
        dispatchQueue2.PlaceComponentResult = true;
        dispatchQueue2.PlaceComponentResult();
    }

    public static /* synthetic */ void getAuthRequestContext(LifecycleController lifecycleController, Job job, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleController, "");
        Intrinsics.checkNotNullParameter(job, "");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "");
        Intrinsics.checkNotNullParameter(event, "");
        if (lifecycleOwner.getLifecycle().PlaceComponentResult() != Lifecycle.State.DESTROYED) {
            if (lifecycleOwner.getLifecycle().PlaceComponentResult().compareTo(lifecycleController.KClassImpl$Data$declaredNonStaticMembers$2) >= 0) {
                DispatchQueue dispatchQueue = lifecycleController.PlaceComponentResult;
                if (dispatchQueue.getAuthRequestContext) {
                    if ((!dispatchQueue.PlaceComponentResult) == false) {
                        throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
                    }
                    dispatchQueue.getAuthRequestContext = false;
                    dispatchQueue.PlaceComponentResult();
                    return;
                }
                return;
            }
            lifecycleController.PlaceComponentResult.getAuthRequestContext = true;
            return;
        }
        Job.DefaultImpls.cancel$default(job, null, 1, null);
        lifecycleController.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(lifecycleController.BuiltInFictitiousFunctionClassFactory);
        DispatchQueue dispatchQueue2 = lifecycleController.PlaceComponentResult;
        dispatchQueue2.PlaceComponentResult = true;
        dispatchQueue2.PlaceComponentResult();
    }
}
