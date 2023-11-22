package androidx.view;

import android.os.Bundle;
import androidx.view.SavedStateRegistry;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0013\u0010\u000f\u001a\u00020\rX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u000e"}, d2 = {"Landroidx/lifecycle/SavedStateHandlesProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/os/Bundle;", "", "getAuthRequestContext", "Z", "MyBillsEntityDataFactory", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedStateRegistry;", "PlaceComponentResult", "Landroidx/savedstate/SavedStateRegistry;", "Landroidx/lifecycle/SavedStateHandlesVM;", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "p0", "Landroidx/lifecycle/ViewModelStoreOwner;", "p1", "<init>", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/ViewModelStoreOwner;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Lazy BuiltInFictitiousFunctionClassFactory;
    Bundle MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final SavedStateRegistry KClassImpl$Data$declaredNonStaticMembers$2;
    boolean getAuthRequestContext;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, final ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistry, "");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = savedStateRegistry;
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<SavedStateHandlesVM>() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SavedStateHandlesVM invoke() {
                return SavedStateHandleSupport.KClassImpl$Data$declaredNonStaticMembers$2(ViewModelStoreOwner.this);
            }
        });
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.MyBillsEntityDataFactory;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, SavedStateHandle> entry : ((SavedStateHandlesVM) this.BuiltInFictitiousFunctionClassFactory.getValue()).PlaceComponentResult.entrySet()) {
            String key = entry.getKey();
            Bundle KClassImpl$Data$declaredNonStaticMembers$2 = entry.getValue().PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
            if (!Intrinsics.areEqual(KClassImpl$Data$declaredNonStaticMembers$2, Bundle.EMPTY)) {
                bundle.putBundle(key, KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
        this.getAuthRequestContext = false;
        return bundle;
    }
}
