package id.dana.cashier.model;

import id.dana.cashier.domain.model.CashierKybOrderDetail;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/CashierKybOrderDetail;", "Lid/dana/cashier/model/CashierKybOrderDetailModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/domain/model/CashierKybOrderDetail;)Lid/dana/cashier/model/CashierKybOrderDetailModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierKybOrderDetailModelKt {
    public static final CashierKybOrderDetailModel BuiltInFictitiousFunctionClassFactory(CashierKybOrderDetail cashierKybOrderDetail) {
        Intrinsics.checkNotNullParameter(cashierKybOrderDetail, "");
        MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
        MoneyViewModel PlaceComponentResult = MoneyViewModel.Companion.PlaceComponentResult(cashierKybOrderDetail.getAdditionalFee());
        MoneyViewModel.Companion companion2 = MoneyViewModel.INSTANCE;
        MoneyViewModel PlaceComponentResult2 = MoneyViewModel.Companion.PlaceComponentResult(cashierKybOrderDetail.getAmount());
        String checkOutUrl = cashierKybOrderDetail.getCheckOutUrl();
        MoneyViewModel.Companion companion3 = MoneyViewModel.INSTANCE;
        return new CashierKybOrderDetailModel(PlaceComponentResult, PlaceComponentResult2, checkOutUrl, MoneyViewModel.Companion.PlaceComponentResult(cashierKybOrderDetail.getOrderAmount()), cashierKybOrderDetail.getOrderTitle());
    }
}
