package androidx.view;

import androidx.view.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Landroidx/lifecycle/SavedStateHandleAttacher;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "p0", "Landroidx/lifecycle/Lifecycle$Event;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/lifecycle/SavedStateHandlesProvider;", "getAuthRequestContext", "Landroidx/lifecycle/SavedStateHandlesProvider;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Landroidx/lifecycle/SavedStateHandlesProvider;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements LifecycleEventObserver {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SavedStateHandlesProvider KClassImpl$Data$declaredNonStaticMembers$2;

    public SavedStateHandleAttacher(SavedStateHandlesProvider savedStateHandlesProvider) {
        Intrinsics.checkNotNullParameter(savedStateHandlesProvider, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = savedStateHandlesProvider;
    }

    @Override // androidx.view.LifecycleEventObserver
    public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner p0, Lifecycle.Event p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (!(p1 == Lifecycle.Event.ON_CREATE)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Next event must be ON_CREATE, it was ");
            sb.append(p1);
            throw new IllegalStateException(sb.toString().toString());
        }
        p0.getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(this);
        SavedStateHandlesProvider savedStateHandlesProvider = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (savedStateHandlesProvider.getAuthRequestContext) {
            return;
        }
        savedStateHandlesProvider.MyBillsEntityDataFactory = savedStateHandlesProvider.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult("androidx.lifecycle.internal.SavedStateHandlesProvider");
        savedStateHandlesProvider.getAuthRequestContext = true;
        SavedStateHandlesVM savedStateHandlesVM = (SavedStateHandlesVM) savedStateHandlesProvider.BuiltInFictitiousFunctionClassFactory.getValue();
    }
}
