package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.CashierAgreementResponse;
import id.dana.cashier.model.CashierAgreementModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/cashier/mapper/CashierAgreementModelMapper;", "", "Lid/dana/cashier/domain/model/CashierAgreementResponse;", "Lid/dana/cashier/model/CashierAgreementModel;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/domain/model/CashierAgreementResponse;)Lid/dana/cashier/model/CashierAgreementModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAgreementModelMapper {
    public static final CashierAgreementModelMapper INSTANCE = new CashierAgreementModelMapper();

    private CashierAgreementModelMapper() {
    }

    public static CashierAgreementModel MyBillsEntityDataFactory(CashierAgreementResponse cashierAgreementResponse) {
        Intrinsics.checkNotNullParameter(cashierAgreementResponse, "");
        return new CashierAgreementModel(cashierAgreementResponse.getBindingId(), cashierAgreementResponse.getCardIndexNo(), cashierAgreementResponse.getIdentifyFailedCount(), cashierAgreementResponse.getLockedExpireSeconds(), cashierAgreementResponse.getMaxFailed(), cashierAgreementResponse.getPayMethod(), cashierAgreementResponse.getPayOption(), cashierAgreementResponse.getSuccess());
    }
}
