package id.dana.cashier.fragment;

import kotlin.jvm.functions.Function0;

/* loaded from: classes4.dex */
public final /* synthetic */ class PayConfirmationFragment$$ExternalSyntheticLambda17 implements Runnable {
    public final /* synthetic */ Function0 MyBillsEntityDataFactory;

    public /* synthetic */ PayConfirmationFragment$$ExternalSyntheticLambda17(Function0 function0) {
        this.MyBillsEntityDataFactory = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PayConfirmationFragment.PlaceComponentResult(this.MyBillsEntityDataFactory);
    }
}
