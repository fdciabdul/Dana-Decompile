package id.dana.cashier.model;

import id.dana.cashier.domain.model.paylater.DanaCredit;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/paylater/DanaCredit;", "Lid/dana/cashier/model/DanaCreditModel;", "PlaceComponentResult", "(Lid/dana/cashier/domain/model/paylater/DanaCredit;)Lid/dana/cashier/model/DanaCreditModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaCreditModelKt {
    public static final DanaCreditModel PlaceComponentResult(DanaCredit danaCredit) {
        Intrinsics.checkNotNullParameter(danaCredit, "");
        MoneyView availableQuota = danaCredit.getAvailableQuota();
        MoneyViewModel authRequestContext = availableQuota != null ? MoneyViewModelKt.getAuthRequestContext(availableQuota) : null;
        MoneyView initCreditQuota = danaCredit.getInitCreditQuota();
        MoneyViewModel authRequestContext2 = initCreditQuota != null ? MoneyViewModelKt.getAuthRequestContext(initCreditQuota) : null;
        String installmentPlanId = danaCredit.getInstallmentPlanId();
        MoneyView totalAmount = danaCredit.getTotalAmount();
        return new DanaCreditModel(authRequestContext, authRequestContext2, installmentPlanId, totalAmount != null ? MoneyViewModelKt.getAuthRequestContext(totalAmount) : null);
    }
}
