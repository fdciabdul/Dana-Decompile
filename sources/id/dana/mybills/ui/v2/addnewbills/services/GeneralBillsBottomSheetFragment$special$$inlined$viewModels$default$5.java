package id.dana.mybills.ui.v2.addnewbills.services;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStoreOwner;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/ViewModelProvider$Factory;", BridgeDSL.INVOKE, "()Landroidx/lifecycle/ViewModelProvider$Factory;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class GeneralBillsBottomSheetFragment$special$$inlined$viewModels$default$5 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ Lazy $$owner$delegate;
    final /* synthetic */ Fragment $$this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneralBillsBottomSheetFragment$special$$inlined$viewModels$default$5(Fragment fragment, Lazy lazy) {
        super(0);
        this.$$this_viewModels = fragment;
        this.$$owner$delegate = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory defaultViewModelProviderFactory;
        ViewModelStoreOwner PlaceComponentResult = FragmentViewModelLazyKt.PlaceComponentResult(this.$$owner$delegate);
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult : null;
        if (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) {
            defaultViewModelProviderFactory = this.$$this_viewModels.getDefaultViewModelProviderFactory();
        }
        Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "");
        return defaultViewModelProviderFactory;
    }
}
