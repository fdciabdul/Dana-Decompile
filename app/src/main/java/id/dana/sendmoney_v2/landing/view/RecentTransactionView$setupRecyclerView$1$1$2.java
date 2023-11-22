package id.dana.sendmoney_v2.landing.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class RecentTransactionView$setupRecyclerView$1$1$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RecentTransactionView$setupRecyclerView$1$1$2(Object obj) {
        super(1, obj, RecentTransactionView.class, "onRecyclerViewExpanded", "onRecyclerViewExpanded(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        RecentTransactionView.access$onRecyclerViewExpanded((RecentTransactionView) this.receiver, z);
    }
}
