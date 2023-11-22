package id.dana.cashier.fragment;

import id.dana.cashier.model.VoucherCashierModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class CashierPromoSelectionFragment$initCashierPromoSelectionAdapter$1 extends FunctionReferenceImpl implements Function1<VoucherCashierModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CashierPromoSelectionFragment$initCashierPromoSelectionAdapter$1(Object obj) {
        super(1, obj, CashierPromoSelectionFragment.class, "getAuthRequestContext", "getAuthRequestContext(Lid/dana/cashier/model/VoucherCashierModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(VoucherCashierModel voucherCashierModel) {
        invoke2(voucherCashierModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(VoucherCashierModel voucherCashierModel) {
        ((CashierPromoSelectionFragment) this.receiver).getAuthRequestContext(voucherCashierModel);
    }
}
