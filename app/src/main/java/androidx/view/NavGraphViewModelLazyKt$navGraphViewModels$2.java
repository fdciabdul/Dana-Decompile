package androidx.view;

import androidx.view.ViewModelProvider;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/ViewModelProvider$Factory;", BridgeDSL.INVOKE, "()Landroidx/lifecycle/ViewModelProvider$Factory;"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes6.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ Lazy<NavBackStackEntry> $$backStackEntry$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$2(Lazy<NavBackStackEntry> lazy) {
        super(0);
        this.$$backStackEntry$delegate = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return NavGraphViewModelLazyKt.PlaceComponentResult(this.$$backStackEntry$delegate).getDefaultViewModelProviderFactory();
    }
}
