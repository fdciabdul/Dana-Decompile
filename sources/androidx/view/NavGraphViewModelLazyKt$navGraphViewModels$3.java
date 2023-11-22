package androidx.view;

import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/viewmodel/CreationExtras;", BridgeDSL.INVOKE, "()Landroidx/lifecycle/viewmodel/CreationExtras;"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes6.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$3 extends Lambda implements Function0<CreationExtras> {
    final /* synthetic */ Lazy<NavBackStackEntry> $$backStackEntry$delegate;
    final /* synthetic */ Function0<CreationExtras> $$extrasProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavGraphViewModelLazyKt$navGraphViewModels$3(Function0<? extends CreationExtras> function0, Lazy<NavBackStackEntry> lazy) {
        super(0);
        this.$$extrasProducer = function0;
        this.$$backStackEntry$delegate = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CreationExtras invoke() {
        CreationExtras invoke;
        Function0<CreationExtras> function0 = this.$$extrasProducer;
        return (function0 == null || (invoke = function0.invoke()) == null) ? NavGraphViewModelLazyKt.MyBillsEntityDataFactory(this.$$backStackEntry$delegate).getDefaultViewModelCreationExtras() : invoke;
    }
}
