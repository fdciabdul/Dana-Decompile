package androidx.view;

import androidx.view.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u000f\u0012\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u00020\n8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0011X\u0091\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "p0", "Landroidx/lifecycle/Lifecycle$Event;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getAuthRequestContext", "Landroidx/lifecycle/Lifecycle;", "MyBillsEntityDataFactory", "Landroidx/lifecycle/Lifecycle;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroidx/lifecycle/Lifecycle;", "PlaceComponentResult", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CoroutineContext getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Lifecycle PlaceComponentResult;

    @Override // androidx.view.LifecycleCoroutineScope
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final Lifecycle getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @JvmName(name = "getCoroutineContext")
    /* renamed from: getCoroutineContext  reason: from getter */
    public final CoroutineContext getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(lifecycle, "");
        Intrinsics.checkNotNullParameter(coroutineContext, "");
        this.PlaceComponentResult = lifecycle;
        this.getAuthRequestContext = coroutineContext;
        if (lifecycle.PlaceComponentResult() == Lifecycle.State.DESTROYED) {
            JobKt__JobKt.cancel$default(getGetAuthRequestContext(), null, 1, null);
        }
    }

    @Override // androidx.view.LifecycleEventObserver
    public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner p0, Lifecycle.Event p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (this.PlaceComponentResult.PlaceComponentResult().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this);
            JobKt__JobKt.cancel$default(getGetAuthRequestContext(), null, 1, null);
        }
    }
}
