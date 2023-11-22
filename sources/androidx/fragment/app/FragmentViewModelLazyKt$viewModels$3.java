package androidx.fragment.app;

import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/viewmodel/CreationExtras;", BridgeDSL.INVOKE, "()Landroidx/lifecycle/viewmodel/CreationExtras;"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes2.dex */
public final class FragmentViewModelLazyKt$viewModels$3 extends Lambda implements Function0<CreationExtras> {
    final /* synthetic */ Lazy<ViewModelStoreOwner> $$owner$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$3(Lazy<? extends ViewModelStoreOwner> lazy) {
        super(0);
        this.$$owner$delegate = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CreationExtras invoke() {
        ViewModelStoreOwner BuiltInFictitiousFunctionClassFactory = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(this.$$owner$delegate);
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = BuiltInFictitiousFunctionClassFactory instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) BuiltInFictitiousFunctionClassFactory : null;
        CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
        return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
    }
}
